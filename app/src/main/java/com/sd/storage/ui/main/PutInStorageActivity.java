package com.sd.storage.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.PutInStoreActionsCreator;
import com.sd.storage.actions.SelectDeptActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.model.BarCodeInptListtModel;
import com.sd.storage.stores.PutInStorageStore;
import com.sd.storage.stores.SelectDeptStore;
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

public class PutInStorageActivity extends BaseSCActivity {

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

    @BindView(R.id.et_wait_check)
    EditText et_wait_check;


    //已验收
    @BindView(R.id.tv_have_check)
    TextView tv_have_check;
    //已全拒
    @BindView(R.id.tv_have_refuse)
    TextView tv_have_refuse;

    //验收
    @BindView(R.id.tv_check_str)
    TextView tv_check_str;
    //全拒
    @BindView(R.id.tv_all_refuse)
    TextView tv_all_refuse;
    //部拒
    @BindView(R.id.tv_some_refuse)
    TextView tv_some_refuse;
    //余共
    @BindView(R.id.tv_TOTQTY)
    TextView tv_TOTQTY;

    @BindView(R.id.unitname_inprc)
    TextView unitname_inprc;


    @BindView(R.id.v_scrollview)
    ScrollView v_scrollview;


    @Inject
    PutInStoreActionsCreator putInStoreActionsCreator;
    @Inject
    PutInStorageStore putInStorageStore;

    private ArrayList<BarCodeInptListtModel> barCodeInptListtModelArrayList;

    private BarCodeInptListtModel barCodeInptListtModel;

    private int position = 0;
    private String boxid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        init();
    }

    public void init() {
        tv_title.setText(R.string.put_in_storage);
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


        showSoftInputFromWindow(et_number);
       /* et_wait_check.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    setCheck();
                    return true;
                }
                return false;
            }
        });*/

        v_scrollview.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        v_scrollview.setFocusable(true);
        v_scrollview.setFocusableInTouchMode(true);
        v_scrollview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.requestFocusFromTouch();
                return false;
            }
        });

    }

    @OnClick({R.id.im_back, R.id.tv_back_page, R.id.tv_next_page, R.id.tv_select, R.id.tv_check_str, R.id.tv_all_refuse})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_back_page:
                if (null != barCodeInptListtModelArrayList) {
                    if (0 == position) {
                        ToastUtils.showBaseToast(getString(R.string.current_page_is_start), this);
                    } else {
                        position--;
                        showPage(position);
                        boxid = barCodeInptListtModelArrayList.get(position).ID;

                    }
                }
                break;
            case R.id.tv_next_page:

                if (null != barCodeInptListtModelArrayList) {
                    if (position == barCodeInptListtModelArrayList.size() - 1) {
                        ToastUtils.showBaseToast(getString(R.string.current_page_is_end), this);
                    } else {
                        position++;
                        showPage(position);
                        boxid = barCodeInptListtModelArrayList.get(position).ID;
                    }
                }
                break;
            case R.id.tv_select:
                //335
                setSearch();
                break;
            case R.id.tv_check_str:
                setCheck("1");
                break;
            case R.id.tv_all_refuse:
                //全部拒绝
                setCheck("2");
                break;


        }
    }


    public void setCheck(String type) {
        String checkNumber = et_wait_check.getText().toString();
        if (null != checkNumber && checkNumber.length() > 0) {
            //  putInStoreActionsCreator.BoxChexkRef("3463", checkNumber);
            if (null != boxid) {
                getDisplay().showWaittingDialog();
                putInStoreActionsCreator.BoxChexkRef(boxid, checkNumber, type);
            } else {
                et_wait_check.setText("");
                showSoftInputFromWindow(et_number);
                ToastUtils.showBaseToast(getString(R.string.please_first_select), this);
            }

        } else {
            ToastUtils.showBaseToast(getString(R.string.please_input_check_number), this);
        }

    }

    public void setSearch() {
        String barnumber = et_number.getText().toString();
        if (null != barnumber && barnumber.length() > 0) {
            getDisplay().showWaittingDialog();
            putInStoreActionsCreator.GetRfScmBoxList(barnumber);
        } else {
            ToastUtils.showBaseToast(getString(R.string.please_input_you_barNumber), this);
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.put_in_storage);
    }

    @Override
    protected void initReturnEvent() {

        //请求列表成功
        putInStorageStore.toMainSubscription(PutInStorageStore.BarListyChange.class, new Action1<PutInStorageStore.BarListyChange>() {
            @Override
            public void call(PutInStorageStore.BarListyChange barListyChange) {
                getDisplay().hideWaittingDialog();
                barCodeInptListtModelArrayList = putInStorageStore.getBarCodeInptListtModelArrayList();
                if (null != barCodeInptListtModelArrayList && barCodeInptListtModelArrayList.size() > 0) {
                    position = 0;
                    boxid = barCodeInptListtModelArrayList.get(0).ID;
                    showPage(position);
                    showSoftInputFromWindow(et_wait_check);
                }
            }
        });


        //请求验收
        putInStorageStore.toMainSubscription(PutInStorageStore.BoxCheckChange.class, new Action1<PutInStorageStore.BoxCheckChange>() {
            @Override
            public void call(PutInStorageStore.BoxCheckChange boxCheckChange) {
                getDisplay().hideWaittingDialog();
                //焦点变化  清空
                setPageReset();
                showSoftInputFromWindow(et_number);
                ToastUtils.showBaseToast(boxCheckChange.msge, PutInStorageActivity.this);


            }
        });


        //请求错误
        putInStorageStore.toMainSubscription(PutInStorageStore.ChangeError.class, new Action1<PutInStorageStore.ChangeError>() {
            @Override
            public void call(PutInStorageStore.ChangeError changeError) {
                getDisplay().hideWaittingDialog();
                et_number.setText("");
                et_wait_check.setText("");
                ToastUtils.showBaseToast(changeError.msge, PutInStorageActivity.this);

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
        // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    /**
     * 页面重置
     */
    public void setPageReset() {
        et_number.setText("");

        et_wait_check.setText("");

        tv_page_show.setText("");
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
        //已验收
        tv_have_check.setText("");
        //已拒收
        tv_have_refuse.setText("");

        tv_TOTQTY.setText("");
        unitname_inprc.setText("");
    }

    /**
     * 翻页
     *
     * @param i
     */
    public void showPage(int i) {
        barCodeInptListtModel = barCodeInptListtModelArrayList.get(i);
        // 供应商
        tv_supplier.setText(barCodeInptListtModel.CSTNAME);
        //部门
        tv_department.setText(barCodeInptListtModel.DEPTNAME);

        //品名
        tv_product_name.setText(barCodeInptListtModel.GOODNAME);
        //规格
        tv_specifications.setText(barCodeInptListtModel.PACKSPEC);

        //仓位
        tv_storage_location.setText(barCodeInptListtModel.SHIPCODE);
        //厂家
        tv_vender.setText(barCodeInptListtModel.PRONAME);

        //批号
        tv_batch_number.setText(barCodeInptListtModel.LOTNO);
        //效期
        tv_validity_time.setText(barCodeInptListtModel.ENDDATE);

        //国准
        tv_gz_str.setText(barCodeInptListtModel.CMSW);


        int have = (int) Double.parseDouble(barCodeInptListtModel.CHECKQTY);
        //已验收
        tv_have_check.setText(have + "");
        int refuse = (int) Double.parseDouble(barCodeInptListtModel.REFQTY);
        //已拒收
        tv_have_refuse.setText(refuse + "");

        tv_TOTQTY.setText("余/共:" + barCodeInptListtModel.TOTQTY);
        tv_page_show.setText(position + 1 + "/" + barCodeInptListtModelArrayList.size());

        unitname_inprc.setText(barCodeInptListtModel.UNITNAME_INPRC);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_put_in_storage;
    }

    @Override
    public Store[] getStoreArray() {
        return new Store[]{putInStorageStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return putInStoreActionsCreator;
    }


}
