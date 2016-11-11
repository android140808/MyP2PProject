package com.avater.myp2pproject.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avater.myp2pproject.R;
import com.avater.myp2pproject.fragment.HomeFragment;
import com.avater.myp2pproject.fragment.InviteFragment;
import com.avater.myp2pproject.fragment.MeFragment;
import com.avater.myp2pproject.fragment.MoreFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.iv_item_home)
    ImageView ivItemHome;
    @InjectView(R.id.tv_item_home)
    TextView tvItemHome;
    @InjectView(R.id.ll_item_home)
    LinearLayout llItemHome;
    @InjectView(R.id.iv_item_invest)
    ImageView ivItemInvest;
    @InjectView(R.id.tv_item_invest)
    TextView tvItemInvest;
    @InjectView(R.id.ll_item_invest)
    LinearLayout llItemInvest;
    @InjectView(R.id.iv_item_me)
    ImageView ivItemMe;
    @InjectView(R.id.tv_item_me)
    TextView tvItemMe;
    @InjectView(R.id.ll_item_me)
    LinearLayout llItemMe;
    @InjectView(R.id.iv_item_more)
    ImageView ivItemMore;
    @InjectView(R.id.tv_item_more)
    TextView tvItemMore;
    @InjectView(R.id.ll_item_more)
    LinearLayout llItemMore;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;

    private HomeFragment homeFragment;
    private InviteFragment inviteFragment;
    private MeFragment meFragment;
    private MoreFragment moreFragment;
    private FragmentManager fragmentManager;
    FragmentTransaction transaction;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
        setSelect(0);
    }

    /**
     *
     */
    private void initData() {

    }

    @OnClick({R.id.ll_item_home, R.id.ll_item_invest, R.id.ll_item_me, R.id.ll_item_more})
    public void changeTab(View view) {
        switch (view.getId()) {
            case R.id.ll_item_home:
                setSelect(0);
                break;
            case R.id.ll_item_invest:
                setSelect(1);
                break;
            case R.id.ll_item_me:
                setSelect(2);
                break;
            case R.id.ll_item_more:
                setSelect(3);
                break;
        }
    }

    /**
     * 提供相应的fragment的显示
     * 动态加载fragment
     *
     * @param position
     */
    private void setSelect(int position) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        hideFragment();
        resetTab();
        if (position == 0) {
            if (homeFragment == null) {
                homeFragment = new HomeFragment();
                transaction.add(R.id.fl_main, homeFragment);
            }
            currentPosition = 0;
            transaction.show(homeFragment);
            ivItemHome.setImageResource(R.drawable.bid01);
            tvItemHome.setTextColor(getResources().getColor(R.color.home_back_selected));
        } else if (position == 1) {
            if (inviteFragment == null) {
                inviteFragment = new InviteFragment();
                transaction.add(R.id.fl_main, inviteFragment);
            }
            currentPosition = 1;
            transaction.show(inviteFragment);
            ivItemInvest.setImageResource(R.drawable.bid03);
            tvItemInvest.setTextColor(getResources().getColor(R.color.home_back_selected));

        } else if (position == 2) {
            if (meFragment == null) {
                meFragment = new MeFragment();
                transaction.add(R.id.fl_main, meFragment);
            }
            currentPosition = 2;
            transaction.show(meFragment);
            ivItemMe.setImageResource(R.drawable.bid05);
            tvItemMe.setTextColor(getResources().getColor(R.color.home_back_selected));
        } else if (position == 3) {
            if (moreFragment == null) {
                moreFragment = new MoreFragment();
                transaction.add(R.id.fl_main, moreFragment);
            }
            transaction.show(moreFragment);
            ivItemMore.setImageResource(R.drawable.bid07);
            tvItemMore.setTextColor(getResources().getColor(R.color.home_back_selected));
            currentPosition = 3;
        }
        transaction.commit();
    }

    private void resetTab() {
        ivItemHome.setImageResource(R.drawable.bid02);
        ivItemInvest.setImageResource(R.drawable.bid04);
        ivItemMe.setImageResource(R.drawable.bid06);
        ivItemMore.setImageResource(R.drawable.bid08);

        tvItemHome.setTextColor(getResources().getColor(R.color.home_back_unselected));
        tvItemMe.setTextColor(getResources().getColor(R.color.home_back_unselected));
        tvItemMore.setTextColor(getResources().getColor(R.color.home_back_unselected));
        tvItemInvest.setTextColor(getResources().getColor(R.color.home_back_unselected));
    }

    private void hideFragment() {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (inviteFragment != null) {
            transaction.hide(inviteFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
        if (moreFragment != null) {
            transaction.hide(moreFragment);
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (isFinishing()) {
                    return;
                }
                isFrag = true;
            }

        }
    };

    /**
     * 实现两次点击返回键退出应用
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (isFrag) {
            setBack2Home();
            isFrag = false;
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            handler.sendEmptyMessageDelayed(1, 2000);
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    private boolean isFrag = true;

    /**
     * 跳转到首页
     */
    private void setBack2Home() {
        if (currentPosition != 0) {
            setSelect(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
