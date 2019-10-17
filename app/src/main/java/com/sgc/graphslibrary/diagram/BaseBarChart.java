package com.sgc.graphslibrary.diagram;

import android.content.Context;
import android.util.AttributeSet;

import com.sgc.graphslibrary.graph.BaseCoordinateSystem;

public class BaseBarChart extends BaseCoordinateSystem {

    public BaseBarChart(Context context) {
        super(context);
    }

    public BaseBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected int columnThickness = 50;


}
