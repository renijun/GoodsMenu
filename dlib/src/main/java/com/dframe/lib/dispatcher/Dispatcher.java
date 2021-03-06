package com.dframe.lib.dispatcher;

import android.util.Log;

import com.dframe.lib.action.Action;
import com.dframe.lib.store.Store;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by MrZhou on 2016/9/26.
 */
public class Dispatcher {
    private static Dispatcher instance;
    private final List<Store> stores = new ArrayList<>();

    public static Dispatcher getInstance() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    public void register(final Store store) {
        if (!stores.contains(store)) {
            stores.add(store);
        }
    }

    public void unregister(final Store store) {
        stores.remove(store);
    }

    public void dispatch(Action action) {
        post(action);
    }

    private void post(final Action action) {
        for (Store store : stores) {
            store.onAction(action);
        }
    }
}
