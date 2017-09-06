package com.identity.entity.measures.impl.functionalWords;

import com.identity.entity.measures.MeasureEnum;

/**
 * Created by Анна on 20.05.2017.
 */
public class FunctionWordThe extends FunctionWordMeasure {

    public FunctionWordThe(double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FUNCTION_THE;
    }
}
