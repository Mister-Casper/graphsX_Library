package com.sgc.graphslibrary.diagram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.sgc.graphslibrary.data.BarChartData;

import java.util.ArrayList;

import androidx.annotation.IntRange;

public class VerticalBarChart extends BaseBarChart {
    private void init() {
        super.setShowDivisionOrdinateAxis(false);
    }

    public VerticalBarChart(Context context) {
        super(context);
        init();
    }

    public VerticalBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerticalBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
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
        drawColumn(canvas);
        drawColumnDescription(canvas);
        drawCValueColumnDescription(canvas);
        drawLining(canvas);
    }

    protected void drawColumn(Canvas canvas) {
        for (int i = 0; i < data.size(); i++) {
            float x = getStartX() + getStepDivisionsAbscissaAxis() * (i + 1) - columnThickness / 2f;
            Paint paint = new Paint();
            paint.setColor(data.get(i).getColorColumn());
            float height = ((getStartY() / 100f) * data.get(i).getPercentHeight());
            canvas.drawRect(x, getStartY() - height, x + columnThickness, getStartY(), paint);
        }
    }

    protected void drawColumnDescription(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(columnDescriptionTextSize);
        paint.setTextAlign(Paint.Align.LEFT);

        float yDivision = getStartY() + indentColumnDescription;
        for (int i = 0; i < data.size(); i++) {
            float x = getStartX() + getStepDivisionsAbscissaAxis() * (i + 1) - columnThickness / 2f;
            canvas.drawText("" + data.get(i).getNameColumn(), x, yDivision, paint);
        }
    }

    protected void drawCValueColumnDescription(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(valueColumnDescriptionTextSize);

        int startY = (int) getStartY();
        int step = startY / countShowDescription;
        int currentY = startY + 15;
        for (int i = 1; i <= countShowDescription; i++) {
            int yCurrentDescription = (int) (i * (maxColumnValue / countShowDescription));
            currentY -= step;
            canvas.drawText("" + yCurrentDescription, getStartX() - indentValueColumnDescription, currentY, paint);
        }
    }

    protected void drawLining(Canvas canvas) {
        if (isLining) {
            float step = (getStartY() / countShowDescription);
            float currentY = getStartY();
            float startX = getStartRelativelyCentreAbscissaAxis() - getWidth();
            float endX = getStartRelativelyCentreAbscissaAxis() + getWidth() * 2;

            for (int i = 0; i < step; i++) {
                currentY -= step;
                canvas.drawLine(startX, currentY, endX, currentY, new Paint());
            }
        }
    }

}
