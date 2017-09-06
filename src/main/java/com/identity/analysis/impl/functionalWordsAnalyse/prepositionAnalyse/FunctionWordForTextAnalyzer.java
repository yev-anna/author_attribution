package com.identity.analysis.impl.functionalWordsAnalyse.prepositionAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.analysis.impl.functionalWordsAnalyse.FunctionWordTextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.functionalWords.preposition.FunctionWordFor;

import java.util.List;

/**
 * Created by Анна on 22.05.2017.
 */
public class FunctionWordForTextAnalyzer extends FunctionWordTextAnalyzer<FunctionWordFor> {

    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FunctionWordFor(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, "for");
    }
}
