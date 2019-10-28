package com.sgc.graphslibrary.diagram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.sgc.graphslibrary.maths.AngleMath;
import com.sgc.graphslibrary.maths.Line;
import com.sgc.graphslibrary.R;
import com.sgc.graphslibrary.data.PieChartData;

import java.util.ArrayList;

import static com.sgc.graphslibrary.maths.AngleMath.getAngleOfSectorCenter;
import static com.sgc.graphslibrary.maths.AngleMath.getCompress;

public class PieChart extends View {

    //
    // Constructors
    //

    public PieChart(Context context) {
        super(context);
    }

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadAttribute(context, attrs);
    }

    public PieChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadAttribute(context, attrs);
    }

    //
    // Constructors
    //

    /**
     * load and set xml attribute
     */
    protected void loadAttribute(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.PieChart);
        try {
            descriptionColor = arr.getColor(
                    R.styleable.PieChart_descriptionColor,
                    descriptionColor);

            startAngle = arr.getFloat(
                    R.styleable.PieChart_startAngle,
                    startAngle);

            distanceDescriptionSectorFactor = arr.getFloat(
                    R.styleable.PieChart_distanceDescription,
                    distanceDescriptionSectorFactor);

            descriptionTextSize = arr.getDimensionPixelSize(
                    R.styleable.PieChart_descriptionTextSize,
                    descriptionTextSize);
        } finally {
            arr.recycle();
        }
    }

    /**
     * coordinates of the beginning and end of the pie chart
     */
    protected RectF circle = new RectF();

    /**
     * sector description text color
     */
    protected int descriptionColor = Color.BLACK;

    /**
     * sector description text size
     */
    protected int descriptionTextSize = 16;

    /*
     * angle rotation pie chart
     */
    protected float startAngle = 0;

    /*
     * Remoteness factor of the description of sectors of the chart.
     * Recommend value 1.2 - 1.7
     */
    protected float distanceDescriptionSectorFactor = 1.5f;

    /**
     * data to build pie chart
     */
    protected ArrayList<PieChartData> data;

    /**
     * @return sector description text size
     */
    public int getDescriptionTextSize() {
        return descriptionTextSize;
    }

    /**
     * @param descriptionTextSize sector description text size
     */
    public void setDescriptionTextSize(int descriptionTextSize) {
        this.descriptionTextSize = descriptionTextSize;
        super.invalidate();
    }

    /**
     * @return sector description text color
     */
    public int getDescriptionColor() {
        return descriptionColor;
    }

    /**
     * @return angle rotation pie chart
     */
    public float getStartAngle() {
        return startAngle;
    }

    /**
     * @return Remoteness factor of the description of sectors of the chart.
     */
    public float getDistanceDescriptionSectorFactor() {
        return distanceDescriptionSectorFactor;
    }

    /**
     * @return data to build pie chart
     */
    public ArrayList<PieChartData> getData() {
        return data;
    }

    /**
     * @param descriptionColor sector description text color
     */
    public void setDescriptionColor(int descriptionColor) {
        this.descriptionColor = descriptionColor;
        super.invalidate();
    }

    /**
     * @param startAngle angle rotation pie chart
     */
    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
        super.invalidate();
    }

    /**
     * @param distanceDescriptionSectorFactor Remoteness factor of the description of sectors of the chart.Recommend value : 1.2 - 1.7
     */
    public void setDistanceDescriptionSectorFactor(float distanceDescriptionSectorFactor) {
        this.distanceDescriptionSectorFactor = distanceDescriptionSectorFactor;
        super.invalidate();
    }

    /**
     * @param data data to build pie chart
     */
    public void setData(ArrayList<PieChartData> data) {
        this.data = data;
        super.invalidate();
    }

    /**
     * draw pie chart
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // check data available
        checkDataNull();
        //calculate pie chart coordinates
        createCircleRectF();
        //draw pie chart
        drawCircle(canvas);
        //draw description of each sector
        drawText(canvas);
    }

    /**
     * check data available
     */
    protected void checkDataNull() {
        if (data == null)
            throw new RuntimeException("Most likely you did not transfer data. Call a method setData() +  \n + and pass data to it to build a chart");
    }

    /**
     * calculate pie chart coordinates
     */
    protected void createCircleRectF() {
        int diameter = getDiameter();
        circle.set(0F, 0F, diameter, diameter);
    }

    /**
     * draw pie chart
     *
     * @param canvas canvas on which need to draw pie chart
     */
    protected void drawCircle(Canvas canvas) {
        float compress = getCompress(data);
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

    /**
     * draw description of each sector
     *
     * @param canvas canvas on which need to draw description of each sector
     */
    protected void drawText(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(descriptionTextSize);
        paint.setColor(descriptionColor);
        int diameter = getDiameter();

        for (int i = 0; i < data.size(); i++) {
            float angle = getAngleOfSectorCenter(i, startAngle, data);
            float cosY = (float) Math.cos(Math.toRadians(angle));
            float sinX = (float) Math.sin(Math.toRadians(angle));
            if (data.get(i).getText() != null) {
                canvas.drawText(data.get(i).getText(),
                        getSectorDescriptionPosition(sinX, diameter),
                        getSectorDescriptionPosition(-cosY, diameter), paint);
            }
        }
    }


    /**
     * @param value    cos Y or sin X
     * @param diameter diameter pie chart
     * @return offset x or y
     */
    private float getSectorDescriptionPosition(float value, int diameter) {
        return ((diameter + value * (diameter / 2f) * distanceDescriptionSectorFactor) / 2);
    }

    /**
     * @return Diameter pie chart
     */
    protected int getDiameter() {
        int width = getWidth();
        int height = getHeight();

        if (width >= height)
            return height;
        else
            return width;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float centerX = getDiameter() / 2;
        float centerY = getDiameter() / 2;

        if (!isGoBeyond(centerX, event, centerX)) {
            Line line = new Line(event.getX(), event.getY(), centerX, centerY);
            double angle = AngleMath.getLineAtan2(line, startAngle);
            PieChartData clickSector = AngleMath.findSectorByAngle(angle, getData());

            if (clickSector.getClickListener() != null)
                clickSector.getClickListener().click();
        }

        return super.onTouchEvent(event);
    }

    private boolean isGoBeyond(float center, MotionEvent event, float radius) {
        float offsetX = event.getX() - center;
        float offsetY = event.getY() - center;
        double lengthFromCenter = Math.sqrt(Math.pow(offsetX, 2) + Math.pow(offsetY, 2));
        return lengthFromCenter > radius;
    }
}