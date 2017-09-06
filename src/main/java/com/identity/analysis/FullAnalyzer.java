package com.identity.analysis;


import com.identity.entity.measures.Measure;
import com.identity.entity.measures.MeasureEnum;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfAdjective;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfNoun;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfPronoun;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfVerb;
import com.identity.entity.measures.impl.fullText.SentenceLength;
import com.identity.entity.measures.impl.fullText.VocabularyAmount;
import com.identity.utils.PartOfSpeech;
import com.identity.utils.Text;
import com.identity.utils.Vocabulary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Анна on 29.04.2017.
 */
public class FullAnalyzer {

    //MeasureFactory factory = MeasureFactory.getInstance();

    public void analyse(String text) {
        int wordsNum = 0;
        Set<String> vocabulary = new HashSet<>();
        Map<PartOfSpeech, Integer> partOfSpeech = new HashMap<>();

        String[]sentences = Text.divideSentences(text);

        for (String s : sentences){
            String partOfSpeech_ = Vocabulary.POSText(s);


            // avg words number
            String[] words = Text.divideWords(s);
            wordsNum += words.length;

            // voc amount
            for (String w: words) {
                vocabulary.add(Vocabulary.makeInfinitive(w));

                PartOfSpeech PoS = Vocabulary.getPartOfSpeech(w);
                if(partOfSpeech.containsKey(PoS))
                    partOfSpeech.put(PoS, partOfSpeech.get(PoS)+1);
                else partOfSpeech.put(PoS, 1);
            }

        }
        SentenceLength m1 = new SentenceLength((double)wordsNum /(double)sentences.length);
        VocabularyAmount m2 = new VocabularyAmount(vocabulary.size()/text.length());

        FractionOfAdjective m3 = new FractionOfAdjective((double)partOfSpeech.get(PartOfSpeech.ADJECTIVE)/text.length());
        FractionOfNoun m4 = new FractionOfNoun((double)partOfSpeech.get(PartOfSpeech.NOUN)/text.length());
        FractionOfPronoun m5 = new FractionOfPronoun((double)partOfSpeech.get(PartOfSpeech.PN)/text.length());
        FractionOfVerb m6 = new FractionOfVerb((double)partOfSpeech.get(PartOfSpeech.VERB)/text.length()); // +VBE?

        Map<MeasureEnum, Measure> measures = new HashMap<>();
        measures.put(MeasureEnum.SENTENCE_LENGTH, m1);
        measures.put(MeasureEnum.VOCABULARY_AMOUNT, m2);
        measures.put(MeasureEnum.FRACTION_ADJECTIVE, m3);
        measures.put(MeasureEnum.FRACTION_NOUN, m4);
        measures.put(MeasureEnum.FRACTION_PRONOUN, m5);
        measures.put(MeasureEnum.FRACTION_VERB, m6);

    }
}
