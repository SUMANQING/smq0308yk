package com.smq.smq0308yk.utils;

import android.util.Log;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Time:2019/3/8
 * <p>
 * Author:Lenovo
 * <p>
 * Description:
 */
public class OkHttpUtils {
    public OkHttpUtils() {};

    public static OkHttpUtils okHttpUtils=null;

    public static OkHttpUtils getInstance(){
        if (okHttpUtils==null){
             okHttpUtils=new OkHttpUtils();
        }
        return okHttpUtils;
    }

    //创建拦截器
    public static Interceptor mInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx",message);
            }
        });
        return httpLoggingInterceptor;
    }
    //封装get方法
    public static void doGet(String url, Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(mInterceptor())
                .build();
        Request request=new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //封装post方法
    public static void doPost(String url, Map<String,String> params,Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(mInterceptor())
                .build();
        FormBody.Builder builder=new FormBody.Builder();
        for (String key:params.keySet()){
            builder.add(key,params.get(key));
        }
        Request request=new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
