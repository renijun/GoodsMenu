// Generated code from Butter Knife. Do not modify!
package com.sd.storage.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplitBarAdapter_ViewBinding<T extends SplitBarAdapter> implements Unbinder {
  protected T target;

  private View view2131230913;

  private View view2131230961;

  @UiThread
  public SplitBarAdapter_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_delt, "method 'onClick'");
    view2131230913 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.v_item, "method 'onClick'");
    view2131230961 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (this.target == null) throw new IllegalStateException("Bindings already cleared.");

    view2131230913.setOnClickListener(null);
    view2131230913 = null;
    view2131230961.setOnClickListener(null);
    view2131230961 = null;

    this.target = null;
  }
}
