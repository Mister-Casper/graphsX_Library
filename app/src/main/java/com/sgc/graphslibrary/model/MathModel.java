package com.sgc.graphslibrary.model;

import android.graphics.Color;

public class MathModel {

    /**
     * coordinate  of the begin of the graph
     */
    private int minX = -50;

    /**
     * coordinate of the end of the graph
     */
    private int maxX = 50;

    /**
     * graph accuracy . Shows how often will x will be taken when build graph.
     * For example, with accuracy = 5. The gap will be 0.2.
     * That is, during the build graph, the values x ​​0.2, 0.4, 0.6 ...
     * Recommend value : 1 - 100 . No recommend using value > 100.
     */
    private int accuracy = 4;

    /**
     * interface to get y
     */
    private MathFunctionInterface mathFunctionInterface;

    /*
    * color graph
     */
    private int colorGraph = Color.BLACK;

    /**
     * thickness graph
     */
    private int lineThicknessGraph = 2;

    public MathModel(int accuracy, MathFunctionInterface mathFunctionInterface) {
        this.accuracy = accuracy;
        this.mathFunctionInterface = mathFunctionInterface;
    }

    public MathModel(MathFunctionInterface mathFunctionInterface) {
        this.mathFunctionInterface = mathFunctionInterface;
    }

    /**
     * @return color graph
     */
    public int getColorGraph() {
        return colorGraph;
    }

    /**
     * @param colorGraph color graph
     */
    public void setColorGraph(int colorGraph) {
        this.colorGraph = colorGraph;
    }

    /**
     * @return thickness graph
     */
    public int getLineThicknessGraph() {
        return lineThicknessGraph;
    }

    /**
     * @param lineThicknessGraph thickness graph
     */
    public void setLineThicknessGraph(int lineThicknessGraph) {
        this.lineThicknessGraph = lineThicknessGraph;
    }

    /**
     * interface to get y
     */
    public interface MathFunctionInterface {
        float function(float x);
    }

    /**
     * @return interface to get y
     */
    public MathFunctionInterface getMathFunctionInterface() {
        return mathFunctionInterface;
    }

    /**
     * @param mathFunctionInterface interface to get y
     */
    public void setMathFunctionInterface(MathFunctionInterface mathFunctionInterface) {
        this.mathFunctionInterface = mathFunctionInterface;
    }

    /**
     * @return graph accuracy . Shows how often will x will be taken when build graph.
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * @param accuracy graph accuracy . Shows how often will x will be taken when build graph.
     */
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * @return coordinate of the begin of the graph
     */
    public int getMinX() {
        return minX;
    }

    /**
     * @param minX coordinate of the begin of the graph
     */
    public void setMinX(int minX) {
        this.minX = minX;
    }

    /**
     * @return coordinate of the end of the graph
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * @param maxX coordinate of the end of the graph
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

}
