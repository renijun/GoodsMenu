// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  private View view2131230751;

  private View view2131230750;

  private View view2131230753;

  private View view2131230752;

  private View view2131230754;

  private View view2131230748;

  private View view2131230749;

  @UiThread
  public MainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_procurement_storage, "method 'onViewClicked'");
    view2131230751 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_procurement_exit_storage, "method 'onViewClicked'");
    view2131230750 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sell_storage, "method 'onViewClicked'");
    view2131230753 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sell_exit_storage, "method 'onViewClicked'");
    view2131230752 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_transfer_slip, "method 'onViewClicked'");
    view2131230754 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_check, "method 'onViewClicked'");
    view2131230748 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_exit, "method 'onViewClicked'");
    view2131230749 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;

    view2131230751.setOnClickListener(null);
    view2131230751 = null;
    view2131230750.setOnClickListener(null);
    view2131230750 = null;
    view2131230753.setOnClickListener(null);
    view2131230753 = null;
    view2131230752.setOnClickListener(null);
    view2131230752 = null;
    view2131230754.setOnClickListener(null);
    view2131230754 = null;
    view2131230748.setOnClickListener(null);
    view2131230748 = null;
    view2131230749.setOnClickListener(null);
    view2131230749 = null;

    this.target = null;
  }
}
