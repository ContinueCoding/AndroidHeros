package com.huoxy.androidheros.chapter9;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;

import com.huoxy.androidheros.R;

public class Chapter9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter9);

        Build build;

        System.getProperty("os.version");


        ActivityInfo activityInfo;

        ServiceInfo serviceInfo;

        ProviderInfo providerInfo;

        ApplicationInfo applicationInfo;

        PackageInfo packageInfo;

        ResolveInfo resolveInfo;

        PackageManager packageManager = getPackageManager();

        //------------------------

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo memoryInfo;

        Debug.MemoryInfo memoryInfo1;

        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;

        ActivityManager.RunningServiceInfo runningServiceInfo;
    }
}
