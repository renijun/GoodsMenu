package com.sd.storage.stores;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class CodeGoodsStore_Factory implements Factory<CodeGoodsStore> {
  private final MembersInjector<CodeGoodsStore> membersInjector;

  public CodeGoodsStore_Factory(MembersInjector<CodeGoodsStore> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public CodeGoodsStore get() {  
    CodeGoodsStore instance = new CodeGoodsStore();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<CodeGoodsStore> create(MembersInjector<CodeGoodsStore> membersInjector) {  
    return new CodeGoodsStore_Factory(membersInjector);
  }
}

