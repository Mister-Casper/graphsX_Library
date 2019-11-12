package com.sgc.graphslibrary.diagram;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;

import com.sgc.graphslibrary.R;
import com.sgc.graphslibrary.data.BarChartData;
import com.sgc.graphslibrary.data.GroupBarChartData;
import com.sgc.graphslibrary.graph.BaseCoordinateSystem;
import com.sgc.graphslibrary.legend.Legend;
import com.sgc.graphslibrary.legend.LegendView;
import com.sgc.graphslibrary.legend.SourceLegendListener;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class BaseBarChart extends BaseCoordinateSystem implements SourceLegendListener {

    protected void loadAttribute(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.BaseBarChart);
        try {
            columnThickness = arr.getInt(
                    R.styleable.BaseBarChart_columnThickness,
                    columnThickness);

            maxColumnValue = arr.getFloat(
                    R.styleable.BaseBarChart_maxColumnValue,
                    maxColumnValue);

            columnDescriptionTextSize = arr.getDimensionPixelSize(
                    R.styleable.BaseBarChart_columnDescriptionTextSize,
                    columnDescriptionTextSize);

            valueColumnDescriptionTextSize = arr.getDimensionPixelSize(
                    R.styleable.BaseBarChart_valueTextSize,
                    valueColumnDescriptionTextSize);

            isLining = arr.getBoolean(
                    R.styleable.BaseBarChart_isLining,
                    isLining);

            countShowDescription = arr.getInt(
                    R.styleable.BaseBarChart_countShowDescription,
                    countShowDescription);

            indentValueColumnDescription = arr.getFloat(
                    R.styleable.BaseBarChart_indentValueColumnDescription,
                    indentValueColumnDescription);

            indentColumnDescription = arr.getFloat(
                    R.styleable.BaseBarChart_indentColumnDescription,
                    indentColumnDescription);
        } finally {
            arr.recycle();
        }
    }

    public BaseBarChart(Context context) {
        super(context);
    }

    public BaseBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.loadAttribute(context, attrs);
    }

    public BaseBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.loadAttribute(context, attrs);
    }

    public float getIndentColumnDescription() {
        return indentColumnDescription;
    }

    public void setIndentColumnDescription(float indentColumnDescription) {
        this.indentColumnDescription = indentColumnDescription;
        invalidate();
    }

    public float getIndentValueColumnDescription() {
        return indentValueColumnDescription;
    }

    public void setIndentValueColumnDescription(float indentValueColumnDescription) {
        this.indentValueColumnDescription = indentValueColumnDescription;
        invalidate();
    }


    public int getColumnThickness() {
        return columnThickness;
    }

    public void setColumnThickness(int columnThickness) {
        this.columnThickness = columnThickness;
        invalidate();
    }

    public float getMaxColumnValue() {
        return maxColumnValue;
    }

    public void setMaxColumnValue(float maxColumnValue) {
        this.maxColumnValue = maxColumnValue;
        invalidate();
    }

    public int getColumnDescriptionTextSize() {
        return columnDescriptionTextSize;
    }

    public void setColumnDescriptionTextSize(int columnDescriptionTextSize) {
        this.columnDescriptionTextSize = columnDescriptionTextSize;
        invalidate();
    }

    public int getValueColumnDescriptionTextSize() {
        return valueColumnDescriptionTextSize;
    }

    public void setValueColumnDescriptionTextSize(int valueColumnDescriptionTextSize) {
        this.valueColumnDescriptionTextSize = valueColumnDescriptionTextSize;
        invalidate();
    }

    public boolean isLining() {
        return isLining;
    }

    public void setLining(boolean lining) {
        isLining = lining;
        invalidate();
    }

    public int getCountShowDescription() {
        return countShowDescription;
    }

    public void setCountShowDescription(int countShowDescription) {
        this.countShowDescription = countShowDescription;
        invalidate();
    }

    protected int columnThickness = 77;
    protected float maxColumnValue = 1000;
    protected int columnDescriptionTextSize = 30;
    protected float indentColumnDescription = 50;
    protected int valueColumnDescriptionTextSize = 30;
    protected float indentValueColumnDescription = 50;
    protected boolean isLining = true;
    protected int countShowDescription = 20;

    ArrayList<GroupBarChartData> data = new ArrayList<>();

    LegendView legend;

    public ArrayList<GroupBarChartData> getData() {
        return data;
    }

    public void setData(ArrayList<GroupBarChartData> data) {
        this.data = data;
        invalidate();
    }


    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof BaseBarChart.SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        BaseBarChart.SavedState ss = (BaseBarChart.SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.columnThickness = ss.columnThickness;
        this.maxColumnValue = ss.maxColumnValue;
        this.columnDescriptionTextSize = ss.columnDescriptionTextSize;
        this.indentColumnDescription = ss.indentColumnDescription;
        this.valueColumnDescriptionTextSize = ss.valueColumnDescriptionTextSize;
        this.indentValueColumnDescription = ss.indentValueColumnDescription;
        this.isLining = ss.isLining;
        this.countShowDescription = ss.countShowDescription;
        this.data = ss.data;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BaseBarChart.SavedState ss = new BaseBarChart.SavedState(superState);

        ss.columnThickness = this.columnThickness;
        ss.maxColumnValue = this.maxColumnValue;
        ss.columnDescriptionTextSize = this.columnDescriptionTextSize;
        ss.indentColumnDescription = this.indentColumnDescription;
        ss.valueColumnDescriptionTextSize = this.valueColumnDescriptionTextSize;
        ss.indentValueColumnDescription = this.indentValueColumnDescription;
        ss.isLining = this.isLining;
        ss.countShowDescription = this.countShowDescription;
        ss.data = this.data;

        return ss;
    }

    static class SavedState extends BaseSavedState {
        int columnThickness;
        float maxColumnValue;
        int columnDescriptionTextSize;
        float indentColumnDescription;
        int valueColumnDescriptionTextSize;
        float indentValueColumnDescription;
        boolean isLining;
        int countShowDescription;

        ArrayList<GroupBarChartData> data;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.columnThickness = in.readInt();
            this.maxColumnValue = in.readFloat();
            this.columnDescriptionTextSize = in.readInt();
            this.indentColumnDescription = in.readFloat();
            this.valueColumnDescriptionTextSize = in.readInt();
            this.isLining = in.readInt() == 1;
            this.indentValueColumnDescription = in.readFloat();
            this.countShowDescription = in.readInt();
            in.readTypedList(data, GroupBarChartData.CREATOR);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.columnThickness);
            out.writeFloat(this.maxColumnValue);
            out.writeInt(this.columnDescriptionTextSize);
            out.writeFloat(this.indentColumnDescription);
            out.writeInt(Integer.parseInt(Boolean.toString(this.isLining)));
            out.writeInt(this.valueColumnDescriptionTextSize);
            out.writeFloat(this.indentValueColumnDescription);
            out.writeInt(this.countShowDescription);
            out.writeTypedList(data);
        }

        //required field that makes Parcelables from a Parcel
        public static final Parcelable.Creator<BaseBarChart.SavedState> CREATOR =
                new Parcelable.Creator<BaseBarChart.SavedState>() {
                    public BaseBarChart.SavedState createFromParcel(Parcel in) {
                        return new BaseBarChart.SavedState(in);
                    }

                    public BaseBarChart.SavedState[] newArray(int size) {
                        return new BaseBarChart.SavedState[size];
                    }
                };
    }


    @Override
    public Legend getLegend() {
        LinkedHashSet<String> legendDescription = new LinkedHashSet<>();
        LinkedHashSet<Integer> legendColor = new LinkedHashSet<>();

        for (int i = 0; i < data.size(); i++) {
            GroupBarChartData groupBarChart = data.get(i);
            for (int q = 0; q < groupBarChart.getData().size(); q++) {
                BarChartData legendElement = groupBarChart.getData().get(q);
                legendDescription.add(legendElement.getColumnLegendDescription());
                legendColor.add(legendElement.getColorColumn());
            }
        }

        return new Legend(legendColor.toArray(),legendDescription.toArray());
    }

    @Override
    public void connectToSourceView(LegendView legendView) {
        this.legend = legendView;
    }

    @Override
    public void invalidate() {
        super.invalidate();

        if (legend != null)
            legend.invalidate();
    }
}
