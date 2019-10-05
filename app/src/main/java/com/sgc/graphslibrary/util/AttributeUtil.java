package com.sgc.graphslibrary.util;

import android.content.res.TypedArray;

public class AttributeUtil {

    /**
     * get xml attribute
     * @param arr R.styleable attribute
     * @param attr context.obtainStyledAttributes
     * @return string value attribute
     */
    public static String getAttribute(TypedArray arr, int attr) {
        CharSequence startAngleArr = arr.getString(attr);
        String valueStr = null;
        if (startAngleArr != null) {
            valueStr = startAngleArr.toString();
        }
        return valueStr;
    }
}
