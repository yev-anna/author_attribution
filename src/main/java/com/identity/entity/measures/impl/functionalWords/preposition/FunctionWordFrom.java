package com.identity.entity.measures.impl.functionalWords.preposition;

import com.identity.entity.measures.MeasureEnum;
import com.identity.entity.measures.impl.functionalWords.FunctionWordMeasure;

/**
 * Created by Анна on 22.05.2017.
 */
public class FunctionWordFrom extends FunctionWordMeasure {

    public FunctionWordFrom(double value) {
        this.value = value;
    }

    @Override
    public MeasureEnum getType() {
        return MeasureEnum.FUNCTION_FROM;
    }
}
