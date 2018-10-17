package com.sd.storage.ui.main.meunorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.MeunOderActionsCreator;
import com.sd.storage.adapter.MeunOrderAdapter;
import com.sd.storage.adapter.OrderAdapter;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.dialog.MeunOrderPopuwindow;
import com.sd.storage.dlib.store.Store;
import com.sd.storage.model.VageModel;
import com.sd.storage.stores.MeunOderStore;
import com.sd.storage.ui.base.BaseSCActivity;
import com.sd.storage.util.ToastUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Created by Administrator on 2018-09-11.
 */

public class MeunOrderActivity extends BaseSCActivity implements MeunOrderAdapter.OnItemOrderClickListener, MeunOrderPopuwindow.OnSelectClickListener {

    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerView2)
    RecyclerView recyclerView2;

    @BindView(R.id.im_order)
    ImageView im_order;

    @BindView(R.id.im_select)
    ImageView im_select;

    private MeunOrderAdapter adapter;

    private OrderAdapter orderAdapter;

    @Inject
    MeunOderActionsCreator meunOderActionsCreator;
    @Inject
    MeunOderStore meunOderStore;
    private ArrayList<VageModel> vageModels = new ArrayList<>();

    private String type = "3";

    private MeunOrderPopuwindow meunOrderPopuwindow;


    private int allSize = 0;
    private boolean isSize = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        init();
    }


    public void init() {
        tv_title.setText(R.string.order_meun);
        meunOrderPopuwindow = new MeunOrderPopuwindow(this);
        meunOrderPopuwindow.setOnSelectClickListener(this);
        adapter = new MeunOrderAdapter(this);
        adapter.setOnItemSearchClickListener(this);

        //  LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        orderAdapter = new OrderAdapter(this);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(orderAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (allSize == 0) {
            meunOderActionsCreator.voteSize();
        } else {
            getData();
        }

    }

    public void getData() {
        getDisplay().showWaittingDialog();
        meunOderActionsCreator.getVegegiveOrder(type);
    }

    @OnClick({R.id.im_back, R.id.im_order, R.id.im_select})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.im_order:
                meunOrderPopuwindow.showPopuwindow(im_order);
                break;
            case R.id.im_select:
                if (!isSize) {
                    im_select.setImageResource(R.drawable.vote_true);
                    isSize = true;
                    orderAdapter.setVegeModels(vageModels, allSize);

                    recyclerView2.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                } else {
                    im_select.setImageResource(R.drawable.vote_false);
                    isSize = false;
                    adapter.setVegeModels(vageModels, type);
                    recyclerView2.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
                break;

        }
    }


    @Override
    protected void initReturnEvent() {
        meunOderStore.toMainSubscription(MeunOderStore.MeunOrderListtChange.class, new Action1<MeunOderStore.MeunOrderListtChange>() {
            @Override
            public void call(MeunOderStore.MeunOrderListtChange meunOrderListtChange) {
                getDisplay().hideWaittingDialog();
                vageModels = meunOderStore.getVageModels();

                if (type.equals("3") && isSize) {
                    orderAdapter.setVegeModels(vageModels, allSize);
                } else {
                    adapter.setVegeModels(vageModels, type);
                }


            }
        });

        /**
         * 请求错误
         */
        meunOderStore.toMainSubscription(MeunOderStore.MeunOderListChangeError.class, new Action1<MeunOderStore.MeunOderListChangeError>() {
            @Override
            public void call(MeunOderStore.MeunOderListChangeError changeError) {
                getDisplay().hideWaittingDialog();
                ToastUtils.showBaseToast(changeError.msge, MeunOrderActivity.this);
            }
        });

        meunOderStore.toMainSubscription(MeunOderStore.SizeChange.class, new Action1<MeunOderStore.SizeChange>() {
            @Override
            public void call(MeunOderStore.SizeChange sizeChange) {
                getDisplay().hideWaittingDialog();
                allSize = (int) meunOderStore.getAllSize();
                getData();

            }
        });

        /**
         * 请求错误
         */
        meunOderStore.toMainSubscription(MeunOderStore.SizeChangeError.class, new Action1<MeunOderStore.SizeChangeError>() {
            @Override
            public void call(MeunOderStore.SizeChangeError changeError) {
                getDisplay().hideWaittingDialog();
                ToastUtils.showBaseToast(changeError.msge, MeunOrderActivity.this);
            }
        });


    }

    @Override
    public Store[] getStoreArray() {
        return new Store[]{meunOderStore};

    }

    @Override
    public ActionsCreator getActionsCreator() {
        return meunOderActionsCreator;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ordermeun;
    }


    @Override
    public void onItemClick(int point) {
        getDisplay().startVageDetailsActivity(vageModels.get(point).vegeid);
    }

    @Override
    public void onItemAddCommentClick(int point) {
        getDisplay().startAddCommentActivity(vageModels.get(point).vegeid);
    }

    @Override
    public void onSelectClickListener(String type) {
        this.type = type;
        if ("3".equals(type)) {
            im_select.setVisibility(View.VISIBLE);
            if (isSize) {
                recyclerView2.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }

        } else {
            im_select.setVisibility(View.GONE);
            recyclerView2.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        getData();
    }
}

