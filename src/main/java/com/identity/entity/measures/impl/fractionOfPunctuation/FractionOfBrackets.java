package com.identity.entity.measures.impl.fractionOfPunctuation;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 23.05.2017.
 */
public class FractionOfBrackets extends FractionOfPMMeasure {

    public FractionOfBrackets(double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FRACTION_BRACKETS;
    }
}
