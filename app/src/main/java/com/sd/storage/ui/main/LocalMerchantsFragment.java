package com.sd.storage.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.ui.base.BaseTabFragment;


/**
 * Created by lenovo on 2018/1/17.
 */

public class LocalMerchantsFragment extends BaseTabFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_merchant;
    }

    @Override
    public Store[] getStoreArray() {
        return new Store[0];
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return null;
    }

}
