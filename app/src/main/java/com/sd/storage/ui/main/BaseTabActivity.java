package com.sd.storage.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.TabHost;

import com.sd.storage.R;
import com.sd.storage.ui.base.BaseSCActivity;

import butterknife.BindView;

/**
 * Created by lenovo on 2018/1/18.
 */

public abstract class BaseTabActivity  extends BaseSCActivity implements TabHost.OnTabChangeListener {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    private static final String SAVE_SELECTED_TAB = "selected_tab";

    @BindView(android.R.id.tabhost)
    protected FragmentTabHost mTabHost;

    private int mCurrentItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null); // 去掉分割线

        setFragmentClasses(getFragmentClasses());

        if (savedInstanceState != null) {
            mCurrentItem = savedInstanceState.getInt(SAVE_SELECTED_TAB);
        }
        mTabHost.setOnTabChangedListener(this);
    }

    protected abstract Class<?> [] getFragmentClasses();

    protected int mFragmentSize;

    protected void setFragmentClasses(Class<?> fragments[]) {
        mFragmentSize = fragments.length;
        for (int i = 0; i < mFragmentSize; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(fragments[i].getSimpleName());
            tabSpec.setIndicator(getTobIndicatorView(i));
            mTabHost.addTab(tabSpec, fragments[i], null);
        }
        mTabHost.setCurrentTab(mCurrentItem);
    }

    protected abstract View getTobIndicatorView(int position);

    protected int getCount() {
        return mFragmentSize;
    }

    @Override
    public void onPause() {
        super.onPause();
        mCurrentItem = mTabHost.getCurrentTab();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVE_SELECTED_TAB, mCurrentItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onTabChanged(String tabId) {

    }

    public void setCurrentTabByTag(String tabIdChanged) {
        mTabHost.setCurrentTabByTag(tabIdChanged);
    }
}
