package com.sd.storage.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sd.storage.R;
import com.sd.storage.adapter.DepartAdapter;
import com.sd.storage.model.DepartmentModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/1/18.
 */

public class SelectDepartmentDialog extends BaseDialog implements DepartAdapter.OnClickItemListener {

    public ArrayList<DepartmentModel> mHistoryModels;
    public ArrayList<DepartmentModel> mHistoryModels2 = new ArrayList<>();
    private DepartAdapter adapter;
    private Context context;
    private String selctID;


    @BindView(R.id.et_key)
    EditText et_key;
    @BindView(R.id.v_list)
    ListView listView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // listView = (ListView) view.findViewById(R.id.v_list);
        adapter = new DepartAdapter(context);
        adapter.setOnClickListener(this);
        adapter.setData(mHistoryModels);
        adapter.setSelctPoint(selctID);
        listView.setAdapter(adapter);
        init();
        return view;
    }


    public void init() {

        et_key.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchKey();
            }
        });
    }

    @OnClick({R.id.tv_select})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select:
                searchKey();
                break;
        }
    }

    /**
     * 筛选部门
     */
    public void searchKey() {
        mHistoryModels2.clear();
        for (int i = 0; i < mHistoryModels.size(); i++) {
            if (mHistoryModels.get(i).DEPTTFF.contains(et_key.getText().toString().toUpperCase().trim())) {
                mHistoryModels2.add(mHistoryModels.get(i));
            }
        }
        adapter.setData(mHistoryModels2);
    }


    public void setData(Context context, ArrayList<DepartmentModel> mHistoryModels) {
        this.context = context;
        this.mHistoryModels = mHistoryModels;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.department_dialog;
    }


    @Override
    public void onItemOnClick(DepartmentModel item, String selctID) {
        this.selctID = selctID;
        if (null != onClickListener) {
            et_key.setText("");
            onClickListener.setDepartText(item);
        }
        adapter.setSelctPoint(selctID);
        this.dismiss();

    }


    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void setDepartText(DepartmentModel itme);

    }

}
