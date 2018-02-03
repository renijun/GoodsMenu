package com.sd.storage.stores;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PanDianStore_Factory implements Factory<PanDianStore> {
  private final MembersInjector<PanDianStore> membersInjector;

  public PanDianStore_Factory(MembersInjector<PanDianStore> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public PanDianStore get() {  
    PanDianStore instance = new PanDianStore();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<PanDianStore> create(MembersInjector<PanDianStore> membersInjector) {  
    return new PanDianStore_Factory(membersInjector);
  }
}

