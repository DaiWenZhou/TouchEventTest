package com.ucai.toucheventtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    TextView mTv;
    ImageView mIv;
    Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setTouchListener();
    }
    private void initView() {
        mTv = (TextView) findViewById(R.id.tv_touchtest);
        mBtn = (Button) findViewById(R.id.btn_touchtest);
        mIv = (ImageView) findViewById(R.id.iv_touch_test);
    }
    private void setTouchListener() {
        //控件是否可点击影响着dispatchTouchEvent()方法的返回值，
        //从而影响着事件的后续（move，up）是否可以继续下去
        mTv.setOnTouchListener(this);
        mBtn.setOnTouchListener(this);
        mIv.setOnTouchListener(this);
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
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

        return false;
    }
}
