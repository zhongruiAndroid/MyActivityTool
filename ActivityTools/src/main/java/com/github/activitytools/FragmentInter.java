package com.github.activitytools;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

interface FragmentInter {
    Activity getTheActivity();
    public void onStartActivityForResult(Intent intent, int requestCode);

    public void onStartActivityForResult(Intent intent, int requestCode, @Nullable Bundle options);
    public void onStartActivity(Intent intent);
    public void onStartActivity(Intent intent, Bundle options);
}
