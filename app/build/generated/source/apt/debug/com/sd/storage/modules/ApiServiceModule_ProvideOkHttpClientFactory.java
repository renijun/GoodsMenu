package com.sd.storage.modules;

import dagger.internal.Factory;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApiServiceModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final ApiServiceModule module;

  public ApiServiceModule_ProvideOkHttpClientFactory(ApiServiceModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public OkHttpClient get() {  
    OkHttpClient provided = module.provideOkHttpClient();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OkHttpClient> create(ApiServiceModule module) {  
    return new ApiServiceModule_ProvideOkHttpClientFactory(module);
  }
}

