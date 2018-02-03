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

public class PandianFragment_ViewBinding<T extends PandianFragment> implements Unbinder {
  protected T target;

  private View view2131230940;

  private View view2131230947;

  @UiThread
  public PandianFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.et_number = Utils.findRequiredViewAsType(source, R.id.et_number, "field 'et_number'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_select, "field 'tv_select' and method 'onClick'");
    target.tv_select = Utils.castView(view, R.id.tv_select, "field 'tv_select'", TextView.class);
    view2131230940 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv_supplier = Utils.findRequiredViewAsType(source, R.id.tv_supplier, "field 'tv_supplier'", TextView.class);
    target.tv_department = Utils.findRequiredViewAsType(source, R.id.tv_department, "field 'tv_department'", TextView.class);
    target.tv_product_name = Utils.findRequiredViewAsType(source, R.id.tv_product_name, "field 'tv_product_name'", TextView.class);
    target.tv_specifications = Utils.findRequiredViewAsType(source, R.id.tv_specifications, "field 'tv_specifications'", TextView.class);
    target.tv_storage_location = Utils.findRequiredViewAsType(source, R.id.tv_storage_location, "field 'tv_storage_location'", TextView.class);
    target.tv_vender = Utils.findRequiredViewAsType(source, R.id.tv_vender, "field 'tv_vender'", TextView.class);
    target.tv_batch_number = Utils.findRequiredViewAsType(source, R.id.tv_batch_number, "field 'tv_batch_number'", TextView.class);
    target.tv_validity_time = Utils.findRequiredViewAsType(source, R.id.tv_validity_time, "field 'tv_validity_time'", TextView.class);
    target.tv_have_all = Utils.findRequiredViewAsType(source, R.id.tv_have_all, "field 'tv_have_all'", TextView.class);
    target.tv_unit = Utils.findRequiredViewAsType(source, R.id.tv_unit, "field 'tv_unit'", TextView.class);
    target.tv_pandian_situation = Utils.findRequiredViewAsType(source, R.id.tv_pandian_situation, "field 'tv_pandian_situation'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_sure, "field 'tv_sure' and method 'onClick'");
    target.tv_sure = Utils.castView(view, R.id.tv_sure, "field 'tv_sure'", TextView.class);
    view2131230947 = view;
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
    target.tv_have_all = null;
    target.tv_unit = null;
    target.tv_pandian_situation = null;
    target.tv_sure = null;

    view2131230940.setOnClickListener(null);
    view2131230940 = null;
    view2131230947.setOnClickListener(null);
    view2131230947 = null;

    this.target = null;
  }
}
