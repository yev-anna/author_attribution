package com.identity.entity.measures.impl.fractionOfPOS;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 20.06.2017.
 */
public class FractionOfArticle extends FractionOfPOSMeasure {

    public FractionOfArticle(double value){
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FRACTION_ARTICLE;
    }
}
