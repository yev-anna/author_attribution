package com.identity.analysis.impl.fullTextAnalyse;

import com.identity.analysis.TextAnalyzer;
import com.identity.entity.measures.impl.fullText.SentenceLength;
import com.identity.utils.Text;

import java.util.List;

/**
 * Created by ���� on 15.03.2017.
 */

public class SentenceLengthTextAnalyzer extends FullTextAnalyzer<SentenceLength> {

    @Override
    public SentenceLength getMeasure(List<String> texts) {
        double[] res = new double[texts.size()];
        for(int i=0; i<texts.size(); i++) {
            res[i]=analyse(texts.get(i));
        }
        return new SentenceLength(TextAnalyzer.expectedValue(texts, res));
    }

    @Override
    public double analyse(String text) {
        String[]sentences = Text.divideSentences(text);
        int wordsNum = 0;
        for (String s : sentences){
            wordsNum += Text.divideWords(s).length;
        }
        // to rewrite in modern java8?
        return (double)wordsNum /(double)sentences.length;
    }
}
