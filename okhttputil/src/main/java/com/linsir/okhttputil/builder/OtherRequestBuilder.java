package com.linsir.okhttputil.builder;

import com.linsir.okhttputil.request.OtherRequest;
import com.linsir.okhttputil.request.RequestCall;

import okhttp3.RequestBody;

/**
 * Created by linSir
 * date at 2017/8/23.
 * describe:
 */

public class OtherRequestBuilder extends OkHttpRequestBuilder<OtherRequestBuilder> {

    private RequestBody requestBody;
    private String method;
    private String content;

    public OtherRequestBuilder(String method) {
        this.method = method;
    }

    @Override
    public RequestCall build() {
        return new OtherRequest(requestBody, content, method, url, tag, params, headers, id).build();
    }

    public OtherRequestBuilder requestBody(RequestBody requestBody) {
        this.content = content;
        return this;
    }

    public OtherRequestBuilder requestBody(String content) {
        this.content = content;
        return this;
    }


}
