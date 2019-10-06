package com.sgc.graphslibrary.model;

public class ChartCoordinatesModel {
    private float valueX;
    private float valueY;

    public ChartCoordinatesModel(float valueX, float valueY) {
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public float getValueY() {
        return valueY;
    }

    public void setValueY(float valueY) {
        this.valueY = valueY;
    }

    public float getValueX() {
        return valueX;
    }

    public void setValueX(float valueX) {
        this.valueX = valueX;
    }
}
