package com.sd.storage.actions;

import com.dframe.lib.action.Action;

/**
 * Created by Administrator on 2018/1/29.
 */

public class CodeGoodsAction extends Action {

    public static final String BILLIST = "bil_list";
    public static final String BILSUBMIT= "bil_submit";

    public CodeGoodsAction(String type, Object data) {
        super(type, data);
    }
}
