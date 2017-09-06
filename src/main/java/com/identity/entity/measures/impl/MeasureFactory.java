package com.identity.entity.measures.impl;

import com.identity.entity.measures.impl.fullText.SentenceLength;
import com.identity.entity.measures.impl.fullText.VocabularyAmount;

/**
 * Created by ���� on 04.04.2017.
 */
public class MeasureFactory {
    private static final MeasureFactory instance = new MeasureFactory();

    private MeasureFactory() {}

    public static MeasureFactory getInstance() {
        return instance;
    }

    public SentenceLength getAvgWordsNumber(double value){
        return new SentenceLength(value);
    }

    public VocabularyAmount getVocabularyAmount(double value){
        return new VocabularyAmount(value);
    }
}
