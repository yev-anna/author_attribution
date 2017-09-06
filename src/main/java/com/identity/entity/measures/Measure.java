package com.identity.entity.measures;

/**
 * Created by ���� on 04.04.2017.
 */
public abstract class Measure {
    protected double value;
    protected double weight;
    protected MeasureEnum type;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    abstract public MeasureEnum getType();
}
