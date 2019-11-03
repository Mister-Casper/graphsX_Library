package com.sgc.graphslibrary.legend;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.sgc.graphslibrary.R;

public class LegendView extends View {

    private int indent = 20;
    private int textSize = 40;

    protected void loadAttribute(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.LegendView);
        try {
            indent = arr.getInt(
                    R.styleable.LegendView_indent,
                    indent);

            textSize = arr.getDimensionPixelSize(
                    R.styleable.LegendView_textSize,
                    textSize);
        } finally {
            arr.recycle();
        }
    }

    public LegendView(Context context) {
        super(context);
    }

    public LegendView(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadAttribute(context, attrs);
    }

    public LegendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadAttribute(context, attrs);
    }

    private SourceLegendListener sourceView;

    public void connectToView(SourceLegendListener sourceView) {
        this.sourceView = sourceView;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        checkSourceViewNotNull();
        Legend legend = sourceView.getLegend();
        if (legend.isVerticalOrientationMode())
            drawVerticalLegend(canvas, legend);
        else
            drawHorizontalLegend(canvas, legend);
    }

    private void checkSourceViewNotNull() {
        if (sourceView == null) {
            throw new RuntimeException("LegendView not connect to graph or diagram view. Call method connectToView() to make it work");
        }
    }

    private void drawVerticalLegend(Canvas canvas, Legend legend) {
        float x = 0;
        float y = 0;

        Paint paint = new Paint();
        Paint textPaint = new Paint();
        textPaint.setTextSize(textSize);

        for (int i = 0; i < legend.getItemsDescription().size(); i++) {
            paint.setColor(legend.getItemsColor().get(i));
            canvas.drawRect(x, y, x + legend.getWidth(), y + legend.getHeight(), paint);
            canvas.drawText(legend.getItemsDescription().get(i), x + legend.getWidth(), y + legend.getHeight() / 1.5f, textPaint);
            y += legend.getHeight() + 20;
        }
    }

    private void drawHorizontalLegend(Canvas canvas, Legend legend) {
        float x = 0;
        float y = 0;

        Paint paint = new Paint();
        Paint textPaint = new Paint();
        textPaint.setTextSize(textSize);

        for (int i = 0; i < legend.getItemsDescription().size(); i++) {
            paint.setColor(legend.getItemsColor().get(i));
            canvas.drawRect(x, y, x + legend.getWidth(), y + legend.getHeight(), paint);
            canvas.drawText(legend.getItemsDescription().get(i), x + legend.getWidth(), y + legend.getHeight() / 1.5f, textPaint);

            String text = legend.getItemsDescription().get(i);
            int textWidth = getTextWidth(text);

            x += legend.getWidth() + textWidth + 20;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        checkSourceViewNotNull();
        Legend legend = sourceView.getLegend();
        int desiredWidth = getLegendWidth(legend);
        int desiredHeight = getLegendHeight(legend);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);
    }

    private int getLegendHeight(Legend legend) {
        if (legend.isVerticalOrientationMode()) {
            int count = legend.getItemsDescription().size();
            float height = count * legend.getHeight() + (count + 1) * indent;
            return (int) height;
        } else
            return legend.getHeight();
    }

    private int getLegendWidth(Legend legend) {
        int maxTextWidth = 0;
        int sumTextWidth = 0;

        for (int i = 0; i < legend.getItemsDescription().size(); i++) {
            String text = legend.getItemsDescription().get(i);
            int textWidth = getTextWidth(text);
            sumTextWidth += textWidth;

            if (textWidth > maxTextWidth)
                maxTextWidth = textWidth;
        }

        if (legend.isVerticalOrientationMode()) {
            return maxTextWidth + legend.getWidth();
        } else {
            int count = legend.getItemsDescription().size();
            return sumTextWidth + count * legend.getWidth() + (count + 1) * indent;
        }
    }

    private int getTextWidth(String text) {
        Paint paint = new Paint();
        Rect bounds = new Rect();

        paint.setTypeface(Typeface.DEFAULT);
        paint.setTextSize(textSize);
        paint.getTextBounds(text, 0, text.length(), bounds);
        int textWidth = bounds.width();

        return textWidth;
    }

}
