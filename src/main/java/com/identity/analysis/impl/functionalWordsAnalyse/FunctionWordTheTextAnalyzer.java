package com.identity.analysis.impl.functionalWordsAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.functionalWords.FunctionWordThe;

import java.util.List;

/**
 * Created by Анна on 20.05.2017.
 */
public class FunctionWordTheTextAnalyzer extends FunctionWordTextAnalyzer<FunctionWordThe> {

    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FunctionWordThe(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, "the");
    }
}
