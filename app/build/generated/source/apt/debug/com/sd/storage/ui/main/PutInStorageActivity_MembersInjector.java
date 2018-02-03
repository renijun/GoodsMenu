package com.sd.storage.ui.main;

import com.sd.storage.actions.PutInStoreActionsCreator;
import com.sd.storage.stores.PutInStorageStore;
import com.sd.storage.ui.base.BaseSCActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PutInStorageActivity_MembersInjector implements MembersInjector<PutInStorageActivity> {
  private final MembersInjector<BaseSCActivity> supertypeInjector;
  private final Provider<PutInStoreActionsCreator> putInStoreActionsCreatorProvider;
  private final Provider<PutInStorageStore> putInStorageStoreProvider;

  public PutInStorageActivity_MembersInjector(MembersInjector<BaseSCActivity> supertypeInjector, Provider<PutInStoreActionsCreator> putInStoreActionsCreatorProvider, Provider<PutInStorageStore> putInStorageStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert putInStoreActionsCreatorProvider != null;
    this.putInStoreActionsCreatorProvider = putInStoreActionsCreatorProvider;
    assert putInStorageStoreProvider != null;
    this.putInStorageStoreProvider = putInStorageStoreProvider;
  }

  @Override
  public void injectMembers(PutInStorageActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.putInStoreActionsCreator = putInStoreActionsCreatorProvider.get();
    instance.putInStorageStore = putInStorageStoreProvider.get();
  }

  public static MembersInjector<PutInStorageActivity> create(MembersInjector<BaseSCActivity> supertypeInjector, Provider<PutInStoreActionsCreator> putInStoreActionsCreatorProvider, Provider<PutInStorageStore> putInStorageStoreProvider) {  
      return new PutInStorageActivity_MembersInjector(supertypeInjector, putInStoreActionsCreatorProvider, putInStorageStoreProvider);
  }
}

