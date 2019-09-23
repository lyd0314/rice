package com.example.rice.Entity;
/**(17)积分兑换*/
public class integralExchange_entity {
    private int message;        //执行是否成功,后台执行成功或者成功,如果成功则返回1.
    private String integral;    //此次兑换的积分,后台计算出给到安卓

    public integralExchange_entity(int message, String integral) {
        this.message = message;
        this.integral = integral;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }
}
