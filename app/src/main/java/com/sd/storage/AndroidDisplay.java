package com.sd.storage;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dframe.lib.utils.StringUtils;
import com.dframe.lib.widgets.dialog.DialogHelper;
import com.dframe.lib.widgets.dialog.WaitDialog;
import com.sd.storage.dialog.WaitingDialog;
import com.sd.storage.dialog.WaittingDialogHelper;
import com.sd.storage.ui.MainActivity;
import com.sd.storage.ui.MainActivity2;
import com.sd.storage.ui.login.LoginActivity;
import com.sd.storage.ui.main.BarCodeInputActivity;
import com.sd.storage.ui.main.PutInStorageActivity;
import com.sd.storage.ui.main.codegoods.CodeGoodsActivity;
import com.sd.storage.ui.main.pandian.PandianMainActivity;
import com.sd.storage.ui.main.splitbar.SplitActivity;

/**
 * Created by MrZhou on 2017/5/13.
 */
public class AndroidDisplay implements Display {

    private AppCompatActivity mActivity;
    private Toolbar mToolbar;

    public AndroidDisplay(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public void setSupportActionBar(Object toolbar) {
        mToolbar = (Toolbar) toolbar;

        if (mToolbar != null) {
            final ActionBar ab = mActivity.getSupportActionBar();
            if (ab != null) {
                ab.setDisplayHomeAsUpEnabled(true);
                ab.setDisplayShowTitleEnabled(false);
                ab.setHomeButtonEnabled(true);
                ab.setHomeAsUpIndicator(R.mipmap.ic_back_grey_v2);
            }
        }
    }

    @Override
    public void startLoginActivity() {
        startActivity(LoginActivity.class);
    }

    @Override
    public void startMainActivity() {
        startActivity(MainActivity.class);
    }

    @Override
    public void startPutInStorageActivity() {
        startActivity(PutInStorageActivity.class);
    }

    @Override
    public void startPandianMainActivity() {
        startActivity(PandianMainActivity.class);
    }


    @Override
    public void startBarCodeInputActivity() {
        startActivity(BarCodeInputActivity.class);
    }

    @Override
    public void startSplitActivity() {
        startActivity(SplitActivity.class);

    }

    @Override
    public void startMainActivity2() {
        startActivity(MainActivity2.class);
    }


    public Intent initIntent(Class<?> clazz) {
        Intent initIntent = new Intent(mActivity, clazz);
        return initIntent;
    }

    public void startActivity(Class<?> clazz) {
        mActivity.startActivity(new Intent(mActivity, clazz));
    }

    public void startActivity(Intent intent) {
        mActivity.startActivity(intent);
        mActivity.overridePendingTransition(R.anim.tran_in, R.anim.tran_out);
    }

    public void startForActivityResult(Intent intent, int requestCode) {
        mActivity.startActivityForResult(intent, requestCode);
    }

    @Override
    public void hideWaitDialog() {
        if (null != mWaitDialog && mWaitDialog.isShowing()) {
            mWaitDialog.dismiss();
        }
    }

    @Override
    public void showWaitDialog() {
        showWaitDialog("");
    }

    @Override
    public void showWaitDialog(int resid) {
        String title = mActivity.getString(resid);
        showWaitDialog(title);
    }

    private WaitDialog mWaitDialog;

    @Override
    public void showWaitDialog(String text) {
        if (null == mWaitDialog) {
            mWaitDialog = DialogHelper.getWaitDialog(mActivity, mActivity.getString(R.string.loading_please_wait));
        }
        if (!mWaitDialog.isShowing()) {
            if (!StringUtils.isBlank(text)) {
                mWaitDialog.setMessage(text);
            }
            mWaitDialog.show();
        }
    }

    private WaitingDialog waitingDialog;

    @Override
    public void showWaittingDialog() {
        showWaittingDialog("");
    }

    @Override
    public void hideWaittingDialog() {
        if (null != waitingDialog && waitingDialog.isShowing()) {
            waitingDialog.dismiss();
        }
    }

    @Override
    public void startCodeGoodsActivity() {
        startActivity(CodeGoodsActivity.class);
    }

    @Override
    public void showWaittingDialog(String text) {
        if (null == waitingDialog) {
            waitingDialog = WaittingDialogHelper.getWaitDialog(mActivity, mActivity.getString(R.string.loading_please_wait));
        }
        if (!waitingDialog.isShowing()) {
          /*  if (!StringUtils.isBlank(text)) {
                waitingDialog.setMessage(text);
            }*/
            waitingDialog.show();
        }
    }


}
