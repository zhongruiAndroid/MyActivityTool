package com.github.activitytools;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;

import androidx.annotation.Nullable;

/**
 * @createBy zhongRui
 * @time 2018-12-13 15:10
 */
public class RequestFragment extends Fragment implements RequestInter, FragmentInter {
    private RequestHelper helper = new RequestHelper();

    private RequestHelper getHelper() {
        if (helper == null) {
            helper = new RequestHelper();
        }
        return helper;
    }


    public static RequestFragment newInstance() {
        RequestFragment fragment = new RequestFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*旋转屏幕保留fragment实例*/
        setRetainInstance(true);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getHelper().onActivityResult(requestCode,resultCode,data);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        getHelper().onDestroy();
    }
    public void startForResult(Class clazz, ResultCallback callback, Pair... pair) {
        startForResult(new Intent(getActivity(), clazz), callback, pair);
    }
    public void startForResult(Intent intent, ResultCallback callback, Pair... pair) {
        if (intent == null) {
            throw new IllegalStateException("intent can not null");
        }
        getHelper().startForResult(this, intent, callback, pair);
    }

    @Override
    public Activity getTheActivity() {
        return getActivity();
    }

    @Override
    public void onStartActivityForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onStartActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivityForResult(intent, requestCode, options);
        } else {
            startActivityForResult(intent, requestCode);
        }
    }

    @Override
    public void onStartActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void onStartActivity(Intent intent, Bundle options) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, options);
        } else {
            startActivity(intent);
        }
    }
}
