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

public class SplitSonFragment_ViewBinding<T extends SplitSonFragment> implements Unbinder {
  protected T target;

  private View view2131230945;

  private View view2131230937;

  @UiThread
  public SplitSonFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.v_list = Utils.findRequiredViewAsType(source, R.id.v_list, "field 'v_list'", ListView.class);
    target.v_empty = Utils.findRequiredViewAsType(source, R.id.v_empty, "field 'v_empty'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'tv_submit' and method 'onClick'");
    target.tv_submit = Utils.castView(view, R.id.tv_submit, "field 'tv_submit'", TextView.class);
    view2131230945 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_re_scan, "field 'tv_re_scan' and method 'onClick'");
    target.tv_re_scan = Utils.castView(view, R.id.tv_re_scan, "field 'tv_re_scan'", TextView.class);
    view2131230937 = view;
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

    target.v_list = null;
    target.v_empty = null;
    target.tv_submit = null;
    target.tv_re_scan = null;

    view2131230945.setOnClickListener(null);
    view2131230945 = null;
    view2131230937.setOnClickListener(null);
    view2131230937 = null;

    this.target = null;
  }
}
