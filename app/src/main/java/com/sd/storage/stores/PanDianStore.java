package com.sd.storage.stores;


import com.dframe.lib.action.Action;
import com.dframe.lib.model.DataContainer;
import com.dframe.lib.store.Store;
import com.sd.storage.actions.BarSplitMainAction;
import com.sd.storage.actions.PandianAction;
import com.sd.storage.model.BarCodeSplitMianModel;
import com.sd.storage.model.PanDianListModel;
import com.sd.storage.model.PandianDataListModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 盘点
 * Created by MrZhou on 2016/11/23.
 */
public class PanDianStore extends Store<Action> {

    public ArrayList<PanDianListModel> panDianListModels;

    public ArrayList<PandianDataListModel> pandianDataListModelArrayList;

    private String dataString;


    public String getDataString() {
        return dataString;
    }

    @Inject
    public PanDianStore() {

    }

    public ArrayList<PandianDataListModel> getPandianDataListModelArrayList() {
        return pandianDataListModelArrayList;
    }

    public ArrayList<PanDianListModel> getPanDianListModels() {
        return panDianListModels;
    }

    @Override
    public void doAction(Action action) {
        switch (action.getType()) {
            case PandianAction.PANDIANLIST:
                DataContainer<ArrayList<PanDianListModel>> dataContainer = (DataContainer<ArrayList<PanDianListModel>>) action.getData();
                if (dataContainer.getResultOK()) {
                    panDianListModels = dataContainer.data;
                    dispatcherStore(new PanDianChange());
                } else {
                    dispatcherStore(new ChangeListError(dataContainer.Code, dataContainer.Message));
                }
                break;
            case PandianAction.PANDIANDATA:
                DataContainer<Object> objectDataContainer = (DataContainer<Object>) action.getData();
                if (objectDataContainer.getResultOK()) {
                    dataString = (String) objectDataContainer.data;
                    dispatcherStore(new PanDianDataChange(objectDataContainer.Message));
                } else {
                    dispatcherStore(new ChangeError(objectDataContainer.Code, objectDataContainer.Message));
                }
                break;

            case PandianAction.PANDIANDATALIST:
                DataContainer<ArrayList<PandianDataListModel>> dataContainer1 = (DataContainer<ArrayList<PandianDataListModel>>) action.getData();
                if (dataContainer1.getResultOK()) {

                    pandianDataListModelArrayList = dataContainer1.data;
                    dispatcherStore(new PanDianDataListChange());
                } else {
                    dispatcherStore(new PanDianDataListErrChange());
                }
                break;


        }
    }


    public static class PanDianDataListErrChange {

    }

    public static class PanDianDataListChange {

    }


    public static class PanDianDataChange {
        public String msge;

        public PanDianDataChange(String msge) {
            this.msge = msge;
        }
    }

    public static class PanDianChange {
    }

    public static class ChangeListError extends ErrorState {
        ChangeListError(int state, String msge) {
            super(state, msge);
        }
    }

    public static class ChangeError extends ErrorState {
        ChangeError(int state, String msge) {
            super(state, msge);
        }
    }

}
