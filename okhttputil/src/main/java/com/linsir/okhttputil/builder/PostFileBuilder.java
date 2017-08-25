package com.linsir.okhttputil.builder;

import com.linsir.okhttputil.request.PostFileRequest;
import com.linsir.okhttputil.request.RequestCall;

import java.io.File;

import okhttp3.MediaType;

/**
 * Created by linSir
 * date at 2017/8/25.
 * describe:
 */

public class PostFileBuilder extends OkHttpRequestBuilder<PostFileBuilder> {

    private File file;
    private MediaType mediaType;

    public OkHttpRequestBuilder file(File file) {
        this.file = file;
        return this;
    }

    public OkHttpRequestBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build() {
        return new PostFileRequest(url, tag, params, headers, file, mediaType, id).build();
    }
}
