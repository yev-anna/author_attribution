package com.identity.analysis.impl.partOfSpeechAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfArticle;
import com.identity.utils.PartOfSpeech;

import java.util.List;

/**
 * Created by Анна on 20.06.2017.
 */
public class FractionOfArticleTextAnalyzer extends FractionOfPOSTextAnalyzer<FractionOfArticle> {

    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new FractionOfArticle(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        return analyse(text, PartOfSpeech.ARTICLE);
    }
}
