package com.ucai.toucheventtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText et1,et2;
    Button btn;
    TextView tv;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foucs);
        initView();
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et_copy);
        et2 = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
         iv = (ImageView) findViewById(R.id.iv);
        //这下面的测试得出。。只有满足两个属性都为true的控件才可请求获取焦点
//        et2.requestFocus();
//        btn.requestFocus();
//        tv.requestFocus();
//        iv.requestFocus();

//        if (tv.isFocusable()) {
//            Log.i("test_", "TextView的focusable可用");
//        }
//        if (tv.isFocusableInTouchMode()) {
//            Log.i("test_", "TextView的focusableInTouchMode可用");
//        }
//        if (btn.isFocusable()) {
//            Log.i("test_", "Button的focusable可用");
//        }
//        if (btn.isFocusableInTouchMode()) {
//            Log.i("test_", "Button的focusableInTouchMode可用");
//        }
        //让它失去焦点能力，从而让后面的ed2获取焦点
        //只设置这个属性应该就够了，因为其他类型的焦点必须先满足这个属性
        et1.setFocusable(false);
        //为了能让et1重新获取焦点能力
        //至此的实验与自己所推理的一样。逻辑正确。。成功！！！
        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setFocusable(true);
                et1.setFocusableInTouchMode(true);
                et1.requestFocus();

            }
        });
    }
}
