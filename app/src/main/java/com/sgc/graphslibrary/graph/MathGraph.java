package com.sgc.graphslibrary.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.sgc.graphslibrary.data.ChartCoordinatesData;
import com.sgc.graphslibrary.data.LineGraphData;
import com.sgc.graphslibrary.data.MathData;
import com.sgc.graphslibrary.legend.Legend;
import com.sgc.graphslibrary.legend.LegendView;
import com.sgc.graphslibrary.legend.SourceLegendListener;

import java.util.ArrayList;

public class MathGraph extends LineGraph implements SourceLegendListener {

    LegendView legend;

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
        this.post(new Runnable() {
            @Override
            public void run() {
                setData(calculatedCoordinates());
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void invalidate() {
        super.invalidate();

        if (legend != null)
            legend.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isHorizontalScroll || isVerticalScroll)
            super.setData(calculatedCoordinates());

        return super.onTouchEvent(event);
    }

    protected ArrayList<LineGraphData> calculatedCoordinates() {
        ArrayList<LineGraphData> graphs = new ArrayList<>();
        for (int i = 0; i < functions.size(); i++) {
            MathData function = functions.get(i);
            graphs.add(calculatedFunctionCoordinates(function));
        }
        return graphs;
    }

    private LineGraphData calculatedFunctionCoordinates(MathData function) {
        ArrayList<ChartCoordinatesData> coordinatesFunctionGraph = new ArrayList<>();
        float stepAccuracy = getStepAccuracy(function);
        float startValue = super.getStartValue();
        int countShowDescription = getCountShowDescription();

        for (float x = startValue - 1 / scaleFactor; x <= startValue + countShowDescription; x += stepAccuracy) {
            ChartCoordinatesData coordinates = calculatedCoordinate(x, function);
            if (coordinates != null)
                coordinatesFunctionGraph.add(coordinates);
        }

        LineGraphData line = new LineGraphData(coordinatesFunctionGraph, function.getColorGraph(), function.getLineThicknessGraph());
        line.setLineLegendDescription(function.getLineLegendDescription());

        return line;
    }

    private float getStepAccuracy(MathData function) {
        float stepAccuracy = 1f / function.getAccuracy();

        if (stepAccuracy < 1f)
            stepAccuracy /= scaleFactor;

        return stepAccuracy;
    }

    private ChartCoordinatesData calculatedCoordinate(float x, MathData function) {
        if (x >= function.getMinX() && x <= function.getMaxX()) {
            x = Math.round(x * 100f) / 100f;
            float Y = function.getMathFunctionInterface().function(x) / super.getScaleDivisionDescriptionAxisY();
            float X = x / super.getScaleDivisionDescriptionAxisX();
            ChartCoordinatesData coordinates = new ChartCoordinatesData(X, Y);
            return coordinates;
        } else
            return null;
    }

    @Override
    public Legend getLegend() {
        ArrayList<String> legendDescription = new ArrayList<>();
        ArrayList<Integer> legendColor = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            legendColor.add(data.get(i).getLineColor());
            legendDescription.add(data.get(i).getLineLegendDescription());
        }

        Legend legend = new Legend(legendColor, legendDescription);
        legend.setHeight(10);

        return legend;
    }

    @Override
    public void connectToSourceView(LegendView legendView) {
        legendView.setWillNotDraw(false);
        legend = legendView;
    }
}
