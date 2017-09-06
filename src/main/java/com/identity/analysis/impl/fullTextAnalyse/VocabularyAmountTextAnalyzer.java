package com.identity.analysis.impl.fullTextAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.impl.fullText.VocabularyAmount;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.identity.utils.Text;
import com.identity.utils.Vocabulary;


/**
 * Created by Anna on 10.04.2017.
 */

public class VocabularyAmountTextAnalyzer extends FullTextAnalyzer<VocabularyAmount> {

    @Override
    public VocabularyAmount getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        double expValue = TextAnalyzer.expectedValue(texts,res);
        return new VocabularyAmount(expValue);
    }

    @Override
    public double analyse(String text) {
        Set<String> vocabulary = new HashSet<>();
        String[] words = Text.divideWords(text);
        for(String word : words){
            //vocabulary.add(Vocabulary.makeInfinitive(word));
            vocabulary.add(word.toLowerCase());
        }
        //System.out.println(vocabulary);
        //rewrite with modern java8 and streams
        return (double)vocabulary.size()/(double)words.length;
    }





}
