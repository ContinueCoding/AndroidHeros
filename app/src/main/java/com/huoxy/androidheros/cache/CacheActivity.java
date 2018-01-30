package com.huoxy.androidheros.cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;

import com.huoxy.androidheros.R;

public class CacheActivity extends AppCompatActivity {

    //Since Android 2.3, Google不再建议使用软、弱引用作为缓存策略，推荐使用LruCache
    LruCache<String, String> lruCache;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
    }
}
