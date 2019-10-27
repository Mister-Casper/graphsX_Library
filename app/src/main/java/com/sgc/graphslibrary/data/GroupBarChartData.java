package com.sgc.graphslibrary.data;

import java.util.ArrayList;

public class GroupBarChartData {

    public final static int locationVertical = 1;
    public final static int locationHorizontal = 2;

    private int location = GroupBarChartData.locationVertical;
    private ArrayList<BarChartData> data;
    private String nameColumn = "";

    public boolean isVerticalLocation() {
        return location == locationVertical;
    }

    public ArrayList<BarChartData> getData() {
        return data;
    }

    public void setData(ArrayList<BarChartData> data) {
        this.data = data;
    }

    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    public GroupBarChartData(ArrayList<BarChartData> data, int location) {
        this.data = data;
        this.location = location;
    }

    public GroupBarChartData(BarChartData data, int location) {
        this.data.add(data);
        this.location = location;
    }

    public GroupBarChartData(ArrayList<BarChartData> data, int location,String nameColumn) {
        this.data = data;
        this.location = location;
        this.nameColumn = nameColumn;
    }

    public GroupBarChartData(BarChartData data, int location,String nameColumn) {
        this.data.add(data);
        this.location = location;
        this.nameColumn = nameColumn;
    }

}
