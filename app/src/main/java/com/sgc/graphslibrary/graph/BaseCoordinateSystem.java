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
        this.loadBaseAttribute(context, attrs);
    }

    public BaseCoordinateSystem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.loadBaseAttribute(context, attrs);
    }
    //
    // Constructors
    //


    /**
     * load and set xml attribute
     */
    protected void loadBaseAttribute(Context context, AttributeSet attrs) {
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
        } finally {
            arr.recycle();
        }
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
     * division line length the axis ordinate and abscissa
     */
    protected int divisionLineThicknessTheAxis = 2;

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
     * step of divisions of the abscissa axis
     */
    protected int stepDivisionsAbscissaAxis = 25;

    /**
     * step of divisions of the ordinate axis
     */
    protected int stepDivisionsOrdinateAxis = 25;

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

    /**
     * @return step of divisions of the abscissa axis
     */
    public int getStepDivisionsAbscissaAxis() {
        return stepDivisionsAbscissaAxis;
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
        return stepDivisionsOrdinateAxis;
    }

    /**
     * @param stepDivisionsOrdinateAxis step of divisions of the ordinate axis
     */
    public void setStepDivisionsOrdinateAxis(int stepDivisionsOrdinateAxis) {
        this.stepDivisionsOrdinateAxis = stepDivisionsOrdinateAxis;
        super.invalidate();
    }

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
        return abscissaAxisShiftUp;
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
        return ordinateAxisShiftRight;
    }

    /**
     * @param ordinateAxisShiftRight The ordinate axis
     *                               shift to the right the axis abscissa.
     */
    public void setOrdinateAxisShiftRight(int ordinateAxisShiftRight) {
        this.ordinateAxisShiftRight = ordinateAxisShiftRight;
        super.invalidate();
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

    protected float getStartX() {
        int startX;

        if (isOrdinateInCenter)
            startX = getWidth() / 2 + ordinateAxisShiftRight;
        else
            startX = ordinateAxisShiftRight;

        return startX;
    }

    protected void drawAbscissaAxis(Canvas canvas) {
        float startY = getStartY();

        float startX = 0;
        float endX = getWidth();
        float endY = startY;

        drawLine(startX, startY, endX, endY, colorAbscissaAxis, abscissaAxisLineThickness, canvas);
    }

    protected float getStartY() {
        int startY;

        if (isAbscissaInCenter) {
            startY = getHeight() / 2 - abscissaAxisShiftUp;
        } else
            startY = getHeight() - abscissaAxisShiftUp;

        return startY;
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
                for (float i = getStartRelativelyCentreAbscissaAxis(); i < endX; i += stepDivisionsAbscissaAxis) {
                    drawLine(i, startLineY, i, endLineY, colorDivisionAbscissaAxis, divisionLineThicknessTheAxis, canvas);
                }
            }
        }
    }

    protected void drawVerticalLine(Canvas canvas, float startLineY, float endLineY,int color,int thickness) {
        if (isShowDivisionAbscissaAxis) {
            if (stepDivisionsAbscissaAxis > 0) {
                for (float i = getStartRelativelyCentreAbscissaAxis(); i < getWidth(); i += stepDivisionsAbscissaAxis) {
                    drawLine(i, startLineY, i, endLineY, color, thickness, canvas);
                }
            }
        }
    }

    /**
     * @return returns the coordinate of the first division along the x axis
     */
    protected float getStartRelativelyCentreAbscissaAxis() {
        float centerX = getStartX();
        while (centerX >= stepDivisionsAbscissaAxis) {
            centerX -= stepDivisionsAbscissaAxis;
        }
        return centerX;
    }

    protected void drawOrdinateDivisions(Canvas canvas) {
        if (isShowDivisionOrdinateAxis) {
            float startX = getStartX();
            float startLineX = startX - divisionLineLengthTheAxis / 2f;
            float endLineX = startX + divisionLineLengthTheAxis / 2f;

            if (stepDivisionsOrdinateAxis > 0) {
                for (float i = getStartRelativelyCentreOrdinateAxis(); i < getHeight(); i += stepDivisionsOrdinateAxis) {
                    drawLine(startLineX, i, endLineX, i, colorDivisionOrdinateAxis, divisionLineThicknessTheAxis, canvas);
                }
            }
        }
    }

    protected void drawHorizontalLine(Canvas canvas, float startLineX, float endLineX,int color,int thickness) {
        if (stepDivisionsOrdinateAxis > 0) {
            for (float i = getStartRelativelyCentreOrdinateAxis(); i < getHeight(); i += stepDivisionsOrdinateAxis) {
                drawLine(startLineX, i, endLineX, i, color, thickness, canvas);
            }
        }
    }

    /**
     * @return returns the coordinate of the first division along the y axis
     */
    protected float getStartRelativelyCentreOrdinateAxis() {
        float centerY = getStartY();
        while (centerY >= stepDivisionsAbscissaAxis) {
            centerY -= stepDivisionsOrdinateAxis;
        }
        return centerY;
    }
}
