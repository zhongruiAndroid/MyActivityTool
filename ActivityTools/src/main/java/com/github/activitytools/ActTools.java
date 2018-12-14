package com.github.activitytools;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Pair;

/**
 * @createBy Administrator
 * @time 2018-12-13 15:09
 */
public class ActTools {
    private final String TAG = this.getClass().getSimpleName();
    private FragmentActivity activity;

    private RequestFragment requestFragment;


    public static ActTools get(Fragment fragment) {
        return get(fragment.getActivity());
    }

    public static ActTools get(FragmentActivity activity) {
        return new ActTools(activity);
    }

    private ActTools(FragmentActivity activity) {
        if (activity == null) {
            throw new IllegalStateException("get()参数不能为空");
        }
        this.activity = activity;
        initFragment();
    }


    private void initFragment() {
        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag(TAG);
        if (fragment == null) {
            requestFragment = RequestFragment.newInstance();
            activity.getSupportFragmentManager().beginTransaction().add(requestFragment, TAG).commitAllowingStateLoss();
            activity.getSupportFragmentManager().executePendingTransactions();
        } else {
            requestFragment = (RequestFragment) fragment;
        }
    }

    /*****************************************************activity ForResult************************************************************************/
    public void startForResult(Class clazz,Intent intent, ResultCallback callback, Pair... pair) {
        if(intent==null){
            intent=new Intent(activity,clazz);
        }else{
            intent.setClass(activity,clazz);
        }

        int callbackForCode = requestFragment.setCallbackForCode(callback);

        if (pair!=null&&pair.length>0&&android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =ActivityOptions.makeSceneTransitionAnimation(activity,pair);
            requestFragment.startActivityForResult(intent,callbackForCode,options.toBundle());
        }else{
            requestFragment.startActivityForResult(intent,callbackForCode);
        }

    }
    public void startForResult(Class clazz,Intent intent, ResultCallback callback) {
        startForResult(clazz,intent,callback,null);
    }

    /*****************************************************************************************************************************/

    /*****************************************************************************************************************************/
    public void startForResult(Class clazz,ResultCallback callback, Pair... pair) {
        startForResult(clazz,null,callback,pair);
    }
    public void startForResult(Class clazz,ResultCallback callback) {
        startForResult(clazz,callback,null);
    }
    /*****************************************************************************************************************************/



    /*****************************************************activity NoForResult************************************************************************/
    public static void startActivity(Activity activity,Class clazz,Intent intent,Pair... pair) {
        if(intent==null){
            intent=new Intent(activity,clazz);
        }else{
            intent.setClass(activity,clazz);
        }
        if (pair!=null&&pair.length>0&&android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =ActivityOptions.makeSceneTransitionAnimation(activity,pair);
            ActivityCompat.startActivity(activity,intent,options.toBundle());
        }else{
            activity.startActivity(intent);
        }

    }
    public static void startActivity(Activity activity,Class clazz,Intent intent ) {
        startActivity(activity,clazz,intent,null);
    }
    /*****************************************************************************************************************************/
    public static void startActivity(Activity activity,Class clazz, Pair... pair) {
        startActivity(activity,clazz,null,pair);
    }
    public static void startActivity(Activity activity,Class clazz) {
        startActivity(activity,clazz, new Pair[0]);
    }
    /*****************************************************************************************************************************/
    /*****************************************************fragment NoForResult************************************************************************/
    public static void startActivity(Fragment fragment,Class clazz,Intent intent,Pair... pair) {
        if(intent==null){
            intent=new Intent(fragment.getActivity(),clazz);
        }else{
            intent.setClass(fragment.getActivity(),clazz);
        }
        if (pair!=null&&pair.length>0&&android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =ActivityOptions.makeSceneTransitionAnimation(fragment.getActivity(),pair);
            ActivityCompat.startActivity(fragment.getActivity(),intent,options.toBundle());
        }else{
            fragment.getActivity().startActivity(intent);
        }

    }
    public static void startActivity(Fragment fragment,Class clazz,Intent intent ) {
        startActivity(fragment.getActivity(),clazz,intent,null);
    }
    /*****************************************************************************************************************************/
    public static void startActivity(Fragment fragment,Class clazz, Pair... pair) {
        startActivity(fragment.getActivity(),clazz,null,pair);
    }
    public static void startActivity(Fragment fragment,Class clazz) {
        startActivity(fragment.getActivity(),clazz, new Pair[0]);
    }
    /*****************************************************************************************************************************/

}
