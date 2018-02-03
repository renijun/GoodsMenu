package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.sd.storage.api.ApiService;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PutInStoreActionsCreator_Factory implements Factory<PutInStoreActionsCreator> {
  private final MembersInjector<PutInStoreActionsCreator> membersInjector;
  private final Provider<Dispatcher> dispatcherProvider;
  private final Provider<ApiService> apiServiceProvider;

  public PutInStoreActionsCreator_Factory(MembersInjector<PutInStoreActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dispatcherProvider != null;
    this.dispatcherProvider = dispatcherProvider;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public PutInStoreActionsCreator get() {  
    PutInStoreActionsCreator instance = new PutInStoreActionsCreator(dispatcherProvider.get(), apiServiceProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<PutInStoreActionsCreator> create(MembersInjector<PutInStoreActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    return new PutInStoreActionsCreator_Factory(membersInjector, dispatcherProvider, apiServiceProvider);
  }
}

