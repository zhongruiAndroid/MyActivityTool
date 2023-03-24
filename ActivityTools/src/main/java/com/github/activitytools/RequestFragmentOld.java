package com.github.activitytools;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

import androidx.annotation.Nullable;

import java.util.Random;

/**
 * @createBy zhongRui
 * @time 2018-12-13 15:10
 */
public class RequestFragmentOld extends Fragment implements RequestInter {

    private SparseArray<ResultCallback> sparseArray = new SparseArray<>();

    public static RequestFragmentOld newInstance() {
        RequestFragmentOld fragment = new RequestFragmentOld();
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
        ResultCallback resultCallback = sparseArray.get(requestCode);
        sparseArray.remove(requestCode);
        if (resultCallback != null) {
            resultCallback.onActivityResult(resultCode, data);
        }
    }

    public int setCallbackForCode(ResultCallback callback) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        int requestCode = getRequestCode();
        sparseArray.put(requestCode, callback);
        return requestCode;
    }

    private int getRequestCode() {
        /*现在1000到9999生成requestCode 如果超过十次一样，就取100到999*/
        Random random = new Random();
        int nextInt;
        int count = 0;
        do {
            if (count >= 10) {
                nextInt = random.nextInt(900) + 100;
            } else {
                nextInt = random.nextInt(9000) + 1000;
            }
            count++;
        } while (sparseArray.indexOfKey(nextInt) >= 0);
        return nextInt;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (sparseArray != null) {
            sparseArray.clear();
        }
        sparseArray = null;
    }

    public void startForResult(Intent intent, ResultCallback callback, Pair... pair) {
        if (intent == null) {
            throw new IllegalStateException("intent can not null");
        }
        int callbackForCode = setCallbackForCode(callback);

        if (pair != null && pair.length > 0 && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pair);
            startActivityForResult(intent, callbackForCode, options.toBundle());
        } else {
            startActivityForResult(intent, callbackForCode);
        }
    }

    public void startForResult(Intent intent, ResultCallback callback) {
        startForResult(intent, callback, new Pair[0]);
    }

    public void startForResult(Intent intent, Class clazz, ResultCallback callback, Pair... pair) {
        if (intent == null) {
            intent = new Intent(getActivity(), clazz);
        } else {
            intent.setClass(getActivity(), clazz);
        }

        int callbackForCode = setCallbackForCode(callback);

        if (pair != null && pair.length > 0 && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pair);
            startActivityForResult(intent, callbackForCode, options.toBundle());
        } else {
            startActivityForResult(intent, callbackForCode);
        }

    }

    public void startForResult(Intent intent, Class clazz, ResultCallback callback) {
        startForResult(intent, clazz, callback, new Pair[0]);
    }

    public void startForResult(Class clazz, ResultCallback callback, Pair... pair) {
        startForResult(null, clazz, callback, pair);
    }

    public void startForResult(Class clazz, ResultCallback callback) {
        startForResult(null, clazz, callback, new Pair[0]);
    }
}
