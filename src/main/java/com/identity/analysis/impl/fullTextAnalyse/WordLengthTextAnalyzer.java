package com.identity.analysis.impl.fullTextAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.impl.fullText.WordLength;
import com.identity.utils.Text;

import java.util.List;

/**
 * Created by Анна on 20.06.2017.
 */
public class WordLengthTextAnalyzer extends FullTextAnalyzer<WordLength> {

    @Override
    public Measure getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new WordLength(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        String[]words = Text.divideWords(text);
        int letterNum = 0;
        for (String w : words){
            letterNum += w.length();
        }
        // to rewrite in modern java8?
        return (double)letterNum /(double)words.length;
    }
}
