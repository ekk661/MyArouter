package com.chape.myarouter.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chape.myarouter.R;
import com.chape.myarouter.base.BaseFragment;
import com.chape.myarouter.fragment.GankFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/activity/ThreeActivity")
public class ThreeActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.bind(this);
    viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
               return new GankFragment();
           case 1:
               return new BaseFragment();
           case 2:
               return new BaseFragment();
               default:
                   return  new GankFragment();
       }
    }

    @Override
    public int getCount() {
        return 3;
    }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "benj";
                case 1:
                    return "ccc";
                case 2:
                    return "bbbb";
                    default:
                        return "benj";

            }
        }
    });
    tab.setupWithViewPager(viewpager);}
}
