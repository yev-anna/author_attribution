package com.identity.entity.measures.impl.fullText;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 20.06.2017.
 */
public class WordLength extends FullTextMeasure {

    public WordLength(double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.WORD_LENGTH;
    }
}
