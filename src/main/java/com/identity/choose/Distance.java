package com.identity.choose;

import com.identity.entity.Author;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.MeasureEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ���� on 04.04.2017.
 */
public class Distance {
    private Author author;

    public Distance(Author author){
        this.author = author;
    }

    public double getDistance(Author possible, MeasureEnum measure){
        return Math.abs(possible.getMeasure(measure).getValue() - author.getMeasure(measure).getValue());
    }




}
