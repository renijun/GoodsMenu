package com.sd.storage.ui.login;

import com.sd.storage.actions.SelectDeptActionsCreator;
import com.sd.storage.stores.AppStore;
import com.sd.storage.stores.SelectDeptStore;
import com.sd.storage.ui.base.BaseSCActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final MembersInjector<BaseSCActivity> supertypeInjector;
  private final Provider<AppStore> mAppStoreProvider;
  private final Provider<SelectDeptActionsCreator> selectDeptActionsCreatorProvider;
  private final Provider<SelectDeptStore> selectDeptStoreProvider;

  public LoginActivity_MembersInjector(MembersInjector<BaseSCActivity> supertypeInjector, Provider<AppStore> mAppStoreProvider, Provider<SelectDeptActionsCreator> selectDeptActionsCreatorProvider, Provider<SelectDeptStore> selectDeptStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mAppStoreProvider != null;
    this.mAppStoreProvider = mAppStoreProvider;
    assert selectDeptActionsCreatorProvider != null;
    this.selectDeptActionsCreatorProvider = selectDeptActionsCreatorProvider;
    assert selectDeptStoreProvider != null;
    this.selectDeptStoreProvider = selectDeptStoreProvider;
  }

  @Override
  public void injectMembers(LoginActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mAppStore = mAppStoreProvider.get();
    instance.selectDeptActionsCreator = selectDeptActionsCreatorProvider.get();
    instance.selectDeptStore = selectDeptStoreProvider.get();
  }

  public static MembersInjector<LoginActivity> create(MembersInjector<BaseSCActivity> supertypeInjector, Provider<AppStore> mAppStoreProvider, Provider<SelectDeptActionsCreator> selectDeptActionsCreatorProvider, Provider<SelectDeptStore> selectDeptStoreProvider) {  
      return new LoginActivity_MembersInjector(supertypeInjector, mAppStoreProvider, selectDeptActionsCreatorProvider, selectDeptStoreProvider);
  }
}

