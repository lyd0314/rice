package com.example.rice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rice.R;
import com.example.rice.Base.BaseActivity;


public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Button qr_code;//扫二维码按钮
    private Button id_card;//刷身份证按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        qr_code = findViewById(R.id.qr_code);
        id_card = findViewById(R.id.id_card);
        qr_code.setOnClickListener(this);
        id_card.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.qr_code:
                //在此添加逻辑
                Intent intent1 = new Intent(LoginActivity.this, QRcodeActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                break;
            case R.id.id_card:
                //在此添加逻辑
                Intent intent2 = new Intent(LoginActivity.this, IDcardActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }


}
