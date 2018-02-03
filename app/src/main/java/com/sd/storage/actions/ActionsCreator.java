package com.sd.storage.actions;

import com.dframe.lib.action.Action;
import com.dframe.lib.bus.ICompositeSubscription;
import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.store.Store;
import com.sd.storage.api.ApiService;
import com.sd.storage.common.RetryWhenProcess;;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Action 产生器，负责发送action 到 Store
 * Created by MrZhou on 2016/10/1.
 */
public class ActionsCreator extends ICompositeSubscription {

    protected Dispatcher mDispatcher;

    protected ApiService mApiService;

    @Inject
    public ActionsCreator(Dispatcher dispatcher, ApiService apiService){
        mDispatcher = dispatcher;
        mApiService = apiService;
    }

    public void dispatchAction(Action action) {
        mDispatcher.dispatch(action);
    }

    public void register(Store store) {
        mDispatcher.register(store);
    }

    public void unregister(Store store){
        mDispatcher.unregister(store);
    }

    /**
     * 添加线程切换以及网络重试观察者
     * @param observable
     * @param subscriber#
     * @return subscription
     */
  /*  public <T> Subscription putObsToSubscriber(Observable<T> observable, Subscriber<T> subscriber){
        Subscription subscription =
                observable.retryWhen(new RetryWhenProcess(2)).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
        putSubscription(subscription);
        return subscription;
    }*/


    public <T> Subscription putObsToSubscriber(Observable<T> observable, Subscriber<T> subscriber){
        Subscription subscription =
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
        putSubscription(subscription);
        return subscription;
    }


}
