package com.identity.utils;

import com.identity.choose.BordaRule;
import com.identity.entity.Author;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.MeasureEnum;
import com.identity.entity.measures.impl.fullText.SentenceLength;
import com.identity.entity.measures.impl.fullText.VocabularyAmount;
import com.identity.entity.measures.impl.fullText.WordLength;
import org.junit.Test;

import java.util.*;


public class LeGrandTest {

    @Test
    public void test(){
        ArrayList<Author> authorList = new ArrayList();

        List<MeasureEnum> measureList = new ArrayList<>();
        measureList.add(MeasureEnum.SENTENCE_LENGTH);
        measureList.add(MeasureEnum.WORD_LENGTH);
        measureList.add(MeasureEnum.VOCABULARY_AMOUNT);

        //Charles Dickens
        Map<MeasureEnum, Measure> dickensMap = new HashMap<>();
        dickensMap.put(MeasureEnum.SENTENCE_LENGTH, new SentenceLength(15.6739777528851));
        dickensMap.put(MeasureEnum.WORD_LENGTH, new WordLength(4.12214314228148));
        dickensMap.put(MeasureEnum.VOCABULARY_AMOUNT, new VocabularyAmount(1880.93470645391));

        Author dickens = new Author("Charles Dickens", dickensMap);
        authorList.add(dickens);

        //Jane Austen
        Map<MeasureEnum, Measure> austenMap = new HashMap<>();
        austenMap.put(MeasureEnum.SENTENCE_LENGTH, new SentenceLength(19.3967224522304));
        austenMap.put(MeasureEnum.WORD_LENGTH, new WordLength(4.30855474665488));
        austenMap.put(MeasureEnum.VOCABULARY_AMOUNT, new VocabularyAmount(1593.17157807554));

        Author austen = new Author("Jane Austen", austenMap);
        authorList.add(austen);

        //Jack London
        Map<MeasureEnum, Measure> londonMap = new HashMap<>();
        londonMap.put(MeasureEnum.SENTENCE_LENGTH, new SentenceLength(13.7307498937434));
        londonMap.put(MeasureEnum.WORD_LENGTH, new WordLength(4.15615176369378));
        londonMap.put(MeasureEnum.VOCABULARY_AMOUNT, new VocabularyAmount(1995.79976545686));

        Author london = new Author("Jack London", londonMap);
        authorList.add(london);

        //analysed text

        Map<MeasureEnum, Measure> unknownMap = new HashMap<>();
        unknownMap.put(MeasureEnum.SENTENCE_LENGTH, new SentenceLength(20.6703));
        unknownMap.put(MeasureEnum.WORD_LENGTH, new WordLength(4.349759366));
        unknownMap.put(MeasureEnum.VOCABULARY_AMOUNT, new VocabularyAmount(1560.0));

        Author unknown = new Author(unknownMap);

        BordaRule choose = new BordaRule(unknown, authorList);
        List<Author> sorted = choose.getMostProbable(measureList);

        System.out.println(sorted);

    }
}
