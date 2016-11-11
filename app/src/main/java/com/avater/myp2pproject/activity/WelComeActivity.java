package com.avater.myp2pproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avater.myp2pproject.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WelComeActivity extends Activity {

    @InjectView(R.id.iv_welcome)
    ImageView ivWelcome;
    @InjectView(R.id.tv_currentverson)
    TextView tvCurrentverson;
    @InjectView(R.id.activity_wel_come)
    RelativeLayout activityWelCome;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wel_come);
        ButterKnife.inject(this);

        startAnimation(activityWelCome);


    }

    /**
     * 透明度动画及动画的监听
     *
     * @param view
     */
    private void startAnimation(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(3000);
        view.startAnimation(alphaAnimation);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelComeActivity.this, MainActivity1.class));
                finish();
            }
        }, 3000);
        //动画监听
//        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                startActivity(new Intent(WelComeActivity.this,MainActivity.class));
//                finish();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
