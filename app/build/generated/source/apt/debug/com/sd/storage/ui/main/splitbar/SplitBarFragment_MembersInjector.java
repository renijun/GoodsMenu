package com.sd.storage.ui.main.splitbar;

import com.sd.storage.actions.BarCodeSplitActionsCreator;
import com.sd.storage.stores.BarcodeSplitStore;
import com.sd.storage.ui.base.BaseSCFragment;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SplitBarFragment_MembersInjector implements MembersInjector<SplitBarFragment> {
  private final MembersInjector<BaseSCFragment> supertypeInjector;
  private final Provider<BarCodeSplitActionsCreator> barCodeSplitActionsCreatorProvider;
  private final Provider<BarcodeSplitStore> barcodeSplitStoreProvider;

  public SplitBarFragment_MembersInjector(MembersInjector<BaseSCFragment> supertypeInjector, Provider<BarCodeSplitActionsCreator> barCodeSplitActionsCreatorProvider, Provider<BarcodeSplitStore> barcodeSplitStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert barCodeSplitActionsCreatorProvider != null;
    this.barCodeSplitActionsCreatorProvider = barCodeSplitActionsCreatorProvider;
    assert barcodeSplitStoreProvider != null;
    this.barcodeSplitStoreProvider = barcodeSplitStoreProvider;
  }

  @Override
  public void injectMembers(SplitBarFragment instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.barCodeSplitActionsCreator = barCodeSplitActionsCreatorProvider.get();
    instance.barcodeSplitStore = barcodeSplitStoreProvider.get();
  }

  public static MembersInjector<SplitBarFragment> create(MembersInjector<BaseSCFragment> supertypeInjector, Provider<BarCodeSplitActionsCreator> barCodeSplitActionsCreatorProvider, Provider<BarcodeSplitStore> barcodeSplitStoreProvider) {  
      return new SplitBarFragment_MembersInjector(supertypeInjector, barCodeSplitActionsCreatorProvider, barcodeSplitStoreProvider);
  }
}

