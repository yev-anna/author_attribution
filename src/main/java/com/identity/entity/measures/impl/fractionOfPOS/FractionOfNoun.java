package com.identity.entity.measures.impl.fractionOfPOS;

import com.identity.entity.measures.Measure;
import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 04.05.2017.
 */
public class FractionOfNoun extends FractionOfPOSMeasure {

    public FractionOfNoun(double value){
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FRACTION_NOUN;
    }
}
