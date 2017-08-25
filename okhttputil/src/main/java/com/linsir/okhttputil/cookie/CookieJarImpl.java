package com.linsir.okhttputil.cookie;

import com.linsir.okhttputil.cookie.store.CookieStore;
import com.linsir.okhttputil.utils.Exceptions;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public class CookieJarImpl implements CookieJar{

    private CookieStore cookieStore;

    public CookieJarImpl(CookieStore cookieStore){
        if (cookieStore == null){
            Exceptions.illegalArgument("cookieStore can not be null");
            this.cookieStore = cookieStore;
        }

    }


    @Override
    public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cookieStore.add(url,cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return cookieStore.get(url);
    }

    public CookieStore getCookieStore(){
        return cookieStore;
    }



}
