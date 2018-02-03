package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.model.DataContainer;
import com.sd.storage.CallBack;
import com.sd.storage.UrlManager;
import com.sd.storage.api.ApiService;
import com.sd.storage.model.BarCodeSplitMianModel;
import com.sd.storage.model.PanDianListModel;
import com.sd.storage.model.PandianDataListModel;
import com.sd.storage.stores.AppStore;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/1/18.
 */

public class PanDianActionsCreator extends ActionsCreator {


    @Inject
    AppStore appStore;

    @Inject
    public PanDianActionsCreator(Dispatcher dispatcher, ApiService apiService) {
        super(dispatcher, apiService);
    }


    /**
     * 根据条码号获取主页面数据（盘点-主页面）
     *
     * @param barCode
     */
    public void GetRfLotWmsBarCodeChkList(String barCode) {
        String appM = "GetRfLotWmsBarCodeChkList";
        HashMap<String, String> params = new HashMap<>();
        params.put("barCode", barCode);
        params.put("deptId", appStore.getDeptId());

        putObsToSubscriber(mApiService.GetRfLotWmsBarCodeChkList(appM, params), new CallBack<DataContainer<ArrayList<PanDianListModel>>>(this) {
            @Override
            protected void doNext(DataContainer<ArrayList<PanDianListModel>> arrayListDataContainer) {

                dispatchAction(new PandianAction(PandianAction.PANDIANLIST, arrayListDataContainer));
            }

        });
    }

    /**
     * 确认（盘点-主页面）
     *
     * @param id
     */
    public void SubmitWmsChkData(String id, String type) {
        String appM = "SubmitWmsChkData";
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("deptId", appStore.getDeptId());
        params.put("hosId", UrlManager.getHosId());
        params.put("userId", appStore.getUserModle().USERID);
        params.put("type", type);

        putObsToSubscriber(mApiService.SubmitWmsChkData(appM, params), new CallBack<DataContainer<Object>>(this) {
            @Override
            protected void doNext(DataContainer<Object> objectDataContainer) {
                dispatchAction(new PandianAction(PandianAction.PANDIANDATA, objectDataContainer));
            }

        });
    }

    /**
     * 根据登录部门获取页面数据（盘点-盘点情况
     */
    public void GetRfLotWmsChkList() {
        String appM = "GetRfLotWmsChkList";
        HashMap<String, String> params = new HashMap<>();
        params.put("deptId", appStore.getDeptId());
        ;

        putObsToSubscriber(mApiService.GetRfLotWmsChkList(appM, params), new CallBack<DataContainer<ArrayList<PandianDataListModel>>>(this) {
            @Override
            protected void doNext(DataContainer<ArrayList<PandianDataListModel>> arrayListDataContainer) {

                dispatchAction(new PandianAction(PandianAction.PANDIANDATALIST, arrayListDataContainer));
            }

        });
    }


}
