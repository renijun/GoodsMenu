package com.sd.storage.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.sd.storage.R;
import com.sd.storage.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setNavigationIcon(null);
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.storage_manage);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.btn_procurement_storage,
            R.id.btn_procurement_exit_storage,
            R.id.btn_sell_storage,
            R.id.btn_sell_exit_storage,
            R.id.btn_transfer_slip,
            R.id.btn_check,
            R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_procurement_storage:
                // 采购入库
                break;
            case R.id.btn_procurement_exit_storage:
                // 采购退库
                break;
            case R.id.btn_sell_storage:
                // 销售出库
                break;
            case R.id.btn_sell_exit_storage:
                // 销售退库
                break;
            case R.id.btn_transfer_slip:
                // 调拨单
                break;
            case R.id.btn_check:
                // 盘点
                break;
            case R.id.btn_exit:
                // 退出
                getDisplay().startLoginActivity();
                finish();
                break;
        }
    }
}
