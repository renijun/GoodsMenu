// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  private View view2131230818;

  private View view2131230817;

  private View view2131230816;

  private View view2131230815;

  private View view2131230931;

  @UiThread
  public MainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lin_weekMenu, "field 'lin_weekMenu' and method 'onClick'");
    target.lin_weekMenu = Utils.castView(view, R.id.lin_weekMenu, "field 'lin_weekMenu'", LinearLayout.class);
    view2131230818 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_meunVote, "field 'lin_meunVote' and method 'onClick'");
    target.lin_meunVote = Utils.castView(view, R.id.lin_meunVote, "field 'lin_meunVote'", LinearLayout.class);
    view2131230817 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_meunOrder, "field 'lin_meunOrder' and method 'onClick'");
    target.lin_meunOrder = Utils.castView(view, R.id.lin_meunOrder, "field 'lin_meunOrder'", LinearLayout.class);
    view2131230816 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_meunMannage, "field 'lin_meunMannage' and method 'onClick'");
    target.lin_meunMannage = Utils.castView(view, R.id.lin_meunMannage, "field 'lin_meunMannage'", LinearLayout.class);
    view2131230815 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_order, "method 'onClick'");
    view2131230931 = view;
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

    target.lin_weekMenu = null;
    target.lin_meunVote = null;
    target.lin_meunOrder = null;
    target.lin_meunMannage = null;

    view2131230818.setOnClickListener(null);
    view2131230818 = null;
    view2131230817.setOnClickListener(null);
    view2131230817 = null;
    view2131230816.setOnClickListener(null);
    view2131230816 = null;
    view2131230815.setOnClickListener(null);
    view2131230815 = null;
    view2131230931.setOnClickListener(null);
    view2131230931 = null;

    this.target = null;
  }
}
