package com.sd.storage.model;

/**
 * Created by lenovo on 2018/1/18.
 */

public class DepartmentModel {


    /*  "HOSID":"d1b77f08-a06c-47be-3334-e7c5b320993c",
              "DEPTID":"f8ec2e03-46f2-4c6e-3334-fc4bcfabd962",
              "DEPTNAME":"医院111：门诊",
              "DEPTTFF":"YYYYY：MZ"*/
    // 用户id
    public String DEPTID;
    // 商品id
    public String DEPTNAME;
    public String HOSID;
    //拼首
    public String DEPTTFF;


    public void setDEPTID(String DEPTID) {
        this.DEPTID = DEPTID;
    }

    public void setDEPTNAME(String DEPTNAME) {
        this.DEPTNAME = DEPTNAME;
    }
}
