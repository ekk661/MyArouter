package com.chape.myarouter.network;

import com.chape.myarouter.model.Gank;
import com.chape.myarouter.model.GankItem;
import com.chape.myarouter.model.GankResults;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2018/1/22.
 */

public class GankResultsToGankItem implements Function<GankResults,List<GankItem>> {
    private static GankResultsToGankItem Instance=new GankResultsToGankItem();
    private GankResultsToGankItem(){

    }
    public static GankResultsToGankItem getInstance(){
        return Instance;
    }

    @Override
    public List<GankItem> apply(GankResults gankResults) throws Exception {
       List<Gank> Ganks=gankResults.Ganks;
       List<GankItem> items=new ArrayList<>(Ganks.size());

        SimpleDateFormat inputFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outFormat=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        for(Gank gank:Ganks){
            GankItem gankItem=new GankItem();
            try {
                Date data=inputFormat.parse(gank.createdAt);
                gankItem.description=outFormat.format(data);
            }catch (ParseException e){
                e.printStackTrace();
                gankItem.description="unknow data";

            }
            gankItem.imageUrl=gank.url;
            items.add(gankItem);
        }
        return items;
    }
}
