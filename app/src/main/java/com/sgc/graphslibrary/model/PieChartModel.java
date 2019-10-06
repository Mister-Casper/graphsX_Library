package com.sgc.graphslibrary.model;

import android.graphics.Color;

public class PieChartModel {
    private int percentageSpace;
    private int colorDedicatedSpace;
    private String text;

    public PieChartModel(int percentageSpace, int colorDedicatedSpace) {
        this.percentageSpace = percentageSpace;
        this.colorDedicatedSpace = colorDedicatedSpace;
    }

    public PieChartModel(int percentageSpace, int colorDedicatedSpace, String text) {
        this.percentageSpace = percentageSpace;
        this.colorDedicatedSpace = colorDedicatedSpace;
        this.text = text;
    }


    public int getColorDedicatedSpace() {
        return colorDedicatedSpace;
    }

    public void setColorDedicatedSpace(int colorDedicatedSpace) {
        this.colorDedicatedSpace = colorDedicatedSpace;
    }

    public int getPercentageSpace() {
        return percentageSpace;
    }

    public void setPercentageSpace(int percentageSpace) {
        this.percentageSpace = percentageSpace;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
