package com.sgc.graphslibrary.data;

import android.graphics.Color;

public class BarChartData {

    private int colorColumn = Color.BLACK;
    private float percentHeight;

    public BarChartData(float percentHeight){
        this.percentHeight = percentHeight;
    }

    public BarChartData(int colorColumn ,float percentHeight){
        this.colorColumn = colorColumn;
        this.percentHeight = percentHeight;
    }

    public int getColorColumn() {
        return colorColumn;
    }

    public void setColorColumn(int colorColumn) {
        this.colorColumn = colorColumn;
    }

    public float getPercentHeight() {
        return percentHeight;
    }

    public void setPercentHeight(float percentHeight) {
        this.percentHeight = percentHeight;
    }
}
