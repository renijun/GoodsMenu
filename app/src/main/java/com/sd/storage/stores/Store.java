package com.sd.storage.stores;


import com.dframe.lib.action.Action;
import com.dframe.lib.model.DataContainer;
import com.sd.storage.actions.BoxCheckAction;
import com.sd.storage.actions.GetRfScmBoxAction;
import com.sd.storage.model.BarCodeInptListtModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 入库
 * Created by MrZhou on 2016/11/23.
 */
public class Store extends com.dframe.lib.store.Store<Action> {

    public ArrayList<BarCodeInptListtModel> barCodeInptListtModelArrayList;

    @Inject
    public Store() {

    }

    public ArrayList<BarCodeInptListtModel> getBarCodeInptListtModelArrayList() {
        return barCodeInptListtModelArrayList;
    }

    @Override
    public void doAction(Action action) {
        switch (action.getType()) {
            case GetRfScmBoxAction.GetRfScmBoxList:
                DataContainer<ArrayList<BarCodeInptListtModel>> dataContainer = (DataContainer<ArrayList<BarCodeInptListtModel>>) action.getData();
                if (dataContainer.getResultOK()) {
                    barCodeInptListtModelArrayList = dataContainer.data;
                    dispatcherStore(new BarListyChange());
                } else {
                    dispatcherStore(new ChangeError(dataContainer.Code, dataContainer.Message));
                }
                break;
            case BoxCheckAction.BOXCHECK:
                DataContainer<Object> objectDataContainer = (DataContainer<Object>) action.getData();
                if (objectDataContainer.getResultOK()) {
                    dispatcherStore(new BoxCheckChange(objectDataContainer.Message));
                } else {
                    dispatcherStore(new ChangeError(objectDataContainer.Code, objectDataContainer.Message));
                }
                break;

        }
    }







    public static class BarListyChange {
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
