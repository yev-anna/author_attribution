package com.identity.analysis.impl.punctuationAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.fractionOfPunctuation.FractionOfDash;

import java.util.List;


public class FractionOfDashTextAnalyzer extends FractionOfPMTextAnalyzer<FractionOfDash> {
    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FractionOfDash(TextAnalyzer.expectedValue(texts, res));
    }

    /* TO TEST!!!!!!!!!!!
        there could be problem with using hyphen
        it should count as dash only when it means dash, but not in situation like "easy-going"
        could " " help? i'm not sure. Some authors (or at least persons that make txt book) could forget about it
     */
    @Override
    public double analyse(String text) {
        return analyse(text, "\\-") + analyse(text, "\\—");
    }
}
