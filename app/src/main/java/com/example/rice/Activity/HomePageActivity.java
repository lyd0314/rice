package com.example.rice.Activity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.rice.R;
import com.example.rice.Base.BaseActivity;
import com.example.rice.Interface.Time;

public class HomePageActivity extends BaseActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private ImageView help;
    private Button exchange;
    private Boolean Item_h = false;
    private Time myTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        help = findViewById(R.id.help);
        help.setOnClickListener(this);
        exchange = findViewById(R.id.exchange);
        exchange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.help:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.exchange:
                Intent intent = new Intent(HomePageActivity.this,GoodsListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void onClick_H(){
        Item_h = true;

    }

    public void setTime(Time myTime){
        this.myTime = myTime;
        myTime.onCencel(Item_h);
    }
}
