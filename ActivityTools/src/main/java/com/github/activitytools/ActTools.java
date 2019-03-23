package com.github.activitytools;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Pair;

/**
 * @createBy zhongRui
 * @time 2018-12-13 15:09
 */
public class ActTools {
    private static final String TAG ="ActToolsRequestFragment";

    private ActTools() {
    }

    public static ActToolsRequestManager get(Fragment fragment) {
        if(fragment==null){
            throw new IllegalStateException("get(fragment)参数不能为空");
        }
        return get(fragment.getActivity());
    }

    public static ActToolsRequestManager get(FragmentActivity activity) {
        if (activity == null) {
            throw new IllegalStateException("get(activity)参数不能为空");
        }
        FragmentManager fm = activity.getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(TAG);
        if (fragment == null) {
            RequestFragment requestFragment = RequestFragment.newInstance();
            fm.beginTransaction().add(requestFragment, TAG).commitAllowingStateLoss();
            fm.executePendingTransactions();
            return requestFragment.getRequestManager();
        } else {
            return ((RequestFragment) fragment).getRequestManager();
        }
    }



    //region   activity noForResult  -----------------------------------------
    /*****************************************************activity noForResult************************************************************************/
    public static void startActivity(Intent intent,Activity activity,Class clazz,Pair... pair) {
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
    public static void startActivity(Intent intent,Activity activity,Class clazz) {
        startActivity(intent,activity,clazz,new Pair[0]);
    }
    public static void startActivity(Activity activity,Class clazz, Pair... pair) {
        startActivity(null,activity,clazz,pair);
    }
    public static void startActivity(Activity activity,Class clazz) {
        startActivity(null,activity,clazz, new Pair[0]);
    }
    /*****************************************************fragment NoForResult************************************************************************/
    public static void startActivity(Intent intent,Fragment fragment,Class clazz,Pair... pair) {
        startActivity(intent,fragment.getActivity(),clazz,pair);
    }
    public static void startActivity(Intent intent,Fragment fragment,Class clazz) {
        startActivity(intent,fragment.getActivity(),clazz,new Pair[0]);
    }
    /*****************************************************************************************************************************/
    public static void startActivity(Fragment fragment,Class clazz, Pair... pair) {
        startActivity(null,fragment.getActivity(),clazz,pair);
    }
    public static void startActivity(Fragment fragment,Class clazz) {
        startActivity(null,fragment.getActivity(),clazz, new Pair[0]);
    }
    /*****************************************************************************************************************************/
    //endregion
}
