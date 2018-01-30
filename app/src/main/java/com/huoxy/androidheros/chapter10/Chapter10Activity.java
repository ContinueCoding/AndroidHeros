package com.huoxy.androidheros.chapter10;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huoxy.androidheros.R;

public class Chapter10Activity extends AppCompatActivity {

    private Button showBtn;
    private ViewStub viewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter10);

        showBtn = (Button) findViewById(R.id.show_view_stub);
        viewStub = (ViewStub) findViewById(R.id.common_action_view_stub);

        //1 - ViewStub
        viewStubDemo();

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        Toast.makeText(this, "堆内存：" + activityManager.getLargeMemoryClass(), Toast.LENGTH_LONG).show();
    }

    //1 - ViewStub使用
    private void viewStubDemo() {
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示方式1 - setVisibility() - 只能控制显示&隐藏各一次；之后就不会再显示了！
                /*if (viewStub.getVisibility() == View.VISIBLE) {
                    viewStub.setVisibility(View.INVISIBLE);
                } else {
                    viewStub.setVisibility(View.VISIBLE);
                }*/

                //显示方式2 - inflate() - 只能inflate一次
                if(viewStub.getParent() != null){
                    View view = viewStub.inflate();
                    ImageView icon = (ImageView) view.findViewById(R.id.icon);
                    TextView title = (TextView) view.findViewById(R.id.title);
                    icon.setImageResource(R.mipmap.ic_launcher_round);
                    title.setText("显示出来了");
                } else {
                    Toast.makeText(Chapter10Activity.this, "已经Inflate过", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
