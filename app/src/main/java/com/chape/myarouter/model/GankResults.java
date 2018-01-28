package com.chape.myarouter.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/1/22.
 */

public class GankResults {
    public boolean error;
    public @SerializedName("results") List<Gank> Ganks;
}
