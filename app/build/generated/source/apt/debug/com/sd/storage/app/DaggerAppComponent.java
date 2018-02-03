package com.sd.storage.app;

import android.app.Application;
import com.dframe.lib.dispatcher.Dispatcher;
import com.dframe.lib.utils.PreferencePlugin;
import com.sd.storage.actions.BarCodeActionsCreator;
import com.sd.storage.actions.BarCodeActionsCreator_Factory;
import com.sd.storage.actions.BarCodeActionsCreator_MembersInjector;
import com.sd.storage.actions.BarCodeSplitActionsCreator;
import com.sd.storage.actions.BarCodeSplitActionsCreator_Factory;
import com.sd.storage.actions.BarCodeSplitActionsCreator_MembersInjector;
import com.sd.storage.actions.BarCodeSplitSonActionsCreator;
import com.sd.storage.actions.BarCodeSplitSonActionsCreator_Factory;
import com.sd.storage.actions.BarCodeSplitSonActionsCreator_MembersInjector;
import com.sd.storage.actions.CodeGoodsCreator;
import com.sd.storage.actions.CodeGoodsCreator_Factory;
import com.sd.storage.actions.CodeGoodsCreator_MembersInjector;
import com.sd.storage.actions.PanDianActionsCreator;
import com.sd.storage.actions.PanDianActionsCreator_Factory;
import com.sd.storage.actions.PanDianActionsCreator_MembersInjector;
import com.sd.storage.actions.PutInStoreActionsCreator;
import com.sd.storage.actions.PutInStoreActionsCreator_Factory;
import com.sd.storage.actions.PutInStoreActionsCreator_MembersInjector;
import com.sd.storage.actions.SelectDeptActionsCreator;
import com.sd.storage.actions.SelectDeptActionsCreator_Factory;
import com.sd.storage.api.ApiService;
import com.sd.storage.modules.ApiServiceModule;
import com.sd.storage.modules.ApiServiceModule_ProvideApiServiceFactory;
import com.sd.storage.modules.ApiServiceModule_ProvideOkHttpClientFactory;
import com.sd.storage.modules.ApiServiceModule_ProvideRestAdapterFactory;
import com.sd.storage.modules.AppModule;
import com.sd.storage.modules.AppModule_ProvideApplicationFactory;
import com.sd.storage.modules.AppModule_ProvideDispatcherFactory;
import com.sd.storage.modules.AppModule_ProvidePreferencePluginFactory;
import com.sd.storage.stores.AppStore;
import com.sd.storage.stores.AppStore_Factory;
import com.sd.storage.stores.BarcodeSplitSonStore;
import com.sd.storage.stores.BarcodeSplitSonStore_Factory;
import com.sd.storage.stores.BarcodeSplitStore;
import com.sd.storage.stores.BarcodeSplitStore_Factory;
import com.sd.storage.stores.BarcodeStore;
import com.sd.storage.stores.BarcodeStore_Factory;
import com.sd.storage.stores.CodeGoodsStore;
import com.sd.storage.stores.CodeGoodsStore_Factory;
import com.sd.storage.stores.PanDianStore;
import com.sd.storage.stores.PanDianStore_Factory;
import com.sd.storage.stores.PutInStorageStore;
import com.sd.storage.stores.PutInStorageStore_Factory;
import com.sd.storage.stores.SelectDeptStore;
import com.sd.storage.stores.SelectDeptStore_Factory;
import com.sd.storage.stores.SelectDeptStore_MembersInjector;
import com.sd.storage.ui.MainActivity2;
import com.sd.storage.ui.login.LoginActivity;
import com.sd.storage.ui.login.LoginActivity_MembersInjector;
import com.sd.storage.ui.main.BarCodeInputActivity;
import com.sd.storage.ui.main.BarCodeInputActivity_MembersInjector;
import com.sd.storage.ui.main.CartFragmentV3;
import com.sd.storage.ui.main.HomeFragment;
import com.sd.storage.ui.main.HomeFragment_MembersInjector;
import com.sd.storage.ui.main.LocalMerchantsFragment;
import com.sd.storage.ui.main.MyFragment;
import com.sd.storage.ui.main.MyFragment_MembersInjector;
import com.sd.storage.ui.main.PutInStorageActivity;
import com.sd.storage.ui.main.PutInStorageActivity_MembersInjector;
import com.sd.storage.ui.main.codegoods.CodeGoodsActivity;
import com.sd.storage.ui.main.codegoods.CodeGoodsActivity_MembersInjector;
import com.sd.storage.ui.main.pandian.PandianFragment;
import com.sd.storage.ui.main.pandian.PandianFragment_MembersInjector;
import com.sd.storage.ui.main.pandian.PandianSonFragment;
import com.sd.storage.ui.main.pandian.PandianSonFragment_MembersInjector;
import com.sd.storage.ui.main.splitbar.SplitBarFragment;
import com.sd.storage.ui.main.splitbar.SplitBarFragment_MembersInjector;
import com.sd.storage.ui.main.splitbar.SplitSonFragment;
import com.sd.storage.ui.main.splitbar.SplitSonFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerAppComponent implements AppComponent {
  private Provider<Application> provideApplicationProvider;
  private Provider<PreferencePlugin> providePreferencePluginProvider;
  private Provider<AppStore> appStoreProvider;
  private Provider<Dispatcher> provideDispatcherProvider;
  private Provider<OkHttpClient> provideOkHttpClientProvider;
  private Provider<Retrofit.Builder> provideRestAdapterProvider;
  private Provider<ApiService> provideApiServiceProvider;
  private Provider<SelectDeptActionsCreator> selectDeptActionsCreatorProvider;
  private MembersInjector<SelectDeptStore> selectDeptStoreMembersInjector;
  private Provider<SelectDeptStore> selectDeptStoreProvider;
  private MembersInjector<LoginActivity> loginActivityMembersInjector;
  private MembersInjector<HomeFragment> homeFragmentMembersInjector;
  private MembersInjector<MyFragment> myFragmentMembersInjector;
  private MembersInjector<PutInStoreActionsCreator> putInStoreActionsCreatorMembersInjector;
  private Provider<PutInStoreActionsCreator> putInStoreActionsCreatorProvider;
  private Provider<PutInStorageStore> putInStorageStoreProvider;
  private MembersInjector<PutInStorageActivity> putInStorageActivityMembersInjector;
  private MembersInjector<BarCodeActionsCreator> barCodeActionsCreatorMembersInjector;
  private Provider<BarCodeActionsCreator> barCodeActionsCreatorProvider;
  private Provider<BarcodeStore> barcodeStoreProvider;
  private MembersInjector<BarCodeInputActivity> barCodeInputActivityMembersInjector;
  private MembersInjector<BarCodeSplitActionsCreator> barCodeSplitActionsCreatorMembersInjector;
  private Provider<BarCodeSplitActionsCreator> barCodeSplitActionsCreatorProvider;
  private Provider<BarcodeSplitStore> barcodeSplitStoreProvider;
  private MembersInjector<SplitBarFragment> splitBarFragmentMembersInjector;
  private MembersInjector<BarCodeSplitSonActionsCreator> barCodeSplitSonActionsCreatorMembersInjector;
  private Provider<BarCodeSplitSonActionsCreator> barCodeSplitSonActionsCreatorProvider;
  private Provider<BarcodeSplitSonStore> barcodeSplitSonStoreProvider;
  private MembersInjector<SplitSonFragment> splitSonFragmentMembersInjector;
  private MembersInjector<PanDianActionsCreator> panDianActionsCreatorMembersInjector;
  private Provider<PanDianActionsCreator> panDianActionsCreatorProvider;
  private Provider<PanDianStore> panDianStoreProvider;
  private MembersInjector<PandianFragment> pandianFragmentMembersInjector;
  private MembersInjector<PandianSonFragment> pandianSonFragmentMembersInjector;
  private MembersInjector<CodeGoodsCreator> codeGoodsCreatorMembersInjector;
  private Provider<CodeGoodsCreator> codeGoodsCreatorProvider;
  private Provider<CodeGoodsStore> codeGoodsStoreProvider;
  private MembersInjector<CodeGoodsActivity> codeGoodsActivityMembersInjector;

  private DaggerAppComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideApplicationProvider = ScopedProvider.create(AppModule_ProvideApplicationFactory.create(builder.appModule));
    this.providePreferencePluginProvider = ScopedProvider.create(AppModule_ProvidePreferencePluginFactory.create(builder.appModule));
    this.appStoreProvider = AppStore_Factory.create((MembersInjector) MembersInjectors.noOp(), providePreferencePluginProvider);
    this.provideDispatcherProvider = AppModule_ProvideDispatcherFactory.create(builder.appModule);
    this.provideOkHttpClientProvider = ScopedProvider.create(ApiServiceModule_ProvideOkHttpClientFactory.create(builder.apiServiceModule));
    this.provideRestAdapterProvider = ScopedProvider.create(ApiServiceModule_ProvideRestAdapterFactory.create(builder.apiServiceModule, provideOkHttpClientProvider));
    this.provideApiServiceProvider = ScopedProvider.create(ApiServiceModule_ProvideApiServiceFactory.create(builder.apiServiceModule, provideRestAdapterProvider));
    this.selectDeptActionsCreatorProvider = SelectDeptActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.selectDeptStoreMembersInjector = SelectDeptStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.selectDeptStoreProvider = SelectDeptStore_Factory.create(selectDeptStoreMembersInjector);
    this.loginActivityMembersInjector = LoginActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider, selectDeptActionsCreatorProvider, selectDeptStoreProvider);
    this.homeFragmentMembersInjector = HomeFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.myFragmentMembersInjector = MyFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.putInStoreActionsCreatorMembersInjector = PutInStoreActionsCreator_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.putInStoreActionsCreatorProvider = PutInStoreActionsCreator_Factory.create(putInStoreActionsCreatorMembersInjector, provideDispatcherProvider, provideApiServiceProvider);
    this.putInStorageStoreProvider = PutInStorageStore_Factory.create((MembersInjector) MembersInjectors.noOp());
    this.putInStorageActivityMembersInjector = PutInStorageActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), putInStoreActionsCreatorProvider, putInStorageStoreProvider);
    this.barCodeActionsCreatorMembersInjector = BarCodeActionsCreator_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.barCodeActionsCreatorProvider = BarCodeActionsCreator_Factory.create(barCodeActionsCreatorMembersInjector, provideDispatcherProvider, provideApiServiceProvider);
    this.barcodeStoreProvider = BarcodeStore_Factory.create((MembersInjector) MembersInjectors.noOp());
    this.barCodeInputActivityMembersInjector = BarCodeInputActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), barCodeActionsCreatorProvider, barcodeStoreProvider);
    this.barCodeSplitActionsCreatorMembersInjector = BarCodeSplitActionsCreator_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.barCodeSplitActionsCreatorProvider = BarCodeSplitActionsCreator_Factory.create(barCodeSplitActionsCreatorMembersInjector, provideDispatcherProvider, provideApiServiceProvider);
    this.barcodeSplitStoreProvider = BarcodeSplitStore_Factory.create((MembersInjector) MembersInjectors.noOp());
    this.splitBarFragmentMembersInjector = SplitBarFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), barCodeSplitActionsCreatorProvider, barcodeSplitStoreProvider);
    this.barCodeSplitSonActionsCreatorMembersInjector = BarCodeSplitSonActionsCreator_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.barCodeSplitSonActionsCreatorProvider = BarCodeSplitSonActionsCreator_Factory.create(barCodeSplitSonActionsCreatorMembersInjector, provideDispatcherProvider, provideApiServiceProvider);
    this.barcodeSplitSonStoreProvider = BarcodeSplitSonStore_Factory.create((MembersInjector) MembersInjectors.noOp());
    this.splitSonFragmentMembersInjector = SplitSonFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), barCodeSplitSonActionsCreatorProvider, barcodeSplitSonStoreProvider);
    this.panDianActionsCreatorMembersInjector = PanDianActionsCreator_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.panDianActionsCreatorProvider = PanDianActionsCreator_Factory.create(panDianActionsCreatorMembersInjector, provideDispatcherProvider, provideApiServiceProvider);
    this.panDianStoreProvider = PanDianStore_Factory.create((MembersInjector) MembersInjectors.noOp());
    this.pandianFragmentMembersInjector = PandianFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), panDianActionsCreatorProvider, panDianStoreProvider);
    this.pandianSonFragmentMembersInjector = PandianSonFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), panDianActionsCreatorProvider, panDianStoreProvider);
    this.codeGoodsCreatorMembersInjector = CodeGoodsCreator_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.codeGoodsCreatorProvider = CodeGoodsCreator_Factory.create(codeGoodsCreatorMembersInjector, provideDispatcherProvider, provideApiServiceProvider);
    this.codeGoodsStoreProvider = CodeGoodsStore_Factory.create((MembersInjector) MembersInjectors.noOp());
    this.codeGoodsActivityMembersInjector = CodeGoodsActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), codeGoodsCreatorProvider, codeGoodsStoreProvider);
  }

  @Override
  public Application getApplication() {  
    return provideApplicationProvider.get();
  }

  @Override
  public void inject(StorageApplication app) {  
    MembersInjectors.noOp().injectMembers(app);
  }

  @Override
  public void inject(LoginActivity activity) {  
    loginActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(MainActivity2 activity) {  
    MembersInjectors.noOp().injectMembers(activity);
  }

  @Override
  public void inject(HomeFragment fragment) {  
    homeFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(LocalMerchantsFragment fragment) {  
    MembersInjectors.noOp().injectMembers(fragment);
  }

  @Override
  public void inject(CartFragmentV3 fragment) {  
    MembersInjectors.noOp().injectMembers(fragment);
  }

  @Override
  public void inject(MyFragment fragment) {  
    myFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(PutInStorageActivity activity) {  
    putInStorageActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(BarCodeInputActivity barCodeInputActivity) {  
    barCodeInputActivityMembersInjector.injectMembers(barCodeInputActivity);
  }

  @Override
  public void inject(SplitBarFragment fragment) {  
    splitBarFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(SplitSonFragment fragment) {  
    splitSonFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(PandianFragment fragment) {  
    pandianFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(PandianSonFragment fragment) {  
    pandianSonFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(CodeGoodsActivity fragment) {  
    codeGoodsActivityMembersInjector.injectMembers(fragment);
  }

  public static final class Builder {
    private AppModule appModule;
    private ApiServiceModule apiServiceModule;
  
    private Builder() {  
    }
  
    public AppComponent build() {  
      if (appModule == null) {
        throw new IllegalStateException("appModule must be set");
      }
      if (apiServiceModule == null) {
        this.apiServiceModule = new ApiServiceModule();
      }
      return new DaggerAppComponent(this);
    }
  
    public Builder appModule(AppModule appModule) {  
      if (appModule == null) {
        throw new NullPointerException("appModule");
      }
      this.appModule = appModule;
      return this;
    }
  
    public Builder apiServiceModule(ApiServiceModule apiServiceModule) {  
      if (apiServiceModule == null) {
        throw new NullPointerException("apiServiceModule");
      }
      this.apiServiceModule = apiServiceModule;
      return this;
    }
  }
}

