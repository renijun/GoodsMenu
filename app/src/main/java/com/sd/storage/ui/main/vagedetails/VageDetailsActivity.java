package com.sd.storage.ui.main.vagedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;;
import com.sd.storage.R;
import com.sd.storage.UrlManager;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.VageDetailsActionsCreator;
import com.sd.storage.adapter.CommentAdapter;

import com.sd.storage.app.StorageApplication;
import com.sd.storage.dlib.store.Store;
import com.sd.storage.model.CommentModel;
import com.sd.storage.model.VageModel;
import com.sd.storage.model.VegeTitle;
import com.sd.storage.stores.VageDetailsStore;
import com.sd.storage.ui.base.BaseSCActivity;
import com.sd.storage.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.http.Url;
import rx.functions.Action1;

/**
 * Created by Administrator on 2018-09-07.
 */

public class VageDetailsActivity extends BaseSCActivity {

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.im_image)
    ImageView im_image;

    @BindView(R.id.im_giveup)
    ImageView im_giveup;
    @BindView(R.id.im_comment)
    ImageView im_comment;

    @BindView(R.id.vegename)
    TextView vegename;
    @BindView(R.id.tv_give)
    TextView tv_give;
    @BindView(R.id.tv_comment)
    TextView tv_comment;


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Inject
    VageDetailsActionsCreator vageDetailsActionsCreator;
    @Inject
    VageDetailsStore vageDetailsStore;

    private CommentAdapter adapter;
    private String vegeid;
    private VegeTitle vegeTitle;
    //记录点赞的总数
    private int vegegive;
    private boolean isGive = false;

    private List<CommentModel> commentModels=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        init();
    }


    private void init() {
        tv_title.setText(R.string.str_meun_details);
        adapter = new CommentAdapter(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        vegeid = getIntent().getStringExtra("vegeid");
        vageDetailsActionsCreator.getVeveDetails(vegeid, UrlManager.getUSERID());
        vageDetailsActionsCreator.getCommentList(vegeid);
    }

    @Override
    protected void initReturnEvent() {

        vageDetailsStore.toMainSubscription(VageDetailsStore.VegetChange.class, new Action1<VageDetailsStore.VegetChange>() {
            @Override
            public void call(VageDetailsStore.VegetChange vegetChange) {
                getDisplay().hideWaittingDialog();
                vegeTitle = vageDetailsStore.getVegeTitle();
                if(null!=vegeTitle){
                    showPage();
                }

            }
        });

        /**
         * 请求错误
         */
        vageDetailsStore.toMainSubscription(VageDetailsStore.VegeChangeError.class, new Action1<VageDetailsStore.VegeChangeError>() {
            @Override
            public void call(VageDetailsStore.VegeChangeError changeError) {
                getDisplay().hideWaittingDialog();
                ToastUtils.showBaseToast(changeError.msge, VageDetailsActivity.this);
            }
        });


        vageDetailsStore.toMainSubscription(VageDetailsStore.CommentListChange.class, new Action1<VageDetailsStore.CommentListChange>() {
            @Override
            public void call(VageDetailsStore.CommentListChange commentListChange) {
                getDisplay().hideWaittingDialog();
                commentModels = vageDetailsStore.getCommentModels();
                adapter.setCommentModels(commentModels);
            }
        });

        /**
         * 请求错误
         */
        vageDetailsStore.toMainSubscription(VageDetailsStore.CommentListChangeError.class, new Action1<VageDetailsStore.CommentListChangeError>() {
            @Override
            public void call(VageDetailsStore.CommentListChangeError changeError) {
                getDisplay().hideWaittingDialog();
                //ToastUtils.showBaseToast(changeError.msge, VageDetailsActivity.this);
            }
        });


        vageDetailsStore.toMainSubscription(VageDetailsStore.GiveChange.class, new Action1<VageDetailsStore.GiveChange>() {
            @Override
            public void call(VageDetailsStore.GiveChange giveChange) {
                getDisplay().hideWaittingDialog();
                setGiveShow();
            }
        });

        /**
         * 点赞错误
         */
        vageDetailsStore.toMainSubscription(VageDetailsStore.GiveChangeError.class, new Action1<VageDetailsStore.GiveChangeError>() {
            @Override
            public void call(VageDetailsStore.GiveChangeError changeError) {
                getDisplay().hideWaittingDialog();
                ToastUtils.showBaseToast(changeError.msge, VageDetailsActivity.this);
            }
        });

    }


    @OnClick({R.id.im_back, R.id.im_giveup, R.id.im_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.im_comment:
                getDisplay().startAddCommentActivity(vegeid);
                break;
            case R.id.im_giveup:
                vageDetailsActionsCreator.setGive(vegeid, UrlManager.getUSERID());
                break;
        }
    }

    public void setGiveShow() {
        if (!isGive) {
            isGive = true;
            im_giveup.setBackgroundResource(R.drawable.give_up_true);
            vegegive+=1;
            tv_give.setText(vegegive+"");
        } else {
            isGive = false;
            im_giveup.setBackgroundResource(R.drawable.give_up_false);
            vegegive-=1;
            tv_give.setText(vegegive+"");
        }

    }

    public void showPage() {
        String url = vegeTitle.vegeimg;
        if (null != url) {
            Glide.with(this).load(UrlManager.getUrlPath() + url).error(R.drawable.err_image).into(im_image);
        }

        vegegive = Integer.parseInt(vegeTitle.vegegive);
        vegename.setText(vegeTitle.vegename);
        tv_give.setText(vegeTitle.vegegive);
        tv_comment.setText(vegeTitle.vegecomment);
        if (vegeTitle.vegestate == 0) {
            isGive = false;
            im_giveup.setBackgroundResource(R.drawable.give_up_false);
        } else {
            isGive = true;
            im_giveup.setBackgroundResource(R.drawable.give_up_true);
        }

    }

    @Override
    public Store[] getStoreArray() {
        return new Store[]{vageDetailsStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return vageDetailsActionsCreator;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vagedetalis;
    }
}
