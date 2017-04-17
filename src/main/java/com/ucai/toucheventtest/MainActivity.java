package com.ucai.toucheventtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener{
    TextView mTv;
    ImageView mIv;
    Button mBtn;
    int downX;
    int upX ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }
    private void initView() {
        mTv = (TextView) findViewById(R.id.tv_touchtest);
        mBtn = (Button) findViewById(R.id.btn_touchtest);
        mIv = (ImageView) findViewById(R.id.iv_touch_test);
    }
    private void setListener() {
        //控件是否可点击影响着dispatchTouchEvent()方法的返回值，
        //从而影响着事件的后续（move，up）是否可以继续下去
        mTv.setOnTouchListener(this);
        mBtn.setOnTouchListener(this);
        mIv.setOnTouchListener(this);

        //设置点击事件监听时，里面有自动判断去设置点击事件可用
        //即设置监听的方法中使用了setClickable（true），
        //使得控件可点击，从而可用正常继续触摸事件
        mTv.setOnClickListener(this);
        mBtn.setOnClickListener(this);
        mIv.setOnClickListener(this);
        //手动设置成不可点击，这样down动作过后就不会继续动作
//        mTv.setClickable(false);
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //round方法不是单纯的四舍五入，其实四舍六入，且中间0.5时会复杂些
                //这里不管那么多，不需要精确值，当做四舍五入
                downX = Math.round(event.getRawX());
                Log.i("test_touch","onTouch(()方法中，触摸事件为：down按下");
                break;
            case MotionEvent.ACTION_UP:
                //四舍五入
                upX = (int)(event.getRawX()+0.5f);
                Log.i("test_touch","onTouch()方法中，触摸事件为：up抬起");
                //判断移动的距离
                if (upX!=downX){
                    Log.i("test_touch","onTouch(()方法中，触摸事件移动了的像素数："+(upX-downX));

               //使用自定义的toast
              /*在默认的容器中加入内容,就是在原来的基础上加上内容
                    Toast toast=Toast.makeText(getApplicationContext(),"自定义Toast",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                    //Toast默认的VIew为一个LinearLayout
                    LinearLayout toastView = (LinearLayout) toast.getView();
                    toastView.setOrientation(LinearLayout.VERTICAL);
                    toastView.setGravity(Gravity.CENTER_HORIZONTAL);

                    ImageView iv = new ImageView(this);
                    iv.setImageResource(R.mipmap.ic_launcher);
                    toastView.setBackgroundColor(Color.BLUE);
                    TextView tv = new TextView(this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    tv.setLayoutParams(params);
                    tv.setText("你触摸抬起了");
                    float density = getResources().getDisplayMetrics().density;
                    tv.setTextSize(25*density);
                    tv.setTextColor(Color.BLACK);
                    toastView.addView(tv);
                    toastView.addView(iv,params);
             */


              /*当调用了setview，会完全充当toast的显示view，取代原本的linearlayout
                也就是完全自定义的显示Toast
                在这里完全自定义就不需要maketext方法了，因为那方法是创建好一个默认
                方式（应该linearlayout就是默认这样创建的）的包含了view和时间等内容设置的toast，
                我们完全自定义，所以只需要去new一个Toast再设置setview，setduration就可以了。
              */
                    Toast toast = new Toast(this);
                    View view = getLayoutInflater().inflate(R.layout.toast_display_view, null);
                    TextView tv = (TextView) view.findViewById(R.id.tv2);
                    tv.setText("你滑动的距离为："+(upX-downX));
                    toast.setDuration(Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.TOP,0,0);
                    toast.setView(view);
                    toast.show();

                    upX=0;
                    downX=0;
                }
                break;
            case MotionEvent.ACTION_MOVE:
//                Log.i("test_touch","onTouch(()方法中，触摸事件为：move移动");
                break;
        }



        //现在测试为false，理论会执行onTouchEvent方法，如果控件可点击，
        // 则点击事件理论上可以到达，且触摸事件可以继续
        //但需注意控件本身是否可点击影响着结果dispatchTouchEvent的返回值
//        return false;

        //现在测试true
        //这样应该就不会调用到ontouchEvent方法，也就不会调用点击事件
        //但由于dispatchTouchEvent返回true，动作会继续下去
        return true;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_touchtest:
                Log.i("test_touch","点击事件：onClick()方法中，textView");
                break;
            case R.id.btn_touchtest:
                Log.i("test_touch","点击事件：onClick()方法中，Button");
                break;
            case R.id.iv_touch_test:
                Log.i("test_touch","点击事件：onClick()方法中，ImageView");
                break;
        }
    }
}
