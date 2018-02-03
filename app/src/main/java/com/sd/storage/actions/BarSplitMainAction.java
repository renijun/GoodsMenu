package com.sd.storage.actions;

import com.dframe.lib.action.Action;

/**
 * Created by lenovo on 2018/1/18.
 * 拆分的主页面
 */

public class BarSplitMainAction extends Action {
    public static final String BARSPLIT = "barsplit";

    public static final String BARSPLITSubmit = "barsplit_submit";

    public static final String BARSPLITSON = "barspilt_son";

    public static final String BARSPLITSUBMIT= "barspilt_son_submit";

    public static final String BARSPLITRESCAN= "barspilt_son_rescan";
    public static final String BARSPLITDELT= "barspilt_son_delt";

    public BarSplitMainAction(String type, Object data) {
        super(type, data);
    }


}
