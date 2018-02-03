// Generated code from Butter Knife. Do not modify!
package com.sd.storage.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplitBarAdapter$ViewDearHolder_ViewBinding<T extends SplitBarAdapter.ViewDearHolder> implements Unbinder {
  protected T target;

  @UiThread
  public SplitBarAdapter$ViewDearHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_BARCODE = Utils.findRequiredViewAsType(source, R.id.tv_BARCODE, "field 'tv_BARCODE'", TextView.class);
    target.tv_position = Utils.findRequiredViewAsType(source, R.id.tv_position, "field 'tv_position'", TextView.class);
    target.tv_BARQTY = Utils.findRequiredViewAsType(source, R.id.tv_BARQTY, "field 'tv_BARQTY'", TextView.class);
    target.tv_delt = Utils.findRequiredViewAsType(source, R.id.tv_delt, "field 'tv_delt'", TextView.class);
    target.v_item = Utils.findRequiredViewAsType(source, R.id.v_item, "field 'v_item'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_BARCODE = null;
    target.tv_position = null;
    target.tv_BARQTY = null;
    target.tv_delt = null;
    target.v_item = null;

    this.target = null;
  }
}
