package com.linsir.okhttputil.callback;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public interface IGenericsSerializator {
    <T> T transform(String response,Class<T> classOfT);
}
