package com.sd.storage.actions;

import com.sd.storage.stores.AppStore;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PanDianActionsCreator_MembersInjector implements MembersInjector<PanDianActionsCreator> {
  private final MembersInjector<ActionsCreator> supertypeInjector;
  private final Provider<AppStore> appStoreProvider;

  public PanDianActionsCreator_MembersInjector(MembersInjector<ActionsCreator> supertypeInjector, Provider<AppStore> appStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert appStoreProvider != null;
    this.appStoreProvider = appStoreProvider;
  }

  @Override
  public void injectMembers(PanDianActionsCreator instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.appStore = appStoreProvider.get();
  }

  public static MembersInjector<PanDianActionsCreator> create(MembersInjector<ActionsCreator> supertypeInjector, Provider<AppStore> appStoreProvider) {  
      return new PanDianActionsCreator_MembersInjector(supertypeInjector, appStoreProvider);
  }
}

