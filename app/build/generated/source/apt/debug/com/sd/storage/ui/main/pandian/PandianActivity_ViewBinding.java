// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main.pandian;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PandianActivity_ViewBinding<T extends PandianActivity> implements Unbinder {
  protected T target;

  private View view2131230802;

  @UiThread
  public PandianActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    target.et_number = Utils.findRequiredViewAsType(source, R.id.et_number, "field 'et_number'", EditText.class);
    target.tv_select = Utils.findRequiredViewAsType(source, R.id.tv_select, "field 'tv_select'", TextView.class);
    target.tv_supplier = Utils.findRequiredViewAsType(source, R.id.tv_supplier, "field 'tv_supplier'", TextView.class);
    target.tv_department = Utils.findRequiredViewAsType(source, R.id.tv_department, "field 'tv_department'", TextView.class);
    target.tv_product_name = Utils.findRequiredViewAsType(source, R.id.tv_product_name, "field 'tv_product_name'", TextView.class);
    target.tv_specifications = Utils.findRequiredViewAsType(source, R.id.tv_specifications, "field 'tv_specifications'", TextView.class);
    target.tv_storage_location = Utils.findRequiredViewAsType(source, R.id.tv_storage_location, "field 'tv_storage_location'", TextView.class);
    target.tv_vender = Utils.findRequiredViewAsType(source, R.id.tv_vender, "field 'tv_vender'", TextView.class);
    target.tv_batch_number = Utils.findRequiredViewAsType(source, R.id.tv_batch_number, "field 'tv_batch_number'", TextView.class);
    target.tv_validity_time = Utils.findRequiredViewAsType(source, R.id.tv_validity_time, "field 'tv_validity_time'", TextView.class);
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
    target.et_number = null;
    target.tv_select = null;
    target.tv_supplier = null;
    target.tv_department = null;
    target.tv_product_name = null;
    target.tv_specifications = null;
    target.tv_storage_location = null;
    target.tv_vender = null;
    target.tv_batch_number = null;
    target.tv_validity_time = null;

    view2131230802.setOnClickListener(null);
    view2131230802 = null;

    this.target = null;
  }
}
