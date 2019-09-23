package com.example.rice.Adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.rice.Entity.Cart_entity;
import com.example.rice.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context mContext;
    private List<Cart_entity> mCartEntityList;
    private OnClickListener mClickListener;

    public CartAdapter(Context context, OnClickListener clickListener) {
        this.mContext = context;
        this.mClickListener = clickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View CartView;
        ImageView iv_goodsImg;
        TextView tv_good_name;
        TextView tv_cart_stock;
        TextView tv_cart_cost;
        TextView tv_goods_num;
        FrameLayout flJian;
        FrameLayout flJia;
        ImageView del;

        public ViewHolder(View view){
            super(view);
            CartView = view;
            iv_goodsImg = view.findViewById(R.id.iv_goodsImg);
            tv_good_name = view.findViewById(R.id.tv_good_name);
            tv_cart_stock = view.findViewById(R.id.tv_cart_stock);
            tv_cart_cost = view.findViewById(R.id.tv_cart_cost);
            tv_goods_num = view.findViewById(R.id.tv_goods_num);
            flJia = view.findViewById(R.id.fl_jia);
            flJian = view.findViewById(R.id.fl_jian);
            del  =  view.findViewById(R.id.iv_del);
        }
    }

    public CartAdapter(List<Cart_entity> cartEntityList){
        mCartEntityList = cartEntityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.cart_item , parent,false);


        final ViewHolder holder = new ViewHolder(view);

        return new ViewHolder(view);
    }

//    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Cart_entity cartEntity = mCartEntityList.get(position);
        holder.tv_good_name.setText(cartEntity.getName());
        holder.tv_cart_stock.setText("库存：" + cartEntity.getStock());
        holder.tv_cart_cost.setText(cartEntity.getCost());
        holder.tv_goods_num.setText(cartEntity.getNum());
        Glide.with(mContext).load(cartEntity.getImageId()).into(holder.iv_goodsImg);
//        holder.flJia.setImageResource(R.id.fl_jia);
//        holder.flJian.setImageResource(R.id.fl_jian);
//        holder.del.setImageResource(R.id.iv_del);

        holder.flJia.setOnClickListener(view -> mClickListener.add(position));
        holder.flJian.setOnClickListener(view -> mClickListener.reduce(position));
        holder.del.setOnClickListener(view -> mClickListener.del(position));
    }

    @Override
    public int getItemCount(){
        return mCartEntityList.size();
    }

    public interface OnClickListener {
        void reduce(int position);

        void add(int position);

        void del(int position);

    }


}


