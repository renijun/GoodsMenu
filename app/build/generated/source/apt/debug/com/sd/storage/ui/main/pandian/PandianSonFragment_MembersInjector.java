package com.sd.storage.ui.main.pandian;

import com.sd.storage.actions.PanDianActionsCreator;
import com.sd.storage.stores.PanDianStore;
import com.sd.storage.ui.base.BaseSCFragment;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PandianSonFragment_MembersInjector implements MembersInjector<PandianSonFragment> {
  private final MembersInjector<BaseSCFragment> supertypeInjector;
  private final Provider<PanDianActionsCreator> panDianActionsCreatorProvider;
  private final Provider<PanDianStore> panDianStoreProvider;

  public PandianSonFragment_MembersInjector(MembersInjector<BaseSCFragment> supertypeInjector, Provider<PanDianActionsCreator> panDianActionsCreatorProvider, Provider<PanDianStore> panDianStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert panDianActionsCreatorProvider != null;
    this.panDianActionsCreatorProvider = panDianActionsCreatorProvider;
    assert panDianStoreProvider != null;
    this.panDianStoreProvider = panDianStoreProvider;
  }

  @Override
  public void injectMembers(PandianSonFragment instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.panDianActionsCreator = panDianActionsCreatorProvider.get();
    instance.panDianStore = panDianStoreProvider.get();
  }

  public static MembersInjector<PandianSonFragment> create(MembersInjector<BaseSCFragment> supertypeInjector, Provider<PanDianActionsCreator> panDianActionsCreatorProvider, Provider<PanDianStore> panDianStoreProvider) {  
      return new PandianSonFragment_MembersInjector(supertypeInjector, panDianActionsCreatorProvider, panDianStoreProvider);
  }
}

