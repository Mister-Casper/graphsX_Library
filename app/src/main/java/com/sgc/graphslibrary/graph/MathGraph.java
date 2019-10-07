package com.sgc.graphslibrary.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.sgc.graphslibrary.model.ChartCoordinatesModel;
import com.sgc.graphslibrary.model.LineGraphModel;
import com.sgc.graphslibrary.model.MathModel;

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

    protected ArrayList<MathModel> functions = new ArrayList<>();

    public void setFunctions(ArrayList<MathModel> functions) {
        this.functions = functions;
        super.setData(calculatedCoordinates());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    protected ArrayList<LineGraphModel> calculatedCoordinates() {
        ArrayList<LineGraphModel> graphs = new ArrayList<>();

        for (int i = 0; i < functions.size(); i++) {
            MathModel function = functions.get(i);
            ArrayList<ChartCoordinatesModel> coordinatesFunctionGraph = new ArrayList<>();

            if (function.getAccuracy() >= 1) {
                float scaleX = super.getScaleDivisionDescriptionAxisX();
                float stepAccuracy = scaleX / function.getAccuracy();

                for (float x = function.getMinX(); x <= function.getMaxX(); x += stepAccuracy) {
                    float Y = function.getMathFunctionInterface().function(Math.round(x * 100f) / 100f) / super.getScaleDivisionDescriptionAxisY();
                    float X = x / super.getScaleDivisionDescriptionAxisX();
                    ChartCoordinatesModel coordinates = new ChartCoordinatesModel(X,Y);
                    coordinatesFunctionGraph.add(coordinates);
                }
            }
            graphs.add(new LineGraphModel(coordinatesFunctionGraph));
        }

        return graphs;
    }

}
