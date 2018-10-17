package com.sd.storage.ui.main.settime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.dlib.store.Store;
import com.sd.storage.ui.base.BaseSCActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-09-21.
 */

public class SetMainActivity extends BaseSCActivity {

    @BindView(R.id.tv_title)
    TextView tv_title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }


    public void init() {
        tv_title.setText(R.string.menu_mannage);
    }


    @OnClick({R.id.im_back, R.id.tv_meun_setting, R.id.tv_time_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_meun_setting:
                //菜谱投票
                getDisplay().startMeunManageActivity();
                break;
            case R.id.tv_time_setting:
                //菜谱排行
                getDisplay().startSetTimeActivity();
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
        return R.layout.activity_setmain;
    }
}
