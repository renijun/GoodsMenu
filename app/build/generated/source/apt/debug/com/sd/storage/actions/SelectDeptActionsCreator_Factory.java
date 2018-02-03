package com.sd.storage.actions;

import com.dframe.lib.dispatcher.Dispatcher;
import com.sd.storage.api.ApiService;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SelectDeptActionsCreator_Factory implements Factory<SelectDeptActionsCreator> {
  private final MembersInjector<SelectDeptActionsCreator> membersInjector;
  private final Provider<Dispatcher> dispatcherProvider;
  private final Provider<ApiService> apiServiceProvider;

  public SelectDeptActionsCreator_Factory(MembersInjector<SelectDeptActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dispatcherProvider != null;
    this.dispatcherProvider = dispatcherProvider;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public SelectDeptActionsCreator get() {  
    SelectDeptActionsCreator instance = new SelectDeptActionsCreator(dispatcherProvider.get(), apiServiceProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<SelectDeptActionsCreator> create(MembersInjector<SelectDeptActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    return new SelectDeptActionsCreator_Factory(membersInjector, dispatcherProvider, apiServiceProvider);
  }
}

