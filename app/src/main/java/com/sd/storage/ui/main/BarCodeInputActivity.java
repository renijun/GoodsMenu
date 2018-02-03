package com.sd.storage.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.BarCodeActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.model.BarCodeModel;
import com.sd.storage.stores.BarcodeStore;
import com.sd.storage.ui.base.BaseSCActivity;
import com.sd.storage.util.ToastUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Created by lenovo on 2018/1/18.
 */

public class BarCodeInputActivity extends BaseSCActivity {

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_page_show)
    TextView tv_page_show;

    @BindView(R.id.tv_back_page)
    TextView tv_back_page;
    @BindView(R.id.tv_next_page)
    TextView tv_next_page;

    @BindView(R.id.et_number)
    EditText et_number;
    @BindView(R.id.tv_select)
    TextView tv_select;
    //供应商
    @BindView(R.id.tv_supplier)
    TextView tv_supplier;
    //部门
    @BindView(R.id.tv_department)
    TextView tv_department;
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

    //批号
    @BindView(R.id.tv_batch_number)
    TextView tv_batch_number;
    //效期
    @BindView(R.id.tv_validity_time)
    TextView tv_validity_time;
    //国准
    @BindView(R.id.tv_gz_str)
    TextView tv_gz_str;

    @BindView(R.id.et_input_bar)
    EditText et_input_bar;


    //数量
    @BindView(R.id.tv_have_number)
    TextView tv_have_number;
    //价格
    @BindView(R.id.tv_price)
    TextView tv_price;

    //上架仓位
    @BindView(R.id.tv_put_goods)
    TextView tv_put_goods;


    @Inject
    BarCodeActionsCreator barCodeActionsCreator;
    @Inject
    BarcodeStore barcodeStore;


    public ArrayList<BarCodeModel> barCodeModels;
    private BarCodeModel barCodeModel;

    private int position = 0;

    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        init();
    }

    public void init() {
        tv_title.setText(R.string.barcode_input);
        showSoftInputFromWindow(et_number);
        et_number.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
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

        // initEditText();

    }


    @OnClick({R.id.tv_back_page, R.id.tv_next_page, R.id.tv_select, R.id.tv_put_goods, R.id.im_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back_page:
                //上页
                if (null != barCodeModels) {
                    if (0 == position) {
                        ToastUtils.showBaseToast(getString(R.string.current_page_is_start), this);
                    } else {
                        position--;
                        pageShow(position);
                    }
                }
                break;
            case R.id.tv_next_page:
                //下页
                if (null != barCodeModels) {
                    if (position == barCodeModels.size() - 1) {
                        ToastUtils.showBaseToast(getString(R.string.current_page_is_end), this);
                    } else {
                        position++;
                        pageShow(position);
                    }
                }
                break;
            case R.id.tv_select:

                setSearch();
                break;
            case R.id.tv_put_goods:
                //  getDisplay().showWaittingDialog();
                //  barCodeActionsCreator.GetRfLotWmsBarCodeInptList("B2018012000061");
                submitData();
                break;
            case R.id.im_back:
                finish();
                break;

        }
    }


    /**
     * 提交
     */
    public void submitData() {
        if (null != id) {
            String input_bar = et_input_bar.getText().toString();
            if (null != input_bar && input_bar.length() > 0) {
                getDisplay().showWaittingDialog();
                barCodeActionsCreator.SubmitPurPosData(id, input_bar);
            } else {
                ToastUtils.showBaseToast(getString(R.string.input_null), this);
            }
        } else {
            ToastUtils.showBaseToast(getString(R.string.please_first_select), this);
        }

    }

    /**
     * 查询
     */
    public void setSearch() {

        String barCode = et_number.getText().toString();

        if (null != barCode && barCode.length() > 0) {
            getDisplay().showWaittingDialog();
            //  barCodeActionsCreator.GetRfLotWmsBarCodeInptList("B2018012000061");
            barCodeActionsCreator.GetRfLotWmsBarCodeInptList(barCode);
        } else {
            ToastUtils.showBaseToast(getString(R.string.please_input_you_barNumber), this);
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.barcode_input);
    }

    @Override
    protected void initReturnEvent() {

        /**
         * 请求列表
         */
        barcodeStore.toMainSubscription(BarcodeStore.BarCodeListChange.class, new Action1<BarcodeStore.BarCodeListChange>() {
            @Override
            public void call(BarcodeStore.BarCodeListChange codeListChange) {
                getDisplay().hideWaittingDialog();
                barCodeModels = barcodeStore.getBarCodeInptListtModelArrayList();
                if (null != barCodeModels && barCodeModels.size() > 0) {
                    //初始化页面
                    position = 0;
                    pageShow(0);
                    showSoftInputFromWindow(et_input_bar);
                }

            }
        });

        /**
         * 提交
         */
        barcodeStore.toMainSubscription(BarcodeStore.BarCodeSubmitChange.class, new Action1<BarcodeStore.BarCodeSubmitChange>() {
            @Override
            public void call(BarcodeStore.BarCodeSubmitChange codeListChange) {
                getDisplay().hideWaittingDialog();
                reSetPage();
                showSoftInputFromWindow(et_number);
                ToastUtils.showBaseToast(codeListChange.msge, BarCodeInputActivity.this);
            }
        });


        //请求错误
        barcodeStore.toMainSubscription(BarcodeStore.ChangeError.class, new Action1<BarcodeStore.ChangeError>() {
            @Override
            public void call(BarcodeStore.ChangeError changeError) {
                getDisplay().hideWaittingDialog();
                et_number.setText("");
                et_input_bar.setText("");
                ToastUtils.showBaseToast(changeError.msge, BarCodeInputActivity.this);

            }
        });


    }


    /**
     * EditText获取焦点并显示软键盘
     */
    public void showSoftInputFromWindow(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * 页面展示
     */
    public void pageShow(int position) {
        barCodeModel = barCodeModels.get(position);
        id = barCodeModel.ID;
        // 供应商
        tv_supplier.setText(barCodeModel.CSTNAME);
        //部门
        tv_department.setText(barCodeModel.DEPTNAME);

        //品名
        tv_product_name.setText(barCodeModel.GOODNAME);
        //规格
        tv_specifications.setText(barCodeModel.PACKSPEC);

        //仓位
        tv_storage_location.setText(barCodeModel.SHIPCODE);
        //厂家
        tv_vender.setText(barCodeModel.PRONAME);

        //批号
        tv_batch_number.setText(barCodeModel.LOTNO);
        //效期
        tv_validity_time.setText(barCodeModel.ENDDATE);

        //国准
        tv_gz_str.setText(barCodeModel.CMSW);


        int BARQTY = (int) Double.parseDouble(barCodeModel.BARQTY);
        //数量
        tv_have_number.setText(BARQTY+"");
        //价格
        tv_price.setText(barCodeModel.UNITNAME_INPRC);

        if (null != barCodeModel.NEWSHIPCODE) {
            et_input_bar.setText(barCodeModel.NEWSHIPCODE);
        }

        tv_page_show.setText(position + 1 + "/" + barCodeModels.size());

    }


    /**
     * 清空页面
     */
    public void reSetPage() {

        et_number.setText("");
        // 供应商
        tv_supplier.setText("");
        //部门
        tv_department.setText("");

        //品名
        tv_product_name.setText("");
        //规格
        tv_specifications.setText("");

        //仓位
        tv_storage_location.setText("");
        //厂家
        tv_vender.setText("");

        //批号
        tv_batch_number.setText("");
        //效期
        tv_validity_time.setText("");

        //国准
        tv_gz_str.setText("");
        //数量
        tv_have_number.setText("");
        //价格
        tv_price.setText("");

        et_input_bar.setText("");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_barcode_input;
    }

    @Override
    public Store[] getStoreArray() {
        return new Store[]{barcodeStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return barCodeActionsCreator;
    }


}
