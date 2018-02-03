package com.sd.storage.stores;


import com.dframe.lib.action.Action;
import com.dframe.lib.model.DataContainer;
import com.dframe.lib.store.Store;
import com.sd.storage.actions.BarcodeInputAction;
import com.sd.storage.actions.BoxCheckAction;
import com.sd.storage.model.BarCodeModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 入库
 * Created by MrZhou on 2016/11/23.
 */
public class BarcodeStore extends Store<Action> {

    public ArrayList<BarCodeModel> barCodeInptListtModelArrayList;

    @Inject
    public BarcodeStore() {

    }

    public ArrayList<BarCodeModel> getBarCodeInptListtModelArrayList() {
        return barCodeInptListtModelArrayList;
    }

    @Override
    public void doAction(Action action) {
        switch (action.getType()) {
            case BoxCheckAction.BOXCHECK:
                DataContainer<ArrayList<BarCodeModel>> dataContainer = (DataContainer<ArrayList<BarCodeModel>>) action.getData();
                if (dataContainer.getResultOK()) {
                    barCodeInptListtModelArrayList = dataContainer.data;
                    dispatcherStore(new BarCodeListChange());
                } else {
                    dispatcherStore(new ChangeError(dataContainer.Code, dataContainer.Message));
                }
                break;

            case BoxCheckAction.BOXCHECKsubmit:
                DataContainer<Object> objectDataContainer = (DataContainer<Object>) action.getData();
                if (objectDataContainer.getResultOK()) {
                    dispatcherStore(new BarCodeSubmitChange(objectDataContainer.Message));
                } else {
                    dispatcherStore(new ChangeError(objectDataContainer.Code, objectDataContainer.Message));
                }
                break;


        }
    }
    public static class BarCodeSubmitChange {
        public String msge;

        public BarCodeSubmitChange(String msge) {
            this.msge = msge;
        }
    }

    public static class BarCodeListChange {

    }

    public static class BoxCheckChange {
        public String msge;

        public BoxCheckChange(String msge) {
            this.msge = msge;
        }
    }

    public static class ChangeError extends ErrorState {
        ChangeError(int state, String msge) {
            super(state, msge);
        }
    }

}
