package com.chape.myarouter.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/22.
 */

public class RetrofitHelper {
    private volatile static Retrofit retrofit=null;
    public static <T> T createApi(Class<T> clazz)
    {
        return getInstance().create(clazz);
    }
    /*
   返回 Retrofit
     */
    private static Retrofit getInstance(){
        if(null==retrofit){
           synchronized (Retrofit.class){
               if(null==retrofit){
                   retrofit=new Retrofit.Builder()
                           .baseUrl("http://gank.io/api/")
                           .client(getokhttp())
                           .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                           .addConverterFactory(GsonConverterFactory.create())
                           .build();
               }

           }
        }
        return retrofit;
    }
/*
返回okhttp
 */
private static OkHttpClient getokhttp(){

    HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);


    return new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .retryOnConnectionFailure(true)//失败重连
            .connectTimeout(15, TimeUnit.SECONDS)//15S连接超时
            .readTimeout(20,TimeUnit.SECONDS)//
            .writeTimeout(20,TimeUnit.SECONDS)//
            .build();
}

}
