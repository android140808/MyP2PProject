package com.avater.eventtext.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Avater on 2016/11/11 0011.
 */

public class FatherViewGroup extends LinearLayout {
    public FatherViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FatherViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FatherViewGroup(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TAG", "FatherViewGroup dispatchTouchEvent " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        super.onInterceptTouchEvent(ev);
        Log.e("TAG", "FatherViewGroup onInterceptTouchEvent " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "FatherViewGroup onTouchEvent " + event.getAction());
        return super.onTouchEvent(event);
//        return true;
    }
}
