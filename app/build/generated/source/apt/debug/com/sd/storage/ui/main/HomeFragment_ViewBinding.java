// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding<T extends HomeFragment> implements Unbinder {
  protected T target;

  private View view2131230815;

  private View view2131230811;

  private View view2131230816;

  private View view2131230814;

  private View view2131230812;

  @UiThread
  public HomeFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lin_put_in, "field 'linPutIn' and method 'onClick'");
    target.linPutIn = Utils.castView(view, R.id.lin_put_in, "field 'linPutIn'", LinearLayout.class);
    view2131230815 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv_home_title = Utils.findRequiredViewAsType(source, R.id.tv_home_title, "field 'tv_home_title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lin_barcode_input, "method 'onClick'");
    view2131230811 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_split_bar, "method 'onClick'");
    view2131230816 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_pan_dian, "method 'onClick'");
    view2131230814 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_code_goods, "method 'onClick'");
    view2131230812 = view;
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

    target.linPutIn = null;
    target.tv_home_title = null;

    view2131230815.setOnClickListener(null);
    view2131230815 = null;
    view2131230811.setOnClickListener(null);
    view2131230811 = null;
    view2131230816.setOnClickListener(null);
    view2131230816 = null;
    view2131230814.setOnClickListener(null);
    view2131230814 = null;
    view2131230812.setOnClickListener(null);
    view2131230812 = null;

    this.target = null;
  }
}
