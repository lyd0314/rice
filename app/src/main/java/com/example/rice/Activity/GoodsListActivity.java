package com.example.rice.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rice.R;
import com.example.rice.Adapter.GoodsAdapter;
import com.example.rice.Base.BaseActivity;
import com.example.rice.Entity.Goods_entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoodsListActivity extends BaseActivity implements View.OnClickListener{

    //商品数据，待改
    private  Goods_entity[] goods = {
            new Goods_entity("矿泉水", R.drawable.u361), new Goods_entity("加多宝",R.drawable.u361),new Goods_entity("百事",R.drawable.u361),
            new Goods_entity("健力宝",R.drawable.u361),new Goods_entity("可口可乐",R.drawable.u361),new Goods_entity("水水水水水",R.drawable.u361),
            new Goods_entity("尖叫",R.drawable.u361),new Goods_entity("好好饮",R.drawable.u361),new Goods_entity("超级好饮",R.drawable.u361)};

    private List<Goods_entity> goodsEntityList = new ArrayList<>();

    private GoodsAdapter adapter;
    private ImageView goods_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        initGoods();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        goods_cart = findViewById(R.id.goods_cart);
        goods_cart.setOnClickListener(this);


        //改动排列方式，一行多少个，竖排横排
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

        //getContext可能待改
        adapter = new GoodsAdapter(goodsEntityList);
                /*getApplicationContext(), new GoodsAdapter.OnClickListener() {

            @Override
            public void add(int position) {
                //参考之前项目的GoodsFragment.java
                if (addCartOrItemClickListener != null) {
                    addCartOrItemClickListener.onAddCart();
                }
            }

            @Override
            public void itemClick(int position) {
                //参考之前项目的GoodsFragment.java
            }
        });*/
        recyclerView.setAdapter(adapter);
    }

    private void initGoods(){
        goodsEntityList.clear();
        for (int i = 0; i<50 ; i++){
            Random random = new Random();
            int index = random.nextInt(goods.length);
            goodsEntityList.add(goods[index]);
        }
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.goods_cart:
                Intent intent = new Intent(GoodsListActivity.this,GoodsCartActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            default:
                break;
        }


    }

    public interface AddCartOrItemClickListener {
        void onAddCart();

        void onBuy();
    }

    private AddCartOrItemClickListener addCartOrItemClickListener;

}
