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

    protected int columnThickness = 77;
    protected float maxColumnValue = 1000;
    protected int columnDescriptionTextSize = 30;
    protected int valueColumnDescriptionTextSize = 30;
    protected boolean isLining = true;
    protected int countShowDescription = 20;

}
