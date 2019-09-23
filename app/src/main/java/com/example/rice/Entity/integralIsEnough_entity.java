package com.example.rice.Entity;
/**(9)积分是否足够,库存是否足
 * ①用户选择商品的时候,每点击一次都会查询后台,查询用户的积分是否足够,查看当前点击的商品库存是否足够.*/
public class integralIsEnough_entity {
    private int message;        //消息，后台执行成功或者成功,如果成功则返回1.
    private int enough;         //积分是否足够，由后台判断以后,给到安卓1积分足够
    private int inventory;      //库存，1库存不足

    public integralIsEnough_entity(int message, int enough, int inventory) {
        this.message = message;
        this.enough = enough;
        this.inventory = inventory;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getEnough() {
        return enough;
    }

    public void setEnough(int enough) {
        this.enough = enough;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
