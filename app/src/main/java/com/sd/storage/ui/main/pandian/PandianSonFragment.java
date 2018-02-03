package com.sd.storage.ui.main.pandian;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.PanDianActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.model.PandianDataListModel;
import com.sd.storage.stores.PanDianStore;
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

public class PandianSonFragment extends BaseSCFragment {
    @BindView(R.id.tv_page_show)
    TextView tv_page_show;

    @BindView(R.id.tv_back_page)
    TextView tv_back_page;
    @BindView(R.id.tv_next_page)
    TextView tv_next_page;
    //码
    @BindView(R.id.tv_barcode)
    TextView tv_barcode;
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
    @BindView(R.id.tv_buda)
    TextView tv_buda;


    @Inject
    PanDianActionsCreator panDianActionsCreator;
    @Inject
    PanDianStore panDianStore;


    private ArrayList<PandianDataListModel> pandianDataListModelArrayList;

    private PandianDataListModel pandianDataListModel;

    private int position = 0;

    private Context context;

    //0  不可以补   1 可以补
    private int isBut = 0;
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
        View view = inflater.inflate(R.layout.activity_pan_dian_son, container, false);
        return view;
    }

    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

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
                pandianMainActivity.setTitle(getString(R.string.pandian_situation_str));
            }
        } else {
            // 相当于Fragment的onPause
            Log.i("TestData", "Fragmen2t ---setUserVisibleHint---isVisibleToUser - FALSE");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        addEvent();
        panDianDataList();
    }


    public void init() {

    }


    public void addEvent() {

        /**
         * 请求列表
         */
        panDianStore.toMainSubscription(PanDianStore.PanDianDataListChange.class, new Action1<PanDianStore.PanDianDataListChange>() {
            @Override
            public void call(PanDianStore.PanDianDataListChange changeError) {
                getDisplay().hideWaittingDialog();

                pandianDataListModelArrayList = panDianStore.getPandianDataListModelArrayList();
                if (null != pandianDataListModelArrayList && pandianDataListModelArrayList.size() > 0) {
                    position = 0;
                    pageShow(position);
                } else {
                    ToastUtils.showBaseToast(" 数据为空", context);
                }
            }
        });
        /**
         *补打
         */
        panDianStore.toMainSubscription(PanDianStore.PanDianDataChange.class, new Action1<PanDianStore.PanDianDataChange>() {
            @Override
            public void call(PanDianStore.PanDianDataChange panDianDataChange) {
                getDisplay().hideWaittingDialog();
                tv_pandian_situation.setText(panDianStore.getDataString());


            }
        });


        //请求错误
        panDianStore.toMainSubscription(PanDianStore.PanDianDataListErrChange.class, new Action1<PanDianStore.PanDianDataListErrChange>() {
            @Override
            public void call(PanDianStore.PanDianDataListErrChange changeError) {
                getDisplay().hideWaittingDialog();


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

    @OnClick({R.id.tv_back_page, R.id.tv_next_page, R.id.tv_buda})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back_page:
                //上页
                if(null!=pandianDataListModelArrayList){
                    if (0 == position) {
                        ToastUtils.showBaseToast(context.getString(R.string.current_page_is_start), context);
                    } else {
                        position--;
                        pageShow(position);
                    }
                }
                break;
            case R.id.tv_next_page:
                //下页
                if(null!=pandianDataListModelArrayList){
                    if (position == pandianDataListModelArrayList.size() - 1) {
                        ToastUtils.showBaseToast(context.getString(R.string.current_page_is_end), context);
                    } else {
                        position++;
                        pageShow(position);
                    }
                }

                break;
            case R.id.tv_buda:
                if (isBut == 1) {
                    budaGet();
                } else {
                    ToastUtils.showBaseToast(context.getString(R.string.buda_is_fal), context);
                }
                break;
        }
    }


    /**
     * 页面显示
     */
    public void pageShow(int position) {

        pandianDataListModel = pandianDataListModelArrayList.get(position);
        isBut = (int) Double.parseDouble(pandianDataListModel.ISBTN);

        id = pandianDataListModel.ID;


        tv_page_show.setText(position + 1 + "/" + pandianDataListModelArrayList.size());
        tv_barcode.setText(pandianDataListModel.BARCODE);
        // 供应商
        tv_supplier.setText(pandianDataListModel.CSTNAME);
        //部门
        tv_department.setText(pandianDataListModel.DEPTNAME);

        //品名
        tv_product_name.setText(pandianDataListModel.GOODNAME);
        //规格
        tv_specifications.setText(pandianDataListModel.PACKSPEC);

        //仓位
        tv_storage_location.setText(pandianDataListModel.SHIPCODE);
        //厂家
        tv_vender.setText(pandianDataListModel.PRONAME);
        //批号
        tv_batch_number.setText(pandianDataListModel.LOTNO);
        //效期
        tv_validity_time.setText(pandianDataListModel.ENDDATE);
        //账面数量
        if (null != pandianDataListModel.ACCQTY) {
            int ACCQTY = (int) Double.parseDouble(pandianDataListModel.ACCQTY);
            tv_have_all.setText(ACCQTY + "");
        }
        //单位
        tv_unit.setText(pandianDataListModel.UNITNAME);
        //盘点情况
        tv_pandian_situation.setText(pandianDataListModel.STATUSNAME);
    }


    /**
     * 盘点情况的列表
     */
    public void panDianDataList() {
        getDisplay().showWaittingDialog();
        panDianActionsCreator.GetRfLotWmsChkList();

    }


    /**
     * 补打
     */
    public void budaGet() {
        getDisplay().showWaittingDialog();

        panDianActionsCreator.SubmitWmsChkData(id, "2");

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
