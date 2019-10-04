package com.sgc.graphslibrary.diagram;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.icu.text.SymbolTable;
import android.util.AttributeSet;
import android.util.LayoutDirection;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.sgc.graphslibrary.R;
import com.sgc.graphslibrary.model.pieChartData;

import java.util.ArrayList;

public class pieChart extends View {
    public pieChart(Context context) {
        super(context);
    }

    public pieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadAttribute(context, attrs);
    }

    public pieChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadAttribute(context, attrs);
    }

    protected void loadAttribute(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.pieChart);

        String attributeStr = getAttribute(arr, R.styleable.pieChart_startAngle);

        if (attributeStr != null) {
            startAngle = Integer.parseInt(getAttribute(arr, R.styleable.pieChart_startAngle));
        }
        attributeStr = getAttribute(arr, R.styleable.pieChart_descriptionColor);
        if (attributeStr != null) {
            descriptionColor = Color.parseColor(attributeStr);
        }
        attributeStr = getAttribute(arr, R.styleable.pieChart_distanceDescription);
        if (attributeStr != null) {
            distanceDescriptionSectorFactor = Float.parseFloat(attributeStr);
        }

        arr.recycle();  // Do this when done.
    }

    protected String getAttribute(TypedArray arr, int attr) {
        CharSequence startAngleArr = arr.getString(attr);
        String valueStr = null;
        if (startAngleArr != null) {
            valueStr = startAngleArr.toString();
        }
        return valueStr;
    }

    protected RectF circle = new RectF();

    protected int width;
    protected int height;

    protected int descriptionColor;
    protected float startAngle = 0;
    protected float distanceDescriptionSectorFactor = 1.5f;

    protected ArrayList<pieChartData> data;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.width = w;
        this.height = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void setData(ArrayList<pieChartData> data) {
        this.data = data;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        checkDataNull();
        createCircleRectF();
        drawCircle(canvas);
        drawText(canvas);
    }

    protected void createCircleRectF() {
        int diameter = getDiameter();
        circle.set(0F, 0F, diameter, diameter);
    }

    protected void drawCircle(Canvas canvas) {
        float compress = getCompress();
        float sweepAngle;

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        for (int i = 0; i < data.size(); i++) {
            paint.setColor(data.get(i).getColorDedicatedSpace());
            sweepAngle = data.get(i).getPercentageSpace() * compress;
            canvas.drawArc(circle, startAngle, sweepAngle, true, paint);
            startAngle += sweepAngle;
        }
    }

    protected float getCompress() {
        float sumPercent = 0;

        for (int i = 0; i < data.size(); i++) {
            sumPercent += data.get(i).getPercentageSpace();
        }

        int degreesOfCircle = 360;
        return degreesOfCircle / sumPercent;
    }

    protected void drawText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(40);
        paint.setColor(descriptionColor);
        int diameter = getDiameter();

        for (int i = 0; i < data.size(); i++) {
            float angle = getAngleOfSectorCenter(i);
            float cosY = (float) Math.cos(Math.toRadians(angle));
            float sinX = (float) Math.sin(Math.toRadians(angle));
            canvas.drawText(data.get(i).getText(), getSectorDescriptionPosition(sinX, diameter), getSectorDescriptionPosition(-cosY, diameter), paint);
        }
    }

    private float getSectorDescriptionPosition(float value, int diameter) {
        return ((diameter + value * (diameter / 2f) * distanceDescriptionSectorFactor) / 2);
    }

    protected int getDiameter() {
        if (width >= height)
            return height;
        else
            return width;
    }

    protected float getAngleOfSectorCenter(int numberSector) {
        float compress = getCompress();
        float startAngleSector = startAngle + 90;

        for (int i = 0; i <= numberSector; i++) {
            float startCurrentAngleSector = data.get(i).getPercentageSpace() * compress;
            if (i == numberSector)
                startAngleSector += startCurrentAngleSector / 2;
            else
                startAngleSector += startCurrentAngleSector;
        }

        return startAngleSector;
    }

    protected void checkDataNull() {
        if (data == null)
            throw new RuntimeException("Most likely you did not transfer data. Call a method setData() +  \n + and pass data to it to build a chart");
    }
}