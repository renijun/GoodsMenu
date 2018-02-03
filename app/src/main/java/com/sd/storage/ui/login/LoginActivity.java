package com.sd.storage.ui.login;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.SelectDeptActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.dialog.SelectDepartmentDialog;
import com.sd.storage.dialog.WaitingDialog;
import com.sd.storage.model.DepartmentModel;
import com.sd.storage.stores.AppStore;
import com.sd.storage.stores.SelectDeptStore;
import com.sd.storage.ui.base.BaseSCActivity;
import com.sd.storage.util.ToastUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * 登录界面
 */
public class LoginActivity extends BaseSCActivity implements SelectDepartmentDialog.OnClickListener {

    @Inject
    AppStore mAppStore;

    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;


    private String account;
    private String password;
    public ArrayList<DepartmentModel> mHistoryModels;


    private SelectDepartmentDialog selectDepartmentDialog;


    @Inject
    SelectDeptActionsCreator selectDeptActionsCreator;
    @Inject
    SelectDeptStore selectDeptStore;

    private String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        getDisplay().showWaittingDialog();
        selectDeptActionsCreator.getDeptItem();
    }


    @OnClick({R.id.tv_department, R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_department:
                department = tvDepartment.getText().toString();
                if (null == department || "".equals(department)) {
                    getDisplay().showWaittingDialog();
                    selectDeptActionsCreator.getDeptItem();
                } else {
                    selectDepartmentDialog.show(getFragmentManager(), "selectDepartmentDialog");
                }
                break;
            case R.id.tv_login:
                account = etAccount.getText().toString();
                if (null == account || "".equals(account)) {
                    ToastUtils.showBaseToast(getString(R.string.please_input_account), this);
                    break;
                }
                password = etPassword.getText().toString();
                if (null == password || "".equals(password)) {
                    ToastUtils.showBaseToast(getString(R.string.hint_password), this);
                    break;
                }
                department = tvDepartment.getText().toString();
                if (null == department || "".equals(department)) {
                    ToastUtils.showBaseToast(getString(R.string.please_select_depart), this);
                    break;
                }
                getDisplay().showWaittingDialog();
                selectDeptActionsCreator.getCheckLogin(account, password);
                break;
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initReturnEvent() {
        /**
         * 登陆成功
         */
        selectDeptStore.toMainSubscription(SelectDeptStore.LoginChange.class, new Action1<SelectDeptStore.LoginChange>() {
            @Override
            public void call(SelectDeptStore.LoginChange loginChange) {
                getDisplay().hideWaittingDialog();
                getDisplay().startMainActivity2();
                finish();
            }
        });


        /**
         * 请求部门
         */
        selectDeptStore.toMainSubscription(SelectDeptStore.MyHistoryChange.class, new Action1<SelectDeptStore.MyHistoryChange>() {
            @Override
            public void call(SelectDeptStore.MyHistoryChange myHistoryChange) {
                mHistoryModels = selectDeptStore.getmHistoryModels();
                selectDepartmentDialog = new SelectDepartmentDialog();
                selectDepartmentDialog.setOnClickListener(LoginActivity.this);
                selectDepartmentDialog.setData(LoginActivity.this, mHistoryModels);
                if (null != mHistoryModels && mHistoryModels.size() > 0) {
                    tvDepartment.setText(mHistoryModels.get(0).DEPTNAME);
                    mAppStore.setDeptId(mHistoryModels.get(0).DEPTID);
                    mAppStore.setDeptName(mHistoryModels.get(0).DEPTNAME);

                }
                getDisplay().hideWaittingDialog();

            }
        });

        /**
         * 请求错误
         */
        selectDeptStore.toMainSubscription(SelectDeptStore.ChangeError.class, new Action1<SelectDeptStore.ChangeError>() {
            @Override
            public void call(SelectDeptStore.ChangeError changeError) {
                getDisplay().hideWaittingDialog();
                ToastUtils.showBaseToast(changeError.msge, LoginActivity.this);
            }
        });


    }

    @Override
    public Store[] getStoreArray() {
        return new Store[]{selectDeptStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return selectDeptActionsCreator;
    }


    @Override
    public void setDepartText(DepartmentModel item) {

        mAppStore.setDeptId(item.DEPTID);
        tvDepartment.setText(item.DEPTNAME);
        // mAppStore.
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean isExit = false;

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
}
