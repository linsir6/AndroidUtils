package com.linsir.okhttputil.callback;

import okhttp3.Response;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public abstract class StringCallback extends Callback<String>{


    @Override
    public String parseNetworkResponse(Response response, int d) throws Exception {
        return response.body().string();
    }

}
