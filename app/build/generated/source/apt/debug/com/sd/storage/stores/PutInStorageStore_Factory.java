package com.sd.storage.stores;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PutInStorageStore_Factory implements Factory<PutInStorageStore> {
  private final MembersInjector<PutInStorageStore> membersInjector;

  public PutInStorageStore_Factory(MembersInjector<PutInStorageStore> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public PutInStorageStore get() {  
    PutInStorageStore instance = new PutInStorageStore();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<PutInStorageStore> create(MembersInjector<PutInStorageStore> membersInjector) {  
    return new PutInStorageStore_Factory(membersInjector);
  }
}

