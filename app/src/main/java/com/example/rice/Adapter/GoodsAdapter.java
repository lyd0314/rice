package com.example.rice.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rice.Entity.Goods_entity;
import com.example.rice.R;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {

    private Context mContext;
    private List<Goods_entity> mGoodsEntityList;
    private OnClickListener mClickListener;

    public GoodsAdapter(Context context, OnClickListener clickListener) {
        this.mContext = context;
        this.mClickListener = clickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView goodsImage;
        TextView goodsName;
        View goodsView;
        ImageView addToCart;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            goodsImage = view.findViewById(R.id.goods_image);
            goodsName = view.findViewById(R.id.goods_name);
            goodsView = view;
            addToCart = view.findViewById(R.id.add_goods_cart);
        }
    }

    public GoodsAdapter(List<Goods_entity> goodsEntityList){
        mGoodsEntityList = goodsEntityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.goods_item , parent,false);

        final ViewHolder holder = new ViewHolder(view);

        return new ViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Goods_entity goodsEntity = mGoodsEntityList.get(position);
        holder.goodsName.setText(goodsEntity.getName());
        Glide.with(mContext).load(goodsEntity.getImageId()).into(holder.goodsImage);
        holder.goodsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mClickListener != null) {
                    mClickListener.itemClick(position);
                }
            }
        });

//        holder.addToCart.setImageResource(R.id.add_goods_cart);
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mClickListener != null) {
                    mClickListener.add(position);
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return mGoodsEntityList.size();
    }

    public interface OnClickListener {

        void add(int position);

        void itemClick(int position);
    }




}
