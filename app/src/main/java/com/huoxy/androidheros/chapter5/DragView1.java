package com.huoxy.androidheros.chapter5;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by huoxy on 2017/9/19.
 *  随着手指的滑动而移动
 */
public class DragView1 extends View {

    public DragView1(Context context) {
        super(context);
        init(context);
    }

    public DragView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DragView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    Scroller scroller;

    private void init(Context context){
        scroller = new Scroller(context);
    }

    private int lastX = 0;
    private int lastY = 0;
    private int offsetX = 0;
    private int offsetY = 0;

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(scroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                offsetX = rawX - lastX;
                offsetY = rawY - lastY;
                //方法1
                /*layout(getLeft() + offsetX, getTop() + offsetY,
                        getRight() + offsetX, getBottom() + offsetY);*/

                //方法2
                /*offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);*/

                //方法3
                /*ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);*/

                //方法4
                /*((View)getParent()).scrollBy(-offsetX, -offsetY);*/


                break;
            case MotionEvent.ACTION_UP:
                View view = (View) getParent();
                scroller.startScroll(view.getScrollX(), view.getScrollY(),
                        - offsetX, - offsetY);
                invalidate();
                lastX = rawX;
                lastY = rawY;
                break;
        }
        return true;
    }

}
