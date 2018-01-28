package com.chape.myarouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt:

               ARouter.getInstance().build("/activity/OneActivity").navigation();
                break;
            case R.id.bt2:
                ARouter.getInstance().build("/activity/TwoActivity").navigation();
                break;
            case R.id.bt3:
                // 来区分环境
            ARouter.getInstance().build("/activity/ThreeActivity").navigation();
                break;
            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);

    }

}
