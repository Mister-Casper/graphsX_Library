package com.sgc.graphslibrary.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class GroupBarChartData implements Parcelable {

    public final static int locationVertical = 1;
    public final static int locationHorizontal = 2;

    private int location = GroupBarChartData.locationVertical;
    private ArrayList<BarChartData> data;
    private String nameColumn = "";

    protected GroupBarChartData(Parcel in) {
        location = in.readInt();
        data = in.createTypedArrayList(BarChartData.CREATOR);
        nameColumn = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(location);
        dest.writeTypedList(data);
        dest.writeString(nameColumn);
    }

    public static final Creator<GroupBarChartData> CREATOR = new Creator<GroupBarChartData>() {
        @Override
        public GroupBarChartData createFromParcel(Parcel in) {
            return new GroupBarChartData(in);
        }

        @Override
        public GroupBarChartData[] newArray(int size) {
            return new GroupBarChartData[size];
        }
    };
}
