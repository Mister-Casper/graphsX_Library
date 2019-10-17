package com.sgc.graphslibrary.diagram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.sgc.graphslibrary.data.BarChartData;

import java.util.ArrayList;

public class VerticalBarChart extends BaseBarChart {
    public VerticalBarChart(Context context) {
        super(context);
    }

    public VerticalBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ArrayList<BarChartData> getData() {
        return data;
    }

    public void setData(ArrayList<BarChartData> data) {
        this.data = data;
        invalidate();
    }

    ArrayList<BarChartData> data = new ArrayList<>();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        showColumn(canvas);
    }

    protected void showColumn(Canvas canvas) {
        for(int i = 0 ; i < data.size();i++) {
            float x = getStartX() + (getStepDivisionsAbscissaAxis()*i);
            canvas.drawRect( x, getStartY()- data.get(i).getLength() , x + columnThickness, getStartY(), new Paint());
        }
    }

}
