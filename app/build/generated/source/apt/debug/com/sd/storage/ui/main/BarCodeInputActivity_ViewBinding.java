// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main;

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

public class BarCodeInputActivity_ViewBinding<T extends BarCodeInputActivity> implements Unbinder {
  protected T target;

  private View view2131230905;

  private View view2131230927;

  private View view2131230940;

  private View view2131230935;

  private View view2131230804;

  @UiThread
  public BarCodeInputActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    target.tv_page_show = Utils.findRequiredViewAsType(source, R.id.tv_page_show, "field 'tv_page_show'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_back_page, "field 'tv_back_page' and method 'onClick'");
    target.tv_back_page = Utils.castView(view, R.id.tv_back_page, "field 'tv_back_page'", TextView.class);
    view2131230905 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_next_page, "field 'tv_next_page' and method 'onClick'");
    target.tv_next_page = Utils.castView(view, R.id.tv_next_page, "field 'tv_next_page'", TextView.class);
    view2131230927 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
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
    target.tv_gz_str = Utils.findRequiredViewAsType(source, R.id.tv_gz_str, "field 'tv_gz_str'", TextView.class);
    target.et_input_bar = Utils.findRequiredViewAsType(source, R.id.et_input_bar, "field 'et_input_bar'", EditText.class);
    target.tv_have_number = Utils.findRequiredViewAsType(source, R.id.tv_have_number, "field 'tv_have_number'", TextView.class);
    target.tv_price = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tv_price'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_put_goods, "field 'tv_put_goods' and method 'onClick'");
    target.tv_put_goods = Utils.castView(view, R.id.tv_put_goods, "field 'tv_put_goods'", TextView.class);
    view2131230935 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
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
    target.tv_page_show = null;
    target.tv_back_page = null;
    target.tv_next_page = null;
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
    target.tv_gz_str = null;
    target.et_input_bar = null;
    target.tv_have_number = null;
    target.tv_price = null;
    target.tv_put_goods = null;

    view2131230905.setOnClickListener(null);
    view2131230905 = null;
    view2131230927.setOnClickListener(null);
    view2131230927 = null;
    view2131230940.setOnClickListener(null);
    view2131230940 = null;
    view2131230935.setOnClickListener(null);
    view2131230935 = null;
    view2131230804.setOnClickListener(null);
    view2131230804 = null;

    this.target = null;
  }
}
