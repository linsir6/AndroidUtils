package com.linsir.okhttputil.builder;

import com.linsir.okhttputil.request.RequestCall;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by linSir
 * date at 2017/8/25.
 * describe:
 */

public class PostFormBuilder extends OkHttpRequestBuilder<PostFormBuilder> implements HasParamsable {

    private List<FileInput> files = new ArrayList<>;



    @Override
    public OkHttpRequestBuilder params(Map<String, String> params) {
        return null;
    }

    @Override
    public OkHttpRequestBuilder addParams(String key, String val) {
        return null;
    }

    @Override
    public RequestCall build() {
        return null;
    }
}
