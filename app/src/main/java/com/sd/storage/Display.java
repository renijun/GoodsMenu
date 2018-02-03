package com.sd.storage;

import com.dframe.lib.widgets.dialog.DialogControl;

/**
 * Created by MrZhou on 2017/5/13.
 */

public interface Display extends DialogControl {

    void setSupportActionBar(Object toolbar);

    void startLoginActivity();

    void startMainActivity();

    void startPutInStorageActivity();

    void startBarCodeInputActivity();

    void startSplitActivity();

    void startPandianMainActivity();

    void startMainActivity2();


    void showWaittingDialog(String text);

    void showWaittingDialog();

    void hideWaittingDialog();

    void startCodeGoodsActivity();


}