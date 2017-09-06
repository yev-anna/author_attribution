package com.identity.analysis.impl.partOfSpeechAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfNoun;
import com.identity.utils.PartOfSpeech;

import java.util.List;

/**
 * Created by Анна on 09.05.2017.
 */
public class FractionOfNounTextAnalyzer extends FractionOfPOSTextAnalyzer<FractionOfNoun> {

    @Override
    public FractionOfNoun getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FractionOfNoun(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, PartOfSpeech.NOUN);
    }
}
