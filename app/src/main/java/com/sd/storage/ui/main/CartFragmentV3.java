package com.sd.storage.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.dframe.lib.store.Store;
import com.sd.storage.R;
import com.sd.storage.actions.ActionsCreator;
import com.sd.storage.app.StorageApplication;
import com.sd.storage.ui.base.BaseTabFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/1/17.
 */

public class CartFragmentV3 extends BaseTabFragment {

    @BindView(R.id.tv_weixin)
    TextView tv_weixin;

    @BindView(R.id.tv_qq)
    TextView tv_qq;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageApplication.getApplication().getAppComponent().inject(this);

    }

    @OnClick({R.id.tv_weixin, R.id.tv_qq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_weixin:

                shareWinXinText();
            case R.id.tv_qq:

                break;
        }

    }



    /**
     * 全部的分享  文字
     */
    public void shareAll() {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, "这是一段分享的文字");
        startActivity(Intent.createChooser(textIntent, "分享"));

    }

    /**
     * 微信的文字分享
     */
    public void shareWinXinText() {
        Intent wechatIntent = new Intent(Intent.ACTION_SEND);
        wechatIntent.setPackage("com.tencent.mm");
        wechatIntent.setPackage("com.tencent.mobileqq");
        wechatIntent.setType("text/plain");
        wechatIntent.putExtra(Intent.EXTRA_TEXT, "分享到微信的内容");
        startActivity(wechatIntent);
    }

    @Override
    public Store[] getStoreArray() {
        return new Store[0];
    }

    @Override
    public ActionsCreator getActionsCreator() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cart;
    }


}
