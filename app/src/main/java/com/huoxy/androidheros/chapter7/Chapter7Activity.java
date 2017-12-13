package com.huoxy.androidheros.chapter7;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoxy.androidheros.R;

/**
 * 动画机制 & 使用技巧
 */
public class Chapter7Activity extends AppCompatActivity {

    private ImageView btn0, btn1, btn2, btn3, btn4;

    private TextView textTimer;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter7);

        btn0 = (ImageView) findViewById(R.id.btn_0);
        btn1 = (ImageView) findViewById(R.id.btn_1);
        btn2 = (ImageView) findViewById(R.id.btn_2);
        btn3 = (ImageView) findViewById(R.id.btn_3);
        btn4 = (ImageView) findViewById(R.id.btn_4);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnim();
            }
        });

        //---------------------------

        textTimer = (TextView) findViewById(R.id.timer);
        textTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });


    }

    private void startAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(btn0, "alpha", 1f, 0.5f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(btn1, "translationY", 200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(btn2, "translationX", 200f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(btn3, "translationY", -200f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(btn4, "translationX", -200f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(600);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2, animator3, animator4);
        set.start();
    }

    private void startTimer(){
        ValueAnimator animator = ValueAnimator.ofInt(0, 20);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textTimer.setText("$" + ((Integer)animation.getAnimatedValue()));
            }
        });
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

    private ValueAnimator createDropAnimator(final View view, int start, int end, long duration) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (Integer) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;
                view.setLayoutParams(layoutParams);
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(duration);
        return animator;
    }
}
