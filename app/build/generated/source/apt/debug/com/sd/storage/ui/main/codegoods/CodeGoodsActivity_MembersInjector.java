package com.sd.storage.ui.main.codegoods;

import com.sd.storage.actions.CodeGoodsCreator;
import com.sd.storage.stores.CodeGoodsStore;
import com.sd.storage.ui.base.BaseSCActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class CodeGoodsActivity_MembersInjector implements MembersInjector<CodeGoodsActivity> {
  private final MembersInjector<BaseSCActivity> supertypeInjector;
  private final Provider<CodeGoodsCreator> codeGoodsCreatorProvider;
  private final Provider<CodeGoodsStore> codeGoodsStoreProvider;

  public CodeGoodsActivity_MembersInjector(MembersInjector<BaseSCActivity> supertypeInjector, Provider<CodeGoodsCreator> codeGoodsCreatorProvider, Provider<CodeGoodsStore> codeGoodsStoreProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert codeGoodsCreatorProvider != null;
    this.codeGoodsCreatorProvider = codeGoodsCreatorProvider;
    assert codeGoodsStoreProvider != null;
    this.codeGoodsStoreProvider = codeGoodsStoreProvider;
  }

  @Override
  public void injectMembers(CodeGoodsActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.codeGoodsCreator = codeGoodsCreatorProvider.get();
    instance.codeGoodsStore = codeGoodsStoreProvider.get();
  }

  public static MembersInjector<CodeGoodsActivity> create(MembersInjector<BaseSCActivity> supertypeInjector, Provider<CodeGoodsCreator> codeGoodsCreatorProvider, Provider<CodeGoodsStore> codeGoodsStoreProvider) {  
      return new CodeGoodsActivity_MembersInjector(supertypeInjector, codeGoodsCreatorProvider, codeGoodsStoreProvider);
  }
}

