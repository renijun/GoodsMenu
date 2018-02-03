package com.sd.storage.actions;

import com.dframe.lib.action.Action;

/**
 * Created by lenovo on 2018/1/18.
 */

public class LoginAction extends Action {

    public static final String LOGIN_RS = "login_re";
    public static final String USERMODEL = "usermodle";

    public LoginAction(String type, Object data) {
        super(type, data);
    }
}
