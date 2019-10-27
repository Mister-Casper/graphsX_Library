package com.sgc.graphslibrary.graph;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.sgc.graphslibrary.R;

public class BaseCoordinateSystem extends View {
    //<editor-fold desc="Constructors">
    public BaseCoordinateSystem(Context context) {
        super(context);
    }

    public BaseCoordinateSystem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.loadBaseAttribute(context, attrs);
    }

    public BaseCoordinateSystem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.loadBaseAttribute(context, attrs);
    }
    //</editor-fold>
    //<editor-fold desc="load attribute">

    /**
     * load and set xml attribute
     */
    protected void loadBaseAttribute(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.BaseCoordinateSystem);
        scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        mGestureDetector = new GestureDetector(context, mGestureListener);
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

            divisionLineThicknessTheAxis =
                    arr.getInt(
                            R.styleable.BaseCoordinateSystem_divisionLineThicknessTheAxis,
                            divisionLineThicknessTheAxis);

            abscissaAxisLineThickness = arr.getInt(
                    R.styleable.BaseCoordinateSystem_lineThicknessAbscissa,
                    abscissaAxisLineThickness);

            ordinateAxisLineThickness = arr.getInt(
                    R.styleable.BaseCoordinateSystem_lineThicknessOrdinate,
                    ordinateAxisLineThickness);

            abscissaAxisShiftUp = arr.getFloat(
                    R.styleable.BaseCoordinateSystem_abscissaAxisShiftUp,
                    abscissaAxisShiftUp);

            ordinateAxisShiftRight = arr.getFloat(
                    R.styleable.BaseCoordinateSystem_ordinateAxisShiftRight,
                    ordinateAxisShiftRight);

            isAbscissaInCenter = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_isAbscissaInCenter,
                    isAbscissaInCenter);

            isOrdinateInCenter = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_isOrdinateInCenter,
                    isOrdinateInCenter);

            stepDivisionsAbscissaAxis = arr.getInt(
                    R.styleable.BaseCoordinateSystem_stepDivisionsAbscissaAxis,
                    stepDivisionsAbscissaAxis);

            stepDivisionsOrdinateAxis = arr.getInt(
                    R.styleable.BaseCoordinateSystem_stepDivisionsOrdinateAxis,
                    stepDivisionsOrdinateAxis);

            colorDivisionAbscissaAxis = arr.getInt(
                    R.styleable.BaseCoordinateSystem_colorDivisionAbscissaAxis,
                    colorDivisionAbscissaAxis);

            colorDivisionOrdinateAxis = arr.getInt(
                    R.styleable.BaseCoordinateSystem_colorDivisionOrdinateAxis,
                    colorDivisionOrdinateAxis);

            isHorizontalScroll = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_isHorizontalScroll,
                    isHorizontalScroll);

            isVerticalScroll = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_isVerticalScroll,
                    isVerticalScroll);

            isScaling = arr.getBoolean(
                    R.styleable.BaseCoordinateSystem_isScaling,
                    isScaling);

            minScaling = arr.getFloat(
                    R.styleable.BaseCoordinateSystem_minScaling,
                    minScaling);

            maxScaling = arr.getFloat(
                    R.styleable.BaseCoordinateSystem_maxScaling,
                    maxScaling);

            scaleFactor = arr.getFloat(
                    R.styleable.BaseCoordinateSystem_scaleFactor,
                    scaleFactor);
        } finally {
            arr.recycle();
        }
    }
    //</editor-fold>

    //<editor-fold desc="Color axes">
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
        super.invalidate();
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
        super.invalidate();
    }
    //</editor-fold>
    //<editor-fold desc="Division color">
    /**
     * Abscissa division axis color.
     * Default : Black.
     */
    protected int colorDivisionAbscissaAxis = Color.BLACK;

    /**
     * Ordinate division axis color.
     * Default : Black.
     */
    protected int colorDivisionOrdinateAxis = Color.BLACK;

    /**
     * @return Abscissa division axis color.
     */
    public int getColorDivisionAbscissaAxis() {
        return colorDivisionAbscissaAxis;
    }

    /**
     * @param colorDivisionAbscissaAxis Abscissa division axis color.
     */
    public void setColorDivisionAbscissaAxis(int colorDivisionAbscissaAxis) {
        this.colorDivisionAbscissaAxis = colorDivisionAbscissaAxis;
        super.invalidate();
    }

    /**
     * @return Ordinate division axis color.
     */
    public int getColorDivisionOrdinateAxis() {
        return colorDivisionOrdinateAxis;
    }

    /**
     * @param colorDivisionOrdinateAxis Ordinate division axis color.
     */
    public void setColorDivisionOrdinateAxis(int colorDivisionOrdinateAxis) {
        this.colorDivisionOrdinateAxis = colorDivisionOrdinateAxis;
        super.invalidate();
    }

    //</editor-fold>
    //<editor-fold desc="Is show division">
    /*
     * if = true The divisions are shown on the abscissa.
     */
    protected boolean isShowDivisionAbscissaAxis = true;

    /*
     * if = true The divisions are shown on the ordinate.
     */
    protected boolean isShowDivisionOrdinateAxis = true;

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
        super.invalidate();
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
        this.isShowDivisionOrdinateAxis = showDivisionOrdinateAxis;
        super.invalidate();
    }
    //</editor-fold>
    //<editor-fold desc="Division parameters">
    /**
     * division line length the axis ordinate and abscissa
     */
    protected int divisionLineLengthTheAxis = 5;

    /**
     * division line length the axis ordinate and abscissa
     */
    protected int divisionLineThicknessTheAxis = 2;

    public int getDivisionLineThicknessTheAxis() {
        return divisionLineThicknessTheAxis;
    }

    public void setDivisionLineThicknessTheAxis(int divisionLineThicknessTheAxis) {
        this.divisionLineThicknessTheAxis = divisionLineThicknessTheAxis;
        super.invalidate();
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
        super.invalidate();
    }
    //</editor-fold>
    //<editor-fold desc="axes thickness">
    /**
     * Line thickness abscissa axis
     */
    protected int abscissaAxisLineThickness = 2;

    /**
     * Line thickness ordinate axis
     */
    protected int ordinateAxisLineThickness = 2;

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
        super.invalidate();
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
        super.invalidate();
    }
    //</editor-fold>
    //<editor-fold desc="Axes location">
    /**
     * The abscissa axis shift to the up the axis ordinate.
     * With match_parent / 2, the abscissa axis is in the
     * center of the ordinate axis
     */
    protected float abscissaAxisShiftUp = 0;

    /**
     * The ordinate axis shift to the right the axis abscissa.
     * With match_parent / 2, the ordinate axis is in the
     * center of the abscissa axis
     */
    protected float ordinateAxisShiftRight = 0;

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
        this.isAbscissaInCenter = abscissaInCenter;
        super.invalidate();
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
        this.isOrdinateInCenter = ordinateInCenter;
        super.invalidate();
    }

    /**
     * @return The abscissa axis shift to the up the axis ordinate.
     */
    public int getAbscissaAxisShiftUp() {
        return (int) (abscissaAxisShiftUp * scaleFactor);
    }

    /**
     * @param abscissaAxisShiftUp The abscissa axis shift to the up the axis ordinate.
     */
    public void setAbscissaAxisShiftUp(int abscissaAxisShiftUp) {
        this.abscissaAxisShiftUp = abscissaAxisShiftUp;
        super.invalidate();
    }

    /**
     * @return The ordinate axis shift to the right the axis abscissa.
     */
    public int getOrdinateAxisShiftRight() {
        return (int) (ordinateAxisShiftRight * scaleFactor);
    }

    /**
     * @param ordinateAxisShiftRight The ordinate axis
     *                               shift to the right the axis abscissa.
     */
    public void setOrdinateAxisShiftRight(int ordinateAxisShiftRight) {
        this.ordinateAxisShiftRight = ordinateAxisShiftRight;
        super.invalidate();
    }
    //</editor-fold>
    //<editor-fold desc="Division step">
    /**
     * step of divisions of the abscissa axis
     */
    protected int stepDivisionsAbscissaAxis = 25;

    /**
     * step of divisions of the ordinate axis
     */
    protected int stepDivisionsOrdinateAxis = 25;

    /**
     * @return step of divisions of the abscissa axis
     */
    public int getStepDivisionsAbscissaAxis() {
        if (scaleFactor <= 1f)
            return (int) (stepDivisionsAbscissaAxis * scaleFactor) * (int) (1f / scaleFactor);
        else
            return (int) (stepDivisionsAbscissaAxis * scaleFactor) / (int) scaleFactor;
    }

    /**
     * @param stepDivisionsAbscissaAxis step of divisions of the abscissa axis
     */
    public void setStepDivisionsAbscissaAxis(int stepDivisionsAbscissaAxis) {
        this.stepDivisionsAbscissaAxis = stepDivisionsAbscissaAxis;
        super.invalidate();
    }

    /**
     * @return step of divisions of the ordinate axis
     */
    public int getStepDivisionsOrdinateAxis() {
        if (scaleFactor <= 1f)
            return (int) (stepDivisionsOrdinateAxis * scaleFactor) * (int) (1f / scaleFactor);
        else
            return (int) (stepDivisionsOrdinateAxis * scaleFactor) / (int) scaleFactor;
    }

    /**
     * @param stepDivisionsOrdinateAxis step of divisions of the ordinate axis
     */
    public void setStepDivisionsOrdinateAxis(int stepDivisionsOrdinateAxis) {
        this.stepDivisionsOrdinateAxis = stepDivisionsOrdinateAxis;
        super.invalidate();
    }

    //</editor-fold>
    //<editor-fold desc="scroll">
    protected boolean isHorizontalScroll = false;
    protected boolean isVerticalScroll = false;

    public boolean isHorizontalScroll() {
        return isHorizontalScroll;
    }

    public void setHorizontalScroll(boolean horizontalScroll) {
        isHorizontalScroll = horizontalScroll;
    }

    public boolean isVerticalScroll() {
        return isVerticalScroll;
    }

    public void setVerticalScroll(boolean verticalScroll) {
        isVerticalScroll = verticalScroll;
    }

    //</editor-fold>
    //<editor-fold desc="scale">
    protected boolean isScaling = false;
    protected float minScaling = 0.5f;
    protected float maxScaling = 2.0f;
    protected float scaleFactor = 1f;

    public boolean isScaling() {
        return isScaling;
    }


    public void setScaling(boolean scaling) {
        isScaling = scaling;
    }

    public float getMinScaling() {
        return minScaling;
    }

    public void setMinScaling(float minScaling) {
        this.minScaling = minScaling;
    }

    public float getMaxScaling() {
        return maxScaling;
    }

    public void setMaxScaling(float maxScaling) {
        this.maxScaling = maxScaling;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
    }
    //</editor-fold>

    //<editor-fold desc="Draw">
    @Override
    protected void onDraw(Canvas canvas) {
        drawAxis(canvas);
    }

    protected void drawAxis(Canvas canvas) {
        drawOrdinateAxis(canvas);
        drawAbscissaAxis(canvas);
        drawDivisions(canvas);
    }

    protected void drawOrdinateAxis(Canvas canvas) {
        float startX = getStartX();

        float startY = 0;
        float endX = startX;
        float endY = getHeight();

        drawLine(startX, startY, endX, endY, colorOrdinateAxis, ordinateAxisLineThickness, canvas);
    }

    protected void drawAbscissaAxis(Canvas canvas) {
        float startY = getStartY();

        float startX = 0;
        float endX = getWidth();
        float endY = startY;

        drawLine(startX, startY, endX, endY, colorAbscissaAxis, abscissaAxisLineThickness, canvas);
    }

    protected void drawLine(float x1, float y1, float x2, float y2, int lineColor, int lineStroke, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(lineColor);
        paint.setStrokeWidth(lineStroke);
        canvas.drawLine(x1, y1, x2, y2, paint);
    }

    protected void drawDivisions(Canvas canvas) {
        drawAbscissaDivisions(canvas);
        drawOrdinateDivisions(canvas);
    }

    protected void drawAbscissaDivisions(Canvas canvas) {
        if (isShowDivisionAbscissaAxis) {
            float endX = getWidth();
            float startY = getStartY();

            float startLineY = startY - divisionLineLengthTheAxis / 2f;
            float endLineY = startY + divisionLineLengthTheAxis / 2f;

            if (stepDivisionsAbscissaAxis > 0) {
                for (float i = getStartRelativelyCentreAbscissaAxis(); i < endX; i += getStepDivisionsAbscissaAxis()) {
                    drawLine(i, startLineY, i, endLineY, colorDivisionAbscissaAxis, divisionLineThicknessTheAxis, canvas);
                }
            }
        }
    }

    protected void drawVerticalLine(Canvas canvas, float startLineY, float endLineY, int color, int thickness) {
        if (isShowDivisionAbscissaAxis) {
            if (stepDivisionsAbscissaAxis > 0) {
                for (float i = getStartRelativelyCentreAbscissaAxis(); i < getWidth(); i += getStepDivisionsAbscissaAxis()) {
                    drawLine(i, startLineY, i, endLineY, color, thickness, canvas);
                }
            }
        }
    }

    protected void drawOrdinateDivisions(Canvas canvas) {
        if (isShowDivisionOrdinateAxis) {
            float startX = getStartX();
            float startLineX = startX - divisionLineLengthTheAxis / 2f;
            float endLineX = startX + divisionLineLengthTheAxis / 2f;

            if (stepDivisionsOrdinateAxis > 0) {
                for (float i = getStartRelativelyCentreOrdinateAxis(); i < getHeight(); i += getStepDivisionsOrdinateAxis()) {
                    drawLine(startLineX, i, endLineX, i, colorDivisionOrdinateAxis, divisionLineThicknessTheAxis, canvas);
                }
            }
        }
    }

    protected void drawHorizontalLine(Canvas canvas, float startLineX, float endLineX, int color, int thickness) {
        if (stepDivisionsOrdinateAxis > 0) {
            for (float i = getStartRelativelyCentreOrdinateAxis(); i < getHeight(); i += getStepDivisionsOrdinateAxis()) {
                drawLine(startLineX, i, endLineX, i, color, thickness, canvas);
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Axes start coordinates">
    protected float getStartX() {
        int startX;

        if (isOrdinateInCenter)
            startX = getWidth() / 2 + getOrdinateAxisShiftRight();
        else
            startX = getOrdinateAxisShiftRight();

        return startX;
    }


    protected float getStartY() {
        int startY;

        if (isAbscissaInCenter) {
            startY = getHeight() / 2 - getAbscissaAxisShiftUp();
        } else
            startY = getHeight() - getAbscissaAxisShiftUp();

        return startY;
    }
    //</editor-fold>

    //<editor-fold desc="Start division cordinates">

    /**
     * @return returns the coordinate of the first division along the x axis
     */
    protected float getStartRelativelyCentreAbscissaAxis() {
        float centerX = getStartX();
        int countStepToCenter = (int) (centerX / getStepDivisionsAbscissaAxis());
        float start = centerX - countStepToCenter * getStepDivisionsAbscissaAxis();
        return start;
    }

    /**
     * @return returns the coordinate of the first division along the y axis
     */
    protected float getStartRelativelyCentreOrdinateAxis() {
        float centerY = getStartY();
        int countStepToCenter = (int) (centerY / getStepDivisionsOrdinateAxis());
        float start = centerY - countStepToCenter * getStepDivisionsOrdinateAxis();
        return start;
    }
    //</editor-fold>

    //<editor-fold desc="Touch , scroll, scale ">

    private ScaleGestureDetector scaleGestureDetector;
    private GestureDetector mGestureDetector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isScaling) {
            scaleGestureDetector.onTouchEvent(event);
        }

        if (!scaleGestureDetector.isInProgress()) {
            mGestureDetector.onTouchEvent(event);
        }

        invalidate();
        return true;
    }

    private GestureDetector.SimpleOnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            horizontalScroll(-distanceX);
            verticalScroll(-distanceY);
            return true;
        }
    };

    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(minScaling, Math.min(scaleFactor, maxScaling));
            scaleFactor = Math.round(scaleFactor * 100f) / 100f;
            return true;
        }
    }


    private void horizontalScroll(float distanceX) {
        if (isHorizontalScroll) {
            ordinateAxisShiftRight += distanceX / scaleFactor;
        }
    }

    private void verticalScroll(float distanceX) {
        if (isVerticalScroll) {
            abscissaAxisShiftUp -= distanceX / scaleFactor;
        }
    }
    //</editor-fold>


    //<editor-fold desc="Save state">

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //begin boilerplate code so parent classes can restore state
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        this.colorAbscissaAxis = ss.colorAbscissaAxis;
        this.colorOrdinateAxis = ss.colorOrdinateAxis;
        this.colorDivisionAbscissaAxis = ss.colorDivisionAbscissaAxis;
        this.colorDivisionOrdinateAxis = ss.colorDivisionOrdinateAxis;
        this.isShowDivisionAbscissaAxis = ss.isShowDivisionAbscissaAxis;
        this.isShowDivisionOrdinateAxis = ss.isShowDivisionOrdinateAxis;
        this.divisionLineLengthTheAxis = ss.divisionLineLengthTheAxis;
        this.divisionLineThicknessTheAxis = ss.divisionLineThicknessTheAxis;
        this.abscissaAxisLineThickness = ss.abscissaAxisLineThickness;
        this.ordinateAxisLineThickness = ss.ordinateAxisLineThickness;
        this.abscissaAxisShiftUp = ss.abscissaAxisShiftUp;
        this.ordinateAxisShiftRight = ss.ordinateAxisShiftRight;
        this.isAbscissaInCenter = ss.isAbscissaInCenter;
        this.isOrdinateInCenter = ss.isOrdinateInCenter;
        this.stepDivisionsAbscissaAxis = ss.stepDivisionsAbscissaAxis;
        this.stepDivisionsOrdinateAxis = ss.stepDivisionsOrdinateAxis;
        this.isHorizontalScroll = ss.isHorizontalScroll;
        this.isVerticalScroll = ss.isVerticalScroll;
        this.isScaling = ss.isScaling;
        this.minScaling = ss.minScaling;
        this.maxScaling = ss.maxScaling;
        this.scaleFactor = ss.scaleFactor;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        //begin boilerplate code that allows parent classes to save state
        Parcelable superState = super.onSaveInstanceState();

        SavedState ss = new SavedState(superState);
        //end

        ss.colorAbscissaAxis = this.colorAbscissaAxis;
        ss.colorOrdinateAxis = this.colorOrdinateAxis;
        ss.colorDivisionAbscissaAxis = this.colorDivisionAbscissaAxis;
        ss.colorDivisionOrdinateAxis = this.colorDivisionOrdinateAxis;
        ss.isShowDivisionAbscissaAxis = this.isShowDivisionAbscissaAxis;
        ss.isShowDivisionOrdinateAxis = this.isShowDivisionOrdinateAxis;
        ss.divisionLineLengthTheAxis = this.divisionLineLengthTheAxis;
        ss.divisionLineThicknessTheAxis = this.divisionLineThicknessTheAxis;
        ss.abscissaAxisLineThickness = this.abscissaAxisLineThickness;
        ss.ordinateAxisLineThickness = this.ordinateAxisLineThickness;
        ss.abscissaAxisShiftUp = this.abscissaAxisShiftUp;
        ss.ordinateAxisShiftRight = this.ordinateAxisShiftRight;
        ss.isAbscissaInCenter = this.isAbscissaInCenter;
        ss.isOrdinateInCenter = this.isOrdinateInCenter;
        ss.stepDivisionsAbscissaAxis = this.stepDivisionsAbscissaAxis;
        ss.stepDivisionsOrdinateAxis = this.stepDivisionsOrdinateAxis;
        ss.isHorizontalScroll = this.isHorizontalScroll;
        ss.isVerticalScroll = this.isVerticalScroll;
        ss.isScaling = this.isScaling;
        ss.minScaling = this.minScaling;
        ss.maxScaling = this.maxScaling;
        ss.scaleFactor = this.scaleFactor;
        return ss;
    }

    static class SavedState extends BaseSavedState {
        int colorAbscissaAxis;
        int colorOrdinateAxis;
        int colorDivisionAbscissaAxis;
        int colorDivisionOrdinateAxis;
        boolean isShowDivisionAbscissaAxis;
        boolean isShowDivisionOrdinateAxis;
        int divisionLineLengthTheAxis;
        int divisionLineThicknessTheAxis;
        int abscissaAxisLineThickness;
        int ordinateAxisLineThickness;
        float abscissaAxisShiftUp;
        float ordinateAxisShiftRight;
        boolean isAbscissaInCenter;
        boolean isOrdinateInCenter;
        int stepDivisionsAbscissaAxis;
        int stepDivisionsOrdinateAxis;
        boolean isHorizontalScroll;
        boolean isVerticalScroll;
        boolean isScaling;
        float minScaling;
        float maxScaling;
        float scaleFactor;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.colorAbscissaAxis = in.readInt();
            this.colorOrdinateAxis = in.readInt();
            this.colorDivisionAbscissaAxis = in.readInt();
            this.colorDivisionOrdinateAxis = in.readInt();
            this.isShowDivisionAbscissaAxis = in.readInt() == 1;
            this.isShowDivisionOrdinateAxis = in.readInt() == 1;
            this.divisionLineLengthTheAxis = in.readInt();
            this.divisionLineThicknessTheAxis = in.readInt();
            this.abscissaAxisLineThickness = in.readInt();
            this.ordinateAxisLineThickness = in.readInt();
            this.abscissaAxisShiftUp = in.readInt();
            this.ordinateAxisShiftRight = in.readInt();
            this.isAbscissaInCenter = in.readInt() == 1;
            this.isOrdinateInCenter = in.readInt() == 1;
            this.stepDivisionsAbscissaAxis = in.readInt();
            this.stepDivisionsOrdinateAxis = in.readInt();
            this.isHorizontalScroll = in.readInt() == 1;
            this.isVerticalScroll = in.readInt() == 1;
            this.isScaling = in.readInt() == 1;
            this.minScaling = in.readFloat();
            this.maxScaling = in.readFloat();
            this.scaleFactor = in.readFloat();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.colorAbscissaAxis);
            out.writeInt(this.colorOrdinateAxis);
            out.writeInt(this.colorDivisionAbscissaAxis);
            out.writeInt(this.colorDivisionOrdinateAxis);
            out.writeInt(Integer.parseInt(Boolean.toString(this.isShowDivisionAbscissaAxis)));
            out.writeInt(Integer.parseInt(Boolean.toString(this.isShowDivisionOrdinateAxis)));
            out.writeInt(this.divisionLineLengthTheAxis);
            out.writeInt(this.divisionLineThicknessTheAxis);
            out.writeInt(this.abscissaAxisLineThickness);
            out.writeInt(this.ordinateAxisLineThickness);
            out.writeFloat(this.abscissaAxisShiftUp);
            out.writeFloat(this.ordinateAxisShiftRight);
            out.writeInt(Integer.parseInt(Boolean.toString(this.isAbscissaInCenter)));
            out.writeInt(Integer.parseInt(Boolean.toString(this.isOrdinateInCenter)));
            out.writeInt(this.stepDivisionsAbscissaAxis);
            out.writeInt(this.stepDivisionsOrdinateAxis);
            out.writeInt(Integer.parseInt(Boolean.toString(this.isHorizontalScroll)));
            out.writeInt(Integer.parseInt(Boolean.toString(this.isVerticalScroll)));
            out.writeInt(Integer.parseInt(Boolean.toString(this.isScaling)));
            out.writeFloat(this.minScaling);
            out.writeFloat(this.maxScaling);
            out.writeFloat(this.scaleFactor);
        }

        //required field that makes Parcelables from a Parcel
        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
                    public SavedState createFromParcel(Parcel in) {
                        return new SavedState(in);
                    }

                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                };
    }
    //</editor-fold>
}
