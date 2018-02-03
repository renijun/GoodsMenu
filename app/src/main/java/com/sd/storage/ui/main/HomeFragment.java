package com.sd.storage.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.model.UserModel;
import com.sd.storage.stores.AppStore;
import com.sd.storage.ui.base.BaseTabFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/1/17.
 */

public class HomeFragment extends BaseTabFragment implements View.OnClickListener {

    @Inject
    AppStore mAppStore;

    @BindView(R.id.lin_put_in)
    LinearLayout linPutIn;

    @BindView(R.id.tv_home_title)
    TextView tv_home_title;

    private UserModel userModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        init();
    }


    public void init() {

    }

    @Override
    protected String getToolbarTitle() {
        return super.getToolbarTitle();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        String userId = mAppStore.getUserModle().USERID;
        String deptName = mAppStore.getDepartName();
        userModel = mAppStore.getUserModle();
        if (null != userModel) {
            tv_home_title.setText(userModel.HOSNAME);
        }

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public Store[] getStoreArray() {
        return new Store[0];
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return null;

    }

    @OnClick({R.id.lin_put_in, R.id.lin_barcode_input, R.id.lin_split_bar, R.id.lin_pan_dian, R.id.lin_code_goods})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_put_in:
                getDisplay().startPutInStorageActivity();
                break;
            case R.id.lin_barcode_input:
                getDisplay().startBarCodeInputActivity();
                break;

            case R.id.lin_split_bar:
                getDisplay().startSplitActivity();
                break;
            case R.id.lin_pan_dian:
                getDisplay().startPandianMainActivity();
                break;
            case R.id.lin_code_goods:
                getDisplay().startCodeGoodsActivity();
                break;
        }
    }
}
