// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main.splitbar;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplitBarSonActivity_ViewBinding<T extends SplitBarSonActivity> implements Unbinder {
  protected T target;

  private View view2131230927;

  private View view2131230921;

  private View view2131230802;

  @UiThread
  public SplitBarSonActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    target.v_list = Utils.findRequiredViewAsType(source, R.id.v_list, "field 'v_list'", ListView.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'tv_submit' and method 'onClick'");
    target.tv_submit = Utils.castView(view, R.id.tv_submit, "field 'tv_submit'", TextView.class);
    view2131230927 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_re_scan, "field 'tv_re_scan' and method 'onClick'");
    target.tv_re_scan = Utils.castView(view, R.id.tv_re_scan, "field 'tv_re_scan'", TextView.class);
    view2131230921 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.im_back, "method 'onClick'");
    view2131230802 = view;
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

    target.tv_title = null;
    target.v_list = null;
    target.tv_submit = null;
    target.tv_re_scan = null;

    view2131230927.setOnClickListener(null);
    view2131230927 = null;
    view2131230921.setOnClickListener(null);
    view2131230921 = null;
    view2131230802.setOnClickListener(null);
    view2131230802 = null;

    this.target = null;
  }
}
