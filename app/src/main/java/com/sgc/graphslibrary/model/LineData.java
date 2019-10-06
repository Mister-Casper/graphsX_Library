package com.sgc.graphslibrary.model;

import android.graphics.Color;

import java.util.ArrayList;

public class LineData {

    /**
     * array points all graph
     */
    private ArrayList<ChartCoordinates> dataLine;

    /**
     * graph color
     */
    private int lineColor = Color.BLACK;

    /**
     * graph thickness
     */
    private int lineThickness = 2;

    public LineData(ArrayList<ChartCoordinates> dataLine, int lineColor) {
        this.dataLine = dataLine;
        this.lineColor = lineColor;
    }

    public LineData(ArrayList<ChartCoordinates> dataLine) {
        this.dataLine = dataLine;
    }

    /**
     * @return array points all graph
     */
    public ArrayList<ChartCoordinates> getDataLine() {
        return dataLine;
    }

    /**
     * @param dataLine array points all graph
     */
    public void setDataLine(ArrayList<ChartCoordinates> dataLine) {
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
