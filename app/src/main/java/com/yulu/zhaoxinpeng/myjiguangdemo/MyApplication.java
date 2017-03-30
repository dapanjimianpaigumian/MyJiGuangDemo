package com.yulu.zhaoxinpeng.myjiguangdemo;

import android.app.Application;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/3/30.
 */

public class MyApplication extends Application {

    private static final String TAG="JPush";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"[MyApplication] onCreate");

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
