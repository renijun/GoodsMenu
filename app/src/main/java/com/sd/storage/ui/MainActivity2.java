package com.sd.storage.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dframe.lib.Constants;
import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.ui.main.BaseTabActivity;
import com.sd.storage.ui.main.CartFragmentV3;
import com.sd.storage.ui.main.HomeFragment;
import com.sd.storage.ui.main.LocalMerchantsFragment;
import com.sd.storage.ui.main.MyFragment;

import butterknife.BindArray;

/**
 * Created by lenovo on 2018/1/18.
 */

public class MainActivity2 extends BaseTabActivity {
    private Class<?> MainTabFragments[] = {
            HomeFragment.class,           // 主页
            LocalMerchantsFragment.class, // 本地商家
            CartFragmentV3.class,         // 购物袋
            MyFragment.class            // 个人中心
    };

    private int mMainTabButtomDrawable[] = {
            R.drawable.tab_home_temp,       // 主页 icon
            R.drawable.tab_lm_temp,         // 本地商家 icon
            R.drawable.tab_cart_temp,       // 购物袋 icon
            R.drawable.tab_me_temp,         // 个人中心 icon
    };


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int index = intent.getIntExtra(Constants.INDEX, Constants.TYPE_00);
        selectTab(index);
    }

    @BindArray(R.array.tab_main_temp)
    String[] mMainTabTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
    }

    @Override
    protected void initReturnEvent() {

    }

    @Override
    protected Class<?>[] getFragmentClasses() {
        return MainTabFragments;
    }

    @Override
    protected View getTobIndicatorView(int position) {
        View indicator = View.inflate(this, R.layout.v3_indicator_main, null);
        ImageView icon = (ImageView) indicator.findViewById(android.R.id.icon);
        icon.setImageResource(mMainTabButtomDrawable[position]);
        TextView title = (TextView) indicator.findViewById(android.R.id.title);
        title.setText(mMainTabTitle[position]);
        return indicator;
    }

    public void selectTab(int tabIndex) {
        mTabHost.setCurrentTab(tabIndex);
    }


    @Override
    protected void onDestroy() {
        mMainTabTitle = null;
        mTabHost = null;
        mMainTabButtomDrawable = null;
        MainTabFragments = null;
        setContentView(new View(this));
        super.onDestroy();
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean isExit = false;

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), R.string.press_once_exit,
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

}
