package com.huoxy.androidheros;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.huoxy.androidheros.cache.CacheActivity;
import com.huoxy.androidheros.chapter10.Chapter10Activity;
import com.huoxy.androidheros.chapter11.BmobActivity;
import com.huoxy.androidheros.chapter3.Chapter3Activity;
import com.huoxy.androidheros.chapter4.Chapter4Activity;
import com.huoxy.androidheros.chapter5.Chapter5Activity;
import com.huoxy.androidheros.chapter6.Chapter6Activity;
import com.huoxy.androidheros.chapter7.Chapter7Activity;
import com.huoxy.androidheros.chapter8.Chapter8Activity;
import com.huoxy.androidheros.chapter9.Chapter9Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第3章 Android控件架构与自定义控件详解
        findViewById(R.id.btn_chapter_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chapter3Activity.class));
            }
        });

        //第4章 ListView使用技巧
        findViewById(R.id.btn_chapter_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chapter4Activity.class));
            }
        });

        //第5章 Android控件架构与自定义控件详解
        findViewById(R.id.btn_chapter_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chapter5Activity.class));
            }
        });

        //第6章 Android控件架构与自定义控件详解
        findViewById(R.id.btn_chapter_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chapter6Activity.class));
            }
        });

        //第7章 Android控件架构与自定义控件详解
        findViewById(R.id.btn_chapter_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chapter7Activity.class));
            }
        });

        //第8章 Activity
        findViewById(R.id.btn_chapter_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chapter8Activity.class));
            }
        });

        //第9章 Android控件架构与自定义控件详解
        findViewById(R.id.btn_chapter_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chapter9Activity.class));
            }
        });

        //第10章 Android性能优化
        findViewById(R.id.btn_chapter_10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chapter10Activity.class));
            }
        });

        //第11章 Baas - Bmob
        findViewById(R.id.btn_chapter_11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BmobActivity.class));
            }
        });

        //第X章 Android Cache
        findViewById(R.id.btn_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CacheActivity.class));
            }
        });



        //handleAppLinkIntent(getIntent());
        Log.i("MainActivity", "onNewIntent() ------ ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "onRestart() ------ ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart() ------ ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume() ------ ");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.i("MainActivity", "onNewIntent() ------ ");
    }

    private void handleAppLinkIntent(Intent intent){
        String appLinkAction = intent.getAction();
        Uri appLinkData = intent.getData();
        Toast.makeText(this, "App Link Intent", Toast.LENGTH_LONG).show();
    }
}
