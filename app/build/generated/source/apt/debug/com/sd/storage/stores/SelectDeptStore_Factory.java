package com.sd.storage.stores;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SelectDeptStore_Factory implements Factory<SelectDeptStore> {
  private final MembersInjector<SelectDeptStore> membersInjector;

  public SelectDeptStore_Factory(MembersInjector<SelectDeptStore> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public SelectDeptStore get() {  
    SelectDeptStore instance = new SelectDeptStore();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<SelectDeptStore> create(MembersInjector<SelectDeptStore> membersInjector) {  
    return new SelectDeptStore_Factory(membersInjector);
  }
}

