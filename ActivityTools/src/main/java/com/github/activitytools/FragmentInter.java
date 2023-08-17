package com.github.activitytools;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

interface FragmentInter {
    Activity getActivity();
    public void startActivityForResult(Intent intent, int requestCode);

    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options);
    public void startActivity(Intent intent);
    public void startActivity(Intent intent, Bundle options);
}
