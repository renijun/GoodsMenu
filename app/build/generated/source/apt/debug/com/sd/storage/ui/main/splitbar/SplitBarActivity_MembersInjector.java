package com.sd.storage.ui.main.splitbar;

import com.sd.storage.actions.BarCodeSplitActionsCreator;
import com.sd.storage.stores.BarcodeSplitStore;
import com.sd.storage.ui.base.BaseSCActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SplitBarActivity_MembersInjector implements MembersInjector<SplitBarActivity> {
  private final MembersInjector<BaseSCActivity> supertypeInjector;
  private final Provider<BarCodeSplitActionsCreator> barCodeSplitActionsCreatorProvider;
  private final Provider<BarcodeSplitStore> barcodeSplitStoreProvider;

  public SplitBarActivity_MembersInjector(MembersInjector<BaseSCActivity> supertypeInjector, Provider<BarCodeSplitActionsCreator> barCodeSplitActionsCreatorProvider, Provider<BarcodeSplitStore> barcodeSplitStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert barCodeSplitActionsCreatorProvider != null;
    this.barCodeSplitActionsCreatorProvider = barCodeSplitActionsCreatorProvider;
    assert barcodeSplitStoreProvider != null;
    this.barcodeSplitStoreProvider = barcodeSplitStoreProvider;
  }

  @Override
  public void injectMembers(SplitBarActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.barCodeSplitActionsCreator = barCodeSplitActionsCreatorProvider.get();
    instance.barcodeSplitStore = barcodeSplitStoreProvider.get();
  }

  public static MembersInjector<SplitBarActivity> create(MembersInjector<BaseSCActivity> supertypeInjector, Provider<BarCodeSplitActionsCreator> barCodeSplitActionsCreatorProvider, Provider<BarcodeSplitStore> barcodeSplitStoreProvider) {  
      return new SplitBarActivity_MembersInjector(supertypeInjector, barCodeSplitActionsCreatorProvider, barcodeSplitStoreProvider);
  }
}

