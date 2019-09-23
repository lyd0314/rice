package com.example.rice.Entity;
/**
 * (8)获取商品列表*/
public class goodsList_entity {
    private int message;            //后台执行成功或者成功,如果成功则返回1.
    private String data;            //商品数据,由后台组装数据
    private String goodsName;      //商品名称
    private double goodsIntegrals; //兑换商品所需要的积分
    private String goodsImages;  //商品图片
    private int goodsInventory; //商品库存
    private String goodsId;        //商品编号

    public goodsList_entity(int message, String data, String goodsName, double goodsIntegrals, String goodsImages, int goodsInventory, String goodsId) {
        this.message = message;
        this.data = data;
        this.goodsName = goodsName;
        this.goodsIntegrals = goodsIntegrals;
        this.goodsImages = goodsImages;
        this.goodsInventory = goodsInventory;
        this.goodsId = goodsId;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsIntegrals() {
        return goodsIntegrals;
    }

    public void setGoodsIntegrals(double goodsIntegrals) {
        this.goodsIntegrals = goodsIntegrals;
    }

    public String getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(String goodsImages) {
        this.goodsImages = goodsImages;
    }

    public int getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
