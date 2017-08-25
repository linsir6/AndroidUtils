package com.linsir.okhttputil.request;

import android.text.TextUtils;

import com.linsir.okhttputil.OkHttpUtils;
import com.linsir.okhttputil.utils.Exceptions;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public class OtherRequest extends OkHttpRequest {

    private static MediaType MEDIA_TYPE_PLAN = MediaType.parse("text/plain;charset=utf-8");

    private RequestBody requestBody;
    private String method;
    private String content;

    public OtherRequest(RequestBody requestBody, String content, String method, String url, Object tag, Map<String, String> params, Map<String, String> headers, int id) {
        super(url, tag, params, headers, id);
        this.requestBody = requestBody;
        this.method = method;
        this.content = content;
    }

    @Override
    protected RequestBody buildRequestBody() {
        if (requestBody == null && TextUtils.isEmpty(content) && HttpMethod.requiresRequestBody(method)) {
            Exceptions.illegalArgument("requestBody and content not be null in method : " + method);
        }

        if (requestBody == null && !TextUtils.isEmpty(content)) {
            requestBody = RequestBody.create(MEDIA_TYPE_PLAN, content);
        }
        return requestBody;
    }

    @Override
    protected Request buildRequest(RequestBody requestBody) {
        if (method.equals(OkHttpUtils.METHOD.PUT)) {
            builder.put(requestBody);
        } else if (method.equals(OkHttpUtils.METHOD.DELETE)) {
            if (requestBody == null) {
                builder.delete();
            } else {
                builder.delete(requestBody);
            }
        } else if (method.equals(OkHttpUtils.METHOD.HEAD)) {
            builder.head();
        } else if (method.equals(OkHttpUtils.METHOD.PATCH)) {
            builder.patch(requestBody);
        }
        return builder.build();
    }


}





























