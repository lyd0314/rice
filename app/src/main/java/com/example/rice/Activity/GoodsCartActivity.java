package com.example.rice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rice.R;
import com.example.rice.Adapter.CartAdapter;
import com.example.rice.Base.ActivityCollector;
import com.example.rice.Base.BaseActivity;
import com.example.rice.Entity.Cart_entity;
import com.example.rice.Entity.Goods_entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoodsCartActivity extends BaseActivity implements View.OnClickListener {

    private Cart_entity[] cart_entities ={
            new Cart_entity("矿泉水", R.drawable.u361,"20","10","1"),
            new Cart_entity("矿泉水", R.drawable.u361,"20","10","5"),
            new Cart_entity("矿泉水", R.drawable.u361,"20","10","3")
    };

    private List<Cart_entity> cartEntityList =  new ArrayList<>();
    private CartAdapter adapter;
    private Button goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_cart);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        initCart();
        adapter = new CartAdapter(cartEntityList);
                /*getApplicationContext(), new CartAdapter.OnClickListener() {*/
          /*  @Override
            public void reduce(int position) {

            }

            @Override
            public void add(int position) {

            }

            @Override
            public void del(int position) {

            }
        });*/
        recyclerView.setAdapter(adapter);

        goback = findViewById(R.id.goback);
        goback.setOnClickListener(this);
    }

    private void initCart(){
        cartEntityList.clear();
        for (int i = 0; i<5 ; i++){
            Random random = new Random();
            int index = random.nextInt(cart_entities.length);
            cartEntityList.add(cart_entities[index]);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goback:
                Intent intent = new Intent(GoodsCartActivity.this,GoodsListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }


}
