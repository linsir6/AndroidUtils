package com.linsir.okhttputil.builder;

import com.linsir.okhttputil.request.PostStringRequest;
import com.linsir.okhttputil.request.RequestCall;

import okhttp3.MediaType;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder> {

    private String content;
    private MediaType mediaType;

    public PostStringBuilder content(String content){
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType){
        this.mediaType = mediaType;
        return this;
    }





    @Override
    public RequestCall build()
    {
        return new PostStringRequest(url, tag, params, headers, content, mediaType,id).build();
    }
}
