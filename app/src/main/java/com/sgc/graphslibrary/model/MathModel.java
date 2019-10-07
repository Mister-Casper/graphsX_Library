package com.sgc.graphslibrary.model;

import android.graphics.Color;

public class MathModel {

    public int getColorGraph() {
        return colorGraph;
    }

    public void setColorGraph(int colorGraph) {
        this.colorGraph = colorGraph;
    }

    public int getLineThicknessGraph() {
        return lineThicknessGraph;
    }

    public void setLineThicknessGraph(int lineThicknessGraph) {
        this.lineThicknessGraph = lineThicknessGraph;
    }

    public interface MathFunctionInterface {
        float function(float x);
    }

    private int minX = -50;
    private int maxX = 50;
    private int accuracy = 4;
    private MathFunctionInterface mathFunctionInterface;
    private int colorGraph = Color.BLACK;
    private int lineThicknessGraph = 2;

    public MathModel( int accuracy,MathFunctionInterface mathFunctionInterface){
        this.accuracy = accuracy;
        this.mathFunctionInterface = mathFunctionInterface;
    }

    public MathModel(MathFunctionInterface mathFunctionInterface){
        this.mathFunctionInterface = mathFunctionInterface;
    }

    public MathFunctionInterface getMathFunctionInterface() {
        return mathFunctionInterface;
    }

    public void setMathFunctionInterface(MathFunctionInterface mathFunctionInterface) {
        this.mathFunctionInterface = mathFunctionInterface;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

}
