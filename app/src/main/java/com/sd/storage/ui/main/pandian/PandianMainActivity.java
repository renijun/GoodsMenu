package com.sd.storage.ui.main.pandian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.adapter.TabFragmentPagerAdapter;
import com.sd.storage.ui.base.BaseSCActivity;
import com.sd.storage.ui.main.splitbar.SplitBarFragment;
import com.sd.storage.ui.main.splitbar.SplitSonFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/24.
 */

public class PandianMainActivity extends BaseSCActivity {


    @BindView(R.id.tv_title)
    TextView tv_title;

    private List<Fragment> list;
    private TabFragmentPagerAdapter adapter;

    @BindView(R.id.myViewPager)
    ViewPager myViewPager;


    private PandianFragment pandianFragment;
    private PandianSonFragment pandianSonFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }

    public void init() {
        tv_title.setText(R.string.pandian_str);
        //把Fragment添加到List集合里面
        list = new ArrayList<>();
        pandianFragment = new PandianFragment();
        pandianSonFragment = new PandianSonFragment();
        list.add(pandianFragment);
        list.add(pandianSonFragment);
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);  //初始化显示第一个页面

    }

    /**
     * 设置title的显示
     * @param titile
     */
    public void setTitle(String titile) {
        tv_title.setText(titile);
    }

    @OnClick({R.id.im_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
        }
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
        return R.layout.activity_pandian_main;
    }
}
