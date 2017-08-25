package com.linsir.okhttputil.utils;

import android.util.Log;

/**
 * Created by linSir
 * date at 2017/8/23.
 * describe: log 工具类
 */

public class L {

    private static boolean debug = false;

    public static void e(String msg){
        if (debug){
            Log.e("OKHttp",msg);
        }
    }

}
