package com.avater.myp2pproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avater.myp2pproject.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Avater on 2016/11/11 0011.
 */

public class MeFragment extends Fragment {
    @InjectView(R.id.iv_top_back)
    ImageView ivTopBack;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.iv_setting)
    ImageView ivSetting;

    /**
     * 返回一个关联的布局文件
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_me, null);
        ButterKnife.inject(this, view);
        initTitle();
        return view;
    }

    private void initTitle() {
        ivTopBack.setVisibility(View.INVISIBLE);
        ivSetting.setVisibility(View.INVISIBLE);
        tvTitle.setText("我的财产");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
