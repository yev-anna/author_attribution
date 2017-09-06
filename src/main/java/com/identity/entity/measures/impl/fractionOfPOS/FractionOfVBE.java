package com.identity.entity.measures.impl.fractionOfPOS;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 20.06.2017.
 */
public class FractionOfVBE extends FractionOfPOSMeasure {

    public FractionOfVBE(double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FRACTION_VBE;
    }
}
