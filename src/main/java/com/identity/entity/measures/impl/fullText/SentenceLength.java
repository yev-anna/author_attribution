package com.identity.entity.measures.impl.fullText;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by ���� on 04.04.2017.
 */
public class SentenceLength extends FullTextMeasure {

    public SentenceLength(double value){
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.SENTENCE_LENGTH;
    }
}
