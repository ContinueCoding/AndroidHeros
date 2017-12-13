package com.huoxy.androidheros;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.huoxy.androidheros.chapter3.Chapter3Activity;
import com.huoxy.androidheros.chapter4.Chapter4Activity;
import com.huoxy.androidheros.chapter5.Chapter5Activity;
import com.huoxy.androidheros.chapter6.Chapter6Activity;
import com.huoxy.androidheros.chapter7.Chapter7Activity;

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

        //第9章 Android控件架构与自定义控件详解
        findViewById(R.id.btn_chapter_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "哈哈哈哈哈哈"));
            }
        });

        //handleAppLinkIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //handleAppLinkIntent(intent);
    }

    private void handleAppLinkIntent(Intent intent){
        String appLinkAction = intent.getAction();
        Uri appLinkData = intent.getData();
        Toast.makeText(this, "App Link Intent", Toast.LENGTH_LONG).show();
    }
}
