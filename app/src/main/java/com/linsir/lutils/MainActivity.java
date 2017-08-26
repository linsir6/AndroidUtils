package com.linsir.lutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.linsir.okhttputil.OkHttpUtils;
import com.linsir.okhttputil.callback.StringCallback;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://www.csdn.net/";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("lin", "---lin---> onError");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("lin", "---lin---> onResponse" + response);
                    }
                });
    }
}
