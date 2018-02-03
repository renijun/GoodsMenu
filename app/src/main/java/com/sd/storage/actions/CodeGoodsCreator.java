package com.sd.storage.actions;

import android.util.Log;

import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.model.DataContainer;
import com.sd.storage.CallBack;
import com.sd.storage.UrlManager;
import com.sd.storage.api.ApiService;
import com.sd.storage.model.BarCodeInptListtModel;
import com.sd.storage.model.CodeGoodsModel;
import com.sd.storage.model.CodeGoodsSubmitModel;
import com.sd.storage.stores.AppStore;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/1/18.
 */

public class CodeGoodsCreator extends ActionsCreator {

    @Inject
    AppStore appStore;


    @Inject
    public CodeGoodsCreator(Dispatcher dispatcher, ApiService apiService) {
        super(dispatcher, apiService);
    }


    /**
     * 根据条码号获取主页面数据（条码拣货-主页面）
     */
    public void GetRfWmsAppBillList(String barCode) {
        String appM = "GetRfWmsAppBillList";
        HashMap<String, String> params = new HashMap<>();
        params.put("barCode", barCode);
        params.put("deptId", appStore.getDeptId());

        putObsToSubscriber(mApiService.GetRfWmsAppBillList(appM, params), new CallBack<DataContainer<ArrayList<CodeGoodsModel>>>(this) {
            @Override
            protected void doNext(DataContainer<ArrayList<CodeGoodsModel>> arrayListDataContainer) {

                dispatchAction(new CodeGoodsAction(CodeGoodsAction.BILLIST, arrayListDataContainer));
            }
        });
    }


    /**
     * 条码拆分提交（条码拆分-主页面）
     *
     * @param id
     * @param barCode
     */
    public void SubmitWmsAppBillData(String id, String barCode) {
        String appM = "SubmitWmsAppBillData";
        HashMap<String, String> params = new HashMap<>();
        params.put("hosId", UrlManager.getHosId());
        params.put("userId", appStore.getUserModle().USERID);
        params.put("id", id);
        params.put("deptId", appStore.getDeptId());
        params.put("barCode", barCode);

        putObsToSubscriber(mApiService.SubmitWmsAppBillData(appM, params), new CallBack<DataContainer<CodeGoodsSubmitModel>>(this) {
            @Override
            protected void doNext(DataContainer<CodeGoodsSubmitModel> objectDataContainer) {

                dispatchAction(new CodeGoodsAction(CodeGoodsAction.BILSUBMIT, objectDataContainer));
            }
        });
    }


}
