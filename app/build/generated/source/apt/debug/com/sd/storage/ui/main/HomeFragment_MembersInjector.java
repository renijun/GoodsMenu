package com.sd.storage.ui.main;

import com.sd.storage.stores.AppStore;
import com.sd.storage.ui.base.BaseTabFragment;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final MembersInjector<BaseTabFragment> supertypeInjector;
  private final Provider<AppStore> mAppStoreProvider;

  public HomeFragment_MembersInjector(MembersInjector<BaseTabFragment> supertypeInjector, Provider<AppStore> mAppStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mAppStoreProvider != null;
    this.mAppStoreProvider = mAppStoreProvider;
  }

  @Override
  public void injectMembers(HomeFragment instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mAppStore = mAppStoreProvider.get();
  }

  public static MembersInjector<HomeFragment> create(MembersInjector<BaseTabFragment> supertypeInjector, Provider<AppStore> mAppStoreProvider) {  
      return new HomeFragment_MembersInjector(supertypeInjector, mAppStoreProvider);
  }
}

