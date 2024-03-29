package com.sgc.graphslibrary.data;

import android.view.View;

public class PieChartData {
    /**
     *percentage of space occupied by a segment diagram
     */
    private int percentageSpace;

    /**
     * chart segment color
     */
    private int colorDedicatedSpace;

    /**
     * description segment pie chart
     */
    private String text;

    private String legendDescription = "";

    private clickSectorListener clickListener;

    public PieChartData(int percentageSpace, int colorDedicatedSpace) {
        this.percentageSpace = percentageSpace;
        this.colorDedicatedSpace = colorDedicatedSpace;
    }

    public PieChartData(int percentageSpace, int colorDedicatedSpace, String text) {
        this.percentageSpace = percentageSpace;
        this.colorDedicatedSpace = colorDedicatedSpace;
        this.text = text;
    }


    /**
     * @return chart segment color
     */
    public int getColorDedicatedSpace() {
        return colorDedicatedSpace;
    }

    /**
     * @param colorDedicatedSpace chart segment color
     */
    public void setColorDedicatedSpace(int colorDedicatedSpace) {
        this.colorDedicatedSpace = colorDedicatedSpace;
    }

    /**
     * @return percentage of space occupied by a segment diagram
     */
    public int getPercentageSpace() {
        return percentageSpace;
    }

    /**
     * @param percentageSpace percentage of space occupied by a segment diagram
     */
    public void setPercentageSpace(int percentageSpace) {
        this.percentageSpace = percentageSpace;
    }

    /**
     * @return description segment pie chart
     */
    public String getText() {
        return text;
    }

    /**
     * @param text description segment pie chart
     */
    public void setText(String text) {
        this.text = text;
    }

    public clickSectorListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(clickSectorListener clickListener) {
        this.clickListener = clickListener;
    }

    public String getLegendDescription() {
        return legendDescription;
    }

    public void setLegendDescription(String legendDescription) {
        this.legendDescription = legendDescription;
    }

    public interface clickSectorListener{
        void click();
    }
}
