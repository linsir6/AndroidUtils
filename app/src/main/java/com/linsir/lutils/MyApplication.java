package com.linsir.lutils;

import android.app.Application;

/**
 * Created by linSir
 * date at 2017/8/21.
 * describe:
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //Stetho.initializeWithDefaults(this);
    }
}
