package com.huoxy.androidheros.chapter6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by huoxy on 2017/9/23.
 *  自定义SurfaceView模板代码
 */
public class SurfaceViewTemplate extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private SurfaceHolder holder;
    private Canvas canvas;
    private boolean isDrawingInThread;//子线程是否正在绘制中

    public SurfaceViewTemplate(Context context) {
        super(context);
        initView();
    }

    public SurfaceViewTemplate(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SurfaceViewTemplate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);

        //holder.setFormat(PixelFormat.OPAQUE);//No alpha
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawingInThread = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawingInThread = false;
    }

    @Override
    public void run() {
        while (isDrawingInThread){
            draw();
        }
    }

    private void draw(){
        try {
            canvas = holder.lockCanvas();
            //TODO draw something
        } finally {
            if(canvas != null){
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
