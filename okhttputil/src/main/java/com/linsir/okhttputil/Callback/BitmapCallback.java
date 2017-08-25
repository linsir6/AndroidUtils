package com.linsir.okhttputil.Callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public abstract class BitmapCallback extends Callback<Bitmap>{

    @Override
    public Bitmap parseNetworkResponse(Response response, int d) throws Exception {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }
}
