package com.sgc.graphslibrary.graph;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.sgc.graphslibrary.R;

public class BaseCoordinateSystem extends View {

    //
    // Constructors
    //
    public BaseCoordinateSystem(Context context) {
        super(context);
    }

    public BaseCoordinateSystem(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadAttribute(context, attrs);
    }

    public BaseCoordinateSystem(Context context, AttributeSet attrs, int defStyleAttr) {
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
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.BaseCoordinateSystem);

        try {
            colorAbscissaAxis = arr.getColor(
                    R.styleable.BaseCoordinateSystem_colorAbscissaAxis,
                    colorAbscissaAxis);

            colorOrdinateAxis = arr.getColor(
                    R.styleable.BaseCoordinateSystem_colorOrdinateAxis,
                    colorOrdinateAxis);

            isShowDivisionAbscissaAxis = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_showDivisionAbscissaAxis,
                    isShowDivisionAbscissaAxis);

            isShowDivisionOrdinateAxis = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_showDivisionOrdinateAxis,
                    isShowDivisionOrdinateAxis);

            divisionLineLengthTheAxis = arr.getInt(
                    R.styleable.BaseCoordinateSystem_divisionLineLengthTheAxis,
                    divisionLineLengthTheAxis);

            abscissaAxisLineThickness = arr.getInt(
                    R.styleable.BaseCoordinateSystem_lineThicknessAbscissa,
                    abscissaAxisLineThickness);

            ordinateAxisLineThickness = arr.getInt(
                    R.styleable.BaseCoordinateSystem_lineThicknessOrdinate,
                    ordinateAxisLineThickness);

            abscissaAxisShiftUp = arr.getInt(
                    R.styleable.BaseCoordinateSystem_abscissaAxisShiftUp,
                    abscissaAxisShiftUp);

            ordinateAxisShiftRight = arr.getInt(
                    R.styleable.BaseCoordinateSystem_ordinateAxisShiftRight,
                    ordinateAxisShiftRight);

            isAbscissaInCenter = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_isAbscissaInCenter,
                    isAbscissaInCenter);

            isOrdinateInCenter = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_isOrdinateInCenter,
                    isOrdinateInCenter);
        } finally {
            arr.recycle();
        }
        arr.recycle();
    }

    /**
     * Abscissa axis color.
     * Default : Black.
     */
    protected int colorAbscissaAxis = Color.BLACK;

    /**
     * Ordinate axis color.
     * Default : Black.
     */
    protected int colorOrdinateAxis = Color.BLACK;

    /*
     * if = true The divisions are shown on the abscissa.
     */
    protected boolean isShowDivisionAbscissaAxis = true;

    /*
     * if = true The divisions are shown on the ordinate.
     */
    protected boolean isShowDivisionOrdinateAxis = true;

    /**
     * division line length the axis ordinate and abscissa
     */
    protected int divisionLineLengthTheAxis = 5;

    /**
     * Line thickness abscissa axis
     */
    protected int abscissaAxisLineThickness = 2;

    /**
     * Line thickness ordinate axis
     */
    protected int ordinateAxisLineThickness = 2;

    /**
     * The abscissa axis shift to the up the axis ordinate.
     * With match_parent / 2, the abscissa axis is in the
     * center of the ordinate axis
     */
    protected int abscissaAxisShiftUp = 0;

    /**
     * The ordinate axis shift to the right the axis abscissa.
     * With match_parent / 2, the ordinate axis is in the
     * center of the abscissa axis
     */
    protected int ordinateAxisShiftRight = 0;

    /**
     * = true if the abscissa axis is in the center
     * of the ordinate axis
     */
    protected boolean isAbscissaInCenter = false;

    /*
     * = true if the ordinate axis is in the center
     *  of the abscissa axis
     */
    protected boolean isOrdinateInCenter = false;

    /**
     * @return true if the abscissa axis is in the center
     */
    public boolean isAbscissaInCenter() {
        return isAbscissaInCenter;
    }

    /**
     * @param abscissaInCenter true if you want the abscissa axis to be in the center
     */
    public void setAbscissaInCenter(boolean abscissaInCenter) {
        isAbscissaInCenter = abscissaInCenter;
    }

    /**
     * @return true if the ordinate axis is in the center
     */
    public boolean isOrdinateInCenter() {
        return isOrdinateInCenter;
    }

    /**
     * @param ordinateInCenter true if you want the ordinate axis to be in the center
     */
    public void setOrdinateInCenter(boolean ordinateInCenter) {
        isOrdinateInCenter = ordinateInCenter;
    }

    /**
     * @return The abscissa axis shift to the up the axis ordinate.
     */
    public int getAbscissaAxisShiftUp() {
        return abscissaAxisShiftUp;
    }

    /**
     * @param abscissaAxisShiftUp The abscissa axis shift to the up the axis ordinate.
     */
    public void setAbscissaAxisShiftUp(int abscissaAxisShiftUp) {
        this.abscissaAxisShiftUp = abscissaAxisShiftUp;
    }

    /**
     * @return The ordinate axis shift to the right the axis abscissa.
     */
    public int getOrdinateAxisShiftRight() {
        return ordinateAxisShiftRight;
    }

    /**
     * @param ordinateAxisShiftRight The ordinate axis
     *                               shift to the right the axis abscissa.
     */
    public void setOrdinateAxisShiftRight(int ordinateAxisShiftRight) {
        this.ordinateAxisShiftRight = ordinateAxisShiftRight;
    }

    /**
     * @return Line thickness abscissa axis
     */
    public int getAbscissaAxisLineThickness() {
        return abscissaAxisLineThickness;
    }

    /**
     * @param abscissaAxisLineThickness Line thickness abscissa axis
     */
    public void setAbscissaAxisLineThickness(int abscissaAxisLineThickness) {
        this.abscissaAxisLineThickness = abscissaAxisLineThickness;
    }

    /**
     * @return Line thickness ordinate axis
     */
    public int getOrdinateAxisLineThickness() {
        return ordinateAxisLineThickness;
    }

    /**
     * @param ordinateAxisLineThickness Line thickness ordinate axis
     */
    public void setOrdinateAxisLineThickness(int ordinateAxisLineThickness) {
        this.ordinateAxisLineThickness = ordinateAxisLineThickness;
    }

    /**
     * @return Abscissa axis color.
     */
    public int getColorAbscissaAxis() {
        return colorAbscissaAxis;
    }

    /**
     * @param colorAbscissaAxis Abscissa axis color.
     */
    public void setColorAbscissaAxis(int colorAbscissaAxis) {
        this.colorAbscissaAxis = colorAbscissaAxis;
    }

    /**
     * @return Ordinate axis color.
     */
    public int getColorOrdinateAxis() {
        return colorOrdinateAxis;
    }

    /**
     * @param colorOrdinateAxis Ordinate axis color.
     */
    public void setColorOrdinateAxis(int colorOrdinateAxis) {
        this.colorOrdinateAxis = colorOrdinateAxis;
    }

    /**
     * @return true if the divisions are shown on the abscissa.
     */
    public boolean isShowDivisionAbscissaAxis() {
        return isShowDivisionAbscissaAxis;
    }

    /**
     * @param showDivisionAbscissaAxis the divisions are shown on the abscissa.
     */
    public void setShowDivisionAbscissaAxis(boolean showDivisionAbscissaAxis) {
        isShowDivisionAbscissaAxis = showDivisionAbscissaAxis;
    }

    /**
     * @return true if the divisions are shown on the abscissa.
     */
    public boolean isShowDivisionOrdinateAxis() {
        return isShowDivisionOrdinateAxis;
    }

    /**
     * @param showDivisionOrdinateAxis the divisions are shown on the abscissa.
     */
    public void setShowDivisionOrdinateAxis(boolean showDivisionOrdinateAxis) {
        isShowDivisionOrdinateAxis = showDivisionOrdinateAxis;
    }

    /**
     * @return division line length the axis ordinate and abscissa
     */
    public int getDivisionLineLengthTheAxis() {
        return divisionLineLengthTheAxis;
    }

    /**
     * @param divisionLineLengthTheAxis division line length the axis ordinate and abscissa
     */
    public void setDivisionLineLengthTheAxis(int divisionLineLengthTheAxis) {
        this.divisionLineLengthTheAxis = divisionLineLengthTheAxis;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawAxis(canvas);
    }

    protected void drawAxis(Canvas canvas) {
        drawOrdinateAxis(canvas);
        drawAbscissaAxis(canvas);
    }

    protected void drawOrdinateAxis(Canvas canvas) {
        float startX;

        if (isOrdinateInCenter)
            startX = getWidth() / 2 + ordinateAxisShiftRight;
        else
            startX = ordinateAxisShiftRight;

        float startY = 0;
        float endX = startX;
        float endY = getHeight();

        Paint paint = new Paint();
        paint.setColor(colorOrdinateAxis);
        paint.setStrokeWidth(ordinateAxisLineThickness);
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    protected void drawAbscissaAxis(Canvas canvas) {
        float startY;

        if (isAbscissaInCenter) {
            startY = getHeight() / 2 - abscissaAxisShiftUp;
        } else
            startY = getHeight() - abscissaAxisShiftUp;

        float startX = 0;
        float endX = getWidth();
        float endY = startY;

        Paint paint = new Paint();
        paint.setColor(colorAbscissaAxis);
        paint.setStrokeWidth(abscissaAxisLineThickness);
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

}
