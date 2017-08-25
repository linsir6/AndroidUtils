package com.linsir.okhttputil.utils;

/**
 * Created by linSir
 * date at 2017/8/23.
 * describe:
 */

public class Exceptions {

    public static void illegalArgument(String msg,Object... params){
        throw new IllegalArgumentException(String.format(msg,params));
    }

}
