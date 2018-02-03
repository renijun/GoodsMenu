package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.sd.storage.api.ApiService;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BarCodeActionsCreator_Factory implements Factory<BarCodeActionsCreator> {
  private final MembersInjector<BarCodeActionsCreator> membersInjector;
  private final Provider<Dispatcher> dispatcherProvider;
  private final Provider<ApiService> apiServiceProvider;

  public BarCodeActionsCreator_Factory(MembersInjector<BarCodeActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dispatcherProvider != null;
    this.dispatcherProvider = dispatcherProvider;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public BarCodeActionsCreator get() {  
    BarCodeActionsCreator instance = new BarCodeActionsCreator(dispatcherProvider.get(), apiServiceProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<BarCodeActionsCreator> create(MembersInjector<BarCodeActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    return new BarCodeActionsCreator_Factory(membersInjector, dispatcherProvider, apiServiceProvider);
  }
}

