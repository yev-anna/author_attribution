package com.identity.analysis.impl.partOfSpeechAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.fractionOfPOS.FractionOfPOSMeasure;
import com.identity.utils.PartOfSpeech;
import com.identity.utils.Text;
import com.identity.utils.Vocabulary;

import java.util.List;

/**
 * Created by Анна on 04.05.2017.
 */
public abstract class FractionOfPOSTextAnalyzer<T extends FractionOfPOSMeasure> implements TextAnalyzer<Measure> {

   protected double analyse(String textPOS, PartOfSpeech type) {
       int amount = Text.findAmount(textPOS, type.toString());
       double allWords = (double)Text.divideWords(textPOS).length;
       return (double)amount/allWords;
    }
}
