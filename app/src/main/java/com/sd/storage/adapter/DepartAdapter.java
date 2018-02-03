package com.sd.storage.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.dframe.lib.adapter.DBaseAdapter;
import com.sd.storage.R;
import com.sd.storage.dialog.SelectDepartmentDialog;
import com.sd.storage.model.DepartmentModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/1/18.
 */

public class DepartAdapter extends BaseAdapter<DepartmentModel> implements View.OnClickListener {


    private String selctID;
    private ViewDearHolder exchangeHolder;

    public DepartAdapter(Context context) {
        super(context);
    }

    @Override
    protected View onCreateItemView(ViewGroup parent) {
        return getLayoutInflater().inflate(R.layout.activity_depat_item, parent, false);
    }

    @Override
    protected ViewHolder onCreateItemViewHolder(View view) {
        return new ViewDearHolder(view);
    }


    @Override
    protected void onBindItemViewHolder(BaseAdapter.ViewHolder holder, int position) {

        DepartmentModel departmentModel = getItem(position);
        exchangeHolder = (ViewDearHolder) holder;
        exchangeHolder.tv_item.setTag(position);
        exchangeHolder.im_point.setTag(position);
        exchangeHolder.tv_item.setOnClickListener(this);
        exchangeHolder.im_point.setOnClickListener(this);

     //   String sss=_data.get((int) exchangeHolder.im_point.getTag()).DEPTID;
        if (_data.get((int) exchangeHolder.im_point.getTag()).DEPTID.equals(selctID)) {
            exchangeHolder.tv_item.setText(departmentModel.DEPTNAME);
            exchangeHolder.im_point.setImageResource(R.drawable.ic_check_on);
            // exchangeHolder.im_point.setChecked(true);

        } else {
            exchangeHolder.tv_item.setText(departmentModel.DEPTNAME);
            // exchangeHolder.im_point.setChecked(false);
            exchangeHolder.im_point.setImageResource(R.drawable.ic_check_off);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_item:
            case R.id.im_point:
                if (null != onClickItemListener) {
                    int position = (int) v.getTag();
                    onClickItemListener.onItemOnClick(_data.get(position), _data.get(position).DEPTID);
                }
                break;
        }
    }


    public void setSelctPoint(String selctID) {
        this.selctID = selctID;
        notifyDataSetChanged();
    }

    private OnClickItemListener onClickItemListener;

    public void setOnClickListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }


    public interface OnClickItemListener {
        void onItemOnClick(DepartmentModel item, String selctID);

    }

    static class ViewDearHolder extends BaseAdapter.ViewHolder {
        // 内容
        @BindView(R.id.tv_item)
        TextView tv_item;
        @BindView(R.id.im_point)
        ImageView im_point;
        @BindView(R.id.lin_item)
        LinearLayout lin_item;


        ViewDearHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
