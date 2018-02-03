package com.sd.storage.model;

/**
 * Created by lenovo on 2018/1/18.
 */

public class BarCodeInptListtModel {

    /*  "ID":"3462",
            "HOSNAME":"医院111（ZKB）",
            "BARCODE":"335",
            "CSTNAME":"医院111：供应商1",


            "DEPTNAME":"医院111：门诊",
            "GOODNAME":"医院111：中药：品种3",
            "PACKSPEC":"23b*7片",
            "SHIPCODE":"CW",


            "PRONAME":"医院111：生成厂家2",
            "LOTNO":"aa",
            "ENDDATE":"2019-09-11",
            "CMSW":"1",

            "CHECKQTY":0,
            "REFQTY":0,
            "QTY":null,
            "UNITNAME_INPRC":"瓶/￥:55",

            "TOTQTY":"200/200",
            "HOSID":"d1b77f08-a06c-47be-3334-e7c5b320993c",
            "SENDDEPTID":"f8ec2e03-46f2-4c6e-3334-fc4bcfabd962"*/




    public String ID;
    public String HOSNAME;
    public String BARCODE;
    // 供应商
    public String CSTNAME;


//部门
    public String DEPTNAME;
    //品名
    public String GOODNAME;
    //规格
    public String PACKSPEC;
    //仓位
    public String SHIPCODE;


    //厂家
    public String PRONAME;
    //批号
    public String LOTNO;
    //效期
    public String ENDDATE;
    //国准
    public String CMSW;



//已验收
    public String CHECKQTY;
    //已拒收
    public String REFQTY;
    //待验收
    public String QTY;
    public String UNITNAME_INPRC;



    public String TOTQTY;
    public String HOSID;
    public String SENDDEPTID;







}
