package com.sgc.graphslibrary.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.sgc.graphslibrary.data.ChartCoordinatesData;
import com.sgc.graphslibrary.data.LineGraphData;
import com.sgc.graphslibrary.data.MathData;

import java.util.ArrayList;

public class MathGraph extends LineGraph {
    public MathGraph(Context context) {
        super(context);
    }

    public MathGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MathGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected ArrayList<MathData> functions = new ArrayList<>();

    public void setFunctions(ArrayList<MathData> functions) {
        this.functions = functions;
        super.setData(calculatedCoordinates());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    protected ArrayList<LineGraphData> calculatedCoordinates() {
        ArrayList<LineGraphData> graphs = new ArrayList<>();

        for (int i = 0; i < functions.size(); i++) {
            MathData function = functions.get(i);
            ArrayList<ChartCoordinatesData> coordinatesFunctionGraph = new ArrayList<>();

            if (function.getAccuracy() >= 1) {
                float scaleX = super.getScaleDivisionDescriptionAxisX();
                float stepAccuracy = scaleX / function.getAccuracy();

                for (float x = function.getMinX(); x <= function.getMaxX(); x += stepAccuracy) {
                    float Y = function.getMathFunctionInterface().function(Math.round(x * 100f) / 100f) / super.getScaleDivisionDescriptionAxisY();
                    float X = x / super.getScaleDivisionDescriptionAxisX();
                    ChartCoordinatesData coordinates = new ChartCoordinatesData(X,Y);
                    coordinatesFunctionGraph.add(coordinates);
                }
            }
            graphs.add(new LineGraphData(coordinatesFunctionGraph,function.getColorGraph(),function.getLineThicknessGraph()));
        }

        return graphs;
    }

}
