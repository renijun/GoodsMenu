package com.sd.storage.modules;

import com.sd.storage.dlib.dispatcher.Dispatcher;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvideDispatcherFactory implements Factory<Dispatcher> {
  private final AppModule module;

  public AppModule_ProvideDispatcherFactory(AppModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Dispatcher get() {  
    Dispatcher provided = module.provideDispatcher();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Dispatcher> create(AppModule module) {  
    return new AppModule_ProvideDispatcherFactory(module);
  }
}

