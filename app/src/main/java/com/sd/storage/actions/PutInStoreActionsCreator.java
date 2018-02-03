package com.sd.storage.actions;

import android.util.Log;

import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.model.DataContainer;
import com.sd.storage.CallBack;
import com.sd.storage.UrlManager;
import com.sd.storage.api.ApiService;
import com.sd.storage.model.BarCodeInptListtModel;
import com.sd.storage.model.DepartmentModel;
import com.sd.storage.stores.AppStore;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/1/18.
 */

public class PutInStoreActionsCreator extends ActionsCreator {

    @Inject
    AppStore appStore;


    @Inject
    public PutInStoreActionsCreator(Dispatcher dispatcher, ApiService apiService) {
        super(dispatcher, apiService);
    }


    /**
     * 根据条码号获取列表数据
     */
    public void GetRfScmBoxList(String barCode) {
        String appM = "GetRfScmBoxList";
        HashMap<String, String> params = new HashMap<>();
        params.put("hosId", UrlManager.getHosId());
        params.put("barCode", barCode);
       // params.put("deptId", "f8ec2e03-46f2-4c6e-3334-fc4bcfabd962");
        params.put("deptId", appStore.getDeptId());


        putObsToSubscriber(mApiService.GetRfScmBoxList(appM, params), new CallBack<DataContainer<ArrayList<BarCodeInptListtModel>>>(this) {
            @Override
            protected void doNext(DataContainer<ArrayList<BarCodeInptListtModel>> arrayListDataContainer) {
                Log.i("URL", "doNext: " + "ok");
                dispatchAction(new GetRfScmBoxAction(GetRfScmBoxAction.GetRfScmBoxList, arrayListDataContainer));
            }
        });
    }


    /**
     * 验收
     *
     * @param boxid
     * @param qty
     */
    public void BoxChexkRef(String boxid, String qty,String type) {
        String appM = "BoxChexkRef";
        HashMap<String, String> params = new HashMap<>();
        params.put("hosId", UrlManager.getHosId());
        params.put("type", type);
        params.put("boxid", boxid);
        params.put("refmark", "");
        params.put("qty", qty);
        //params.put("userid", "bccb9c94-0133-47a3-886e-373d051e9dab");
        params.put("userid", appStore.getUserModle().USERID);


        putObsToSubscriber(mApiService.BoxChexkRef(appM, params), new CallBack<DataContainer<Object>>(this) {
            @Override
            protected void doNext(DataContainer<Object> objectDataContainer) {

                dispatchAction(new BoxCheckAction(BoxCheckAction.BOXCHECK, objectDataContainer));
            }
        });
    }


}
