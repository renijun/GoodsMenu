package com.sd.storage.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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

/**
 * Created by lenovo on 2018/1/17.
 */

public class MyFragment extends BaseTabFragment {


    @Inject
    AppStore appStore;

    @BindView(R.id.tv_host)
    TextView tv_host;
    @BindView(R.id.tv_account)
    TextView tv_account;
    @BindView(R.id.tv_userName)
    TextView tv_userName;
    @BindView(R.id.tv_belong_depar)
    TextView tv_belong_depar;

    @BindView(R.id.tv_login_depar)
    TextView tv_login_depar;
    @BindView(R.id.tv_role)
    TextView tv_role;

    private UserModel userModel;


    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);

    }


    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    public void init() {
        userModel = appStore.getUserModle();
        String ss=appStore.getDepartName();
        if (null != userModel) {
            tv_host.setText(userModel.HOSNAME);
            tv_account.setText(userModel.USERACCOUNT);
            tv_userName.setText(userModel.USERNAME);
            tv_belong_depar.setText(userModel.DEPTNAME);
            tv_role.setText(userModel.ROLENAME);
            tv_login_depar.setText(appStore.getDepartName());
           // tv_login_depar.setText(appStore.getUserModle().DEPTNAME);
        }
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
    public int getLayoutId() {
        return R.layout.fragment_me;
    }
}
