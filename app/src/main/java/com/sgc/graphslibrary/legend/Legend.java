package com.sgc.graphslibrary.legend;

import android.graphics.Color;

import java.util.ArrayList;

import androidx.appcompat.widget.LinearLayoutCompat;

public class Legend {

    private int orientationMode = LinearLayoutCompat.VERTICAL;
    private ArrayList<Integer> itemsColor = new ArrayList<>();
    private ArrayList<String> itemsDescription = new ArrayList<>();

    private int height = 50;
    private int width = 50;

    public Legend(ArrayList<Integer> itemsColor, ArrayList<String> itemsDescription) {
        this.itemsColor = itemsColor;
        this.itemsDescription = itemsDescription;
        isValuesEqual();
    }

    public Legend(Object[] itemsColor, Object[] itemsDescription) {
        for (int i = 0; i < itemsColor.length && i <itemsDescription.length; i++) {
            this.itemsColor.add((Integer)itemsColor[i]);
            this.itemsDescription.add((String)itemsDescription[i]);
        }
        isValuesEqual();
    }

    public Legend(ArrayList<Integer> itemsColor, ArrayList<String> itemsDescription, int orientationMode) {
        this.itemsColor = itemsColor;
        this.itemsDescription = itemsDescription;
        this.orientationMode = orientationMode;
        isValuesEqual();
    }

    private void isValuesEqual() {
        if (itemsDescription.size() != itemsColor.size()) {
            throw new RuntimeException("Count itemsDescription must be equal count itemsColor");
        }
    }

    public boolean isVerticalOrientationMode() {
        return orientationMode == LinearLayoutCompat.VERTICAL;
    }

    public int getOrientationMode() {
        return orientationMode;
    }

    public void setOrientationMode(int orientationMode) {
        this.orientationMode = orientationMode;
    }

    public ArrayList<Integer> getItemsColor() {
        return itemsColor;
    }

    public void setItemsColor(ArrayList<Integer> itemsColor) {
        this.itemsColor = itemsColor;
    }

    public ArrayList<String> getItemsDescription() {
        return itemsDescription;
    }

    public void setItemsDescription(ArrayList<String> itemsDescription) {
        this.itemsDescription = itemsDescription;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
