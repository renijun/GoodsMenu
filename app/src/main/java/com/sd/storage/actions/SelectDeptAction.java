package com.sd.storage.actions;

import com.dframe.lib.action.Action;

/**
 * Created by lenovo on 2018/1/18.
 */

public class SelectDeptAction extends Action {
    public static final String MY_DEPARTMENT = "my_department";
    public static final String DEPTID = "deptId";
    public static final String DEPTNAME = "deptname";

    public SelectDeptAction(String type, Object data) {
        super(type, data);
    }


}
