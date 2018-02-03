// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main;

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

public class CartFragmentV3_ViewBinding<T extends CartFragmentV3> implements Unbinder {
  protected T target;

  private View view2131230955;

  private View view2131230936;

  @UiThread
  public CartFragmentV3_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_weixin, "field 'tv_weixin' and method 'onClick'");
    target.tv_weixin = Utils.castView(view, R.id.tv_weixin, "field 'tv_weixin'", TextView.class);
    view2131230955 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_qq, "field 'tv_qq' and method 'onClick'");
    target.tv_qq = Utils.castView(view, R.id.tv_qq, "field 'tv_qq'", TextView.class);
    view2131230936 = view;
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

    target.tv_weixin = null;
    target.tv_qq = null;

    view2131230955.setOnClickListener(null);
    view2131230955 = null;
    view2131230936.setOnClickListener(null);
    view2131230936 = null;

    this.target = null;
  }
}
