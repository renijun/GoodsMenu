package com.sd.storage.stores;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class Store_Factory implements Factory<Store> {
  private final MembersInjector<Store> membersInjector;

  public Store_Factory(MembersInjector<Store> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public Store get() {  
    Store instance = new Store();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<Store> create(MembersInjector<Store> membersInjector) {  
    return new Store_Factory(membersInjector);
  }
}

