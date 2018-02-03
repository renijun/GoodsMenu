package com.sd.storage.stores;


import com.dframe.lib.action.Action;
import com.dframe.lib.model.DataContainer;
import com.dframe.lib.store.Store;
import com.sd.storage.actions.BoxCheckAction;
import com.sd.storage.actions.CodeGoodsAction;
import com.sd.storage.actions.GetRfScmBoxAction;
import com.sd.storage.model.BarCodeInptListtModel;
import com.sd.storage.model.CodeGoodsModel;
import com.sd.storage.model.CodeGoodsSubmitModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 条码拣货
 * Created by MrZhou on 2016/11/23.
 */
public class CodeGoodsStore extends Store<Action> {


    private ArrayList<CodeGoodsModel> codeGoodsModels;

    private CodeGoodsSubmitModel codeGoodsSubmitModel;

    public CodeGoodsSubmitModel getCodeGoodsSubmitModel() {
        return codeGoodsSubmitModel;
    }

    @Inject
    public CodeGoodsStore() {

    }

    public ArrayList<CodeGoodsModel> getCodeGoodsModels() {
        return codeGoodsModels;
    }

    @Override
    public void doAction(Action action) {
        switch (action.getType()) {
            case CodeGoodsAction.BILLIST:
                DataContainer<ArrayList<CodeGoodsModel>> dataContainer = (DataContainer<ArrayList<CodeGoodsModel>>) action.getData();
                if (dataContainer.getResultOK()) {
                    codeGoodsModels = dataContainer.data;
                    dispatcherStore(new BilListyChange());
                } else {
                    dispatcherStore(new ChangeError(dataContainer.Code, dataContainer.Message));
                }
                break;
            case CodeGoodsAction.BILSUBMIT:
                DataContainer<CodeGoodsSubmitModel> objectDataContainer = (DataContainer<CodeGoodsSubmitModel>) action.getData();
                if (objectDataContainer.getResultOK()) {

                    codeGoodsSubmitModel=objectDataContainer.data;
                    dispatcherStore(new BilSubmitChange(objectDataContainer.Message));
                } else {
                    dispatcherStore(new SubmitChangeError(objectDataContainer.Code, objectDataContainer.Message));
                }
                break;
        }
    }

    public static class BilSubmitChange {
        public String msge;

        public BilSubmitChange(String msge) {
            this.msge = msge;
        }
    }

    public static class BilListyChange {

    }

    public static class SubmitChangeError extends ErrorState {
        SubmitChangeError(int state, String msge) {
            super(state, msge);
        }
    }

    public static class ChangeError extends ErrorState {
        ChangeError(int state, String msge) {
            super(state, msge);
        }
    }

}
