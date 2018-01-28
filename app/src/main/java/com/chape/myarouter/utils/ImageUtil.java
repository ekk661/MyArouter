package com.chape.myarouter.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2018/1/22.
 */

public class ImageUtil {
    public static void with(Context context, String imageUrl, ImageView imageView){
        Glide.with(context).load(imageUrl).into(imageView);
    }
}
