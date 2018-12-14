package com.github.activitytools;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

import java.util.Random;

/**
 * @createBy Administrator
 * @time 2018-12-13 15:10
 */
public class RequestFragment extends Fragment {
    private SparseArray<ResultCallback> sparseArray=new SparseArray<>();

    public static RequestFragment newInstance() {
        RequestFragment fragment = new RequestFragment();
        return fragment;
    }

    public int setCallbackForCode(ResultCallback callback){
        if(sparseArray==null){
            sparseArray=new SparseArray<>();
        }
        int requestCode = getRequestCode();
        sparseArray.put(requestCode,callback);
        return requestCode;
    }
    public int getRequestCode(){
        /*现在1000到9999生成requestCode 如果超过十次一样，就取100到999*/
        Random random=new Random();
        int nextInt;
        int count=0;
        do {
            if(count>=10){
                nextInt = random.nextInt(900)+100;
            }else{
                nextInt = random.nextInt(9000)+1000;
            }
            count++;
        }while(sparseArray.indexOfKey(nextInt)>=0);
        return nextInt;
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
        resultCallback.onActivityResult(resultCode,data);
    }
}
