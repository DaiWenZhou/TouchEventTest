package com.ucai.toucheventtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/4/17.
 */

public class Mylayout extends LinearLayout{
    public Mylayout(Context context) {
        super(context);
    }

    public Mylayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("test_viewgroup","执行ViewGroup的dispatchTouchEvent()方法");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //默认为不拦截
        Log.i("test_viewgroup","执行ViewGroup的onInterceptTouchEvent()方法");
//        return true;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("test_viewgroup","执行ViewGroup的onTouchEvent()方法");
        return super.onTouchEvent(event);
    }
}
