package com.identity.analysis;

import com.identity.entity.measures.Measure;

import java.util.List;

/**
 * Created by ���� on 15.03.2017.
 */
public interface TextAnalyzer<T extends Measure> {
    T getMeasure(List<String> texts);

    double analyse(String text);

    static double expectedValue(List<String> texts, double[] results) {

        double nom = 0;
        double denom = 0; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for(int i = 0; i< texts.size(); i++) {
            nom += results[i]*texts.get(i).length();
            denom += texts.get(i).length();
        }
        return nom/denom;
    }
}
