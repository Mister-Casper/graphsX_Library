package com.sgc.graphslibrary.diagram;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.sgc.graphslibrary.R;
import com.sgc.graphslibrary.graph.BaseCoordinateSystem;

public class BaseBarChart extends BaseCoordinateSystem {

    protected void loadAttribute(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.BaseBarChart);
        try {
            columnThickness = arr.getInt(
                    R.styleable.BaseBarChart_columnThickness,
                    columnThickness);

            maxColumnValue = arr.getFloat(
                    R.styleable.BaseBarChart_maxColumnValue,
                    maxColumnValue);

            columnDescriptionTextSize = arr.getDimensionPixelSize(
                    R.styleable.BaseBarChart_columnDescriptionTextSize,
                    columnDescriptionTextSize);

            valueColumnDescriptionTextSize = arr.getDimensionPixelSize(
                    R.styleable.BaseBarChart_valueTextSize,
                    valueColumnDescriptionTextSize);

            isLining =  arr.getBoolean(
                    R.styleable.BaseBarChart_isLining,
                    isLining);

            countShowDescription = arr.getInt(
                    R.styleable.BaseBarChart_countShowDescription,
                    countShowDescription);
        } finally {
            arr.recycle();
        }
    }

    public BaseBarChart(Context context) {
        super(context);
    }

    public BaseBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.loadAttribute(context,attrs);
    }

    public BaseBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.loadAttribute(context,attrs);
    }

    public int getColumnThickness() {
        return columnThickness;
    }

    public void setColumnThickness(int columnThickness) {
        this.columnThickness = columnThickness;
        invalidate();
    }

    public float getMaxColumnValue() {
        return maxColumnValue;
    }

    public void setMaxColumnValue(float maxColumnValue) {
        this.maxColumnValue = maxColumnValue;
        invalidate();
    }

    public int getColumnDescriptionTextSize() {
        return columnDescriptionTextSize;
    }

    public void setColumnDescriptionTextSize(int columnDescriptionTextSize) {
        this.columnDescriptionTextSize = columnDescriptionTextSize;
        invalidate();
    }

    public int getValueColumnDescriptionTextSize() {
        return valueColumnDescriptionTextSize;
    }

    public void setValueColumnDescriptionTextSize(int valueColumnDescriptionTextSize) {
        this.valueColumnDescriptionTextSize = valueColumnDescriptionTextSize;
        invalidate();
    }

    public boolean isLining() {
        return isLining;
    }

    public void setLining(boolean lining) {
        isLining = lining;
        invalidate();
    }

    public int getCountShowDescription() {
        return countShowDescription;
    }

    public void setCountShowDescription(int countShowDescription) {
        this.countShowDescription = countShowDescription;
        invalidate();
    }

    protected int columnThickness = 77;
    protected float maxColumnValue = 1000;
    protected int columnDescriptionTextSize = 30;
    protected int valueColumnDescriptionTextSize = 30;
    protected boolean isLining = true;
    protected int countShowDescription = 20;

}
