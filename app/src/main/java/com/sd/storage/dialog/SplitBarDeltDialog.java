package com.sd.storage.dialog;


import android.view.View;

import com.sd.storage.R;

import butterknife.OnClick;

/**
 * Created by lenovo on 2018/1/18.
 */

public class SplitBarDeltDialog extends BaseDialog{



    @Override
    protected int getLayoutId() {
        return R.layout.dialog_delt_activity;
    }


    @OnClick({R.id.tv_sure, R.id.tv_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sure:
                if (null != onDeltSureClickListener) {
                    onDeltSureClickListener.onDeltSure();
                }
                break;
            case R.id.tv_cancel:
                this.dismiss();
                break;
        }
    }

    private OnDeltSureClickListener onDeltSureClickListener;

    public void setOnDeltSureClickListener(OnDeltSureClickListener onDeltSureClickListener) {
        this.onDeltSureClickListener = onDeltSureClickListener;
    }


    public interface OnDeltSureClickListener {
        void onDeltSure();

    }


}
