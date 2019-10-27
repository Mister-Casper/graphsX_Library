package com.sgc.graphslibrary.data;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public class BarChartData implements Parcelable {

    private int colorColumn = Color.BLACK;
    private float percentHeight;

    public BarChartData(float percentHeight){
        this.percentHeight = percentHeight;
    }

    public BarChartData(int colorColumn ,float percentHeight){
        this.colorColumn = colorColumn;
        this.percentHeight = percentHeight;
    }

    protected BarChartData(Parcel in) {
        colorColumn = in.readInt();
        percentHeight = in.readFloat();
    }

    public int getColorColumn() {
        return colorColumn;
    }

    public void setColorColumn(int colorColumn) {
        this.colorColumn = colorColumn;
    }

    public float getPercentHeight() {
        return percentHeight;
    }

    public void setPercentHeight(float percentHeight) {
        this.percentHeight = percentHeight;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(colorColumn);
        dest.writeFloat(percentHeight);
    }

    public static final Creator<BarChartData> CREATOR = new Creator<BarChartData>() {
        @Override
        public BarChartData createFromParcel(Parcel in) {
            return new BarChartData(in);
        }

        @Override
        public BarChartData[] newArray(int size) {
            return new BarChartData[size];
        }
    };
}
