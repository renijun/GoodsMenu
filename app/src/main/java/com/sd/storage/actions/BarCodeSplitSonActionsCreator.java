package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.model.DataContainer;
import com.sd.storage.CallBack;
import com.sd.storage.UrlManager;
import com.sd.storage.api.ApiService;
import com.sd.storage.model.BarCodeSplitMianModel;
import com.sd.storage.model.BarCodeSplitSonModel;
import com.sd.storage.stores.AppStore;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/1/18.
 */

public class BarCodeSplitSonActionsCreator extends ActionsCreator {


    @Inject
    AppStore appStore;

    @Inject
    public BarCodeSplitSonActionsCreator(Dispatcher dispatcher, ApiService apiService) {
        super(dispatcher, apiService);
    }


    /**
     * 根据条码号获取列表数据（上架入库）
     *
     * @param id
     */
    public void GetLotWmsBarCodeSubSplList(String id) {
        String appM = "GetLotWmsBarCodeSubSplList";
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);

        putObsToSubscriber(mApiService.GetLotWmsBarCodeSubSplList(appM, params), new CallBack<DataContainer<ArrayList<BarCodeSplitSonModel>>>(this) {
            @Override
            protected void doNext(DataContainer<ArrayList<BarCodeSplitSonModel>> arrayListDataContainer) {

                dispatchAction(new BarSplitMainAction(BarSplitMainAction.BARSPLITSON, arrayListDataContainer));
            }

        });
    }


    /**
     * 提交
     * @param id
     */
    public void SubmitSubBarCodeSpl(String id ) {
        String appM = "ResetSubBarCodeSpl";
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("hosId", UrlManager.getHosId());
        params.put("userId", appStore.getUserModle().USERID);

        putObsToSubscriber(mApiService.SubmitSubBarCodeSpl(appM, params), new CallBack<DataContainer<Object>>(this) {
            @Override
            protected void doNext(DataContainer<Object> objectDataContainer) {

                dispatchAction(new BarSplitMainAction(BarSplitMainAction.BARSPLITSUBMIT, objectDataContainer));
            }

        });
    }


    /**
     * 重扫
     * @param id
     */
    public void ResetSubBarCodeSpl(String id ) {
        String appM = "ResetSubBarCodeSpl";
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("hosId", UrlManager.getHosId());
        params.put("userId", appStore.getUserModle().USERID);

        putObsToSubscriber(mApiService.ResetSubBarCodeSpl(appM, params), new CallBack<DataContainer<Object>>(this) {
            @Override
            protected void doNext(DataContainer<Object> objectDataContainer) {

                dispatchAction(new BarSplitMainAction(BarSplitMainAction.BARSPLITRESCAN, objectDataContainer));
            }

        });
    }




    /**
     * 删除
     * @param id
     */
    public void RemoveSubBarCodeSpl(String id ) {
        String appM = "RemoveSubBarCodeSpl";
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("hosId", UrlManager.getHosId());
        params.put("userId", appStore.getUserModle().USERID);

        putObsToSubscriber(mApiService.RemoveSubBarCodeSpl(appM, params), new CallBack<DataContainer<Object>>(this) {
            @Override
            protected void doNext(DataContainer<Object> objectDataContainer) {

                dispatchAction(new BarSplitMainAction(BarSplitMainAction.BARSPLITDELT, objectDataContainer));
            }

        });
    }




}
