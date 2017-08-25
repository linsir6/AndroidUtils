package com.linsir.okhttputil.builder;

import java.util.Map;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public interface HasParamsable {

    OkHttpRequestBuilder params(Map<String, String> params);

    OkHttpRequestBuilder addParams(String key, String val);


}
