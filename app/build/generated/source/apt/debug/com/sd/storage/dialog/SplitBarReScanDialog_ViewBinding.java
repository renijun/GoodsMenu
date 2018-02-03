// Generated code from Butter Knife. Do not modify!
package com.sd.storage.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplitBarReScanDialog_ViewBinding<T extends SplitBarReScanDialog> implements Unbinder {
  protected T target;

  private View view2131230947;

  private View view2131230910;

  @UiThread
  public SplitBarReScanDialog_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tv_content = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tv_content'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_sure, "method 'onClick'");
    view2131230947 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel, "method 'onClick'");
    view2131230910 = view;
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
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_content = null;

    view2131230947.setOnClickListener(null);
    view2131230947 = null;
    view2131230910.setOnClickListener(null);
    view2131230910 = null;

    this.target = null;
  }
}