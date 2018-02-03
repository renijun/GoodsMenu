package com.sd.storage.actions;

import com.dframe.lib.action.Action;

import javax.inject.Inject;

/**
 * Created by MrZhou on 2017/5/13.
 */

public class AppAction extends Action {

    @Inject
    public AppAction(String type, Object data) {
        super(type, data);
    }
}
