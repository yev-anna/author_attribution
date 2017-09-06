package com.identity.analysis.impl.punctuationAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.fractionOfPunctuation.FractionOfPMMeasure;
import com.identity.utils.Text;

import java.awt.font.TextMeasurer;

/**
 * Created by Анна on 16.05.2017.
 */
public abstract class FractionOfPMTextAnalyzer <T extends FractionOfPMMeasure> implements TextAnalyzer<Measure> {

    protected double analyse(String text, String punctuationMark) {
        int amountOfMark = Text.findAmount(text, punctuationMark);
        return (double)amountOfMark/(double)text.length();
    }
}
