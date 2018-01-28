package com.chape.myarouter.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.chape.myarouter.MyApplication;

/**
 * Created by Administrator on 2018/1/22.
 */

public class NetworkUtil {
    /**
     * 获取网络状态信息
     * @return NetworkInfo
     */
    public static NetworkInfo getNetworkInfo(){
        ConnectivityManager connectivityManager= (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }

    /**
     * 判断是否离线
     * @return true则有网络,否则离线
     */
    public static boolean isNetworkConnected(){
        NetworkInfo activeNetworkInfo = getNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * 判断是否Wifi连线
     * @return true则wifi,否则不是
     */
    public static boolean isWifi(){
        NetworkInfo activeNetworkInfo = getNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }
}
