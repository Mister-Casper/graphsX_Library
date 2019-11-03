package com.sgc.graphslibrary.data;

import android.graphics.Color;

import java.util.ArrayList;

public class LineGraphData {

    /**
     * array points all graph
     */
    private ArrayList<ChartCoordinatesData> dataLine;

    /**
     * graph color
     */
    private int lineColor = Color.BLACK;

    private String lineLegendDescription = "";

    /**
     * graph thickness
     */
    private int lineThickness = 2;

    public LineGraphData(ArrayList<ChartCoordinatesData> dataLine, int lineColor, int lineThickness) {
        this.dataLine = dataLine;
        this.lineColor = lineColor;
        this.lineThickness = lineThickness;
    }

    public LineGraphData(ArrayList<ChartCoordinatesData> dataLine, int lineColor) {
        this.dataLine = dataLine;
        this.lineColor = lineColor;
    }

    public LineGraphData(ArrayList<ChartCoordinatesData> dataLine) {
        this.dataLine = dataLine;
    }

    /**
     * @return array points all graph
     */
    public ArrayList<ChartCoordinatesData> getDataLine() {
        return dataLine;
    }

    /**
     * @param dataLine array points all graph
     */
    public void setDataLine(ArrayList<ChartCoordinatesData> dataLine) {
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

    public String getLineLegendDescription() {
        return lineLegendDescription;
    }

    public void setLineLegendDescription(String lineLegendDescription) {
        this.lineLegendDescription = lineLegendDescription;
    }
}
