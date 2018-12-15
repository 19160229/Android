package com.example.weatherdemo.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

//使用okhttp3获取服务器上的省市县三级数据
public class HttpUtil {

    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

}
