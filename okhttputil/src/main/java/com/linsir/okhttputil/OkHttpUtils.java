package com.linsir.okhttputil;

import com.linsir.okhttputil.Callback.Callback;
import com.linsir.okhttputil.builder.GetBuilder;
import com.linsir.okhttputil.request.RequestCall;
import com.linsir.okhttputil.utils.Platform;

import java.io.IOException;
import java.util.concurrent.Executor;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by linSir
 * date at 2017/8/23.
 * describe: 网络工具类
 */

public class OkHttpUtils {

    public static final long DEFAULT_MILLISECONDS = 10_000L;
    private volatile static OkHttpUtils mInstance;
    private OkHttpClient mOkHttpClient;
    private Platform mPlatform;

    public OkHttpUtils(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        } else {
            mOkHttpClient = okHttpClient;
        }
        mPlatform = Platform.get();
    }

    public static OkHttpUtils initClient(OkHttpClient okHttpClient) {
        if (mInstance == null) {
            synchronized (OkHttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpUtils(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public static OkHttpUtils getInstance() {
        return initClient(null);
    }

    public Executor getDelivery() {
        return mPlatform.defaultCallbackExecutor();
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    public static GetBuilder get() {
        return new GetBuilder();
    }


    public void exectue(final RequestCall requestCall, Callback callback) {
        if (callback == null) {
            callback = Callback.CALLBACK_DEFAULT;
        }
        final Callback finalCallback = callback;
        final int id = requestCall.getOkHttpRequest().getId();

        requestCall.getCall().enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFai
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });


    }

    public void sendFailResultCallback(final Call call, final Exception e, final Callback callback, final int id) {
        if (callback == null){
            return;
        }

        mPlatform.execute(new Runnable() {
            @Override
            public void run() {
                callback.onError(call,e,id);
                callback.onAfter(id);
            }
        });
    }

    public void cancelTag(Object tag){
        for(Call call : mOkHttpClient.dispatcher().queuedCalls()){
            if (tag.equals(call.request().tag())){
                 call.cancel();
            }
        }
        for(Call call: mOkHttpClient.dispatcher().runningCalls()){
            if (tag.equals(call.request().tag())){
                call.cancel();;
            }
        }
    }

    public static class METHOD{
        public static final String HEAD = "HEAD";
        public static final String DELETE = "DELETE";
        public static final String PUT = "PUT";
        public static final String PATCH = "PATCH";
    }


}

























