package com.linsir.okhttputil.request;

import com.linsir.okhttputil.OkHttpUtils;
import com.linsir.okhttputil.callback.Callback;
import com.linsir.okhttputil.utils.Exceptions;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by linSir
 * date at 2017/8/25.
 * describe:
 */

public class PostFileRequest extends OkHttpRequest {

    private static MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");

    private File file;
    private MediaType mediaType;

    public PostFileRequest(String url, Object tag, Map<String, String> params, Map<String, String> headers, File file, MediaType mediaType, int id) {
        super(url, tag, params, headers, id);
        this.file = file;
        this.mediaType = mediaType;
        if (this.file == null) {
            Exceptions.illegalArgument("the file can not be null !");
        }
        if(this.mediaType == null){
            this.mediaType = MEDIA_TYPE_STREAM;
        }
    }

    @Override
    protected RequestBody buildRequestBody() {
        return RequestBody.create(mediaType,file);
    }

    protected RequestBody wrapRequestBody(RequestBody requestBody, final Callback callback){
        if(callback == null){
            return requestBody;
        }
        CountingRequestBody countingRequestBody = new CountingRequestBody(requestBody,
        new CountingRequestBody.Listener() {
            @Override
            public void onRequestProgress(final long byteWritten, final long contentLength) {
                OkHttpUtils.getInstance().getDelivery().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.inProgress(byteWritten*1.0f/contentLength,contentLength,id);
                    }
                });
            }
        });
        return countingRequestBody;
    }

    @Override
    protected Request buildRequest(RequestBody requestBody) {
        return builder.post(requestBody).build();
    }
}
