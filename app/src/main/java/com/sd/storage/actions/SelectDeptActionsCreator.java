package com.sd.storage.actions;

import android.util.Log;

import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.model.DataContainer;
import com.sd.storage.CallBack;
import com.sd.storage.Constants;
import com.sd.storage.UrlManager;
import com.sd.storage.api.ApiService;
import com.sd.storage.model.DepartmentModel;
import com.sd.storage.model.UserModel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/1/18.
 */

public class SelectDeptActionsCreator extends ActionsCreator {

    @Inject
    public SelectDeptActionsCreator(Dispatcher dispatcher, ApiService apiService) {
        super(dispatcher, apiService);
    }


    /**
     * 部门
     */
    public void getDeptItem() {
       // String appM = "supportBankList";
        String appM = "GetDeptByHos";

        HashMap<String, String> params = new HashMap<>();
        //params.put("orderNo", UrlManager.getHosId());
        params.put("hosId", UrlManager.getHosId());

        putObsToSubscriber(mApiService.getDeptItem(appM, params), new CallBack<DataContainer<ArrayList<DepartmentModel>>>(this) {
            @Override
            protected void doNext(DataContainer<ArrayList<DepartmentModel>> arrayListDataContainer) {
                Log.i("URL", "doNext: "+"ok");
                dispatchAction(new SelectDeptAction(SelectDeptAction.MY_DEPARTMENT, arrayListDataContainer));
            }
        });



    }

    public void getCheckLogin(String name,String pass) {
        String appM = "CheckLogin";
        HashMap<String, String> params = new HashMap<>();
        params.put("userName", name);
        params.put("pwd", pass);
        putObsToSubscriber(mApiService.CheckLogin(appM, params), new CallBack<DataContainer<UserModel>>(this) {
            @Override
            protected void doNext(DataContainer<UserModel> objectDataContainer) {
                Log.i("URL", "doNext: "+"ok");
                dispatchAction(new LoginAction(LoginAction.LOGIN_RS, objectDataContainer));
            }

            /*@Override
            protected void doNext(DataContainer<ArrayList<DepartmentModel>> arrayListDataContainer) {
                Log.i("URL", "doNext: "+"ok");
                dispatchAction(new SelectDeptAction(SelectDeptAction.MY_DEPARTMENT, arrayListDataContainer));
            }*/
        });
    }










}
