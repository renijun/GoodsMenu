package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.model.DataContainer;
import com.sd.storage.CallBack;
import com.sd.storage.UrlManager;
import com.sd.storage.api.ApiService;
import com.sd.storage.model.BarCodeModel;
import com.sd.storage.stores.AppStore;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/1/18.
 */

public class BarCodeActionsCreator extends ActionsCreator {


    @Inject
    AppStore appStore;

    @Inject
    public BarCodeActionsCreator(Dispatcher dispatcher, ApiService apiService) {
        super(dispatcher, apiService);
    }


    /**
     * 根据条码号获取列表数据（上架入库）
     *
     * @param barCode
     */
    public void GetRfLotWmsBarCodeInptList(String barCode) {
        String appM = "GetRfLotWmsBarCodeInptList";
        HashMap<String, String> params = new HashMap<>();
        params.put("deptId", appStore.getDeptId());
        params.put("barCode", barCode);


        putObsToSubscriber(mApiService.GetRfLotWmsBarCodeInptList(appM, params), new CallBack<DataContainer<ArrayList<BarCodeModel>>>(this) {
            @Override
            protected void doNext(DataContainer<ArrayList<BarCodeModel>> arrayListDataContainer) {


                dispatchAction(new BoxCheckAction(BoxCheckAction.BOXCHECK, arrayListDataContainer));
            }

        });
    }


    /**
     * 上架（上架入库）
     * @param id
     * @param newShipCode
     */
    public void SubmitPurPosData(String id,String newShipCode) {
        String appM = "SubmitPurPosData";
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("newShipCode", newShipCode);
        params.put("hosId", UrlManager.getHosId());
        params.put("deptId", appStore.getDeptId());
        params.put("userId", appStore.getUserModle().USERID);

        putObsToSubscriber(mApiService.SubmitPurPosData(appM, params), new CallBack<DataContainer<Object>>(this) {
            @Override
            protected void doNext(DataContainer<Object> objectDataContainer) {


                dispatchAction(new BoxCheckAction(BoxCheckAction.BOXCHECKsubmit, objectDataContainer));
            }

        });
    }





}
