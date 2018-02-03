package com.sd.storage.modules;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit.Builder;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApiServiceModule_ProvideRestAdapterFactory implements Factory<Builder> {
  private final ApiServiceModule module;
  private final Provider<OkHttpClient> okHttpClientProvider;

  public ApiServiceModule_ProvideRestAdapterFactory(ApiServiceModule module, Provider<OkHttpClient> okHttpClientProvider) {  
    assert module != null;
    this.module = module;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Builder get() {  
    Builder provided = module.provideRestAdapter(okHttpClientProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Builder> create(ApiServiceModule module, Provider<OkHttpClient> okHttpClientProvider) {  
    return new ApiServiceModule_ProvideRestAdapterFactory(module, okHttpClientProvider);
  }
}

