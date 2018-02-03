package com.sd.storage.dialog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sd.storage.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/1/18.
 */

public class SplitBarReScanDialog extends BaseDialog {


    @BindView(R.id.tv_content)
    TextView tv_content;

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_submit_activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        tv_content.setText("确定重扫？");
        return view;
    }

    @OnClick({R.id.tv_sure, R.id.tv_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sure:
                if (null != onRescanSureClickListener) {
                    onRescanSureClickListener.onRescanSure();
                }
                break;
            case R.id.tv_cancel:
                this.dismiss();
                break;
        }
    }

    private OnRescanSureClickListener onRescanSureClickListener;

    public void setOnReScanSureClickListener(OnRescanSureClickListener onSureClickListener) {
        this.onRescanSureClickListener = onSureClickListener;
    }


    public interface OnRescanSureClickListener {
        void onRescanSure();

    }


}
