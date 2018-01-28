package com.chape.myarouter.network;

import com.chape.myarouter.model.GankResults;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2018/1/22.
 */

public interface GankApi {
    @GET("data/福利/{num}/{page}")
    Observable<GankResults>  getmeizi(@Path("num")int num, @Path("page") int page);
}
