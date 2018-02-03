package com.sd.storage.app;

import android.app.Application;

import com.sd.storage.modules.AppModule;
import com.sd.storage.ui.MainActivity2;
import com.sd.storage.ui.login.LoginActivity;
import com.sd.storage.ui.main.BarCodeInputActivity;
import com.sd.storage.ui.main.CartFragmentV3;
import com.sd.storage.ui.main.HomeFragment;
import com.sd.storage.ui.main.LocalMerchantsFragment;
import com.sd.storage.ui.main.MyFragment;
import com.sd.storage.ui.main.PutInStorageActivity;
import com.sd.storage.ui.main.codegoods.CodeGoodsActivity;
import com.sd.storage.ui.main.pandian.PandianFragment;
import com.sd.storage.ui.main.pandian.PandianSonFragment;
import com.sd.storage.ui.main.splitbar.SplitBarFragment;
import com.sd.storage.ui.main.splitbar.SplitSonFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by MrZhou on 2017/5/13.
 */
@Singleton
@Component(
        modules = {AppModule.class}
)
public interface AppComponent {

    Application getApplication();

    final class Initializer {
        public static AppComponent init(StorageApplication app) {
            return DaggerAppComponent.builder().appModule(new AppModule(app)).build();
        }
    }

    void inject(StorageApplication app);

    void inject(LoginActivity activity);

    void inject(MainActivity2 activity);

    void inject(HomeFragment fragment);

    void inject(LocalMerchantsFragment fragment);

    void inject(CartFragmentV3 fragment);

    void inject(MyFragment fragment);

    void inject(PutInStorageActivity activity);

    void inject(BarCodeInputActivity barCodeInputActivity);


    void inject(SplitBarFragment fragment);

    void inject(SplitSonFragment fragment);

    void inject(PandianFragment fragment);

    void inject(PandianSonFragment fragment);

    void inject(CodeGoodsActivity fragment);








}
