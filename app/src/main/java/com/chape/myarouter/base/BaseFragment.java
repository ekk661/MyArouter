package com.chape.myarouter.base;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/23.
 */

public class BaseFragment extends Fragment {
    protected Disposable disposable;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
