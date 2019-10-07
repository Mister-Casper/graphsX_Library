package com.sgc.graphslibrary.model;

import android.graphics.Color;

import java.util.ArrayList;

public class LineGraphModel {

    /**
     * array points all graph
     */
    private ArrayList<ChartCoordinatesModel> dataLine;

    /**
     * graph color
     */
    private int lineColor = Color.BLACK;

    /**
     * graph thickness
     */
    private int lineThickness = 2;

    public LineGraphModel(ArrayList<ChartCoordinatesModel> dataLine, int lineColor,int lineThickness) {
        this.dataLine = dataLine;
        this.lineColor = lineColor;
        this.lineThickness = lineThickness;
    }

    public LineGraphModel(ArrayList<ChartCoordinatesModel> dataLine, int lineColor) {
        this.dataLine = dataLine;
        this.lineColor = lineColor;
    }

    public LineGraphModel(ArrayList<ChartCoordinatesModel> dataLine) {
        this.dataLine = dataLine;
    }

    /**
     * @return array points all graph
     */
    public ArrayList<ChartCoordinatesModel> getDataLine() {
        return dataLine;
    }

    /**
     * @param dataLine array points all graph
     */
    public void setDataLine(ArrayList<ChartCoordinatesModel> dataLine) {
        this.dataLine = dataLine;
    }

    /**
     * @return graph color
     */
    public int getLineColor() {
        return lineColor;
    }

    /**
     * @param lineColor graph color
     */
    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * @return graph thickness
     */
    public int getLineThickness() {
        return lineThickness;
    }

    /**
     * @param lineThickness graph thickness
     */
    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }
}
