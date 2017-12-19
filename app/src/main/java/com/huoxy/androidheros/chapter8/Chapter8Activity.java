package com.huoxy.androidheros.chapter8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.huoxy.androidheros.MainActivity;
import com.huoxy.androidheros.R;

public class Chapter8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter8);

        findViewById(R.id.flag_single_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chapter8Activity.this, Chapter8Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        findViewById(R.id.flag_single_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chapter8Activity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("Chapter8Activity", "onNewIntent() ------ ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Chapter8Activity", "onPause() ------ ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Chapter8Activity", "onStop() ------ ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Chapter8Activity", "onDestroy() ------ ");
    }
}
