package com.sgc.graphslibrary.diagram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.sgc.graphslibrary.data.BarChartData;
import com.sgc.graphslibrary.data.GroupBarChartData;

import java.util.ArrayList;

import androidx.annotation.IntRange;

public class VerticalBarChart extends BaseBarChart {
    private void init() {
        super.setShowDivisionOrdinateAxis(false);
        super.setShowDivisionAbscissaAxis(false);
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

    public ArrayList<GroupBarChartData> getData() {
        return data;
    }

    public void setData(ArrayList<GroupBarChartData> data) {
        this.data = data;
        invalidate();
    }

    ArrayList<GroupBarChartData> data = new ArrayList<>();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawColumn(canvas);
        drawColumnDescription(canvas);
        drawCValueColumnDescription(canvas);
        drawLining(canvas);
    }

    protected void drawColumn(Canvas canvas) {
        float x = getStartX() - columnThickness / 2f;

        for (int i = 0; i < data.size(); i++) {
            x = getXNextColumn(i, x);

            if (data.get(i).isVerticalLocation())
                drawVerticalGroup(canvas, x, i);
            else
                drawHorizontalGroup(canvas, x, i);
        }
    }

    private float getXNextColumn(int columnNum, float x) {
        float thickness1 = 1f;

        if (columnNum >= 1) {
            if (!data.get(columnNum - 1).isVerticalLocation())
                thickness1 = 0.5f + data.get(columnNum - 1).getData().size() * 0.5f;
        }

        x += getStepDivisionsAbscissaAxis() * thickness1;
        return x;
    }

    private void drawVerticalGroup(Canvas canvas, float x, int numberGroup) {
        float indentX = 0;
        float height = 0;

        Paint paint = new Paint();
        for (int q = 0; q < data.get(numberGroup).getData().size(); q++) {
            BarChartData currentBarChartData = data.get(numberGroup).getData().get(q);
            paint.setColor(currentBarChartData.getColorColumn());
            height += ((getStartY() / 100f) * currentBarChartData.getPercentHeight());
            canvas.drawRect(x - columnThickness, getStartY() - height, x, getStartY() - indentX, paint);
            indentX = height;
        }
    }

    private void drawHorizontalGroup(Canvas canvas, float x, int numberGroup) {
        Paint paint = new Paint();
        for (int q = 0; q < data.get(numberGroup).getData().size(); q++) {
            BarChartData currentBarChartData = data.get(numberGroup).getData().get(q);
            paint.setColor(currentBarChartData.getColorColumn());
            float height = ((getStartY() / 100f) * currentBarChartData.getPercentHeight());
            canvas.drawRect(x + columnThickness * (q - 1), getStartY() - height, x + columnThickness * (q), getStartY(), paint);
        }
    }

    protected void drawColumnDescription(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(columnDescriptionTextSize);
        paint.setTextAlign(Paint.Align.CENTER);

        float yDivision = getStartY() + indentColumnDescription;
        float x = getStartX() - columnThickness;

        for (int i = 0; i < data.size(); i++) {
            x = getXNextColumn(i, x);
            if (!data.get(i).isVerticalLocation()) {
                float centerX = x + (data.get(i).getData().size()-1f) * columnThickness/2f;
                canvas.drawText("" + data.get(i).getNameColumn(), centerX, yDivision, paint);
            } else
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }
}
