package com.github.activitytools;

import android.content.Intent;
import android.util.Pair;

public interface RequestInter {
    void startForResult(Intent intent, ResultCallback callback, Pair... pair);
    void startForResult(Class clazz, ResultCallback callback, Pair... pair) ;
}
