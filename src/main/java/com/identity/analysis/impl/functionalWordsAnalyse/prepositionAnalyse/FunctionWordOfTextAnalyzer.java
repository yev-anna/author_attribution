package com.identity.analysis.impl.functionalWordsAnalyse.prepositionAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.analysis.impl.functionalWordsAnalyse.FunctionWordTextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.functionalWords.FunctionWordA;
import com.identity.entity.measures.impl.functionalWords.preposition.FunctionWordOf;

import java.util.List;

/**
 * Created by Анна on 22.05.2017.
 */
public class FunctionWordOfTextAnalyzer extends FunctionWordTextAnalyzer<FunctionWordOf> {

    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FunctionWordOf(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, "of");
    }
}
