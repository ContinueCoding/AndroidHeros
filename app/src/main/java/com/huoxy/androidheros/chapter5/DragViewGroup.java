package com.huoxy.androidheros.chapter5;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by huoxy on 2017/9/20.
 *  通过ViewDragHelper实现QQ侧滑功能
 *      第一个子View作为MenuView；第二个子View作为MainView。
 */
public class DragViewGroup extends FrameLayout {

    private ViewDragHelper dragHelper;
    private View menuView, mainView;
    private int width;

    public DragViewGroup(@NonNull Context context) {
        super(context);
        initView();
    }

    public DragViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        /*
         * 初始化
         *   参数1 - ViewGroup，要监听滑动的View
         *   参数2 - 滑动回调，处理滑动逻辑的核心
         */
        dragHelper = ViewDragHelper.create(this, callback);
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {

        //何时开始检测触摸事件 - 即哪一个子View可以被移动
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            //true if capture should be allowed, false otherwise
            return mainView == child;
        }

        //水平滑动
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        //竖直滑动
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            //返回0说明不能竖直滑动
            return 0;
        }

        //拖动结束后调用 - 内部通过Scroller实现，因此需要重写ViewGroup的computeScroll()
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            //手指抬起后缓慢移动到指定位置
            if(mainView.getLeft() < 500){
                //关闭menu
                dragHelper.smoothSlideViewTo(mainView, 0, 0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }else{
                //打开menu
                dragHelper.smoothSlideViewTo(mainView, 300, 0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }
        }
    };

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //第一个子View作为侧滑菜单；第二个子View作为主界面
        menuView = getChildAt(0);
        mainView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = menuView.getMeasuredWidth();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //事件拦截交给ViewDragHelper处理
        return dragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将触摸事件传递给ViewDragHelper处理
        dragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        //实际是通过Scroller实现移动，此方法的模板代码如下
        if(dragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
}
