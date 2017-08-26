package com.huoxy.androidheros.chapter3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by huoxy on 2017/8/16.
 *  自定义View - 测量测试
 */
public class CustomMeasureView extends View {
    private static final String TAG = "CustomMeasureView";

    public CustomMeasureView(Context context) {
        super(context);
    }

    public CustomMeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMeasureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec){
        int result = 0;
        //分别获取测量模式和大小
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        Log.i(TAG, "********** measureWidth() --- specMode = " + specMode + ", specSize = " + specSize);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
            Log.i(TAG, "********** measureWidth() --- MeasureSpec.EXACTLY");
        } else {
            //指定一个默认大小 —— 待优化
            result = 300;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
                Log.i(TAG, "********** measureWidth() --- MeasureSpec.AT_MOST");
            }

            if(specMode == MeasureSpec.UNSPECIFIED){
                Log.i(TAG, "********** measureWidth() --- MeasureSpec.UNSPECIFIED");
            }
        }

        return result;

    }

    private int measureHeight(int heightMeasureSpec){
        int result = 0;
        //分别获取测量模式和大小
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.i(TAG, "measureHeight() --- specMode = " + specMode + ", specSize = " + specSize);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
            Log.i(TAG, "measureHeight() --- MeasureSpec.EXACTLY");
        } else {
            //指定一个默认大小 —— 待优化
            result = 300;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
                Log.i(TAG, "measureHeight() --- MeasureSpec.AT_MOST");
            }

            if(specMode == MeasureSpec.UNSPECIFIED){
                Log.i(TAG, "measureHeight() --- MeasureSpec.UNSPECIFIED");
            }
        }

        return result;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.RED);
    }
}
