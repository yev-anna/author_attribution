package com.identity.entity.measures.impl.functionalWords.preposition;

import com.identity.entity.measures.MeasureEnum;
import com.identity.entity.measures.impl.functionalWords.FunctionWordMeasure;

/**
 * Created by Анна on 22.05.2017.
 */
public class FunctionWordWith extends FunctionWordMeasure {

    public FunctionWordWith(double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FUNCTION_WITH;
    }
}
