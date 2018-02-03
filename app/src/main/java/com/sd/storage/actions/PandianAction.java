package com.sd.storage.actions;

import com.dframe.lib.action.Action;

/**
 * Created by Administrator on 2018/1/28.
 */

public class PandianAction extends Action {


    public static final String PANDIANLIST = "pandian_list";
    public static final String PANDIANDATA = "pandian_data";

    public static final String PANDIANDATALIST = "pandian_data_list";

    public PandianAction(String type, Object data) {
        super(type, data);
    }


}
