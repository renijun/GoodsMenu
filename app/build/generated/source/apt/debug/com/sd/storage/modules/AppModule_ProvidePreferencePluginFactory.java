package com.sd.storage.modules;

import com.dframe.lib.utils.PreferencePlugin;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvidePreferencePluginFactory implements Factory<PreferencePlugin> {
  private final AppModule module;

  public AppModule_ProvidePreferencePluginFactory(AppModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public PreferencePlugin get() {  
    PreferencePlugin provided = module.providePreferencePlugin();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<PreferencePlugin> create(AppModule module) {  
    return new AppModule_ProvidePreferencePluginFactory(module);
  }
}

