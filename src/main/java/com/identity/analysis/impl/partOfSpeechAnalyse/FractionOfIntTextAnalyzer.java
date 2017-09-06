package com.identity.analysis.impl.partOfSpeechAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfInt;
import com.identity.utils.PartOfSpeech;

import java.util.List;

/**
 * Created by Анна on 16.05.2017.
 */
public class FractionOfIntTextAnalyzer extends FractionOfPOSTextAnalyzer<FractionOfInt> {
    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FractionOfInt(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, PartOfSpeech.INT);
    }
}
