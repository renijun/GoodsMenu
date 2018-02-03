package com.sd.storage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dframe.lib.adapter.DBaseAdapter;
import com.sd.storage.R;
import com.sd.storage.model.BarCodeSplitSonModel;
import com.sd.storage.model.DepartmentModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/1/18.
 */

public class SplitBarAdapter extends DBaseAdapter<BarCodeSplitSonModel> implements View.OnClickListener {


    private int selctPoint = 0;
    private ViewDearHolder exchangeHolder;

    public SplitBarAdapter(Context context) {
        super(context);
    }

    @Override
    protected View onCreateItemView(ViewGroup parent) {
        return getLayoutInflater().inflate(R.layout.activity_spilt_bar_item, parent, false);
    }

    @Override
    protected ViewHolder onCreateItemViewHolder(View view) {
        return new ViewDearHolder(view);
    }

    @Override
    protected void onBindItemViewHolder(ViewHolder holder, int position) {

        BarCodeSplitSonModel barCodeSplitSonModel = getItem(position);
        exchangeHolder = (ViewDearHolder) holder;


        exchangeHolder.tv_BARCODE.setText(position + "");
        exchangeHolder.tv_BARCODE.setText(barCodeSplitSonModel.BARCODE);
        int count = (int) Double.parseDouble(barCodeSplitSonModel.BARQTY);
        exchangeHolder.tv_BARQTY.setText(count+"");


        exchangeHolder.v_item.setTag(barCodeSplitSonModel);
        exchangeHolder.v_item.setOnClickListener(this);

        // exchangeHolder.tv_delt.setTag(barCodeSplitSonModel);
        //  exchangeHolder.tv_delt.setOnClickListener(this);

    }

    @OnClick({R.id.tv_delt, R.id.v_item})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.v_item:
                if (null != onClickItemDeltListener) {
                    onClickItemDeltListener.onItemDeltOnClick((BarCodeSplitSonModel) v.getTag());
                }
                break;
            case R.id.tv_delt:

                break;
        }
    }


    private OnClickItemDeltListener onClickItemDeltListener;

    public void setOnDeltClickListener(OnClickItemDeltListener onClickItemDeltListener) {
        this.onClickItemDeltListener = onClickItemDeltListener;
    }

    public interface OnClickItemDeltListener {
        void onItemDeltOnClick(BarCodeSplitSonModel item);

    }

    static class ViewDearHolder extends ViewHolder {
        // 内容
        @BindView(R.id.tv_BARCODE)
        TextView tv_BARCODE;
        @BindView(R.id.tv_position)
        TextView tv_position;

        @BindView(R.id.tv_BARQTY)
        TextView tv_BARQTY;
        @BindView(R.id.tv_delt)
        TextView tv_delt;
        @BindView(R.id.v_item)
        LinearLayout v_item;


        ViewDearHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
