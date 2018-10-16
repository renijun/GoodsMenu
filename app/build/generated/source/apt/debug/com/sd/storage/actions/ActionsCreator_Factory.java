package com.sd.storage.actions;

import com.sd.storage.api.ApiService;
import com.sd.storage.dlib.dispatcher.Dispatcher;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ActionsCreator_Factory implements Factory<ActionsCreator> {
  private final MembersInjector<ActionsCreator> membersInjector;
  private final Provider<Dispatcher> dispatcherProvider;
  private final Provider<ApiService> apiServiceProvider;

  public ActionsCreator_Factory(MembersInjector<ActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dispatcherProvider != null;
    this.dispatcherProvider = dispatcherProvider;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public ActionsCreator get() {  
    ActionsCreator instance = new ActionsCreator(dispatcherProvider.get(), apiServiceProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<ActionsCreator> create(MembersInjector<ActionsCreator> membersInjector, Provider<Dispatcher> dispatcherProvider, Provider<ApiService> apiServiceProvider) {  
    return new ActionsCreator_Factory(membersInjector, dispatcherProvider, apiServiceProvider);
  }
}

