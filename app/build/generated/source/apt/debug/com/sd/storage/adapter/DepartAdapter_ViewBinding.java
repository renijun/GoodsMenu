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

public class DepartAdapter_ViewBinding<T extends DepartAdapter> implements Unbinder {
  protected T target;

  private View view2131230910;

  private View view2131230803;

  @UiThread
  public DepartAdapter_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_item, "method 'onClick'");
    view2131230910 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.im_point, "method 'onClick'");
    view2131230803 = view;
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

    view2131230910.setOnClickListener(null);
    view2131230910 = null;
    view2131230803.setOnClickListener(null);
    view2131230803 = null;

    this.target = null;
  }
}
