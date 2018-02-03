package com.sd.storage.ui.main;

import com.sd.storage.actions.BarCodeSplitSonActionsCreator;
import com.sd.storage.stores.BarcodeSplitSonStore;
import com.sd.storage.ui.base.BaseSCActivity;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SplitBarSonActivity_MembersInjector implements MembersInjector<SplitBarSonActivity> {
  private final MembersInjector<BaseSCActivity> supertypeInjector;
  private final Provider<BarCodeSplitSonActionsCreator> barCodeSplitSonActionsCreatorProvider;
  private final Provider<BarcodeSplitSonStore> barcodeSplitSonStoreProvider;

  public SplitBarSonActivity_MembersInjector(MembersInjector<BaseSCActivity> supertypeInjector, Provider<BarCodeSplitSonActionsCreator> barCodeSplitSonActionsCreatorProvider, Provider<BarcodeSplitSonStore> barcodeSplitSonStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert barCodeSplitSonActionsCreatorProvider != null;
    this.barCodeSplitSonActionsCreatorProvider = barCodeSplitSonActionsCreatorProvider;
    assert barcodeSplitSonStoreProvider != null;
    this.barcodeSplitSonStoreProvider = barcodeSplitSonStoreProvider;
  }

  @Override
  public void injectMembers(SplitBarSonActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.barCodeSplitSonActionsCreator = barCodeSplitSonActionsCreatorProvider.get();
    instance.barcodeSplitSonStore = barcodeSplitSonStoreProvider.get();
  }

  public static MembersInjector<SplitBarSonActivity> create(MembersInjector<BaseSCActivity> supertypeInjector, Provider<BarCodeSplitSonActionsCreator> barCodeSplitSonActionsCreatorProvider, Provider<BarcodeSplitSonStore> barcodeSplitSonStoreProvider) {
      return new SplitBarSonActivity_MembersInjector(supertypeInjector, barCodeSplitSonActionsCreatorProvider, barcodeSplitSonStoreProvider);
  }
}

