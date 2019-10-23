package com.sgc.graphslibrary.data;

import android.graphics.Color;

public class BarChartData {

    private int colorColumn = Color.BLACK;
    private float percentHeight;
    private String nameColumn = "";

    public BarChartData(float percentHeight){
        this.percentHeight = percentHeight;
    }

    public BarChartData(int colorColumn ,float percentHeight){
        this.colorColumn = colorColumn;
        this.percentHeight = percentHeight;
    }

    public BarChartData(int colorColumn ,float percentHeight,String nameColumn){
        this.colorColumn = colorColumn;
        this.percentHeight = percentHeight;
        this.nameColumn = nameColumn;
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

    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }
}
