package com.identity.analysis.impl.partOfSpeechAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfAdjective;
import com.identity.utils.PartOfSpeech;

import java.util.List;

/**
 * Created by Анна on 04.05.2017.
 */
public class FractionOfAdjectiveTextAnalyzer extends FractionOfPOSTextAnalyzer<FractionOfAdjective> {

    @Override
    public FractionOfAdjective getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FractionOfAdjective(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, PartOfSpeech.ADJECTIVE);
    }
}
