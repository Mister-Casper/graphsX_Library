package com.sgc.graphslibrary.diagram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.sgc.graphslibrary.data.BarChartData;
import com.sgc.graphslibrary.data.GroupBarChartData;

import java.util.ArrayList;

public class HorizontalBarChart extends BaseBarChart {
    private void init() {
        super.setShowDivisionOrdinateAxis(false);
        super.setShowDivisionAbscissaAxis(false);
    }

    public HorizontalBarChart(Context context) {
        super(context);
        init();
    }

    public HorizontalBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawColumn(canvas);
        drawColumnDescription(canvas);
        drawCValueColumnDescription(canvas);
        drawLining(canvas);
    }

    protected void drawColumn(Canvas canvas) {
        float y = getStartY() - columnThickness / 2f;

        for (int i = 0; i < data.size(); i++) {
            y = getYNextColumn(i, y);

            if (data.get(i).isVerticalLocation())
                drawVerticalGroup(canvas, y, i);
            else
                drawHorizontalGroup(canvas, y, i);
        }
    }

    private float getYNextColumn(int columnNum, float y) {
        float thickness1 = 1f;

        if (columnNum >= 1) {
            if (!data.get(columnNum - 1).isVerticalLocation())
                thickness1 = 0.5f + data.get(columnNum - 1).getData().size() * 0.5f;
        }

        y -= getStepDivisionsOrdinateAxis() * thickness1;
        return y;
    }

    private void drawVerticalGroup(Canvas canvas, float y, int numberGroup) {
        float indentX = 0;
        float width = 0;

        Paint paint = new Paint();
        for (int q = 0; q < data.get(numberGroup).getData().size(); q++) {
            BarChartData currentBarChartData = data.get(numberGroup).getData().get(q);
            paint.setColor(currentBarChartData.getColorColumn());
            width += ((getWidth() - getStartX()) / 100f) * currentBarChartData.getPercentHeight();
            canvas.drawRect(getStartX() + indentX, y - columnThickness, getStartX() + width, y, paint);
            indentX = width;
        }
    }

    private void drawHorizontalGroup(Canvas canvas, float y, int numberGroup) {
        Paint paint = new Paint();
        for (int q = 0; q < data.get(numberGroup).getData().size(); q++) {
            BarChartData currentBarChartData = data.get(numberGroup).getData().get(q);
            paint.setColor(currentBarChartData.getColorColumn());
            float height = ((getWidth() - getStartX()) / 100f) * currentBarChartData.getPercentHeight();
            canvas.drawRect(getStartX(), y - columnThickness * (q), getStartX() + height, y - columnThickness * (q+1), paint);
        }
    }

    protected void drawColumnDescription(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(columnDescriptionTextSize);
        paint.setTextAlign(Paint.Align.CENTER);

        float xDivision = getStartX() - indentColumnDescription;
        float y = getStartY() - columnThickness;

        for (int i = 0; i < data.size(); i++) {
            y = getYNextColumn(i, y);
            if (!data.get(i).isVerticalLocation()) {
                float centerY = y - (data.get(i).getData().size() - 1f) * columnThickness / 2f;
                canvas.drawText("" + data.get(i).getNameColumn(), xDivision, centerY, paint);
            } else
                canvas.drawText("" + data.get(i).getNameColumn(),xDivision, y, paint);
        }
    }

    protected void drawCValueColumnDescription(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(valueColumnDescriptionTextSize);

        float currentX = getStartX() - 75;
        float step = (getWidth() - getStartX()) / countShowDescription;
        float currentY = getStartY() + indentValueColumnDescription;
        for (int i = 1; i <= countShowDescription; i++) {
            int yCurrentDescription = (int) (i * (maxColumnValue / countShowDescription));
            currentX += step;
            canvas.drawText("" + yCurrentDescription, currentX, currentY, paint);
        }
    }

    protected void drawLining(Canvas canvas) {
        if (isLining) {
            float step = ((getWidth() - getStartX()) / countShowDescription);
            float currentX = getStartX();
            float startY = getStartRelativelyCentreOrdinateAxis() - getHeight();
            float endY = getStartRelativelyCentreOrdinateAxis() + getHeight() * 2;

            for (int i = 0; i < step; i++) {
                currentX += step;
                canvas.drawLine(currentX, startY, currentX, endY, new Paint());
            }
        }
    }


}
