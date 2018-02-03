// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main.pandian;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PandianMainActivity_ViewBinding<T extends PandianMainActivity> implements Unbinder {
  protected T target;

  private View view2131230804;

  @UiThread
  public PandianMainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    target.myViewPager = Utils.findRequiredViewAsType(source, R.id.myViewPager, "field 'myViewPager'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.im_back, "method 'onClick'");
    view2131230804 = view;
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
    target.myViewPager = null;

    view2131230804.setOnClickListener(null);
    view2131230804 = null;

    this.target = null;
  }
}
