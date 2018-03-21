package com.example.zsk.smb;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zsk on 2018/3/14.
 */

public class HttpUtil {
    public static void SendOkHttpRequest(String address,String json,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON,json);
        Request request = new Request.Builder()
                .url(address)
                .addHeader("content-type","application/json;charset:utf-8")
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
