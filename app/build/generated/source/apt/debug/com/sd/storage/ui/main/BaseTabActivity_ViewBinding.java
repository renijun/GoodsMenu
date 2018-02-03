// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BaseTabActivity_ViewBinding<T extends BaseTabActivity> implements Unbinder {
  protected T target;

  @UiThread
  public BaseTabActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mTabHost = Utils.findRequiredViewAsType(source, android.R.id.tabhost, "field 'mTabHost'", FragmentTabHost.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTabHost = null;

    this.target = null;
  }
}
