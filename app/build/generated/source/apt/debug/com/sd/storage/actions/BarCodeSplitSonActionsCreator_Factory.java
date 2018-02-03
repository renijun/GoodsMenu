package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.sd.storage.api.ApiService;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BarCodeSplitSonActionsCreator_Factory implements Factory<BarCodeSplitSonActionsCreator> {
  private final MembersInjector<BarCodeSplitSonActionsCreator> membersInjector;
  private final Provider<Dispatcher> dispatcherProvider;
  private final Provider<ApiService> apiServiceProvider;

  public BarCodeSplitSonActionsCreator_Factory(MembersInjector<BarCodeSplitSonActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dispatcherProvider != null;
    this.dispatcherProvider = dispatcherProvider;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public BarCodeSplitSonActionsCreator get() {  
    BarCodeSplitSonActionsCreator instance = new BarCodeSplitSonActionsCreator(dispatcherProvider.get(), apiServiceProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<BarCodeSplitSonActionsCreator> create(MembersInjector<BarCodeSplitSonActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    return new BarCodeSplitSonActionsCreator_Factory(membersInjector, dispatcherProvider, apiServiceProvider);
  }
}

