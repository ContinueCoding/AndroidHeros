package com.huoxy.androidheros.chapter4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.huoxy.androidheros.R;

import java.util.ArrayList;
import java.util.List;

public class Chapter4Activity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private Button showData, noData, scrollToLast;
    private TextView emptyView;

    private List<String> messages;
    private ViewHolderAdapter adapter;
    private int lastVisibleItemPosition = 0;

    //监听上下滑动
    private int mFirstY = 0;
    private int mCurrentY = 0;
    private int direction = 0;
    private boolean mShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_4);

        initViews();

        setListeners();

        initData();

        int scaledEdgeSlop = ViewConfiguration.get(this).getScaledEdgeSlop();//36
        int scaledTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();//24
        int scaledDoubleTapSlop = ViewConfiguration.get(this).getScaledDoubleTapSlop();//300
        int scaledPagingTouchSlop = ViewConfiguration.get(this).getScaledPagingTouchSlop();//48
        int scaledWindowTouchSlop = ViewConfiguration.get(this).getScaledWindowTouchSlop();//48

        Log.i("Slop", "1 - " + scaledEdgeSlop +
                        "\n 2 - " + scaledTouchSlop +
                        "\n 3 - " + scaledDoubleTapSlop +
                        "\n 4 - " + scaledPagingTouchSlop +
                        "\n 5 - " + scaledWindowTouchSlop);
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.listView);
        showData = (Button) findViewById(R.id.show_data);
        noData = (Button) findViewById(R.id.no_data);
        scrollToLast = (Button) findViewById(R.id.scroll_to_last);
        emptyView = (TextView) findViewById(R.id.empty_view);
    }

    private void setListeners(){
        showData.setOnClickListener(this);
        noData.setOnClickListener(this);
        scrollToLast.setOnClickListener(this);
        emptyView.setOnClickListener(this);

        //ListView滑动监听方式一: 根据不同ACTION的坐标判断滑动方向
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_MOVE:

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }
                return false;
            }
        });

        //ListView滑动监听方式二:
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            //如果手指不离开屏幕滑动时，只会回调2次（前两种STATE）；如果猛滑时会回调3次（3中STATE）
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        //滑动停止

                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        //正在滑动

                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        //手指猛滑 - 手指离开屏幕后，继续滑动的情况

                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //滑动时一直回调 - 可以根据后三个参数判断相应逻辑
                if(firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount > 0){
                    //滑动到最后一行了

                }

                if(firstVisibleItem > lastVisibleItemPosition){
                    //上滑

                }else if(firstVisibleItem < lastVisibleItemPosition){
                    //下滑

                }
                lastVisibleItemPosition = firstVisibleItem;
            }
        });

        listView.getLastVisiblePosition();
        listView.getFirstVisiblePosition();
    }

    private void initData(){
        messages = new ArrayList<>();
        adapter = new ViewHolderAdapter(this, messages);
        listView.setAdapter(adapter);
        listView.setEmptyView(emptyView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_data:
            case R.id.empty_view:
                addMessages();
                break;
            case R.id.no_data:
                clearMessages();
                break;
            case R.id.scroll_to_last:
                if(messages != null && messages.size() > 0){
                    listView.smoothScrollToPosition(messages.size());
                }
                break;
        }
    }

    private void addMessages(){
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        messages.add("Hello world!");
        adapter.notifyDataSetChanged();
    }

    private void clearMessages(){
        messages.clear();
        adapter.notifyDataSetChanged();
    }
}
