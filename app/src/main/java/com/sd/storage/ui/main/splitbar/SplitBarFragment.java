package com.sd.storage.ui.main.splitbar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.dframe.lib.widgets.refreshloadmore.PullLoadMoreRecyclerView;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.BarCodeSplitActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.model.BarCodeSplitMianModel;
import com.sd.storage.stores.BarcodeSplitStore;
import com.sd.storage.ui.base.BaseSCFragment;
import com.sd.storage.util.ToastUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Created by Administrator on 2018/1/24.
 */

public class SplitBarFragment extends BaseSCFragment {

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


    //余共
    @BindView(R.id.tv_have_all)
    TextView tv_have_all;
    //单位
    @BindView(R.id.tv_unit)
    TextView tv_unit;
    //拆分数量
    @BindView(R.id.et_spilt_number)
    EditText et_spilt_number;
    //拆分条码
    @BindView(R.id.et_split_bar)
    EditText et_split_bar;

    @BindView(R.id.tv_text)
    TextView tv_text;


    @Inject
    BarCodeSplitActionsCreator barCodeSplitActionsCreator;
    @Inject
    BarcodeSplitStore barcodeSplitStore;

    public ArrayList<BarCodeSplitMianModel> barCodeSplitMianModels;
    private BarCodeSplitMianModel barCodeSplitMianModel;

    private int positio = 0;
    private String lwbid;

    private Context context;
    private View view;
    private boolean iac;
    private SplitActivity splitActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.activity_spilt_bar, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        // showSoftInputFromWindow(et_number);
    }

    @Override
    public void onResume() {
        super.onResume();
        addEvent();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        splitActivity = (SplitActivity) activity;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            // 相当于Fragment的onResume
            if (null != splitActivity) {
                splitActivity.setTitle(getString(R.string.spilt_bar));
            }
        } else {
            // 相当于Fragment的onPause
            Log.i("TestData", "Fragmen2t ---setUserVisibleHint---isVisibleToUser - FALSE");
        }
    }


    @OnClick({R.id.tv_select, R.id.tv_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select:
                setSearch();
                break;
        }
    }


    public void init() {

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


        et_split_bar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND || (null != event && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                    if (null != event) {
                        switch (event.getAction()) {
                            case KeyEvent.ACTION_UP:
                                //拆分
                                setSplitBar();
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


    public void addEvent() {
        /**
         * 请求列表
         */
        barcodeSplitStore.toMainSubscription(BarcodeSplitStore.BarSplittChange.class, new Action1<BarcodeSplitStore.BarSplittChange>() {
            @Override
            public void call(BarcodeSplitStore.BarSplittChange barSplittChange) {
                getDisplay().hideWaittingDialog();
                barCodeSplitMianModels = barcodeSplitStore.getBarCodeSplitMianModels();
                if (null != barCodeSplitMianModels) {
                    positio = 0;
                    lwbid = barCodeSplitMianModels.get(0).ID;
                    if (null != onGetIdListener) {
                        onGetIdListener.onGetID(lwbid);
                    }
                    if (null != barCodeSplitMianModels && barCodeSplitMianModels.size() > 0) {
                        showSoftInputFromWindow(et_split_bar);
                        pageShow(positio);
                    }
                }
            }
        });

        /**
         *条码拆分提交
         */
        barcodeSplitStore.toMainSubscription(BarcodeSplitStore.BarSplitSubmitChange.class, new Action1<BarcodeSplitStore.BarSplitSubmitChange>() {
            @Override
            public void call(BarcodeSplitStore.BarSplitSubmitChange barSplitSubmitChange) {
                getDisplay().hideWaittingDialog();
                //拆分成功  下一步的操作
                et_split_bar.setText("");
                if (null != onGetIdListener) {
                    onGetIdListener.onGetID(lwbid);
                }
            }
        });

        //请求错误
        barcodeSplitStore.toMainSubscription(BarcodeSplitStore.ChangeError.class, new Action1<BarcodeSplitStore.ChangeError>() {
            @Override
            public void call(BarcodeSplitStore.ChangeError changeError) {
                getDisplay().hideWaittingDialog();
                et_number.setText("");
                et_spilt_number.setText("");
                ToastUtils.showBaseToast(changeError.msge, context);

            }
        });
    }

    /**
     * 拆分条码
     */
    public void setSplitBar() {
        String splitBar = et_split_bar.getText().toString();
        if (null != splitBar && splitBar.length() > 0) {
            if (null != lwbid) {
                getDisplay().showWaittingDialog();
                barCodeSplitActionsCreator.SubmitLotWmsBarCodeData(lwbid, splitBar);
            } else {
                showSoftInputFromWindow(et_number);
                et_split_bar.setText("");
                ToastUtils.showBaseToast(context.getString(R.string.please_first_select), context);
            }

        } else {
            ToastUtils.showBaseToast(context.getString(R.string.please_input_split_bar), context);
        }
    }

    /**
     * 查询
     */
    public void setSearch() {

        String barCode = et_number.getText().toString();
        if (null != barCode && barCode.length() > 0) {
            //B20171201000032
            getDisplay().showWaittingDialog();
            barCodeSplitActionsCreator.GetLotWmsBarCodeSplList(barCode);
            //   barCodeSplitActionsCreator.GetLotWmsBarCodeSplList(barCode);
        } else {
            ToastUtils.showBaseToast(context.getString(R.string.please_input_you_barNumber), context);
        }
    }


    /**
     * EditText获取焦点并显示软键盘
     */
    public void showSoftInputFromWindow(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        // getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    public void pageShow(int position) {
        barCodeSplitMianModel = barCodeSplitMianModels.get(position);
        // 供应商
        tv_supplier.setText(barCodeSplitMianModel.CSTNAME);
        //部门
        tv_department.setText(barCodeSplitMianModel.DEPTNAME);

        //品名
        tv_product_name.setText(barCodeSplitMianModel.GOODNAME);
        //规格
        tv_specifications.setText(barCodeSplitMianModel.PACKSPEC);

        //仓位
        tv_storage_location.setText(barCodeSplitMianModel.SHIPCODE);
        //厂家
        tv_vender.setText(barCodeSplitMianModel.PRONAME);

        //批号
        tv_batch_number.setText(barCodeSplitMianModel.LOTNO);
        //效期
        tv_validity_time.setText(barCodeSplitMianModel.ENDDATE);


        if (null != barCodeSplitMianModel.QTY) {
            int have = (int) Double.parseDouble(barCodeSplitMianModel.QTY);
            //余共
            tv_have_all.setText(have + "");
        }
        //单位
        tv_unit.setText(barCodeSplitMianModel.UNITNAME);


        if (null != barCodeSplitMianModel.SPLQTY) {
            int splqty = (int) Double.parseDouble(barCodeSplitMianModel.SPLQTY);
            et_spilt_number.setText(splqty + "");
        }
        //0 不可编辑   1 可编辑
        int ISSPLQTY = (int) Double.parseDouble(barCodeSplitMianModel.ISSPLQTY);
        if (ISSPLQTY==1) {
            et_spilt_number.setEnabled(true);
            et_spilt_number.setBackgroundResource(R.color.cffffff);
        } else {
            et_spilt_number.setEnabled(false);
            et_spilt_number.setBackgroundResource(R.color.cefefef);
        }

    }


    @Override
    public Store[] getStoreArray() {
        return new Store[]{barcodeSplitStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return barCodeSplitActionsCreator;
    }


    private OnGetIdListener onGetIdListener;

    public interface OnGetIdListener {
        void onGetID(String ID);
    }

    public void setOnDataListener(OnGetIdListener onGetIdListener) {
        this.onGetIdListener = onGetIdListener;
    }


}
