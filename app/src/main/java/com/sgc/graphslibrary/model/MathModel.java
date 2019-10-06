package com.sgc.graphslibrary.model;

public class MathModel {

    public interface MathFunctionInterface {
        float function(float x);
    }

    private int minX = -50;
    private int maxX = 50;
    private int accuracy = 4;
    private MathFunctionInterface mathFunctionInterface;

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
