package com.identity.analysis.impl.punctuationAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.fractionOfPunctuation.FractionOfQuestionMark;

import java.util.List;

/**
 * Created by Анна on 16.05.2017.
 */
public class FractionOfQuestionMarkTextAnalyzer extends FractionOfPMTextAnalyzer<FractionOfQuestionMark> {
    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FractionOfQuestionMark(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, "\\?");
    }
}
