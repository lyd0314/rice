package com.example.rice.Entity;
/**(14)垃圾重量上报*/
public class weight_entity {
    private int message;                //消息,后台执行成功或者成功,如果成功则返回1.
    private String launchingRecordId;   //投放记录ID，投放记录ID

    public weight_entity(int message, String launchingRecordId) {
        this.message = message;
        this.launchingRecordId = launchingRecordId;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getLaunchingRecordId() {
        return launchingRecordId;
    }

    public void setLaunchingRecordId(String launchingRecordId) {
        this.launchingRecordId = launchingRecordId;
    }
}
