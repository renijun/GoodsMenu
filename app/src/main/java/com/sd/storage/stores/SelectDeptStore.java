package com.sd.storage.stores;


import com.dframe.lib.action.Action;
import com.dframe.lib.model.DataContainer;
import com.dframe.lib.store.Store;
import com.sd.storage.actions.LoginAction;
import com.sd.storage.actions.SelectDeptAction;
import com.sd.storage.model.DepartmentModel;
import com.sd.storage.model.UserModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 选择部门
 * Created by MrZhou on 2016/11/23.
 */
public class SelectDeptStore extends Store<Action> {

    public ArrayList<DepartmentModel> mHistoryModels;

    private UserModel userModel;

    @Inject
    AppStore mAppStore;

    @Inject
    public SelectDeptStore() {

    }

    public ArrayList<DepartmentModel> getmHistoryModels() {
        return mHistoryModels;
    }

    @Override
    public void doAction(Action action) {
        switch (action.getType()) {
            case SelectDeptAction.MY_DEPARTMENT:
                DataContainer<ArrayList<DepartmentModel>> dataContainer = (DataContainer<ArrayList<DepartmentModel>>) action.getData();
                if (dataContainer.getResultOK()) {
                    mHistoryModels = dataContainer.data;
                    dispatcherStore(new MyHistoryChange());
                } else {
                    dispatcherStore(new ChangeError(dataContainer.Code, dataContainer.Message));
                }
                break;
            case LoginAction.LOGIN_RS:
                DataContainer<UserModel> dataLoginContainer = (DataContainer<UserModel>) action.getData();
                if (dataLoginContainer.getResultOK()) {
                    userModel = dataLoginContainer.data;
                    //保存useId
                  //  mAppStore.setUserId(dataLoginContainer.Message);
                    //保存登录的信息
                    mAppStore.setUserModle(userModel);

                    dispatcherStore(new LoginChange());
                } else {
                    dispatcherStore(new ChangeError(dataLoginContainer.Code, dataLoginContainer.Message));
                }
                break;

        }
    }


    public static class LoginChange {
    }

    public static class MyHistoryChange {
    }

    public static class ChangeError extends ErrorState {
        ChangeError(int state, String msge) {
            super(state, msge);
        }
    }

}
