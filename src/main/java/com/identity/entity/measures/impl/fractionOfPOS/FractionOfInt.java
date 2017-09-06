package com.identity.entity.measures.impl.fractionOfPOS;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 16.05.2017.
 */
public class FractionOfInt extends FractionOfPOSMeasure {

    public FractionOfInt(double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FRACTION_INT;
    }
}
