package com.sd.storage.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.sd.storage.R;
import com.sd.storage.UrlManager;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.actions.TimeActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.dlib.store.Store;
import com.sd.storage.stores.TimeStore;
import com.sd.storage.ui.base.BaseSCActivity;
import com.sd.storage.util.ToastUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;


/**
 * Created by Administrator on 2018-09-05.
 */

public class MainActivity extends BaseSCActivity {

    @BindView(R.id.lin_weekMenu)
    LinearLayout lin_weekMenu;
    @BindView(R.id.lin_meunVote)
    LinearLayout lin_meunVote;
    @BindView(R.id.lin_meunOrder)
    LinearLayout lin_meunOrder;
    @BindView(R.id.lin_meunMannage)
    LinearLayout lin_meunMannage;




    @Inject
    TimeActionsCreator timeActionsCreator;
    @Inject
    TimeStore timeStore;

    private String userid, username, level;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);
        init();
    }


    public void init() {

        level="1";
        username="li";
        userid="lilili";
        UrlManager.setLEVEl(level);
        UrlManager.setUSENAME(username);
        UrlManager.setUSERID(userid);

    }

    @OnClick({R.id.lin_weekMenu, R.id.lin_meunVote, R.id.lin_meunOrder, R.id.lin_meunMannage, R.id.tv_order})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_weekMenu:
                //本周菜谱
                getDisplay().startWeekMenuActivity();
                break;
            case R.id.lin_meunVote:
                //菜谱投票
                timeActionsCreator.voteTime();
                break;
            case R.id.lin_meunOrder:
                //菜谱排行
                getDisplay().startMeunOrderActivity();
                break;
            case R.id.lin_meunMannage:
                //菜谱管理
                if("1".equals(UrlManager.getLEVEl())){
                    getDisplay().startSetMainActivity();
                }else{
                    ToastUtils.showBaseToast(R.string.you_not_have_level, MainActivity.this);
                }
                break;
            case R.id.tv_order:
               // getDisplay().startOrderActivity();
                break;

        }
    }



    @Override
    protected void initReturnEvent() {
        timeStore.toMainSubscription(TimeStore.VoteTimeChange.class, new Action1<TimeStore.VoteTimeChange>() {
            @Override
            public void call(TimeStore.VoteTimeChange voteTimeChange) {
                getDisplay().hideWaittingDialog();
                getDisplay().startVoteManageActivity();
            }
        });

        /**
         * 请求错误
         */
        timeStore.toMainSubscription(TimeStore.VoteTimeChangeError.class, new Action1<TimeStore.VoteTimeChangeError>() {
            @Override
            public void call(TimeStore.VoteTimeChangeError changeError) {
                getDisplay().hideWaittingDialog();
                ToastUtils.showBaseToast(changeError.msge, MainActivity.this);
            }
        });
    }

    @Override
    public Store[] getStoreArray() {
        return new Store[]{timeStore};
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return timeActionsCreator;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
