// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class HomeFragment$$ViewBinder<T extends HomeFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558579, "field 'linPutIn' and method 'onClick'");
    target.linPutIn = finder.castView(view, 2131558579, "field 'linPutIn'");
    unbinder.view2131558579 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558580, "method 'onClick'");
    unbinder.view2131558580 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558581, "method 'onClick'");
    unbinder.view2131558581 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558582, "method 'onClick'");
    unbinder.view2131558582 = view;
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

  protected static class InnerUnbinder<T extends HomeFragment> implements Unbinder {
    private T target;

    View view2131558579;

    View view2131558580;

    View view2131558581;

    View view2131558582;

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
      view2131558579.setOnClickListener(null);
      target.linPutIn = null;
      view2131558580.setOnClickListener(null);
      view2131558581.setOnClickListener(null);
      view2131558582.setOnClickListener(null);
    }
  }
}
