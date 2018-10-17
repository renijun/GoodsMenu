package com.sd.storage.dialog;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sd.storage.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-09-06.
 */

public class MeunOrderPopuwindow extends PopupWindow {




    public View mView;

    public MeunOrderPopuwindow(Activity context) {

        LayoutInflater inflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.order_meun_window, null);

        ButterKnife.bind(this,mView);

        int height = context.getWindowManager().getDefaultDisplay().getHeight();

        int width = context.getWindowManager().getDefaultDisplay().getWidth();

        // 设置选择的popuwndow的View
        this.setContentView(mView);

        // 设置弹出的popuwindow的宽
        this.setWidth(width / 3);

        // 设置弹出的popuwndow的高
        this.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);

        // 设置popuwindow的弹出窗体是否可以点击
        this.setFocusable(true);

        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();

        // 实例化一个colorDrawable颜色为半透明
        ColorDrawable colorDrawable = new ColorDrawable(0000000000);

        // 点击返回键和其他地方使其消失，设置了这个才能触发OnDismissListener,设置其他控件变化等操作
        this.setBackgroundDrawable(colorDrawable);

        // 设置SelectPicPopupWindow弹出窗体动画效果
        //this.setAnimationStyle(R.style.AnimationPreview);

    }

    //显示popupwindow
    public void showPopuwindow(View view) {
        if (!this.isShowing()) {
// 以下拉方式显示popuwindow
            this.showAsDropDown(view, view.getLayoutParams().width / 2, 18);
        } else {
            this.dismiss();
        }
    }


    @OnClick({R.id.tv_more_give,R.id.tv_more_point,R.id.tv_more_comment})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_more_give:
                if (null != onClickItemListener) {
                    onClickItemListener.onSelectClickListener("3");
                }
                this.dismiss();
                break;
            case R.id.tv_more_point:
                if (null != onClickItemListener) {
                    onClickItemListener.onSelectClickListener("1");
                }
                this.dismiss();
                break;
            case R.id.tv_more_comment:
                if (null != onClickItemListener) {
                    onClickItemListener.onSelectClickListener("2");
                }
                this.dismiss();
                break;

        }
    }

    private OnSelectClickListener onClickItemListener;

    public void setOnSelectClickListener(OnSelectClickListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public interface OnSelectClickListener {
        void onSelectClickListener(String type);
    }

}
