package com.sd.storage.ui.main.codegoods;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.CodeGoodsCreator;
import com.sd.storage.actions.PutInStoreActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.model.CodeGoodsModel;
import com.sd.storage.model.CodeGoodsSubmitModel;
import com.sd.storage.stores.CodeGoodsStore;
import com.sd.storage.stores.PutInStorageStore;
import com.sd.storage.ui.base.BaseSCActivity;
import com.sd.storage.ui.main.PutInStorageActivity;
import com.sd.storage.util.ToastUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * 条码拣货
 * Created by Administrator on 2018/1/29.
 */

public class CodeGoodsActivity extends BaseSCActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.et_number)
    EditText et_number;


    //发货部门
    @BindView(R.id.tv_send_depart)
    TextView tv_send_depart;
    //请领部门
    @BindView(R.id.tv_please_departmentd)
    TextView tv_please_departmentd;
    //品名
    @BindView(R.id.tv_product_name)
    TextView tv_product_name;
    //规格
    @BindView(R.id.tv_specifications)
    TextView tv_specifications;
    //仓位
    @BindView(R.id.tv_storage_location)
    TextView tv_storage_location;
    //厂家
    @BindView(R.id.tv_vender)
    TextView tv_vender;
    //余共
    @BindView(R.id.tv_have_all)
    TextView tv_have_all;
    //单位
    @BindView(R.id.tv_unit)
    TextView tv_unit;
    //定数条码
    @BindView(R.id.et_bar_number)
    EditText et_bar_number;
    //数量
    @BindView(R.id.tv_number)
    TextView tv_number;
    //批号
    @BindView(R.id.tv_batch_number)
    TextView tv_batch_number;
    //效期
    @BindView(R.id.tv_validity_time)
    TextView tv_validity_time;

    @Inject
    CodeGoodsCreator codeGoodsCreator;
    @Inject
    CodeGoodsStore codeGoodsStore;

    private ArrayList<CodeGoodsModel> codeGoodsModels;

    private CodeGoodsModel codeGoodsModel;

    private CodeGoodsSubmitModel codeGoodsSubmitModel;

    private String lwbid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        init();
    }


    public void init() {
        tv_title.setText(R.string.code_goods);
        et_number.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND || (null != event && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                    if (null != event) {
                        switch (event.getAction()) {
                            case KeyEvent.ACTION_UP:
                                setSearch();
                                return true;
                            default:
                                return true;
                        }
                    }
                }
                return false;
            }
        });

        et_bar_number.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND || (null != event && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                    if (null != event) {
                        switch (event.getAction()) {
                            case KeyEvent.ACTION_UP:
                                setCodeNumber();
                                return true;
                            default:
                                return true;
                        }
                    }
                }
                return false;
            }
        });


    }


    @OnClick({R.id.im_back, R.id.tv_select})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_select:
                setSearch();
                break;
        }
    }


    /**
     * 查询
     */
    public void setSearch() {
        String code = et_number.getText().toString();
        if (null != code && code.length() > 0) {
            getDisplay().showWaittingDialog();
            //   codeGoodsCreator.GetRfScmBoxList(barnumber);
            //泌尿二科门诊
            codeGoodsCreator.GetRfWmsAppBillList(code);
        } else {
            ToastUtils.showBaseToast(getString(R.string.please_input_you_barNumber), this);
        }
    }


    /**
     * 定点条码
     */
    public void setCodeNumber() {
        String barnumber = et_bar_number.getText().toString();
        if (null != barnumber && barnumber.length() > 0) {

            if (null != lwbid) {
                //泌尿二科门诊
                getDisplay().showWaittingDialog();
                codeGoodsCreator.SubmitWmsAppBillData(lwbid, barnumber);
            } else {
                showSoftInputFromWindow(et_number);
                et_bar_number.setText("");
                ToastUtils.showBaseToast(getString(R.string.please_first_select), this);
            }

        } else {
            ToastUtils.showBaseToast(getString(R.string.please_input_code_goods_submit), this);
        }
    }


    @Override
    protected void initReturnEvent() {
        //请求验收
        codeGoodsStore.toMainSubscription(CodeGoodsStore.BilListyChange.class, new Action1<CodeGoodsStore.BilListyChange>() {
            @Override
            public void call(CodeGoodsStore.BilListyChange bilListyChange) {
                getDisplay().hideWaittingDialog();
                //焦点变化  清空
                codeGoodsModels = codeGoodsStore.getCodeGoodsModels();
                if (null != codeGoodsModels && codeGoodsModels.size() > 0) {
                    codeGoodsModel = codeGoodsModels.get(0);
                    lwbid = codeGoodsModel.ID;
                    pageShow();
                    showSoftInputFromWindow(et_bar_number);
                }

            }
        });
        /**
         * 提交
         */
        codeGoodsStore.toMainSubscription(CodeGoodsStore.BilSubmitChange.class, new Action1<CodeGoodsStore.BilSubmitChange>() {
            @Override
            public void call(CodeGoodsStore.BilSubmitChange bilSubmitChange) {
                getDisplay().hideWaittingDialog();
                // 请求成功后操作内容
                et_bar_number.setText("");
                codeGoodsSubmitModel=codeGoodsStore.getCodeGoodsSubmitModel();
                setData();
                ToastUtils.showBaseToast(bilSubmitChange.msge, CodeGoodsActivity.this);

            }
        });

        //请求错误
        codeGoodsStore.toMainSubscription(CodeGoodsStore.ChangeError.class, new Action1<CodeGoodsStore.ChangeError>() {
            @Override
            public void call(CodeGoodsStore.ChangeError changeError) {
                getDisplay().hideWaittingDialog();
                et_bar_number.setText("");
                ToastUtils.showBaseToast(changeError.msge, CodeGoodsActivity.this);

            }
        });

        //请求错误
        codeGoodsStore.toMainSubscription(CodeGoodsStore.SubmitChangeError.class, new Action1<CodeGoodsStore.SubmitChangeError>() {
            @Override
            public void call(CodeGoodsStore.SubmitChangeError submitChangeError) {
                getDisplay().hideWaittingDialog();
                et_bar_number.setText("");
                ToastUtils.showBaseToast(submitChangeError.msge, CodeGoodsActivity.this);

            }
        });
    }



    public  void setData(){

        tv_have_all.setText(codeGoodsSubmitModel.QTY);
        tv_number.setText(codeGoodsSubmitModel.BARQTY);
        //批号
        tv_batch_number.setText(codeGoodsSubmitModel.LOTNO);
        // //效期
        tv_validity_time.setText(codeGoodsSubmitModel.ENDDATE);

    }
    /**
     * 页面的展示
     */
    public void pageShow() {
        //发货部门
        tv_send_depart.setText(codeGoodsModel.OUTDEPTNAME);
        //请领部门
        tv_please_departmentd.setText(codeGoodsModel.INDEPTNAME);

        //品名
        tv_product_name.setText(codeGoodsModel.GOODNAME);
        //规格
        tv_specifications.setText(codeGoodsModel.PACKSPEC);
        //仓位
        tv_storage_location.setText(codeGoodsModel.SHIPCODE);
        //厂家
        tv_vender.setText(codeGoodsModel.PRONAME);
        //余共
        tv_have_all.setText(codeGoodsModel.QTY);
        //单位
        tv_unit.setText(codeGoodsModel.UNITNAME);

       /* //数量
        tv_number.setText(codeGoodsModel.LOTNO);
        //批号
        tv_validity_time.setText(codeGoodsModel.LOTNO);
        //效期
        tv_validity_time.setText(codeGoodsModel.ENDDATE);*/

    }



    /**
     * EditText获取焦点并显示软键盘
     */
    public void showSoftInputFromWindow(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public Store[] getStoreArray() {
        return new Store[]{codeGoodsStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return codeGoodsCreator;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_code_goods;
    }
}
