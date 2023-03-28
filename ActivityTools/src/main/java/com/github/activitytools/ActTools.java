package com.github.activitytools;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Pair;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

/**
 * @createBy zhongRui
 * @time 2018-12-13 15:09
 */
public class ActTools {
    private static final String TAGCompat = "ActToolsRequestFragmentCompat";
    private static final String TAG = "ActToolsRequestFragment";

    private ActTools() {
    }

    public static RequestInter get(Fragment fragment) {
        if (fragment == null) {
            throw new IllegalStateException("get(fragment)参数不能为空");
        }
        return get(fragment.getActivity());
    }

    public static RequestInter get(FragmentActivity activity) {
        if (activity == null) {
            throw new IllegalStateException("get(activity)参数不能为空");
        }
        FragmentManager fm = activity.getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(TAGCompat);
        if (fragment == null) {
            RequestFragment requestFragment = RequestFragment.newInstance();
            fm.beginTransaction().add(requestFragment, TAGCompat).commitAllowingStateLoss();
            fm.executePendingTransactions();
            return requestFragment;
        } else {
            return ((RequestFragment) fragment);
        }
    }

    public static RequestInter get(android.app.Fragment fragment) {
        if (fragment == null) {
            throw new IllegalStateException("get(fragment)参数不能为空");
        }
        return get(fragment.getActivity());
    }

    public static RequestInter get(Activity activity) {
        if (activity == null) {
            throw new IllegalStateException("get(activity)参数不能为空");
        }
        android.app.FragmentManager fm = activity.getFragmentManager();
        android.app.Fragment fragment = fm.findFragmentByTag(TAG);
        if (fragment == null) {
            RequestFragmentOld requestFragment = RequestFragmentOld.newInstance();
            fm.beginTransaction().add(requestFragment, TAG).commitAllowingStateLoss();
            fm.executePendingTransactions();
            return requestFragment;
        } else {
            return ((RequestFragmentOld) fragment);
        }
    }
    //region   activity noForResult  -----------------------------------------

    /*****************************************************activity noForResult************************************************************************/
    public static void startActivity(Activity activity, Intent intent, Pair... pair) {
        if (intent == null) {
            return;
        }
        if (pair != null && pair.length > 0 && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, options.toBundle());
        } else {
            activity.startActivity(intent);
        }
    }
    public static void startActivity(Activity activity, Class clazz, Pair... pair) {
        startActivity(activity,new Intent(activity,clazz),pair);
    }
    /*****************************************************fragment NoForResult************************************************************************/
    public static void startActivity(Fragment fragment, Intent intent, Pair... pair) {
        startActivity(fragment.getActivity(), intent, pair);
    }
    public static void startActivity(android.app.Fragment fragment, Intent intent, Pair... pair) {
        startActivity(fragment.getActivity(), intent, pair);
    }


    /*****************************************************************************************************************************/
    public static void startActivity(Fragment fragment, Class clazz, Pair... pair) {
        startActivity(fragment.getActivity(), new Intent(fragment.getActivity(), clazz), pair);
    }

    /*****************************************************************************************************************************/
    public static void startActivity(android.app.Fragment fragment, Class clazz, Pair... pair) {
        startActivity(fragment.getActivity(), new Intent(fragment.getActivity(), clazz), pair);
    }

    //endregion
}
