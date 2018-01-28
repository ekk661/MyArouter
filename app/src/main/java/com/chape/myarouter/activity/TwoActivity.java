package com.chape.myarouter.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chape.myarouter.R;
import com.chape.myarouter.adapter.Gankadapter;
import com.chape.myarouter.model.GankItem;
import com.chape.myarouter.network.GankApi;
import com.chape.myarouter.network.GankResultsToGankItem;
import com.chape.myarouter.network.RetrofitHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.chape.myarouter.MyApplication.getContext;

@Route(path = "/activity/TwoActivity")
public class TwoActivity extends AppCompatActivity {
    Gankadapter gankadapter=new Gankadapter();
    Disposable disposable;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
        initview();
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
        disposable= RetrofitHelper.createApi(GankApi.class).getmeizi(10,8)
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
                        Toast.makeText(getContext(),"数据加载失败",Toast.LENGTH_LONG).show();
                    }
                });
    }

}
