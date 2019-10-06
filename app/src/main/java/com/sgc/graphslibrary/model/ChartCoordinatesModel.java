package com.sgc.graphslibrary.model;

public class ChartCoordinatesModel {
    private int valueX;
    private int valueY;

    public ChartCoordinatesModel(int valueX, int valueY) {
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public int getValueY() {
        return valueY;
    }

    public void setValueY(int valueY) {
        this.valueY = valueY;
    }

    public int getValueX() {
        return valueX;
    }

    public void setValueX(int valueX) {
        this.valueX = valueX;
    }
}