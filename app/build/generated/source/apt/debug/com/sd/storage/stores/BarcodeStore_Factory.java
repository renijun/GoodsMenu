package com.sd.storage.stores;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BarcodeStore_Factory implements Factory<BarcodeStore> {
  private final MembersInjector<BarcodeStore> membersInjector;

  public BarcodeStore_Factory(MembersInjector<BarcodeStore> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public BarcodeStore get() {  
    BarcodeStore instance = new BarcodeStore();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<BarcodeStore> create(MembersInjector<BarcodeStore> membersInjector) {  
    return new BarcodeStore_Factory(membersInjector);
  }
}

