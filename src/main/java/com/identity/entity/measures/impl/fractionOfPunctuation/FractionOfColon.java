package com.identity.entity.measures.impl.fractionOfPunctuation;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 16.05.2017.
 */
public class FractionOfColon extends FractionOfPMMeasure {
    public FractionOfColon(double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FRACTION_COLON;
    }
}
