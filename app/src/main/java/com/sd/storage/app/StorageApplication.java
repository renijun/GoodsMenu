package com.sd.storage.app;

import android.app.Application;
import android.support.multidex.MultiDex;




public class StorageApplication extends Application{

    public static StorageApplication mInstance;



    public static StorageApplication getApplication() {
        if(null == mInstance){
            mInstance = new StorageApplication();
        }
        return mInstance;
    }

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        MultiDex.install(this);
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
    public void removeUser(){

    }


}
