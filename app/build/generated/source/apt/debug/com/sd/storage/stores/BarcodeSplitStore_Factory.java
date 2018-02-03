package com.sd.storage.stores;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BarcodeSplitStore_Factory implements Factory<BarcodeSplitStore> {
  private final MembersInjector<BarcodeSplitStore> membersInjector;

  public BarcodeSplitStore_Factory(MembersInjector<BarcodeSplitStore> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public BarcodeSplitStore get() {  
    BarcodeSplitStore instance = new BarcodeSplitStore();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<BarcodeSplitStore> create(MembersInjector<BarcodeSplitStore> membersInjector) {  
    return new BarcodeSplitStore_Factory(membersInjector);
  }
}

