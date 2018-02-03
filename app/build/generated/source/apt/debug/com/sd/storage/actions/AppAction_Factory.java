package com.sd.storage.actions;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppAction_Factory implements Factory<AppAction> {
  private final MembersInjector<AppAction> membersInjector;
  private final Provider<String> typeProvider;
  private final Provider<Object> dataProvider;

  public AppAction_Factory(MembersInjector<AppAction> membersInjector, Provider<String> typeProvider, Provider<Object> dataProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert typeProvider != null;
    this.typeProvider = typeProvider;
    assert dataProvider != null;
    this.dataProvider = dataProvider;
  }

  @Override
  public AppAction get() {  
    AppAction instance = new AppAction(typeProvider.get(), dataProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<AppAction> create(MembersInjector<AppAction> membersInjector, Provider<String> typeProvider, Provider<Object> dataProvider) {  
    return new AppAction_Factory(membersInjector, typeProvider, dataProvider);
  }
}

