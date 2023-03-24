package com.github.activitytools;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.SparseArray;

import java.util.Random;

/**
 * @createBy zhongRui
 * @time 2018-12-13 15:10
 */
public class RequestFragment extends Fragment {
    private ActToolsRequestManager requestManager;
    private SparseArray<ResultCallback> sparseArray = new SparseArray<>();

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

    public ActToolsRequestManager getRequestManager() {
        if (requestManager == null) {
            requestManager=new ActToolsRequestManager(this);
        }
        return requestManager;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        requestManager=null;
        if(sparseArray!=null&&sparseArray.size()>0){
            sparseArray.clear();
        }
        sparseArray=null;
    }
}
