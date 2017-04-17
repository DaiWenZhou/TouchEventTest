package com.ucai.toucheventtest.view;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/4/17.
 */

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("test_touch","dispatchTouchEvent()方法中，触摸事件为：down按下");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("test_touch","dispatchTouchEvent()方法中，触摸事件为：up抬起");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("test_touch","dispatchTouchEvent()方法中，触摸事件为：move移动");
        }

        return super.dispatchTouchEvent(event);
    }
}
