// Generated code from Butter Knife. Do not modify!
package com.sd.storage.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class DepartAdapter$ViewDearHolder$$ViewBinder<T extends DepartAdapter.ViewDearHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558532, "field 'tv_item'");
    target.tv_item = finder.castView(view, 2131558532, "field 'tv_item'");
    view = finder.findRequiredView(source, 2131558533, "field 'im_point'");
    target.im_point = finder.castView(view, 2131558533, "field 'im_point'");
    view = finder.findRequiredView(source, 2131558531, "field 'lin_item'");
    target.lin_item = finder.castView(view, 2131558531, "field 'lin_item'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends DepartAdapter.ViewDearHolder> implements Unbinder {
    private T target;

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
      target.tv_item = null;
      target.im_point = null;
      target.lin_item = null;
    }
  }
}
