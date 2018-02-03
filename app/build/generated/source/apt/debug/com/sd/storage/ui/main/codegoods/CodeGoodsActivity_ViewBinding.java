// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main.codegoods;

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

public class CodeGoodsActivity_ViewBinding<T extends CodeGoodsActivity> implements Unbinder {
  protected T target;

  private View view2131230804;

  private View view2131230940;

  @UiThread
  public CodeGoodsActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    target.et_number = Utils.findRequiredViewAsType(source, R.id.et_number, "field 'et_number'", EditText.class);
    target.tv_send_depart = Utils.findRequiredViewAsType(source, R.id.tv_send_depart, "field 'tv_send_depart'", TextView.class);
    target.tv_please_departmentd = Utils.findRequiredViewAsType(source, R.id.tv_please_departmentd, "field 'tv_please_departmentd'", TextView.class);
    target.tv_product_name = Utils.findRequiredViewAsType(source, R.id.tv_product_name, "field 'tv_product_name'", TextView.class);
    target.tv_specifications = Utils.findRequiredViewAsType(source, R.id.tv_specifications, "field 'tv_specifications'", TextView.class);
    target.tv_storage_location = Utils.findRequiredViewAsType(source, R.id.tv_storage_location, "field 'tv_storage_location'", TextView.class);
    target.tv_vender = Utils.findRequiredViewAsType(source, R.id.tv_vender, "field 'tv_vender'", TextView.class);
    target.tv_have_all = Utils.findRequiredViewAsType(source, R.id.tv_have_all, "field 'tv_have_all'", TextView.class);
    target.tv_unit = Utils.findRequiredViewAsType(source, R.id.tv_unit, "field 'tv_unit'", TextView.class);
    target.et_bar_number = Utils.findRequiredViewAsType(source, R.id.et_bar_number, "field 'et_bar_number'", EditText.class);
    target.tv_number = Utils.findRequiredViewAsType(source, R.id.tv_number, "field 'tv_number'", TextView.class);
    target.tv_batch_number = Utils.findRequiredViewAsType(source, R.id.tv_batch_number, "field 'tv_batch_number'", TextView.class);
    target.tv_validity_time = Utils.findRequiredViewAsType(source, R.id.tv_validity_time, "field 'tv_validity_time'", TextView.class);
    view = Utils.findRequiredView(source, R.id.im_back, "method 'onClick'");
    view2131230804 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_select, "method 'onClick'");
    view2131230940 = view;
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
    target.tv_send_depart = null;
    target.tv_please_departmentd = null;
    target.tv_product_name = null;
    target.tv_specifications = null;
    target.tv_storage_location = null;
    target.tv_vender = null;
    target.tv_have_all = null;
    target.tv_unit = null;
    target.et_bar_number = null;
    target.tv_number = null;
    target.tv_batch_number = null;
    target.tv_validity_time = null;

    view2131230804.setOnClickListener(null);
    view2131230804 = null;
    view2131230940.setOnClickListener(null);
    view2131230940 = null;

    this.target = null;
  }
}
