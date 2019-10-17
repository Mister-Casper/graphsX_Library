package com.sgc.graphslibrary.data;

import android.graphics.Color;

public class BarChartData {

    private int colorColumn;
    private float length;
    private int position;

    public BarChartData(int colorColumn ,float length , int position ){
        this.colorColumn = colorColumn;
        this.length = length;
        this.position = position;
    }

    public int getColorColumn() {
        return colorColumn;
    }

    public void setColorColumn(int colorColumn) {
        this.colorColumn = colorColumn;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
