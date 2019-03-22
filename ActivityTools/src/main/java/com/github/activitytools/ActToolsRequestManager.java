package com.github.activitytools;

import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Pair;

/***
 *   created by android on 2019/3/22
 */
public class ActToolsRequestManager {
    private RequestFragment requestFragment;

    public ActToolsRequestManager(RequestFragment requestFragment) {
        this.requestFragment = requestFragment;
    }
    //region   activity forResult       -----------------------------------------

    /*****************************************************activity forResult************************************************************************/
    public void startForResult(Intent intent, ResultCallback callback, Pair... pair) {
        if (intent == null) {
            throw new IllegalStateException("intent can not null");
        }
        int callbackForCode = requestFragment.setCallbackForCode(callback);

        if (pair != null && pair.length > 0 && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this.requestFragment.getActivity(), pair);
            this.requestFragment.startActivityForResult(intent, callbackForCode, options.toBundle());
        } else {
            this.requestFragment.startActivityForResult(intent, callbackForCode);
        }
    }

    public void startForResult(Intent intent, ResultCallback callback) {
        startForResult(intent, callback, new Pair[0]);
    }

    public void startForResult(Intent intent, Class clazz, ResultCallback callback, Pair... pair) {
        if (intent == null) {
            intent = new Intent(this.requestFragment.getActivity(), clazz);
        } else {
            intent.setClass(this.requestFragment.getActivity(), clazz);
        }

        int callbackForCode = this.requestFragment.setCallbackForCode(callback);

        if (pair != null && pair.length > 0 && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this.requestFragment.getActivity(), pair);
            this.requestFragment.startActivityForResult(intent, callbackForCode, options.toBundle());
        } else {
            this.requestFragment.startActivityForResult(intent, callbackForCode);
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
    /*****************************************************************************************************************************/
    //endregion
}
