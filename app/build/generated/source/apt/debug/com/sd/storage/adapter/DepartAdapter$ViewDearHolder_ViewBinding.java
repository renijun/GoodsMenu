// Generated code from Butter Knife. Do not modify!
package com.sd.storage.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DepartAdapter$ViewDearHolder_ViewBinding<T extends DepartAdapter.ViewDearHolder> implements Unbinder {
  protected T target;

  @UiThread
  public DepartAdapter$ViewDearHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_item = Utils.findRequiredViewAsType(source, R.id.tv_item, "field 'tv_item'", TextView.class);
    target.im_point = Utils.findRequiredViewAsType(source, R.id.im_point, "field 'im_point'", ImageView.class);
    target.lin_item = Utils.findRequiredViewAsType(source, R.id.lin_item, "field 'lin_item'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_item = null;
    target.im_point = null;
    target.lin_item = null;

    this.target = null;
  }
}
