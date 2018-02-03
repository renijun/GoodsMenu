// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyFragment_ViewBinding<T extends MyFragment> implements Unbinder {
  protected T target;

  @UiThread
  public MyFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_host = Utils.findRequiredViewAsType(source, R.id.tv_host, "field 'tv_host'", TextView.class);
    target.tv_account = Utils.findRequiredViewAsType(source, R.id.tv_account, "field 'tv_account'", TextView.class);
    target.tv_userName = Utils.findRequiredViewAsType(source, R.id.tv_userName, "field 'tv_userName'", TextView.class);
    target.tv_belong_depar = Utils.findRequiredViewAsType(source, R.id.tv_belong_depar, "field 'tv_belong_depar'", TextView.class);
    target.tv_login_depar = Utils.findRequiredViewAsType(source, R.id.tv_login_depar, "field 'tv_login_depar'", TextView.class);
    target.tv_role = Utils.findRequiredViewAsType(source, R.id.tv_role, "field 'tv_role'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_host = null;
    target.tv_account = null;
    target.tv_userName = null;
    target.tv_belong_depar = null;
    target.tv_login_depar = null;
    target.tv_role = null;

    this.target = null;
  }
}
