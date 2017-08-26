package com.huoxy.androidheros.chapter4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huoxy.androidheros.R;

/**
 * Created by huoxy on 2017/8/26.
 */
public class EmptyView extends RelativeLayout {

    TextView emptyView;
    OnRefreshClickListener listener;

    public EmptyView(Context context) {
        super(context);
        init(context);
    }

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_empty_view, null);
        emptyView = (TextView) view.findViewById(R.id.empty_txt);
        emptyView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onRefreshClicked();
                }
            }
        });
    }

    public void setOnRefreshClickListener(OnRefreshClickListener listener) {
        this.listener = listener;
    }

    interface OnRefreshClickListener{
        void onRefreshClicked();
    }
}
