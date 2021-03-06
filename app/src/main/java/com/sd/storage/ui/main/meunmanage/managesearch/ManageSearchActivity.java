package com.sd.storage.ui.main.meunmanage.managesearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.dlib.store.Store;
import com.sd.storage.ui.base.BaseSCActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-09-13.
 */

public class ManageSearchActivity extends BaseSCActivity {


    @BindView(R.id.et_search)
    EditText et_search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        init();
    }

    public void init() {

    }

    @OnClick({R.id.im_back, R.id.im_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.im_search:

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
        return R.layout.activity_managesearch;
    }
}
