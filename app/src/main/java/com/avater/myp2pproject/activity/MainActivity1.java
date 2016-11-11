package com.avater.myp2pproject.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.avater.myp2pproject.R;
import com.avater.myp2pproject.fragment.HomeFragment;
import com.avater.myp2pproject.fragment.InviteFragment;
import com.avater.myp2pproject.fragment.MeFragment;
import com.avater.myp2pproject.fragment.MoreFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity1 extends FragmentActivity {


    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.ll_item_home)
    RadioButton llItemHome;
    @InjectView(R.id.ll_item_invest)
    RadioButton llItemInvest;
    @InjectView(R.id.ll_item_me)
    RadioButton llItemMe;
    @InjectView(R.id.ll_item_more)
    RadioButton llItemMore;
    @InjectView(R.id.radiogroup)
    RadioGroup radiogroup;
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
        setContentView(R.layout.activity_main_radiogroup);
        ButterKnife.inject(this);
        initData();
        initListener();
        radiogroup.check(R.id.ll_item_home);

    }

    private void initListener() {
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.ll_item_home:
                        currentPosition = 0;
//                        Toast.makeText(MainActivity1.this, "0", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ll_item_invest:
                        currentPosition = 1;
//                        Toast.makeText(MainActivity1.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ll_item_me:
                        currentPosition = 2;
//                        Toast.makeText(MainActivity1.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ll_item_more:
                        currentPosition = 3;
//                        Toast.makeText(MainActivity1.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                }
                switchFragment(currentPosition);
            }
        });
    }

    private void switchFragment(int currentPosition) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        hideFragment();

        if (currentPosition == 0) {
            if (homeFragment == null) {
                homeFragment = new HomeFragment();
                transaction.add(R.id.fl_main, homeFragment);
            }
            transaction.show(homeFragment);

        } else if (currentPosition == 1) {
            if (inviteFragment == null) {
                inviteFragment = new InviteFragment();
                transaction.add(R.id.fl_main, inviteFragment);
            }
            transaction.show(inviteFragment);
        } else if (currentPosition == 2) {
            if (meFragment == null) {
                meFragment = new MeFragment();
                transaction.add(R.id.fl_main, meFragment);
            }
            transaction.show(meFragment);
        } else if (currentPosition == 3) {
            if (moreFragment == null) {
                moreFragment = new MoreFragment();
                transaction.add(R.id.fl_main, moreFragment);
            }
            transaction.show(moreFragment);
        }
        transaction.commit();
    }

    /**
     *
     */
    private void initData() {
//        homeFragment = new HomeFragment();
//        inviteFragment = new InviteFragment();
//        meFragment = new MeFragment();
//        moreFragment = new MoreFragment();


    }


    /**
     * 提供相应的fragment的显示
     * 动态加载fragment
     *
     * @param position
     */
    private void setSelect(int position) {
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
            Toast.makeText(MainActivity1.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
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
            radiogroup.check(R.id.ll_item_home);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
