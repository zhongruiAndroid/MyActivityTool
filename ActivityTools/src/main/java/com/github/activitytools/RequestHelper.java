package com.github.activitytools;

import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Pair;
import android.util.SparseArray;

import java.io.Serializable;
import java.util.Random;

public class RequestHelper   {

    private SparseArray<ResultCallback> sparseArray = new SparseArray<>();
    private Random random = new Random();

    public void startForResult(FragmentInter fragmentInter, Class clazz, ResultCallback callback, Pair... pair) {
        startForResult(fragmentInter, new Intent(fragmentInter.getTheActivity(), clazz), callback, pair);
    }

    public void startForResult(FragmentInter fragmentInter, Intent intent, ResultCallback callback, Pair... pair) {
        if (intent == null) {
            throw new IllegalStateException("intent can not null");
        }
        if (pair != null && pair.length > 0 && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(fragmentInter.getTheActivity(), pair);
            if (callback == null) {
                fragmentInter.onStartActivity(intent, options.toBundle());
            } else {
                int callbackForCode = setCallbackForCode(callback);
                fragmentInter.onStartActivityForResult(intent, callbackForCode, options.toBundle());
            }
        } else {
            if (callback == null) {
                fragmentInter.onStartActivity(intent);
            } else {
                int callbackForCode = setCallbackForCode(callback);
                fragmentInter.onStartActivityForResult(intent, callbackForCode);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
        if (callback != null) {
            sparseArray.put(requestCode, callback);
        }
        return requestCode;
    }

    private int getRequestCode() {
        int code;
        do {
            code = (System.currentTimeMillis() + "" + random.nextInt(900) + 100).hashCode();
        } while (sparseArray.indexOfKey(code) >= 0);
        return code;
    }


    public void onDestroy() {
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }
}
