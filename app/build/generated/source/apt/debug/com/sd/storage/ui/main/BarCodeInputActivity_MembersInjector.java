package com.sd.storage.ui.main;

import com.sd.storage.actions.BarCodeActionsCreator;
import com.sd.storage.stores.BarcodeStore;
import com.sd.storage.ui.base.BaseSCActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BarCodeInputActivity_MembersInjector implements MembersInjector<BarCodeInputActivity> {
  private final MembersInjector<BaseSCActivity> supertypeInjector;
  private final Provider<BarCodeActionsCreator> barCodeActionsCreatorProvider;
  private final Provider<BarcodeStore> barcodeStoreProvider;

  public BarCodeInputActivity_MembersInjector(MembersInjector<BaseSCActivity> supertypeInjector, Provider<BarCodeActionsCreator> barCodeActionsCreatorProvider, Provider<BarcodeStore> barcodeStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert barCodeActionsCreatorProvider != null;
    this.barCodeActionsCreatorProvider = barCodeActionsCreatorProvider;
    assert barcodeStoreProvider != null;
    this.barcodeStoreProvider = barcodeStoreProvider;
  }

  @Override
  public void injectMembers(BarCodeInputActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.barCodeActionsCreator = barCodeActionsCreatorProvider.get();
    instance.barcodeStore = barcodeStoreProvider.get();
  }

  public static MembersInjector<BarCodeInputActivity> create(MembersInjector<BaseSCActivity> supertypeInjector, Provider<BarCodeActionsCreator> barCodeActionsCreatorProvider, Provider<BarcodeStore> barcodeStoreProvider) {  
      return new BarCodeInputActivity_MembersInjector(supertypeInjector, barCodeActionsCreatorProvider, barcodeStoreProvider);
  }
}

