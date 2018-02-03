package com.sd.storage.stores;

import com.dframe.lib.action.Action;
import com.dframe.lib.store.Store;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SelectDeptStore_MembersInjector implements MembersInjector<SelectDeptStore> {
  private final MembersInjector<Store<Action>> supertypeInjector;
  private final Provider<AppStore> mAppStoreProvider;

  public SelectDeptStore_MembersInjector(MembersInjector<Store<Action>> supertypeInjector, Provider<AppStore> mAppStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mAppStoreProvider != null;
    this.mAppStoreProvider = mAppStoreProvider;
  }

  @Override
  public void injectMembers(SelectDeptStore instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mAppStore = mAppStoreProvider.get();
  }

  public static MembersInjector<SelectDeptStore> create(MembersInjector<Store<Action>> supertypeInjector, Provider<AppStore> mAppStoreProvider) {  
      return new SelectDeptStore_MembersInjector(supertypeInjector, mAppStoreProvider);
  }
}

