package com.example.rice.Entity;
/**(3)刷身份证
 * ①用户刷了身份证以后,安卓会上传用户的信息到后台,
 * 后台得到信息,检测这个用户是否有注册过,如果没有则注册一下,
 * 然后查询这个用户是否是黑名单用户,并把用户的id和积分给到安卓,后天如果成功查询到这个用户,
 * 那么把用户信息存在redis以设备号为key*/
public class identityLogin_entity {

//⑧返回参数:后台--->安卓
    private int message;            //消息,后台执行成功或者成功,如果成功则返回1.
    private int blacklist;          //黑名单,判断用户是否是黑名单用户,1则是
    private String userId;          //用户ID,用户注册的时候系统生成的
    private int integral;           //积分余额,用户投放垃圾,获取的

    public identityLogin_entity(int message, int blacklist, String userId, int integral) {
        this.message = message;
        this.blacklist = blacklist;
        this.userId = userId;
        this.integral = integral;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(int blacklist) {
        this.blacklist = blacklist;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }
}
