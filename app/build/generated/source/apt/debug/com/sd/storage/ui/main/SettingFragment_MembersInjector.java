package com.sd.storage.ui.main;

import com.sd.storage.stores.AppStore;
import com.sd.storage.ui.base.BaseTabFragment;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SettingFragment_MembersInjector implements MembersInjector<MyFragment> {
  private final MembersInjector<BaseTabFragment> supertypeInjector;
  private final Provider<AppStore> appStoreProvider;

  public SettingFragment_MembersInjector(MembersInjector<BaseTabFragment> supertypeInjector, Provider<AppStore> appStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert appStoreProvider != null;
    this.appStoreProvider = appStoreProvider;
  }

  @Override
  public void injectMembers(MyFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.appStore = appStoreProvider.get();
  }

  public static MembersInjector<MyFragment> create(MembersInjector<BaseTabFragment> supertypeInjector, Provider<AppStore> appStoreProvider) {
      return new SettingFragment_MembersInjector(supertypeInjector, appStoreProvider);
  }
}

