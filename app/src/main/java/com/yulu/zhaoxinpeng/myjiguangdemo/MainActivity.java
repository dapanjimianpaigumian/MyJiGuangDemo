package com.yulu.zhaoxinpeng.myjiguangdemo;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.MultiActionsNotificationBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        //设置自定义通知栏样式1
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(MainActivity.this);
        //指定状态栏的小图标
        builder.statusBarDrawable = R.drawable.dog;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
        builder.notificationDefaults = Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
        //设置通知栏编号，样式
        JPushInterface.setPushNotificationBuilder(1,builder);


        //设置自定义通知栏样式2
        MultiActionsNotificationBuilder builder2 = new MultiActionsNotificationBuilder(MainActivity.this);
        //添加按钮，参数(按钮图片、按钮文字、扩展数据)
        builder2.addJPushAction(R.drawable.jpush_ic_richpush_actionbar_back, "first", "my_extra1");
        builder2.addJPushAction(R.drawable.jpush_ic_richpush_actionbar_back, "second", "my_extra2");
        builder2.addJPushAction(R.drawable.jpush_ic_richpush_actionbar_back, "third", "my_extra3");
        JPushInterface.setPushNotificationBuilder(2, builder2);

        //设置自定义通知栏样式3
        CustomPushNotificationBuilder builder3 = new
                CustomPushNotificationBuilder(MainActivity.this,
                R.layout.view_notification,
                R.id.icon,
                R.id.title,
                R.id.text);
        //指定状态栏的小图标
        builder3.statusBarDrawable = R.drawable.dog;
        // 指定最顶层状态栏小图标
        builder3.layoutIconDrawable = R.drawable.yellow;
        // 指定下拉状态栏时显示的通知图标
        JPushInterface.setPushNotificationBuilder(3, builder3);
    }
}
