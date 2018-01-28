package com.chape.myarouter.utils;

import android.widget.Toast;

import com.chape.myarouter.MyApplication;

/**
 * Created by Administrator on 2018/1/22.
 */

public class TosatUtil {
    public static void show(String msg){
        Toast.makeText(MyApplication.getContext(),msg,Toast.LENGTH_LONG).show();
    }
}
