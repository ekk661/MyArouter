package com.chape.myarouter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chape.myarouter.R;
import com.chape.myarouter.adapter.Gankadapter;
import com.chape.myarouter.base.BaseFragment;
import com.chape.myarouter.model.GankItem;
import com.chape.myarouter.network.GankApi;
import com.chape.myarouter.network.GankResultsToGankItem;
import com.chape.myarouter.network.RetrofitHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/24.
 */

public class GankFragment extends BaseFragment {
    Gankadapter gankadapter=new Gankadapter();
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gank, container, false);
        ButterKnife.bind(this, view);
        initview();

        return view;
    }
    private void initview(){
        rv.setLayoutManager(new GridLayoutManager(getContext(),2));
        rv.setAdapter(gankadapter);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.setRefreshing(true);
                loaddata();
            }
        });
    }
private void loaddata(){
        disposable= RetrofitHelper.createApi(GankApi.class).getmeizi(10,1)
                .map(GankResultsToGankItem.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<GankItem>>() {
                    @Override
                    public void accept(List<GankItem> gankItems) throws Exception {
                        refresh.setRefreshing(false);
                        gankadapter.setGankItems(gankItems);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        refresh.setRefreshing(false);
                        Toast.makeText(getActivity(),"数据加载失败",Toast.LENGTH_LONG).show();
                    }
                });
}

}
