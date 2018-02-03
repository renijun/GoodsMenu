package com.sd.storage.ui.main.splitbar;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.adapter.TabFragmentPagerAdapter;
import com.sd.storage.dialog.SplitBarSubmitDialog;
import com.sd.storage.ui.base.BaseSCActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/15.
 */

public class SplitActivity extends BaseSCActivity implements SplitBarFragment.OnGetIdListener {

    @BindView(R.id.tv_title)
    TextView tv_title;

    private List<Fragment> list;
    private TabFragmentPagerAdapter adapter;

    @BindView(R.id.myViewPager)
    ViewPager myViewPager;


    private String id;

    private SplitBarFragment splitBarFragment;
    private SplitSonFragment splitSonFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }

    public void init() {
        tv_title.setText(R.string.spilt_bar);
        //把Fragment添加到List集合里面
        list = new ArrayList<>();
        splitBarFragment = new SplitBarFragment();
        splitBarFragment.setOnDataListener(this);
        splitSonFragment = new SplitSonFragment();

        list.add(splitBarFragment);
        list.add(splitSonFragment);
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);  //初始化显示第一个页面


    }

    @OnClick({R.id.im_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
        }

    }

    public void setTitle(String titile) {
        tv_title.setText(titile);
    }


    @Override
    protected void initReturnEvent() {

    }

    @Override
    public Store[] getStoreArray() {
        return new Store[0];
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_spilt;
    }

    @Override
    public void onGetID(String ID) {
        this.id = ID;
        if (null != onSendIdListener) {
            onSendIdListener.onSendID(ID);
        }
    }

    private OnSendIdListener onSendIdListener;

    public interface OnSendIdListener {
        void onSendID(String ID);
    }

    public void setOnDataListener(OnSendIdListener onSendIdListener) {
        this.onSendIdListener = onSendIdListener;
    }
}
