package com.sd.storage.ui.main.splitbar;

import com.sd.storage.actions.BarCodeSplitSonActionsCreator;
import com.sd.storage.stores.BarcodeSplitSonStore;
import com.sd.storage.ui.base.BaseSCFragment;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SplitSonFragment_MembersInjector implements MembersInjector<SplitSonFragment> {
  private final MembersInjector<BaseSCFragment> supertypeInjector;
  private final Provider<BarCodeSplitSonActionsCreator> barCodeSplitSonActionsCreatorProvider;
  private final Provider<BarcodeSplitSonStore> barcodeSplitSonStoreProvider;

  public SplitSonFragment_MembersInjector(MembersInjector<BaseSCFragment> supertypeInjector, Provider<BarCodeSplitSonActionsCreator> barCodeSplitSonActionsCreatorProvider, Provider<BarcodeSplitSonStore> barcodeSplitSonStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert barCodeSplitSonActionsCreatorProvider != null;
    this.barCodeSplitSonActionsCreatorProvider = barCodeSplitSonActionsCreatorProvider;
    assert barcodeSplitSonStoreProvider != null;
    this.barcodeSplitSonStoreProvider = barcodeSplitSonStoreProvider;
  }

  @Override
  public void injectMembers(SplitSonFragment instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.barCodeSplitSonActionsCreator = barCodeSplitSonActionsCreatorProvider.get();
    instance.barcodeSplitSonStore = barcodeSplitSonStoreProvider.get();
  }

  public static MembersInjector<SplitSonFragment> create(MembersInjector<BaseSCFragment> supertypeInjector, Provider<BarCodeSplitSonActionsCreator> barCodeSplitSonActionsCreatorProvider, Provider<BarcodeSplitSonStore> barcodeSplitSonStoreProvider) {  
      return new SplitSonFragment_MembersInjector(supertypeInjector, barCodeSplitSonActionsCreatorProvider, barcodeSplitSonStoreProvider);
  }
}

