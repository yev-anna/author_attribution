package com.identity.analysis.impl.punctuationAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.fractionOfPunctuation.FractionOfComma;

import java.util.List;

public class FractionOfCommaTextAnalyzer extends FractionOfPMTextAnalyzer<FractionOfComma> {
    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FractionOfComma(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, "\\,");
    }
}
