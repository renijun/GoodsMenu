package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.model.DataContainer;
import com.sd.storage.CallBack;
import com.sd.storage.UrlManager;
import com.sd.storage.api.ApiService;
import com.sd.storage.model.BarCodeModel;
import com.sd.storage.model.BarCodeSplitMianModel;
import com.sd.storage.stores.AppStore;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/1/18.
 */

public class BarCodeSplitActionsCreator extends ActionsCreator {


    @Inject
    AppStore appStore;

    @Inject
    public BarCodeSplitActionsCreator(Dispatcher dispatcher, ApiService apiService) {
        super(dispatcher, apiService);
    }


    /**
     * 根据条码号获取列表数据（上架入库）
     *
     * @param barCode
     */
    public void GetLotWmsBarCodeSplList(String barCode) {
        String appM = "GetLotWmsBarCodeSplList";
        HashMap<String, String> params = new HashMap<>();
        params.put("barCode", barCode);
        params.put("deptId", appStore.getDeptId());
        params.put("hosId", UrlManager.getHosId());
        params.put("userId", appStore.getUserModle().USERID);


        putObsToSubscriber(mApiService.GetLotWmsBarCodeSplList(appM, params), new CallBack<DataContainer<ArrayList<BarCodeSplitMianModel>>>(this) {
            @Override
            protected void doNext(DataContainer<ArrayList<BarCodeSplitMianModel>> arrayListDataContainer) {

                dispatchAction(new BarSplitMainAction(BarSplitMainAction.BARSPLIT, arrayListDataContainer));
            }

        });
    }


    /**
     * 条码拆分提交（条码拆分-主页面）
     * @param lwbid
     * @param barCode
     */
    public void SubmitLotWmsBarCodeData(String lwbid,String barCode) {
        String appM = "SubmitLotWmsBarCodeData";
        HashMap<String, String> params = new HashMap<>();
        params.put("barCode", barCode);
        params.put("lwbid", lwbid);
        params.put("hosId", UrlManager.getHosId());
        params.put("userId", appStore.getUserModle().USERID);


        putObsToSubscriber(mApiService.SubmitLotWmsBarCodeData(appM, params), new CallBack<DataContainer<Object>>(this) {
            @Override
            protected void doNext(DataContainer<Object> objectDataContainer) {

                dispatchAction(new BarSplitMainAction(BarSplitMainAction.BARSPLITSubmit, objectDataContainer));
            }

        });
    }






}
