package com.sd.storage.dialog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sd.storage.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/1/18.
 */

public class SplitBarSubmitDialog extends BaseDialog {


    @Override
    protected int getLayoutId() {
        return R.layout.dialog_submit_activity;
    }


    @OnClick({R.id.tv_sure, R.id.tv_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sure:
                if (null != onSureClickListener) {
                    onSureClickListener.onSubmitSure();
                }
                break;
            case R.id.tv_cancel:
                this.dismiss();
                break;
        }
    }

    private OnSureClickListener onSureClickListener;

    public void setOnSureClickListener(OnSureClickListener onSureClickListener) {
        this.onSureClickListener = onSureClickListener;
    }


    public interface OnSureClickListener {
        void onSubmitSure();

    }


}
