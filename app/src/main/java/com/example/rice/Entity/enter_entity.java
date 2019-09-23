package com.example.rice.Entity;
/**
 *  (6)通知安卓进入系统*/
public class enter_entity {

    private String inform;  //返回参数

    public enter_entity(String inform) {
        this.inform = inform;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }
}

