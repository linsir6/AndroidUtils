package com.linsir.okhttputil.Callback;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public interface IGenericsSerializator {
    <T> T transform(String response,Class<T> classOfT);
}
