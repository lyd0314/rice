package com.example.rice.Custom;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rice.Base.ActivityCollector;
import com.example.rice.Interface.Time;
import com.example.rice.R;

public class TimerLayout extends LinearLayout {

    private ImageView img_timer;
    private TextView tv_timer;
    private Time myTime;

    public TimerLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.timer,this);
        img_timer = findViewById(R.id.img_timer);
        tv_timer = findViewById(R.id.tv_timer);



        final CountDownTimer timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_timer.setText(millisUntilFinished/1000 + "");

            }
            @Override
            public void onFinish() {
                ActivityCollector.finishAll();
            }
        }.start();
    }



}



