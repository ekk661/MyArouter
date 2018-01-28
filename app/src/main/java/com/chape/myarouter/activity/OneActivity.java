package com.chape.myarouter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chape.myarouter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/activity/OneActivity")
public class OneActivity extends AppCompatActivity {


    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.clear)
    Button clear;
    @BindView(R.id.del)
    Button del;
    @BindView(R.id.chu)
    Button chu;
    @BindView(R.id.cheng)
    Button cheng;
    @BindView(R.id.num1)
    Button num1;
    @BindView(R.id.num2)
    Button num2;
    @BindView(R.id.num3)
    Button num3;
    @BindView(R.id.ruslt)
    Button ruslt;
    @BindView(R.id.num4)
    Button num4;
    @BindView(R.id.num5)
    Button num5;
    @BindView(R.id.num6)
    Button num6;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.num7)
    Button num7;
    @BindView(R.id.num8)
    Button num8;
    @BindView(R.id.num9)
    Button num9;
    @BindView(R.id.minus)
    Button minus;
    @BindView(R.id.num0)
    Button num0;
    @BindView(R.id.and)
    Button and;
    @BindView(R.id.fen)
    Button fen;
    @BindView(R.id.zhen)
    Button zhen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.clear, R.id.del, R.id.chu, R.id.cheng, R.id.num1, R.id.num2, R.id.num3, R.id.ruslt, R.id.num4, R.id.num5, R.id.num6, R.id.add, R.id.num7, R.id.num8, R.id.num9, R.id.minus, R.id.num0, R.id.and, R.id.fen, R.id.zhen})
    public void onViewClicked(View view) {
        String str=tv.getText().toString();
        switch (view.getId()) {
            case R.id.clear:
                str="";
                tv.setText("");
                break;
            case R.id.del:

                break;
            case R.id.chu:
                break;
            case R.id.cheng:
                break;
            case R.id.num1:

                break;
            case R.id.num2:
                break;
            case R.id.num3:
                break;
            case R.id.ruslt:
                break;
            case R.id.num4:
                break;
            case R.id.num5:
                break;
            case R.id.num6:
                break;
            case R.id.add:
                break;
            case R.id.num7:
                break;
            case R.id.num8:
                break;
            case R.id.num9:
                break;
            case R.id.minus:
                break;
            case R.id.num0:
                break;
            case R.id.and:
                break;
            case R.id.fen:
                break;
            case R.id.zhen:
                break;
        }
    }
}
