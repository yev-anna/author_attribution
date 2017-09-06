package com.identity.entity.measures.impl.fullText;

import com.identity.entity.measures.Measure;
import com.identity.entity.measures.MeasureEnum;

/**
 * Created by ���� on 10.04.2017.
 */
public class VocabularyAmount extends FullTextMeasure {

    public VocabularyAmount(double value){
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.VOCABULARY_AMOUNT;
    }

}
