package com.bill56.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.bill56.carlife.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bill56 on 2016/5/25.
 */
public class NotificationDetailActivity extends BaseActivity {

    // 显示通知的控件
    private TextView textNotifiTime;

    private TextView textNotifiContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);
        // 初始化控件
        initView();
    }

    private void initView() {
        textNotifiTime = (TextView) findViewById(R.id.text_notifi_time);
        textNotifiContent = (TextView) findViewById(R.id.text_notifi_content);
        String carState = getIntent().getStringExtra("carState");
        long notifiTime = getIntent().getLongExtra("notifiTime",-1);
        if (carState != null && notifiTime > 0) {
            // 将时间格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyw-MM-dd HH:mm:ss");
            Date date = new Date(notifiTime);
            textNotifiTime.setText(sdf.format(date));
            textNotifiContent.setText(carState);
        }
    }

}
