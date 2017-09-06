package com.identity.entity.measures.impl.fractionOfPOS;

import com.identity.entity.measures.Measure;
import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 04.05.2017.
 */
public class FractionOfVerb extends FractionOfPOSMeasure {

    public FractionOfVerb(double value){
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FRACTION_VERB;
    }
}
