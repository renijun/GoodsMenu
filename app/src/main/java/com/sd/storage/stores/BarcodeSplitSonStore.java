package com.sd.storage.stores;


import com.dframe.lib.action.Action;
import com.dframe.lib.model.DataContainer;
import com.dframe.lib.store.Store;
import com.sd.storage.actions.BarSplitMainAction;
import com.sd.storage.model.BarCodeSplitMianModel;
import com.sd.storage.model.BarCodeSplitSonModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 条码拆分
 * Created by MrZhou on 2016/11/23.
 */
public class BarcodeSplitSonStore extends Store<Action> {

    public ArrayList<BarCodeSplitSonModel> barCodeSplitMianModels;

    @Inject
    public BarcodeSplitSonStore() {

    }

    public ArrayList<BarCodeSplitSonModel> getBarCodeSplitMianModels() {
        return barCodeSplitMianModels;
    }

    @Override
    public void doAction(Action action) {
        switch (action.getType()) {
            case BarSplitMainAction.BARSPLITSON:
                DataContainer<ArrayList<BarCodeSplitSonModel>> dataContainer = (DataContainer<ArrayList<BarCodeSplitSonModel>>) action.getData();
                if (dataContainer.getResultOK()) {
                    barCodeSplitMianModels = dataContainer.data;
                    dispatcherStore(new BarSplittChange());
                } else {

                    dispatcherStore(new BarSplitErrChange());
                }
                break;

            case BarSplitMainAction.BARSPLITSUBMIT:
                DataContainer<Object> objectDataContainer = (DataContainer<Object>) action.getData();
                if (objectDataContainer.getResultOK()) {
                    dispatcherStore(new BarSplittSubmitChange(objectDataContainer.Message));
                } else {
                    dispatcherStore(new ChangeError(objectDataContainer.Code, objectDataContainer.Message));
                }
                break;

            case BarSplitMainAction.BARSPLITRESCAN:
                DataContainer<Object> reScanDataContainer = (DataContainer<Object>) action.getData();
                if (reScanDataContainer.getResultOK()) {
                    dispatcherStore(new BarSplittReScanChange(reScanDataContainer.Message));
                } else {
                    dispatcherStore(new ChangeError(reScanDataContainer.Code, reScanDataContainer.Message));
                }
                break;

            case BarSplitMainAction.BARSPLITDELT:
                DataContainer<Object> deltDataContainer = (DataContainer<Object>) action.getData();
                if (deltDataContainer.getResultOK()) {
                    dispatcherStore(new BarSplittDeltChange(deltDataContainer.Message));
                } else {
                    dispatcherStore(new ChangeError(deltDataContainer.Code, deltDataContainer.Message));
                }
                break;


        }
    }


    /**
     * 删除
     */
    public static class BarSplittDeltChange {
        public String msge;

        public BarSplittDeltChange(String msge) {
            this.msge = msge;
        }


    }

    /**
     * 重扫
     */
    public static class BarSplittReScanChange {
        public String msge;

        public BarSplittReScanChange(String msge) {
            this.msge = msge;
        }
    }

    /**
     * 提交
     */
    public static class BarSplittSubmitChange {

        public String msge;

        public BarSplittSubmitChange(String msge) {
            this.msge = msge;
        }
    }

    public static class BarSplittChange {
    }

    /**
     * 请求失败
     */
    public static class BarSplitErrChange {
    }


    public static class ChangeError extends ErrorState {
        ChangeError(int state, String msge) {
            super(state, msge);
        }
    }

}
