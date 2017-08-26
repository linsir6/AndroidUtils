package com.linsir.okhttputil.builder;

import com.linsir.okhttputil.OkHttpUtils;
import com.linsir.okhttputil.request.OtherRequest;
import com.linsir.okhttputil.request.RequestCall;

/**
 * Created by linSir
 * date at 2017/8/24.
 * describe:
 */

public class HeadBuilder extends GetBuilder {

    @Override
    public RequestCall build(){
        return new OtherRequest(null,null, OkHttpUtils.METHOD.HEAD,url,tag,params,headers,id).build();
    }



}
