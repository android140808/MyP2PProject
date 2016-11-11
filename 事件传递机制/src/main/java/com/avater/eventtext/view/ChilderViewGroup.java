package com.avater.eventtext.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Avater on 2016/11/11 0011.
 */

public class ChilderViewGroup extends LinearLayout {
    public ChilderViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ChilderViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChilderViewGroup(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        getParent().requestDisallowInterceptTouchEvent(true);
        Log.e("TAG", "ChilderViewGroup dispatchTouchEvent " + ev.getAction());
        return super.dispatchTouchEvent(ev);
//        return  true;
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        getParent().requestDisallowInterceptTouchEvent(true);
        Log.e("TAG", "ChilderViewGroup setOnTouchListener " + l.toString());
        super.setOnTouchListener(l);
    }
    //    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
////        getParent().requestDisallowInterceptTouchEvent(true);
//        Log.e("TAG", "ChilderViewGroup onInterceptTouchEvent "+ev.getAction());
//        return super.onInterceptTouchEvent(ev);
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP) {
            getParent().requestDisallowInterceptTouchEvent(true);
            Log.e("TAG", "11111111111");
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        Log.e("TAG", "ChilderViewGroup onTouchEvent " + event.getAction());
        return super.onTouchEvent(event);
//        return true;
    }
}
