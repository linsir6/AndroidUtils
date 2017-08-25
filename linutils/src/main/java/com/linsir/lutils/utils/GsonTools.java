package com.linsir.lutils.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by linSir
 * date at 2017/8/21.
 * describe:封装的gson的工具类
 */

public class GsonTools {


    public static<T> String modelToJson(T model){
        Gson gson = new Gson();
        return gson.toJson(model);
    }

    public static <T> T changeGsonToBean(String gsonString, Class<T> cls) {
        Gson gson = new Gson();
        T t = gson.fromJson(gsonString, cls);
        return t;
    }

    public static <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
        }.getType());
        return list;
    }









}
