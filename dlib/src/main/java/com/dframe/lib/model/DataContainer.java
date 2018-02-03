package com.dframe.lib.model;

/**
 * Created by MrZhou on 2016/10/1.
 */
public class DataContainer<T> {
    public T data;

/*    public int status;
    public String message;*/

    public boolean Success;
    public int Code;
    public int ErrCode;
    public String Message;


/*    public boolean getResultOK() {
        if (Code == 200) {
            return true;
        }
        return false;
    }*/

    public boolean getResultOK() {
        return Success;
    }


}
