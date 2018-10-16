package com.sd.storage.app;

import android.app.Application;
import com.sd.storage.actions.AddCommentActionsCreator;
import com.sd.storage.actions.AddCommentActionsCreator_Factory;
import com.sd.storage.actions.AddMeunActionsCreator;
import com.sd.storage.actions.AddMeunActionsCreator_Factory;
import com.sd.storage.actions.AllMeunActionsCreator;
import com.sd.storage.actions.AllMeunActionsCreator_Factory;
import com.sd.storage.actions.EditMeunListCreator;
import com.sd.storage.actions.EditMeunListCreator_Factory;
import com.sd.storage.actions.MeunOderActionsCreator;
import com.sd.storage.actions.MeunOderActionsCreator_Factory;
import com.sd.storage.actions.SearchVageActionsCreator;
import com.sd.storage.actions.SearchVageActionsCreator_Factory;
import com.sd.storage.actions.TimeActionsCreator;
import com.sd.storage.actions.TimeActionsCreator_Factory;
import com.sd.storage.actions.VageDetailsActionsCreator;
import com.sd.storage.actions.VageDetailsActionsCreator_Factory;
import com.sd.storage.actions.VoteCreator;
import com.sd.storage.actions.VoteCreator_Factory;
import com.sd.storage.actions.WeekMeunActionsCreator;
import com.sd.storage.actions.WeekMeunActionsCreator_Factory;
import com.sd.storage.api.ApiService;
import com.sd.storage.dlib.dispatcher.Dispatcher;
import com.sd.storage.dlib.utils.PreferencePlugin;
import com.sd.storage.modules.ApiServiceModule;
import com.sd.storage.modules.ApiServiceModule_ProvideApiServiceFactory;
import com.sd.storage.modules.ApiServiceModule_ProvideOkHttpClientFactory;
import com.sd.storage.modules.ApiServiceModule_ProvideRestAdapterFactory;
import com.sd.storage.modules.AppModule;
import com.sd.storage.modules.AppModule_ProvideApplicationFactory;
import com.sd.storage.modules.AppModule_ProvideDispatcherFactory;
import com.sd.storage.modules.AppModule_ProvidePreferencePluginFactory;
import com.sd.storage.stores.AddCommentStore;
import com.sd.storage.stores.AddCommentStore_Factory;
import com.sd.storage.stores.AddCommentStore_MembersInjector;
import com.sd.storage.stores.AddMeunStore;
import com.sd.storage.stores.AddMeunStore_Factory;
import com.sd.storage.stores.AddMeunStore_MembersInjector;
import com.sd.storage.stores.AllMeunStore;
import com.sd.storage.stores.AllMeunStore_Factory;
import com.sd.storage.stores.AllMeunStore_MembersInjector;
import com.sd.storage.stores.AppStore;
import com.sd.storage.stores.AppStore_Factory;
import com.sd.storage.stores.EditMeunStore;
import com.sd.storage.stores.EditMeunStore_Factory;
import com.sd.storage.stores.EditMeunStore_MembersInjector;
import com.sd.storage.stores.MeunOderStore;
import com.sd.storage.stores.MeunOderStore_Factory;
import com.sd.storage.stores.MeunOderStore_MembersInjector;
import com.sd.storage.stores.SearchVageStore;
import com.sd.storage.stores.SearchVageStore_Factory;
import com.sd.storage.stores.SearchVageStore_MembersInjector;
import com.sd.storage.stores.TimeStore;
import com.sd.storage.stores.TimeStore_Factory;
import com.sd.storage.stores.TimeStore_MembersInjector;
import com.sd.storage.stores.VageDetailsStore;
import com.sd.storage.stores.VageDetailsStore_Factory;
import com.sd.storage.stores.VageDetailsStore_MembersInjector;
import com.sd.storage.stores.VoteStore;
import com.sd.storage.stores.VoteStore_Factory;
import com.sd.storage.stores.VoteStore_MembersInjector;
import com.sd.storage.stores.WeekMeunStore;
import com.sd.storage.stores.WeekMeunStore_Factory;
import com.sd.storage.stores.WeekMeunStore_MembersInjector;
import com.sd.storage.ui.MainActivity;
import com.sd.storage.ui.MainActivity_MembersInjector;
import com.sd.storage.ui.main.addcommend.AddCommentActivity;
import com.sd.storage.ui.main.addcommend.AddCommentActivity_MembersInjector;
import com.sd.storage.ui.main.meunmanage.MeunManageActivity;
import com.sd.storage.ui.main.meunmanage.MeunManageActivity_MembersInjector;
import com.sd.storage.ui.main.meunmanage.addnewvege.AddNewVegeActivity;
import com.sd.storage.ui.main.meunmanage.addnewvege.AddNewVegeActivity_MembersInjector;
import com.sd.storage.ui.main.meunmanage.addweekmeun.AddWeekMeunActivity;
import com.sd.storage.ui.main.meunmanage.addweekmeun.AddWeekMeunActivity_MembersInjector;
import com.sd.storage.ui.main.meunmanage.manageedit.MansageEditActivity;
import com.sd.storage.ui.main.meunmanage.manageedit.MansageEditActivity_MembersInjector;
import com.sd.storage.ui.main.meunmanage.managesearch.ManageSearchActivity;
import com.sd.storage.ui.main.meunorder.MeunOrderActivity;
import com.sd.storage.ui.main.meunorder.MeunOrderActivity_MembersInjector;
import com.sd.storage.ui.main.search.SearchVageActivity;
import com.sd.storage.ui.main.search.SearchVageActivity_MembersInjector;
import com.sd.storage.ui.main.settime.SetTimeActivity;
import com.sd.storage.ui.main.settime.SetTimeActivity_MembersInjector;
import com.sd.storage.ui.main.vagedetails.VageDetailsActivity;
import com.sd.storage.ui.main.vagedetails.VageDetailsActivity_MembersInjector;
import com.sd.storage.ui.main.votemanage.VoteManageActivity;
import com.sd.storage.ui.main.votemanage.VoteManageActivity_MembersInjector;
import com.sd.storage.ui.main.weekmeun.WeekMenuActivity;
import com.sd.storage.ui.main.weekmeun.WeekMenuActivity_MembersInjector;
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
  private Provider<Dispatcher> provideDispatcherProvider;
  private Provider<OkHttpClient> provideOkHttpClientProvider;
  private Provider<Retrofit.Builder> provideRestAdapterProvider;
  private Provider<ApiService> provideApiServiceProvider;
  private Provider<WeekMeunActionsCreator> weekMeunActionsCreatorProvider;
  private Provider<PreferencePlugin> providePreferencePluginProvider;
  private Provider<AppStore> appStoreProvider;
  private MembersInjector<WeekMeunStore> weekMeunStoreMembersInjector;
  private Provider<WeekMeunStore> weekMeunStoreProvider;
  private MembersInjector<WeekMenuActivity> weekMenuActivityMembersInjector;
  private Provider<AddCommentActionsCreator> addCommentActionsCreatorProvider;
  private MembersInjector<AddCommentStore> addCommentStoreMembersInjector;
  private Provider<AddCommentStore> addCommentStoreProvider;
  private MembersInjector<AddCommentActivity> addCommentActivityMembersInjector;
  private Provider<VageDetailsActionsCreator> vageDetailsActionsCreatorProvider;
  private MembersInjector<VageDetailsStore> vageDetailsStoreMembersInjector;
  private Provider<VageDetailsStore> vageDetailsStoreProvider;
  private MembersInjector<VageDetailsActivity> vageDetailsActivityMembersInjector;
  private Provider<MeunOderActionsCreator> meunOderActionsCreatorProvider;
  private MembersInjector<MeunOderStore> meunOderStoreMembersInjector;
  private Provider<MeunOderStore> meunOderStoreProvider;
  private MembersInjector<MeunOrderActivity> meunOrderActivityMembersInjector;
  private Provider<SearchVageActionsCreator> searchVageActionsCreatorProvider;
  private MembersInjector<SearchVageStore> searchVageStoreMembersInjector;
  private Provider<SearchVageStore> searchVageStoreProvider;
  private MembersInjector<SearchVageActivity> searchVageActivityMembersInjector;
  private Provider<AllMeunActionsCreator> allMeunActionsCreatorProvider;
  private MembersInjector<AllMeunStore> allMeunStoreMembersInjector;
  private Provider<AllMeunStore> allMeunStoreProvider;
  private MembersInjector<MeunManageActivity> meunManageActivityMembersInjector;
  private Provider<AddMeunActionsCreator> addMeunActionsCreatorProvider;
  private MembersInjector<AddMeunStore> addMeunStoreMembersInjector;
  private Provider<AddMeunStore> addMeunStoreProvider;
  private MembersInjector<AddNewVegeActivity> addNewVegeActivityMembersInjector;
  private Provider<EditMeunListCreator> editMeunListCreatorProvider;
  private MembersInjector<EditMeunStore> editMeunStoreMembersInjector;
  private Provider<EditMeunStore> editMeunStoreProvider;
  private MembersInjector<MansageEditActivity> mansageEditActivityMembersInjector;
  private Provider<VoteCreator> voteCreatorProvider;
  private MembersInjector<VoteStore> voteStoreMembersInjector;
  private Provider<VoteStore> voteStoreProvider;
  private MembersInjector<VoteManageActivity> voteManageActivityMembersInjector;
  private MembersInjector<AddWeekMeunActivity> addWeekMeunActivityMembersInjector;
  private Provider<TimeActionsCreator> timeActionsCreatorProvider;
  private MembersInjector<TimeStore> timeStoreMembersInjector;
  private Provider<TimeStore> timeStoreProvider;
  private MembersInjector<SetTimeActivity> setTimeActivityMembersInjector;
  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private DaggerAppComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideApplicationProvider = ScopedProvider.create(AppModule_ProvideApplicationFactory.create(builder.appModule));
    this.provideDispatcherProvider = AppModule_ProvideDispatcherFactory.create(builder.appModule);
    this.provideOkHttpClientProvider = ScopedProvider.create(ApiServiceModule_ProvideOkHttpClientFactory.create(builder.apiServiceModule));
    this.provideRestAdapterProvider = ScopedProvider.create(ApiServiceModule_ProvideRestAdapterFactory.create(builder.apiServiceModule, provideOkHttpClientProvider));
    this.provideApiServiceProvider = ScopedProvider.create(ApiServiceModule_ProvideApiServiceFactory.create(builder.apiServiceModule, provideRestAdapterProvider));
    this.weekMeunActionsCreatorProvider = WeekMeunActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.providePreferencePluginProvider = ScopedProvider.create(AppModule_ProvidePreferencePluginFactory.create(builder.appModule));
    this.appStoreProvider = AppStore_Factory.create((MembersInjector) MembersInjectors.noOp(), providePreferencePluginProvider);
    this.weekMeunStoreMembersInjector = WeekMeunStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.weekMeunStoreProvider = WeekMeunStore_Factory.create(weekMeunStoreMembersInjector);
    this.weekMenuActivityMembersInjector = WeekMenuActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), weekMeunActionsCreatorProvider, weekMeunStoreProvider);
    this.addCommentActionsCreatorProvider = AddCommentActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.addCommentStoreMembersInjector = AddCommentStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.addCommentStoreProvider = AddCommentStore_Factory.create(addCommentStoreMembersInjector);
    this.addCommentActivityMembersInjector = AddCommentActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), addCommentActionsCreatorProvider, addCommentStoreProvider);
    this.vageDetailsActionsCreatorProvider = VageDetailsActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.vageDetailsStoreMembersInjector = VageDetailsStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.vageDetailsStoreProvider = VageDetailsStore_Factory.create(vageDetailsStoreMembersInjector);
    this.vageDetailsActivityMembersInjector = VageDetailsActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), vageDetailsActionsCreatorProvider, vageDetailsStoreProvider);
    this.meunOderActionsCreatorProvider = MeunOderActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.meunOderStoreMembersInjector = MeunOderStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.meunOderStoreProvider = MeunOderStore_Factory.create(meunOderStoreMembersInjector);
    this.meunOrderActivityMembersInjector = MeunOrderActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), meunOderActionsCreatorProvider, meunOderStoreProvider);
    this.searchVageActionsCreatorProvider = SearchVageActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.searchVageStoreMembersInjector = SearchVageStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.searchVageStoreProvider = SearchVageStore_Factory.create(searchVageStoreMembersInjector);
    this.searchVageActivityMembersInjector = SearchVageActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), searchVageActionsCreatorProvider, searchVageStoreProvider);
    this.allMeunActionsCreatorProvider = AllMeunActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.allMeunStoreMembersInjector = AllMeunStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.allMeunStoreProvider = AllMeunStore_Factory.create(allMeunStoreMembersInjector);
    this.meunManageActivityMembersInjector = MeunManageActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), allMeunActionsCreatorProvider, allMeunStoreProvider);
    this.addMeunActionsCreatorProvider = AddMeunActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.addMeunStoreMembersInjector = AddMeunStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.addMeunStoreProvider = AddMeunStore_Factory.create(addMeunStoreMembersInjector);
    this.addNewVegeActivityMembersInjector = AddNewVegeActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), addMeunActionsCreatorProvider, addMeunStoreProvider);
    this.editMeunListCreatorProvider = EditMeunListCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.editMeunStoreMembersInjector = EditMeunStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.editMeunStoreProvider = EditMeunStore_Factory.create(editMeunStoreMembersInjector);
    this.mansageEditActivityMembersInjector = MansageEditActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), editMeunListCreatorProvider, editMeunStoreProvider);
    this.voteCreatorProvider = VoteCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.voteStoreMembersInjector = VoteStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.voteStoreProvider = VoteStore_Factory.create(voteStoreMembersInjector);
    this.voteManageActivityMembersInjector = VoteManageActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), voteCreatorProvider, voteStoreProvider);
    this.addWeekMeunActivityMembersInjector = AddWeekMeunActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), allMeunActionsCreatorProvider, allMeunStoreProvider);
    this.timeActionsCreatorProvider = TimeActionsCreator_Factory.create((MembersInjector) MembersInjectors.noOp(), provideDispatcherProvider, provideApiServiceProvider);
    this.timeStoreMembersInjector = TimeStore_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), appStoreProvider);
    this.timeStoreProvider = TimeStore_Factory.create(timeStoreMembersInjector);
    this.setTimeActivityMembersInjector = SetTimeActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), timeActionsCreatorProvider, timeStoreProvider);
    this.mainActivityMembersInjector = MainActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), timeActionsCreatorProvider, timeStoreProvider);
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
  public void inject(WeekMenuActivity weekMenuActivity) {  
    weekMenuActivityMembersInjector.injectMembers(weekMenuActivity);
  }

  @Override
  public void inject(AddCommentActivity addCommentActivity) {  
    addCommentActivityMembersInjector.injectMembers(addCommentActivity);
  }

  @Override
  public void inject(VageDetailsActivity vageDetailsActivity) {  
    vageDetailsActivityMembersInjector.injectMembers(vageDetailsActivity);
  }

  @Override
  public void inject(MeunOrderActivity meunOrderActivity) {  
    meunOrderActivityMembersInjector.injectMembers(meunOrderActivity);
  }

  @Override
  public void inject(SearchVageActivity searchVageActivity) {  
    searchVageActivityMembersInjector.injectMembers(searchVageActivity);
  }

  @Override
  public void inject(MeunManageActivity meunManageActivity) {  
    meunManageActivityMembersInjector.injectMembers(meunManageActivity);
  }

  @Override
  public void inject(ManageSearchActivity manageSearchActivity) {  
    MembersInjectors.noOp().injectMembers(manageSearchActivity);
  }

  @Override
  public void inject(AddNewVegeActivity addNewVegeActivity) {  
    addNewVegeActivityMembersInjector.injectMembers(addNewVegeActivity);
  }

  @Override
  public void inject(MansageEditActivity mansageEditActivity) {  
    mansageEditActivityMembersInjector.injectMembers(mansageEditActivity);
  }

  @Override
  public void inject(VoteManageActivity voteManageActivity) {  
    voteManageActivityMembersInjector.injectMembers(voteManageActivity);
  }

  @Override
  public void inject(AddWeekMeunActivity addWeekMeunActivity) {  
    addWeekMeunActivityMembersInjector.injectMembers(addWeekMeunActivity);
  }

  @Override
  public void inject(SetTimeActivity setTimeActivity) {  
    setTimeActivityMembersInjector.injectMembers(setTimeActivity);
  }

  @Override
  public void inject(MainActivity mainActivity) {  
    mainActivityMembersInjector.injectMembers(mainActivity);
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

