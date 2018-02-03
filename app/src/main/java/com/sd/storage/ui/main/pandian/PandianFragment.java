package com.sd.storage.ui.main.pandian;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.BarCodeSplitActionsCreator;
import com.sd.storage.actions.PanDianActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.model.PanDianListModel;
import com.sd.storage.stores.BarcodeSplitStore;
import com.sd.storage.stores.PanDianStore;
import com.sd.storage.ui.base.BaseSCFragment;
import com.sd.storage.ui.main.splitbar.SplitActivity;
import com.sd.storage.util.ToastUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Created by Administrator on 2018/1/24.
 */

public class PandianFragment extends BaseSCFragment {

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

    //账面数量
    @BindView(R.id.tv_have_all)
    TextView tv_have_all;
    //单位
    @BindView(R.id.tv_unit)
    TextView tv_unit;

    //盘点情况
    @BindView(R.id.tv_pandian_situation)
    TextView tv_pandian_situation;

    //确定
    @BindView(R.id.tv_sure)
    TextView tv_sure;

    @Inject
    PanDianActionsCreator panDianActionsCreator;
    @Inject
    PanDianStore panDianStore;

    public ArrayList<PanDianListModel> panDianListModels;
    private Context context;
    private PanDianListModel panDianListModel;
    private String id;
    private PandianMainActivity pandianMainActivity;

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
        View view = inflater.inflate(R.layout.activity_pan_dian, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

    }

    @Override
    public void onResume() {
        super.onResume();
        addEvent();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        pandianMainActivity = (PandianMainActivity) activity;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            // 相当于Fragment的onResume
            if (null != pandianMainActivity) {
                pandianMainActivity.setTitle(getString(R.string.pandian_str));
            }
        } else {
            // 相当于Fragment的onPause
            Log.i("TestData", "Fragmen2t ---setUserVisibleHint---isVisibleToUser - FALSE");
        }
    }

    @OnClick({R.id.tv_select, R.id.tv_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select:
                searchCode();
                break;
            case R.id.tv_sure:
                panDianSure();
                break;
        }
    }


    /**
     * 确定
     */
    public void panDianSure() {
        if (null != id) {
            panDianActionsCreator.SubmitWmsChkData(id, "1");
        } else {
            ToastUtils.showBaseToast(context.getString(R.string.please_search_bar), context);
        }

    }

    /**
     * 盘点请求
     */
    public void searchCode() {
        String barCode = et_number.getText().toString();
        if (null != barCode && barCode.length() > 0) {
            getDisplay().showWaittingDialog();
            //335
            panDianActionsCreator.GetRfLotWmsBarCodeChkList(barCode);
        } else {
            ToastUtils.showBaseToast(context.getString(R.string.please_input_pandian), context);
        }
    }

    public void addEvent() {

        /**
         * 盘点主页面
         */
        panDianStore.toMainSubscription(PanDianStore.PanDianChange.class, new Action1<PanDianStore.PanDianChange>() {
            @Override
            public void call(PanDianStore.PanDianChange panDianChange) {
                getDisplay().hideWaittingDialog();
                //拆分成功  下一步的操作
                panDianListModels = panDianStore.getPanDianListModels();
                if (null != panDianListModels && panDianListModels.size() > 0) {
                    panDianListModel = panDianListModels.get(0);
                    id = panDianListModel.ID;
                    pageShow();
                }

            }
        });


        //请求错误
        panDianStore.toMainSubscription(PanDianStore.ChangeListError.class, new Action1<PanDianStore.ChangeListError>() {
            @Override
            public void call(PanDianStore.ChangeListError changeError) {
                getDisplay().hideWaittingDialog();
                et_number.setText("");
                ToastUtils.showBaseToast(changeError.msge, context);

            }
        });

        /**
         *确定
         */
        panDianStore.toMainSubscription(PanDianStore.PanDianDataChange.class, new Action1<PanDianStore.PanDianDataChange>() {
            @Override
            public void call(PanDianStore.PanDianDataChange panDianDataChange) {
                getDisplay().hideWaittingDialog();
                tv_pandian_situation.setText(panDianStore.getDataString());
                reSetPage();
                ToastUtils.showBaseToast(panDianDataChange.msge, context);
            }
        });

        //请求错误
        panDianStore.toMainSubscription(PanDianStore.ChangeError.class, new Action1<PanDianStore.ChangeError>() {
            @Override
            public void call(PanDianStore.ChangeError changeError) {
                getDisplay().hideWaittingDialog();
                ToastUtils.showBaseToast(changeError.msge, context);

            }
        });


    }

    public void init() {
        et_number.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND || (null != event && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                    if (null != event) {
                        switch (event.getAction()) {
                            case KeyEvent.ACTION_UP:
                                searchCode();
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


    /**
     * 页面的展示
     */
    public void pageShow() {

        // 供应商
        tv_supplier.setText(panDianListModel.CSTNAME);
        //部门
        tv_department.setText(panDianListModel.DEPTNAME);

        //品名
        tv_product_name.setText(panDianListModel.GOODNAME);
        //规格
        tv_specifications.setText(panDianListModel.PACKSPEC);

        //仓位
        tv_storage_location.setText(panDianListModel.SHIPCODE);
        //厂家
        tv_vender.setText(panDianListModel.PRONAME);
        //批号
        tv_batch_number.setText(panDianListModel.LOTNO);
        //效期
        tv_validity_time.setText(panDianListModel.ENDDATE);
        //账面数量
        if (null != panDianListModel.ACCQTY) {
            int ACCQTY = (int) Double.parseDouble(panDianListModel.ACCQTY);
            tv_have_all.setText(ACCQTY + "");
        }
        //单位
        tv_unit.setText(panDianListModel.UNITNAME);
        //盘点情况
        tv_pandian_situation.setText(panDianListModel.STATUSNAME);
    }


    /**
     * 刷新页面
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
        //账面数量
        tv_have_all.setText("");
        //单位
        tv_unit.setText("");

    }

    @Override
    public Store[] getStoreArray() {
        return new Store[]{panDianStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return panDianActionsCreator;
    }
}
