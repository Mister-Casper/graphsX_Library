package com.sgc.graphslibrary.diagram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.sgc.graphslibrary.legend.Legend;
import com.sgc.graphslibrary.legend.LegendView;
import com.sgc.graphslibrary.legend.SourceLegendListener;
import com.sgc.graphslibrary.maths.AngleMath;
import com.sgc.graphslibrary.maths.Line;
import com.sgc.graphslibrary.R;
import com.sgc.graphslibrary.data.PieChartData;

import java.util.ArrayList;

import static androidx.appcompat.widget.LinearLayoutCompat.HORIZONTAL;
import static com.sgc.graphslibrary.maths.AngleMath.getAngleOfSectorCenter;
import static com.sgc.graphslibrary.maths.AngleMath.getCompress;

public class PieChart extends View implements SourceLegendListener {

    LegendView legend;

    OnPieChartClickListener clickListener;

    public OnPieChartClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(OnPieChartClickListener clickListener) {
        this.clickListener = clickListener;
    }

    interface OnPieChartClickListener {
        void click(PieChartData clickPieChart);
    }

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

    @Override
    public void invalidate() {
        super.invalidate();

        if (legend != null)
            legend.invalidate();
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
        float radius = getDiameter() / 2;

        if (!isGoBeyond(centerX, event, radius)) {
            Line line = new Line(event.getX(), event.getY(), centerX, centerY);
            double angle = AngleMath.getLineAtan2(line, startAngle);
            PieChartData clickSector = AngleMath.findSectorByAngle(angle, getData());

            if (clickSector.getClickListener() != null)
                clickSector.getClickListener().click();

            if (clickListener != null)
                clickListener.click(clickSector);
        }

        return super.onTouchEvent(event);
    }

    private boolean isGoBeyond(float center, MotionEvent event, float radius) {
        float offsetX = event.getX() - center;
        float offsetY = event.getY() - center;
        double lengthFromCenter = Math.sqrt(Math.pow(offsetX, 2) + Math.pow(offsetY, 2));
        return lengthFromCenter > radius;
    }

    @Override
    public Legend getLegend() {
        ArrayList<String> legendDescription = new ArrayList<>();
        ArrayList<Integer> legendColor = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            legendColor.add(data.get(i).getColorDedicatedSpace());
            legendDescription.add(data.get(i).getLegendDescription());
        }

        return new Legend(legendColor, legendDescription);
    }

    @Override
    public void connectToSourceView(LegendView legendView) {
        legend = legendView;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof PieChart.SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        PieChart.SavedState ss = (PieChart.SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.descriptionColor = ss.descriptionColor;
        this.startAngle = ss.startAngle;
        this.distanceDescriptionSectorFactor = ss.distanceDescriptionSectorFactor;
        this.descriptionTextSize = ss.descriptionTextSize;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        PieChart.SavedState ss = new PieChart.SavedState(superState);

        ss.descriptionColor = this.descriptionColor;
        ss.startAngle = this.startAngle;
        ss.distanceDescriptionSectorFactor = this.distanceDescriptionSectorFactor;
        ss.descriptionTextSize = this.descriptionTextSize;

        return ss;
    }


    static class SavedState extends BaseSavedState {
        int descriptionColor;
        float startAngle;
        float distanceDescriptionSectorFactor;
        int descriptionTextSize;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.descriptionColor = in.readInt();
            this.startAngle = in.readFloat();
            this.distanceDescriptionSectorFactor = in.readFloat();
            this.descriptionTextSize = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.descriptionColor);
            out.writeFloat(this.startAngle);
            out.writeFloat(this.distanceDescriptionSectorFactor);
            out.writeInt(this.descriptionTextSize);
        }

        //required field that makes Parcelables from a Parcel
        public static final Parcelable.Creator<PieChart.SavedState> CREATOR =
                new Parcelable.Creator<PieChart.SavedState>() {
                    public PieChart.SavedState createFromParcel(Parcel in) {
                        return new PieChart.SavedState(in);
                    }

                    public PieChart.SavedState[] newArray(int size) {
                        return new PieChart.SavedState[size];
                    }
                };
    }
}