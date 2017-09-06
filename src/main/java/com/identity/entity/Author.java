package com.identity.entity;

import com.identity.entity.measures.*;
import com.identity.entity.measures.impl.MeasureFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by ���� on 22.03.2017.
 */

public class Author  {
    private String name;
    private Map<MeasureEnum, Measure> measures = new HashMap<>();;

    public Author(){     }

    public Author (Map<MeasureEnum,Measure> measures){
        this.measures = measures;
    }

    public Author(String name, Map<MeasureEnum,Measure> measures){
        this.name = name;
        this.measures = measures;
    }


    public Measure getMeasure(Measure m){
        return measures.get(m.getType());
    }

    public Measure getMeasure(MeasureEnum m) {
        return measures.get(m);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<MeasureEnum, Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(Map<MeasureEnum, Measure> measures) {
        this.measures = measures;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!name.equals(((Author)obj).name)) return false;
        //check parameters!
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
