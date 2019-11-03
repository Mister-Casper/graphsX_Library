package com.sgc.graphslibrary.data;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public class MathData implements Parcelable{

    /**
     * coordinate  of the begin of the graph
     */
    private int minX = Integer.MIN_VALUE;

    /**
     * coordinate of the end of the graph
     */
    private int maxX = Integer.MAX_VALUE;

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

    private String lineLegendDescription = "";

    /**
     * thickness graph
     */
    private int lineThicknessGraph = 2;

    public MathData(int accuracy, MathFunctionInterface mathFunctionInterface) {
        this.accuracy = accuracy;
        this.mathFunctionInterface = mathFunctionInterface;
    }

    public MathData(MathFunctionInterface mathFunctionInterface) {
        this.mathFunctionInterface = mathFunctionInterface;
    }

    protected MathData(Parcel in) {
        minX = in.readInt();
        maxX = in.readInt();
        accuracy = in.readInt();
        mathFunctionInterface = in.readParcelable(MathFunctionInterface.class.getClassLoader());
        colorGraph = in.readInt();
        lineLegendDescription = in.readString();
        lineThicknessGraph = in.readInt();
    }

    public static final Creator<MathData> CREATOR = new Creator<MathData>() {
        @Override
        public MathData createFromParcel(Parcel in) {
            return new MathData(in);
        }

        @Override
        public MathData[] newArray(int size) {
            return new MathData[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(minX);
        dest.writeInt(maxX);
        dest.writeInt(accuracy);
        dest.writeParcelable(mathFunctionInterface, flags);
        dest.writeInt(colorGraph);
        dest.writeString(lineLegendDescription);
        dest.writeInt(lineThicknessGraph);
    }

    /**
     * interface to get y
     */
    public interface MathFunctionInterface extends Parcelable {
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

    public String getLineLegendDescription() {
        return lineLegendDescription;
    }

    public void setLineLegendDescription(String lineLegendDescription) {
        this.lineLegendDescription = lineLegendDescription;
    }
}
