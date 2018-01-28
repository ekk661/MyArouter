package com.chape.myarouter.adapter;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chape.myarouter.R;
import com.chape.myarouter.model.GankItem;
import com.chape.myarouter.utils.ImageUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/24.
 */

public class Gankadapter extends RecyclerView.Adapter {
    List<GankItem> gankItems;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);
        return new MyViewHolder(view);
    }
public void setGankItems(List<GankItem > gankItems){
        this.gankItems=gankItems;
        notifyDataSetChanged();
}
    @Override
    public int getItemCount() {
        return gankItems==null ? 0 : gankItems.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      MyViewHolder myViewHolder=(MyViewHolder)holder;
      GankItem gankItem=gankItems.get(position);
        ImageUtil.with(((MyViewHolder) holder).imageView.getContext(),gankItem.imageUrl,myViewHolder.imageView);
   myViewHolder.textView.setText(gankItem.description);
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageIv)ImageView imageView;
        @BindView(R.id.descriptionTv)TextView textView;
        public MyViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
