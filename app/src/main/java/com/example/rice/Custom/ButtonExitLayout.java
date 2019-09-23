package com.example.rice.Custom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.rice.Base.ActivityCollector;
import com.example.rice.R;


public class ButtonExitLayout extends LinearLayout {

    private Button exit;


    public ButtonExitLayout(final Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.button_exit,this);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //ActivityCollector.finishAll();
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("请求退出");
                dialog.setMessage("是否退出登录？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCollector.finishAll();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //
                    }
                });
                dialog.show();
            }
        });
    }
}
