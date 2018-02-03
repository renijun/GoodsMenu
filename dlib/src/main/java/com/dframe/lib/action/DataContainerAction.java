package com.dframe.lib.action;

import com.dframe.lib.model.DataContainer;

/**
 * Created by MrZhou on 2016/10/27.
 */
public class DataContainerAction<D> extends Action<DataContainer<D>>{

    public DataContainerAction(String type, DataContainer<D> data) {
        super(type, data);
    }
}
