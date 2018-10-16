package com.sd.storage.stores;

import com.sd.storage.dlib.utils.PreferencePlugin;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppStore_Factory implements Factory<AppStore> {
  private final MembersInjector<AppStore> membersInjector;
  private final Provider<PreferencePlugin> prefernceProvider;

  public AppStore_Factory(MembersInjector<AppStore> membersInjector, Provider<PreferencePlugin> prefernceProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert prefernceProvider != null;
    this.prefernceProvider = prefernceProvider;
  }

  @Override
  public AppStore get() {  
    AppStore instance = new AppStore(prefernceProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<AppStore> create(MembersInjector<AppStore> membersInjector, Provider<PreferencePlugin> prefernceProvider) {  
    return new AppStore_Factory(membersInjector, prefernceProvider);
  }
}

