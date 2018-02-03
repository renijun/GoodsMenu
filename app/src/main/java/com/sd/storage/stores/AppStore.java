package com.sd.storage.stores;

import com.dframe.lib.store.Store;
import com.dframe.lib.utils.PreferencePlugin;
import com.dframe.lib.utils.aescrypt.AESCrypt;
import com.google.gson.Gson;
import com.sd.storage.actions.AppAction;
import com.sd.storage.actions.LoginAction;
import com.sd.storage.actions.SelectDeptAction;
import com.sd.storage.model.UserModel;

import javax.inject.Inject;

/**
 * Created by MrZhou on 2017/5/13.
 */
public class AppStore extends Store<AppAction> {


    private PreferencePlugin mPrefernce;
    private String userid;
    private String deptId;
    private UserModel userModel;
    private Gson gson = new Gson();

    @Inject
    public AppStore(PreferencePlugin prefernce) {
        mPrefernce = prefernce;
    }


    @Override
    public void doAction(AppAction action) {

    }


    /**
     * 设置userId
     *
     * @param userid
     */
/*    public void setUserId(String userid) {
        if (null != userid) {
            this.userid = userid;
            mPrefernce.commitString(LoginAction.LOGIN_RS, userid);
        }
    }*/

    /**
     * 保存用户的信息
     *
     * @param userModel
     */
    public void setUserModle(UserModel userModel) {
        if (null != userModel) {
            this.userModel = userModel;
            String jsonStr = gson.toJson(userModel); //将对象转换成Json
            mPrefernce.commitString(LoginAction.USERMODEL, jsonStr);
        }
    }

    /**
     * 获得用户信息
     *
     * @return
     */
    public UserModel getUserModle() {
        String jsonStr = mPrefernce.getString(LoginAction.USERMODEL, null);
        if (null != jsonStr) {
            userModel = gson.fromJson(jsonStr, UserModel.class); //将json字符串转换成 people对象
        }
        return userModel;
    }

    /**
     * 设置部门id
     *
     * @param deptId
     */
    public void setDeptId(String deptId) {
        if (null != deptId) {
            mPrefernce.commitString(SelectDeptAction.MY_DEPARTMENT, deptId);
        }
    }

    /**
     * 设置部门名字
     *
     * @param deptName
     */
    public void setDeptName(String deptName) {
        if (null != deptName) {
            mPrefernce.commitString(SelectDeptAction.DEPTNAME, deptName);
        }
    }

    public String getDeptId() {
        deptId = mPrefernce.getString(SelectDeptAction.MY_DEPARTMENT, null);
        return deptId;
    }


  /*  public String getUserid() {
        userid = mPrefernce.getString(LoginAction.LOGIN_RS, null);
        return userid;
    }*/

    public String getDepartName() {
        userid = mPrefernce.getString(SelectDeptAction.DEPTNAME, null);
        return userid;
    }


}
