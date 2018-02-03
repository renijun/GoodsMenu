package com.sd.storage.stores;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BarcodeSplitSonStore_Factory implements Factory<BarcodeSplitSonStore> {
  private final MembersInjector<BarcodeSplitSonStore> membersInjector;

  public BarcodeSplitSonStore_Factory(MembersInjector<BarcodeSplitSonStore> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public BarcodeSplitSonStore get() {  
    BarcodeSplitSonStore instance = new BarcodeSplitSonStore();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<BarcodeSplitSonStore> create(MembersInjector<BarcodeSplitSonStore> membersInjector) {  
    return new BarcodeSplitSonStore_Factory(membersInjector);
  }
}

