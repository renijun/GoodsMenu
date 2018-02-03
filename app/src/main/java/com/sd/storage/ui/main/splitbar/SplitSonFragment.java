package com.sd.storage.ui.main.splitbar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.BarCodeSplitSonActionsCreator;
import com.sd.storage.adapter.SplitBarAdapter;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.dialog.SelectDepartmentDialog;
import com.sd.storage.dialog.SplitBarDeltDialog;
import com.sd.storage.dialog.SplitBarReScanDialog;
import com.sd.storage.dialog.SplitBarSubmitDialog;
import com.sd.storage.model.BarCodeSplitSonModel;
import com.sd.storage.stores.BarcodeSplitSonStore;
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

public class SplitSonFragment extends BaseSCFragment implements SplitActivity.OnSendIdListener, SplitBarSubmitDialog.OnSureClickListener, SplitBarReScanDialog.OnRescanSureClickListener,
        SplitBarAdapter.OnClickItemDeltListener, SplitBarDeltDialog.OnDeltSureClickListener {


    @BindView(R.id.v_list)
    ListView v_list;

    @BindView(R.id.v_empty)
    TextView v_empty;

    @BindView(R.id.tv_submit)
    TextView tv_submit;
    @BindView(R.id.tv_re_scan)
    TextView tv_re_scan;




    public ArrayList<BarCodeSplitSonModel> barCodeSplitMianModels;
    private BarCodeSplitSonModel barCodeSplitSonModel;

    @Inject
    BarCodeSplitSonActionsCreator barCodeSplitSonActionsCreator;
    @Inject
    BarcodeSplitSonStore barcodeSplitSonStore;


    private SplitBarAdapter mAdapter;
    private SplitBarSubmitDialog splitBarSubmitDialog;
    private SplitBarReScanDialog splitBarReScanDialog;
    private SplitBarDeltDialog splitBarDeltDialog;


    private String lwbid = "";
    private SplitActivity splitActivity;
    private Context context;

    private View view;
    private Boolean iac;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        splitActivity.setOnDataListener(this);
        context = getContext();
    }

    @Override
    public void onResume() {
        super.onResume();
        getListData();
        addEvent();
    }


    /**
     * 请求列表
     */
    public void getListData() {
        if (!"".equals(lwbid)) {
            // getDisplay().showWaittingDialog();
            barCodeSplitSonActionsCreator.GetLotWmsBarCodeSubSplList(lwbid);
        }

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
                splitActivity.setTitle(getString(R.string.spilt_bar_select));
            }
        } else {
            // 相当于Fragment的onPause
            Log.i("TestData", "Fragmen2t ---setUserVisibleHint---isVisibleToUser - FALSE");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.activity_spliltbar_son, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @OnClick({R.id.tv_submit, R.id.tv_re_scan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                if ("".equals(lwbid)) {
                    ToastUtils.showBaseToast(getString(R.string.please_back_pag), context);
                } else {
                    //提交  弹出框添加
                    splitBarSubmitDialog.show(getActivity().getFragmentManager(), "");
                }
                break;
            case R.id.tv_re_scan:
                if ("".equals(lwbid)) {
                    ToastUtils.showBaseToast(getString(R.string.please_back_pag), context);
                } else {
                    //重扫
                    splitBarReScanDialog.show(getActivity().getFragmentManager(), "");
                }
                break;
        }
    }


    public void init() {
        mAdapter = new SplitBarAdapter(context);
        mAdapter.setOnDeltClickListener(this);
        v_list.setAdapter(mAdapter);
        splitBarSubmitDialog = new SplitBarSubmitDialog();
        splitBarSubmitDialog.setOnSureClickListener(this);
        splitBarReScanDialog = new SplitBarReScanDialog();
        splitBarReScanDialog.setOnReScanSureClickListener(this);
        splitBarDeltDialog = new SplitBarDeltDialog();
        splitBarDeltDialog.setOnDeltSureClickListener(this);

    }

    public void addEvent() {
        //获取子页面数据
        barcodeSplitSonStore.toMainSubscription(BarcodeSplitSonStore.BarSplittChange.class, new Action1<BarcodeSplitSonStore.BarSplittChange>() {
            @Override
            public void call(BarcodeSplitSonStore.BarSplittChange barSplittChange) {
                getDisplay().hideWaittingDialog();
                barCodeSplitMianModels = barcodeSplitSonStore.getBarCodeSplitMianModels();
                mAdapter.setData(barCodeSplitMianModels);

            }
        });

        /**
         * 提交
         */
        barcodeSplitSonStore.toMainSubscription(BarcodeSplitSonStore.BarSplittSubmitChange.class, new Action1<BarcodeSplitSonStore.BarSplittSubmitChange>() {
            @Override
            public void call(BarcodeSplitSonStore.BarSplittSubmitChange barSplittSubmitChange) {
                getDisplay().hideWaittingDialog();
                //提交成功后的操作
                ToastUtils.showBaseToast(barSplittSubmitChange.msge, context);
                getListData();
                ;
            }
        });

        /**
         * 删除
         */
        barcodeSplitSonStore.toMainSubscription(BarcodeSplitSonStore.BarSplittDeltChange.class, new Action1<BarcodeSplitSonStore.BarSplittDeltChange>() {
            @Override
            public void call(BarcodeSplitSonStore.BarSplittDeltChange barSplittDeltChange) {
                getListData();
                //提交成功后的操作
                ToastUtils.showBaseToast(barSplittDeltChange.msge, context);
                ;
            }
        });

        /**
         * 重扫
         */
        barcodeSplitSonStore.toMainSubscription(BarcodeSplitSonStore.BarSplittReScanChange.class, new Action1<BarcodeSplitSonStore.BarSplittReScanChange>() {
            @Override
            public void call(BarcodeSplitSonStore.BarSplittReScanChange barSplittReScanChange) {
                getDisplay().hideWaittingDialog();
                //重扫成功后的操作
                ToastUtils.showBaseToast(barSplittReScanChange.msge, context);
                getListData();

            }
        });

        //请求错误
        barcodeSplitSonStore.toMainSubscription(BarcodeSplitSonStore.ChangeError.class, new Action1<BarcodeSplitSonStore.ChangeError>() {
            @Override
            public void call(BarcodeSplitSonStore.ChangeError changeError) {
                getDisplay().hideWaittingDialog();
                ToastUtils.showBaseToast(changeError.msge, context);

            }
        });


        /**
         * 列表请求错误
         */
        barcodeSplitSonStore.toMainSubscription(BarcodeSplitSonStore.BarSplitErrChange.class, new Action1<BarcodeSplitSonStore.BarSplitErrChange>() {
            @Override
            public void call(BarcodeSplitSonStore.BarSplitErrChange changeError) {


            }
        });
    }


    @Override
    public Store[] getStoreArray() {
        return new Store[]{barcodeSplitSonStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return barCodeSplitSonActionsCreator;
    }

    @Override
    public void onSendID(String ID) {
        this.lwbid = ID;
        v_empty.setVisibility(View.GONE);
        v_list.setVisibility(View.VISIBLE);
        getListData();
    }

    @Override
    public void onSubmitSure() {
        splitBarSubmitDialog.dismiss();
        getDisplay().showWaittingDialog();
        barCodeSplitSonActionsCreator.SubmitSubBarCodeSpl(lwbid);
    }

    @Override
    public void onRescanSure() {
        splitBarReScanDialog.dismiss();
        getDisplay().showWaittingDialog();
        barCodeSplitSonActionsCreator.ResetSubBarCodeSpl(lwbid);
    }

    @Override
    public void onItemDeltOnClick(BarCodeSplitSonModel item) {
        barCodeSplitSonModel = item;
        splitBarDeltDialog.show(getActivity().getFragmentManager(), "");

    }

    @Override
    public void onDeltSure() {
        splitBarDeltDialog.dismiss();
        getDisplay().showWaittingDialog();
        barCodeSplitSonActionsCreator.RemoveSubBarCodeSpl(barCodeSplitSonModel.ID);

    }


    /**
     * 隐藏键盘
     */
/*    public void hideKey() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        iac = imm.isActive();
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
        }
    }*/


}
