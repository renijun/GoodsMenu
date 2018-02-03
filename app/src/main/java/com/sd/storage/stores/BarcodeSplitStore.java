package com.sd.storage.stores;


import com.dframe.lib.action.Action;
import com.dframe.lib.model.DataContainer;
import com.dframe.lib.store.Store;
import com.sd.storage.actions.BarSplitMainAction;
import com.sd.storage.actions.BarcodeInputAction;
import com.sd.storage.model.BarCodeModel;
import com.sd.storage.model.BarCodeSplitMianModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 条码拆分
 * Created by MrZhou on 2016/11/23.
 */
public class BarcodeSplitStore extends Store<Action> {

    public ArrayList<BarCodeSplitMianModel> barCodeSplitMianModels;

    @Inject
    public BarcodeSplitStore() {

    }

    public ArrayList<BarCodeSplitMianModel> getBarCodeSplitMianModels() {
        return barCodeSplitMianModels;
    }

    @Override
    public void doAction(Action action) {
        switch (action.getType()) {
            case BarSplitMainAction.BARSPLIT:
                DataContainer<ArrayList<BarCodeSplitMianModel>> dataContainer = (DataContainer<ArrayList<BarCodeSplitMianModel>>) action.getData();
                if (dataContainer.getResultOK()) {
                    barCodeSplitMianModels = (ArrayList<BarCodeSplitMianModel>) dataContainer.data;
                    dispatcherStore(new BarSplittChange());
                } else {
                    dispatcherStore(new ChangeError(dataContainer.Code, dataContainer.Message));
                }
                break;
            case BarSplitMainAction.BARSPLITSubmit:
                DataContainer<Object> objectDataContainer = (DataContainer<Object>) action.getData();
                if (objectDataContainer.getResultOK()) {
                    dispatcherStore(new BarSplitSubmitChange());
                } else {
                    dispatcherStore(new ChangeError(objectDataContainer.Code, objectDataContainer.Message));
                }
                break;
        }
    }


    public static class BarSplitSubmitChange {

    }


    public static class BarSplittChange {

    }


    public static class ChangeError extends ErrorState {
        ChangeError(int state, String msge) {
            super(state, msge);
        }
    }

}
