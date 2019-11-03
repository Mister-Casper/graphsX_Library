package com.sgc.graphslibrary.graph;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;

import com.sgc.graphslibrary.R;
import com.sgc.graphslibrary.data.LineGraphData;
import com.sgc.graphslibrary.data.ChartCoordinatesData;
import com.sgc.graphslibrary.diagram.PieChart;

import java.util.ArrayList;

public class LineGraph extends BaseCoordinateSystem {

    /**
     * load and set xml attribute
     */
    protected void loadLineGraphAttribute(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.LineGraph);

        try {
            isDivisionDescriptionAxisX = arr.getBoolean(
                    R.styleable.LineGraph_isDivisionDescriptionAxisX,
                    isDivisionDescriptionAxisX);

            isDivisionDescriptionAxisY = arr.getBoolean(
                    R.styleable.LineGraph_isDivisionDescriptionAxisY,
                    isDivisionDescriptionAxisY);

            scaleDivisionDescriptionAxisX = arr.getFloat(
                    R.styleable.LineGraph_scaleDivisionDescriptionAxisX,
                    scaleDivisionDescriptionAxisX);

            scaleDivisionDescriptionAxisY = arr.getFloat(
                    R.styleable.LineGraph_scaleDivisionDescriptionAxisY,
                    scaleDivisionDescriptionAxisY);

            colorDivisionDescriptionAxisX = arr.getColor(
                    R.styleable.LineGraph_colorDivisionDescriptionAxisX,
                    colorDivisionDescriptionAxisX);

            colorDivisionDescriptionAxisY = arr.getColor(
                    R.styleable.LineGraph_colorDivisionDescriptionAxisY,
                    colorDivisionDescriptionAxisY);

            divisionDescriptionSize = arr.getDimensionPixelSize(
                    R.styleable.LineGraph_divisionDescriptionSize,
                    divisionDescriptionSize);

            xOffsetDescriptionDivision = arr.getInt(
                    R.styleable.LineGraph_xOffsetDescriptionDivision,
                    xOffsetDescriptionDivision);

            yOffsetDescriptionDivision = arr.getInt(
                    R.styleable.LineGraph_yOffsetDescriptionDivision,
                    yOffsetDescriptionDivision);

            isShowCoordinateGrid = arr.getBoolean(
                    R.styleable.LineGraph_isShowCoordinateGrid,
                    isShowCoordinateGrid);

            colorCoordinateGrid = arr.getColor(
                    R.styleable.LineGraph_colorCoordinateGrid,
                    colorCoordinateGrid);

            thicknessCoordinateGrid = arr.getInt(
                    R.styleable.LineGraph_thicknessCoordinateGrid,
                    thicknessCoordinateGrid);
        } finally {
            arr.recycle();
        }
    }

    public LineGraph(Context context) {
        super(context);
    }

    public LineGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
        //   super.loadAttribute(context,attrs);
        loadLineGraphAttribute(context, attrs);
    }

    public LineGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // super.loadAttribute(context,attrs);
        loadLineGraphAttribute(context, attrs);
    }

    /**
     * if = true then on the coordinate field is displayed on the coordinate grid
     */
    protected boolean isShowCoordinateGrid = false;

    /**
     * color coordinate grid
     */
    protected int colorCoordinateGrid = Color.LTGRAY;

    /**
     * thickness of the lines of which the grid coordinate
     */
    protected int thicknessCoordinateGrid = 1;

    /**
     * = true if show description division on x axis
     */
    protected boolean isDivisionDescriptionAxisX = true;

    /**
     * = true if show description division on y axis
     */
    protected boolean isDivisionDescriptionAxisY = true;

    /*
     * shows the difference in numbers between
     *  the two closest descriptions division
     * on x axis
     */
    protected float scaleDivisionDescriptionAxisX = 4;

    /*
     * shows the difference in numbers between
     *  the two closest descriptions division
     * on y axis
     */
    protected float scaleDivisionDescriptionAxisY = 4;

    /**
     * color description division on x axis
     */
    protected int colorDivisionDescriptionAxisX = Color.BLACK;

    /**
     * color description division on y axis
     */
    protected int colorDivisionDescriptionAxisY = Color.BLACK;

    /**
     * text size description division
     */
    protected int divisionDescriptionSize = 26;

    /**
     * distance from axis x to description division
     * on x axis
     */
    protected int xOffsetDescriptionDivision = -20;

    /**
     * distance from axis x to description division
     * on y axis
     */
    protected int yOffsetDescriptionDivision = 20;

    /**
     * array chart coordinates
     */
    protected ArrayList<LineGraphData> data = new ArrayList<>();

    /**
     * @return color coordinate grid
     */
    public int getColorCoordinateGrid() {
        return colorCoordinateGrid;
    }

    /**
     * @param colorCoordinateGrid color coordinate grid
     */
    public void setColorCoordinateGrid(int colorCoordinateGrid) {
        this.colorCoordinateGrid = colorCoordinateGrid;
        super.invalidate();
    }

    /**
     * @return thickness of the lines of which the grid coordinate
     */
    public int getThicknessCoordinateGrid() {
        return thicknessCoordinateGrid;
    }

    /**
     * @param thicknessCoordinateGrid thickness of the lines of which the grid coordinate
     */
    public void setThicknessCoordinateGrid(int thicknessCoordinateGrid) {
        this.thicknessCoordinateGrid = thicknessCoordinateGrid;
        super.invalidate();
    }

    /**
     * @return if = true then on the coordinate field is displayed on the coordinate grid
     */
    public boolean isShowCoordinateGrid() {
        return isShowCoordinateGrid;
    }

    /**
     * @param showCoordinateGrid is displayed on the coordinate field is displayed on the coordinate grid
     */
    public void setShowCoordinateGrid(boolean showCoordinateGrid) {
        isShowCoordinateGrid = showCoordinateGrid;
        super.invalidate();
        super.invalidate();
    }

    /**
     * @return true if show description division on x axis else false
     */
    public boolean isDivisionDescriptionAxisX() {
        return isDivisionDescriptionAxisX;
    }

    /**
     * @param divisionDescriptionAxisX true if do you went show description division on x axis
     */
    public void setDivisionDescriptionAxisX(boolean divisionDescriptionAxisX) {
        this.isDivisionDescriptionAxisX = divisionDescriptionAxisX;
        super.invalidate();
    }

    /**
     * @return true if show description division on y axis else false
     */
    public boolean isDivisionDescriptionAxisY() {
        return isDivisionDescriptionAxisY;
    }

    /**
     * @param divisionDescriptionAxisY true if do you went show description division on y axis
     */
    public void setDivisionDescriptionAxisY(boolean divisionDescriptionAxisY) {
        this.isDivisionDescriptionAxisY = divisionDescriptionAxisY;
        super.invalidate();
    }

    /**
     * @return the difference in numbers between
     * the two closest descriptions division
     * on x axis
     */
    public float getScaleDivisionDescriptionAxisX() {
        if (scaleFactor <= 1f)
            return scaleDivisionDescriptionAxisX * (int) (1f / scaleFactor);
        return scaleDivisionDescriptionAxisX / (int) scaleFactor;
    }

    /**
     * @param scaleDivisionDescriptionAxisX the difference in numbers between
     *                                      the two closest descriptions division
     *                                      on x axis
     */
    public void setScaleDivisionDescriptionAxisX(float scaleDivisionDescriptionAxisX) {
        this.scaleDivisionDescriptionAxisX = scaleDivisionDescriptionAxisX;
        super.invalidate();
    }

    /**
     * @return the difference in numbers between
     * the two closest descriptions division
     * on y axis
     */
    public float getScaleDivisionDescriptionAxisY() {
        if (scaleFactor <= 1f)
            return scaleDivisionDescriptionAxisY * (int) (1f / scaleFactor);
        return scaleDivisionDescriptionAxisY / (int) scaleFactor;
    }

    /**
     * @param scaleDivisionDescriptionAxisY the difference in numbers between
     *                                      the two closest descriptions division
     *                                      on y axis
     */
    public void setScaleDivisionDescriptionAxisY(float scaleDivisionDescriptionAxisY) {
        this.scaleDivisionDescriptionAxisY = scaleDivisionDescriptionAxisY;
        super.invalidate();
    }

    /**
     * @return color description division on x axis
     */
    public int getColorDivisionDescriptionAxisX() {
        return colorDivisionDescriptionAxisX;
    }

    /**
     * @param colorDivisionDescriptionAxisX color description division on x axis
     */
    public void setColorDivisionDescriptionAxisX(int colorDivisionDescriptionAxisX) {
        this.colorDivisionDescriptionAxisX = colorDivisionDescriptionAxisX;
        super.invalidate();
    }

    /**
     * @return color description division on y axis
     */
    public int getColorDivisionDescriptionAxisY() {
        return colorDivisionDescriptionAxisY;
    }

    /**
     * @param colorDivisionDescriptionAxisY color description division on y axis
     */
    public void setColorDivisionDescriptionAxisY(int colorDivisionDescriptionAxisY) {
        this.colorDivisionDescriptionAxisY = colorDivisionDescriptionAxisY;
        super.invalidate();
    }

    /**
     * @return text size description division
     */
    public int getDivisionDescriptionSize() {
        return divisionDescriptionSize;
    }

    /**
     * @param divisionDescriptionSize text size description division
     */
    public void setDivisionDescriptionSize(int divisionDescriptionSize) {
        this.divisionDescriptionSize = divisionDescriptionSize;
        super.invalidate();
    }

    /**
     * @return distance from axis x to description division
     * on x axis
     */
    public int getxOffsetDescriptionDivision() {
        return xOffsetDescriptionDivision;
    }

    /**
     * @param xOffsetDescriptionDivision distance from axis x to description division on x axis
     */
    public void setxOffsetDescriptionDivision(int xOffsetDescriptionDivision) {
        this.xOffsetDescriptionDivision = xOffsetDescriptionDivision;
        super.invalidate();
    }

    /**
     * @return distance from axis y to description division on y axis
     */
    public int getyOffsetDescriptionDivision() {
        return yOffsetDescriptionDivision;
    }

    /**
     * @param yOffsetDescriptionDivision distance from axis y to description division on y axis
     */
    public void setyOffsetDescriptionDivision(int yOffsetDescriptionDivision) {
        this.yOffsetDescriptionDivision = yOffsetDescriptionDivision;
        super.invalidate();
    }

    /**
     * @return array chart coordinates
     */
    public ArrayList<LineGraphData> getData() {
        return data;
    }

    /**
     * @param data array chart coordinates
     */
    public void setData(ArrayList<LineGraphData> data) {
        this.data = data;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDivisionDescription(canvas);
        showCoordinateGrid(canvas);
        drawGraph(canvas);
    }

    /**
     * draw graphs by chart coordinates
     *
     * @param canvas
     */
    protected void drawGraph(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        for (int q = 0; q < data.size(); q++) {
            LineGraphData line = data.get(q);
            ArrayList<ChartCoordinatesData> graphPoints = line.getDataLine();
            paint.setColor(line.getLineColor());
            paint.setStrokeWidth(line.getLineThickness());
            paint.setAntiAlias(true);
            drawGraphLine(canvas, graphPoints, paint);
        }
    }

    /**
     * draw graph
     *
     * @param canvas
     * @param graphPoints
     * @param paint
     */
    protected void drawGraphLine(Canvas canvas, ArrayList<ChartCoordinatesData> graphPoints, Paint paint) {
        float[] points = new float[graphPoints.size() * 4];
        for (int q = 0; q < points.length - 4; q++) {
            points[q++] = super.getStartX() + super.getStepDivisionsAbscissaAxis() * graphPoints.get(q / 4).getValueX();
            points[q++] = super.getStartY() - super.getStepDivisionsOrdinateAxis() * graphPoints.get(q / 4).getValueY();
            points[q++] = super.getStartX() + super.getStepDivisionsAbscissaAxis() * graphPoints.get(q / 4 + 1).getValueX();
            points[q] = super.getStartY() - super.getStepDivisionsOrdinateAxis() * graphPoints.get(q / 4 + 1).getValueY();
        }
        canvas.drawLines(points, paint);
    }

    /**
     * draw division description on axis x and y
     *
     * @param canvas
     */
    protected void drawDivisionDescription(Canvas canvas) {
        drawDivisionDescriptionAxisX(canvas);
        drawDivisionDescriptionAxisY(canvas);
    }

    /**
     * draw division description on axis x
     *
     * @param canvas
     */
    protected void drawDivisionDescriptionAxisX(Canvas canvas) {
        if (isDivisionDescriptionAxisX) {
            Paint paint = new Paint();
            paint.setColor(colorDivisionDescriptionAxisX);
            paint.setTextSize(divisionDescriptionSize);
            float startX = super.getStartRelativelyCentreAbscissaAxis();
            float step = super.getStepDivisionsAbscissaAxis();
            int countShowDescription = (int) (getWidth() / step) + 4;
            float startValue = (-((int) getStartX() / getStepDivisionsAbscissaAxis()) * getScaleDivisionDescriptionAxisX());

            float yDivision = getStartY() + yOffsetDescriptionDivision;
            for (int i = 0; i < countShowDescription + 1; i++) {
                float xCurrentDescription = startValue + i * getScaleDivisionDescriptionAxisX();
                xCurrentDescription = Math.round(xCurrentDescription * 100f) / 100f;
                float xCurrentPosition = startX + i * step - stepDivisionsAbscissaAxis / 5f;
                canvas.drawText("" + xCurrentDescription, xCurrentPosition, yDivision, paint);
            }
        }
    }

    /**
     * draw division description on axis y
     *
     * @param canvas
     */
    protected void drawDivisionDescriptionAxisY(Canvas canvas) {
        if (isDivisionDescriptionAxisY) {
            Paint paint = new Paint();
            paint.setColor(colorDivisionDescriptionAxisY);
            paint.setTextSize(divisionDescriptionSize);

            float startY = super.getStartRelativelyCentreOrdinateAxis();
            float step = super.getStepDivisionsOrdinateAxis();
            int countShowDescription = (int) (getHeight() / step) + 4;
            float startValue = (int) ((getStartY() / getStepDivisionsOrdinateAxis())) * getScaleDivisionDescriptionAxisY();
            float xDivision = getStartX() + xOffsetDescriptionDivision;
            for (int i = 0; i < countShowDescription + 1; i++) {
                float yCurrentDescription = startValue - i * getScaleDivisionDescriptionAxisY();
                yCurrentDescription = Math.round(yCurrentDescription * 100f) / 100f;
                float yCurrentPosition = startY + i * step + stepDivisionsAbscissaAxis / 5f;
                if (yCurrentDescription != 0) {
                    canvas.drawText("" + yCurrentDescription, xDivision, yCurrentPosition, paint);
                }
            }
        }
    }

    protected void showCoordinateGrid(Canvas canvas) {
        if (isShowCoordinateGrid) {
            super.drawVerticalLine(canvas, 0, getHeight(), colorCoordinateGrid, thicknessCoordinateGrid);
            super.drawHorizontalLine(canvas, 0, getWidth(), colorCoordinateGrid, thicknessCoordinateGrid);
        }
    }

    protected float getStartValue() {
        float startValue = (-((int) getStartX() / getStepDivisionsAbscissaAxis()) * getScaleDivisionDescriptionAxisX());
        return startValue;
    }

    protected int getCountShowDescription() {
        float step = getStepDivisionsAbscissaAxis();
        int countShowDescription = (int) ((getWidth() / step) + 4 * scaleFactor);

        if (scaleFactor <= 1f)
            countShowDescription *= (int) (1f / scaleFactor);
        else
            countShowDescription /= (int) scaleFactor;

        return countShowDescription;
    }


    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof LineGraph.SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        LineGraph.SavedState ss = (LineGraph.SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.isDivisionDescriptionAxisX = ss.isDivisionDescriptionAxisX;
        this.isDivisionDescriptionAxisY = ss.isDivisionDescriptionAxisY;
        this.scaleDivisionDescriptionAxisX = ss.scaleDivisionDescriptionAxisX;
        this.scaleDivisionDescriptionAxisY = ss.scaleDivisionDescriptionAxisY;
        this.colorDivisionDescriptionAxisX = ss.colorDivisionDescriptionAxisX;
        this.colorDivisionDescriptionAxisY = ss.colorDivisionDescriptionAxisY;
        this.divisionDescriptionSize = ss.divisionDescriptionSize;
        this.xOffsetDescriptionDivision = ss.xOffsetDescriptionDivision;
        this.yOffsetDescriptionDivision = ss.yOffsetDescriptionDivision;
        this.isShowCoordinateGrid = ss.isShowCoordinateGrid;
        this.colorCoordinateGrid = ss.colorCoordinateGrid;
        this.thicknessCoordinateGrid = ss.thicknessCoordinateGrid;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        LineGraph.SavedState ss = new LineGraph.SavedState(superState);

        ss.isDivisionDescriptionAxisX = this.isDivisionDescriptionAxisX;
        ss.isDivisionDescriptionAxisY = this.isDivisionDescriptionAxisY;
        ss.scaleDivisionDescriptionAxisX = this.scaleDivisionDescriptionAxisX;
        ss.scaleDivisionDescriptionAxisY = this.scaleDivisionDescriptionAxisY;
        ss.colorDivisionDescriptionAxisX = this.colorDivisionDescriptionAxisX;
        ss.colorDivisionDescriptionAxisY = this.colorDivisionDescriptionAxisY;
        ss.divisionDescriptionSize = this.divisionDescriptionSize;
        ss.xOffsetDescriptionDivision = this.xOffsetDescriptionDivision;
        ss.yOffsetDescriptionDivision = this.yOffsetDescriptionDivision;
        ss.isShowCoordinateGrid = this.isShowCoordinateGrid;
        ss.colorCoordinateGrid = this.colorCoordinateGrid;
        ss.thicknessCoordinateGrid = this.thicknessCoordinateGrid;

        return ss;
    }


    static class SavedState extends BaseSavedState {
        boolean isDivisionDescriptionAxisX;
        boolean isDivisionDescriptionAxisY;
        float scaleDivisionDescriptionAxisX;
        float scaleDivisionDescriptionAxisY;
        int colorDivisionDescriptionAxisX;
        int colorDivisionDescriptionAxisY;
        int divisionDescriptionSize;
        int xOffsetDescriptionDivision;
        int yOffsetDescriptionDivision;
        boolean isShowCoordinateGrid;
        int colorCoordinateGrid;
        int thicknessCoordinateGrid;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.isDivisionDescriptionAxisX = in.readInt() == 1;
            this.isDivisionDescriptionAxisY = in.readInt() == 1;
            this.scaleDivisionDescriptionAxisX = in.readFloat();
            this.scaleDivisionDescriptionAxisY = in.readFloat();
            this.colorDivisionDescriptionAxisX = in.readInt();
            this.colorDivisionDescriptionAxisY = in.readInt();
            this.divisionDescriptionSize = in.readInt();
            this.xOffsetDescriptionDivision = in.readInt();
            this.yOffsetDescriptionDivision = in.readInt();
            this.isShowCoordinateGrid = in.readInt() == 1;
            this.colorCoordinateGrid = in.readInt();
            this.thicknessCoordinateGrid = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeByte((byte) (this.isDivisionDescriptionAxisX ? 1 : 0));
            out.writeByte((byte) (this.isDivisionDescriptionAxisY ? 1 : 0));
            out.writeFloat(this.scaleDivisionDescriptionAxisX);
            out.writeFloat(this.scaleDivisionDescriptionAxisY);
            out.writeInt(this.colorDivisionDescriptionAxisX);
            out.writeInt(this.colorDivisionDescriptionAxisY);
            out.writeInt(this.divisionDescriptionSize);
            out.writeInt(this.xOffsetDescriptionDivision);
            out.writeInt(this.yOffsetDescriptionDivision);
            out.writeByte((byte) (this.isShowCoordinateGrid ? 1 : 0));
            out.writeInt(this.colorCoordinateGrid);
            out.writeInt(this.thicknessCoordinateGrid);
        }

        //required field that makes Parcelables from a Parcel
        public static final Parcelable.Creator<LineGraph.SavedState> CREATOR =
                new Parcelable.Creator<LineGraph.SavedState>() {
                    public LineGraph.SavedState createFromParcel(Parcel in) {
                        return new LineGraph.SavedState(in);
                    }

                    public LineGraph.SavedState[] newArray(int size) {
                        return new LineGraph.SavedState[size];
                    }
                };
    }
}
