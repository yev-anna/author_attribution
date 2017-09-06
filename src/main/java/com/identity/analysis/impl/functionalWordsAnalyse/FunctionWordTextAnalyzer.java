package com.identity.analysis.impl.functionalWordsAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.functionalWords.FunctionWordMeasure;
import com.identity.utils.Text;

/**
 * Created by Анна on 20.05.2017.
 */
public abstract class FunctionWordTextAnalyzer<T extends FunctionWordMeasure> implements TextAnalyzer<Measure> {

    protected double analyse(String text, String functionalWord) {
        int amountOfWordLowerCase = Text.findAmount(text, " " + functionalWord + " ");

        String firstLetter = String.valueOf(functionalWord.charAt(0));
        String upperCaseWord;
        if (functionalWord.length() > 1)
            upperCaseWord = firstLetter.toUpperCase() + functionalWord.substring(1)+ " ";
        else upperCaseWord = firstLetter.toUpperCase() + " ";

        int amountOfWordUpperCase = Text.findAmount(text, upperCaseWord);

        double allWords = (double)Text.divideWords(text).length;
        return (double)(amountOfWordLowerCase + amountOfWordUpperCase)/allWords;
    }
}
