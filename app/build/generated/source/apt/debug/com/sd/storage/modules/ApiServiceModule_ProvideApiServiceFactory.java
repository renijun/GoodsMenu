package com.sd.storage.modules;

import com.sd.storage.api.ApiService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit.Builder;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApiServiceModule_ProvideApiServiceFactory implements Factory<ApiService> {
  private final ApiServiceModule module;
  private final Provider<Builder> builderProvider;

  public ApiServiceModule_ProvideApiServiceFactory(ApiServiceModule module, Provider<Builder> builderProvider) {  
    assert module != null;
    this.module = module;
    assert builderProvider != null;
    this.builderProvider = builderProvider;
  }

  @Override
  public ApiService get() {  
    ApiService provided = module.provideApiService(builderProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ApiService> create(ApiServiceModule module, Provider<Builder> builderProvider) {  
    return new ApiServiceModule_ProvideApiServiceFactory(module, builderProvider);
  }
}

