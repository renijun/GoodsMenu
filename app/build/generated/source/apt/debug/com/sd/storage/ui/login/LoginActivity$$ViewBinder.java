// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.login;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class LoginActivity$$ViewBinder<T extends LoginActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558519, "field 'tvDepartment' and method 'onClick'");
    target.tvDepartment = finder.castView(view, 2131558519, "field 'tvDepartment'");
    unbinder.view2131558519 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558534, "field 'etAccount'");
    target.etAccount = finder.castView(view, 2131558534, "field 'etAccount'");
    view = finder.findRequiredView(source, 2131558535, "field 'etPassword'");
    target.etPassword = finder.castView(view, 2131558535, "field 'etPassword'");
    view = finder.findRequiredView(source, 2131558536, "method 'onClick'");
    unbinder.view2131558536 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends LoginActivity> implements Unbinder {
    private T target;

    View view2131558519;

    View view2131558536;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      view2131558519.setOnClickListener(null);
      target.tvDepartment = null;
      target.etAccount = null;
      target.etPassword = null;
      view2131558536.setOnClickListener(null);
    }
  }
}
