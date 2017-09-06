package com.identity.entity.measures.impl.fractionOfPOS;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 14.06.2017.
 */
public class FractionOfNumeral extends FractionOfPOSMeasure {

    public FractionOfNumeral (double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FRACTION_NUMERAL;
    }
}
