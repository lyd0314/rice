package com.example.rice.Entity;
/**(18)安卓二维码*/
public class QRCode_entity {
    private int message;    //执行是否成,后台执行成
    private String url;     //二维码URL,后台生成

    public QRCode_entity(int message, String url) {
        this.message = message;
        this.url = url;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
