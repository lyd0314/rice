package com.example.rice.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rice.R;
import com.example.rice.Base.BaseActivity;
import com.huashi.otg.sdk.HSIDCardInfo;
import com.huashi.otg.sdk.HandlerMsg;
import com.huashi.otg.sdk.HsOtgApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class IDcardActivity extends BaseActivity {

    private TextView skip_qr_code;
    private ImageView imageView;
//    private TextView tv_info;

    boolean m_Auto = false;
    HsOtgApi api;
    //开发api注册（外来SDK注册成功即意味接入成功）
    String filepath="";
    SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");// 设置日期格式

    Handler h = new Handler(){
        public void handleMessage(Message msg) {
            if (msg.what == 99 || msg.what == 100) {
                //statu.setText((String)msg.obj);
            }
            //第一次授权时候的判断是利用handler判断，授权过后就不用这个判断了
            if (msg.what == HandlerMsg.CONNECT_SUCCESS) {
                //tv_info.setText("连接成功");
                //tv_info.setText(api.GetSAMID());

            }
            if (msg.what == HandlerMsg.CONNECT_ERROR) {
                //statu.setText("连接失败");
            }
            if (msg.what == HandlerMsg.READ_ERROR) {
                //cz();
                //statu.setText("卡认证失败");
            }
            if (msg.what == HandlerMsg.READ_SUCCESS) {
                //statu.setText("读卡成功");
                HSIDCardInfo ic = (HSIDCardInfo) msg.obj;
                byte[] fp = new byte[1024];
                fp = ic.getFpDate();
                String m_FristPFInfo = "";
                String m_SecondPFInfo = "";
                if (ic.getcertType() == " ") {
                    /*tv_info.setText("证件类型：身份证\n" + "姓名："
                            + ic.getPeopleName() + "\n" + "性别：" + ic.getSex()
                            + "\n" + "民族：" + ic.getPeople() + "\n" + "出生日期："
                            + df.format(ic.getBirthDay()) + "\n" + "地址："
                            + ic.getAddr() + "\n" + "身份号码：" + ic.getIDCard()
                            + "\n" + "签发机关：" + ic.getDepartment() + "\n"
                            + "有效期限：" + ic.getStrartDate() + "-"
                            + ic.getEndDate() + "\n" + m_FristPFInfo + "\n"
                            + m_SecondPFInfo);*/
                } else {
                    if(ic.getcertType() == "J")
                    {
                        /*tv_info.setText("证件类型：港澳台居住证（J）\n"
                                + "姓名：" + ic.getPeopleName() + "\n" + "性别："
                                + ic.getSex() + "\n"
                                + "签发次数：" + ic.getissuesNum() + "\n"
                                + "通行证号码：" + ic.getPassCheckID() + "\n"
                                + "出生日期：" + df.format(ic.getBirthDay())
                                + "\n" + "地址：" + ic.getAddr() + "\n" + "身份号码："
                                + ic.getIDCard() + "\n" + "签发机关："
                                + ic.getDepartment() + "\n" + "有效期限："
                                + ic.getStrartDate() + "-" + ic.getEndDate() + "\n"
                                + m_FristPFInfo + "\n" + m_SecondPFInfo);*/
                    }
                    else{
                        if(ic.getcertType() == "I")
                        {
                            /*tv_info.setText("证件类型：外国人永久居留证（I）\n"
                                    + "英文名称：" + ic.getPeopleName() + "\n"
                                    + "中文名称：" + ic.getstrChineseName() + "\n"
                                    + "性别：" + ic.getSex() + "\n"
                                    + "永久居留证号：" + ic.getIDCard() + "\n"
                                    + "国籍：" + ic.getstrNationCode() + "\n"
                                    + "出生日期：" + df.format(ic.getBirthDay())
                                    + "\n" + "证件版本号：" + ic.getstrCertVer() + "\n"
                                    + "申请受理机关：" + ic.getDepartment() + "\n"
                                    + "有效期限："+ ic.getStrartDate() + "-" + ic.getEndDate() + "\n"
                                    + m_FristPFInfo + "\n" + m_SecondPFInfo);*/
                        }
                    }

                }


            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idcard);
        filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/wltlib";// 授权目录
        //	filepath = "/mnt/sdcard/wltlib";// 授权目录

        skip_qr_code = findViewById(R.id.skip_qr_code);
        skip_qr_code.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        skip_qr_code.getPaint().setAntiAlias(true);
        skip_qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IDcardActivity.this, QRcodeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.img_id_card);
//        tv_info = findViewById(R.id.tv_info);

        connect();
        autoRead();
    }

    //连接读卡器
    private void connect() {

        copy(IDcardActivity.this, "base.dat", "base.dat", filepath);
        copy(IDcardActivity.this, "license.lic", "license.lic", filepath);
        api = new HsOtgApi(h, IDcardActivity.this);
      int ret = api.init();
     /*    if (ret == 1) {
            tv_info.setText("连接成功");
            tv_info.setText(api.GetSAMID());
        } else {
            tv_info.setText("连接失败");
        }*/
    }

    //自动打开读卡
    private void autoRead(){
        cz();
        if (m_Auto) {
            m_Auto = false;
            //autoread.setText("自动读卡");
        }
        else{
            m_Auto = true;
            new Thread(new CPUThread()).start();
            //autoread.setText("停止读卡");
        }
    }

    private void cz() {
        // TODO Auto-generated method stub
        //tv_info.setText("");
    }

    public class CPUThread extends Thread {
        public CPUThread() {
            super();
        }
        @Override
        public void run() {
            super.run();
            HSIDCardInfo ici;
            Message msg;
            while (m_Auto) {
                if (api.Authenticate(200, 200) != 1) {
                    msg = Message.obtain();
                    msg.what = HandlerMsg.READ_ERROR;
                    h.sendMessage(msg);
                } else {
                    ici = new HSIDCardInfo();
                    if (api.ReadCard(ici, 200, 1300) == 1) {
                        msg = Message.obtain();
                        msg.obj = ici;
                        msg.what = HandlerMsg.READ_SUCCESS;
                        h.sendMessage(msg);
                        Intent intent1 = new Intent(IDcardActivity.this,HomePageActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent1);
                    }
                }
                SystemClock.sleep(300);
            }

        }
    }

    private void copy(Context context, String fileName, String saveName,
                      String savePath) {
        File path = new File(savePath);
        if (!path.exists()) {
            path.mkdir();
        }

        try {
            File e = new File(savePath + "/" + saveName);
            if (e.exists() && e.length() > 0L) {
                Log.i("LU", saveName + "存在了");
                return;
            }

            FileOutputStream fos = new FileOutputStream(e);
            InputStream inputStream = context.getResources().getAssets()
                    .open(fileName);
            byte[] buf = new byte[1024];
            boolean len = false;

            int len1;
            while ((len1 = inputStream.read(buf)) != -1) {
                fos.write(buf, 0, len1);
            }

            fos.close();
            inputStream.close();
        } catch (Exception var11) {
            Log.i("LU", "IO异常");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (api == null) {
            return;
        }
        api.unInit();
    }


}
