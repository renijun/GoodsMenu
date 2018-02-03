package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.sd.storage.api.ApiService;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BarCodeSplitActionsCreator_Factory implements Factory<BarCodeSplitActionsCreator> {
  private final MembersInjector<BarCodeSplitActionsCreator> membersInjector;
  private final Provider<Dispatcher> dispatcherProvider;
  private final Provider<ApiService> apiServiceProvider;

  public BarCodeSplitActionsCreator_Factory(MembersInjector<BarCodeSplitActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dispatcherProvider != null;
    this.dispatcherProvider = dispatcherProvider;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public BarCodeSplitActionsCreator get() {  
    BarCodeSplitActionsCreator instance = new BarCodeSplitActionsCreator(dispatcherProvider.get(), apiServiceProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<BarCodeSplitActionsCreator> create(MembersInjector<BarCodeSplitActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    return new BarCodeSplitActionsCreator_Factory(membersInjector, dispatcherProvider, apiServiceProvider);
  }
}

