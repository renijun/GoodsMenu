// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PutInStorageActivity_ViewBinding<T extends PutInStorageActivity> implements Unbinder {
  protected T target;

  private View view2131230905;

  private View view2131230927;

  private View view2131230940;

  private View view2131230911;

  private View view2131230904;

  private View view2131230804;

  @UiThread
  public PutInStorageActivity_ViewBinding(final T target, View source) {
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
    target.et_wait_check = Utils.findRequiredViewAsType(source, R.id.et_wait_check, "field 'et_wait_check'", EditText.class);
    target.tv_have_check = Utils.findRequiredViewAsType(source, R.id.tv_have_check, "field 'tv_have_check'", TextView.class);
    target.tv_have_refuse = Utils.findRequiredViewAsType(source, R.id.tv_have_refuse, "field 'tv_have_refuse'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_check_str, "field 'tv_check_str' and method 'onClick'");
    target.tv_check_str = Utils.castView(view, R.id.tv_check_str, "field 'tv_check_str'", TextView.class);
    view2131230911 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_all_refuse, "field 'tv_all_refuse' and method 'onClick'");
    target.tv_all_refuse = Utils.castView(view, R.id.tv_all_refuse, "field 'tv_all_refuse'", TextView.class);
    view2131230904 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv_some_refuse = Utils.findRequiredViewAsType(source, R.id.tv_some_refuse, "field 'tv_some_refuse'", TextView.class);
    target.tv_TOTQTY = Utils.findRequiredViewAsType(source, R.id.tv_TOTQTY, "field 'tv_TOTQTY'", TextView.class);
    target.unitname_inprc = Utils.findRequiredViewAsType(source, R.id.unitname_inprc, "field 'unitname_inprc'", TextView.class);
    target.v_scrollview = Utils.findRequiredViewAsType(source, R.id.v_scrollview, "field 'v_scrollview'", ScrollView.class);
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
    target.et_wait_check = null;
    target.tv_have_check = null;
    target.tv_have_refuse = null;
    target.tv_check_str = null;
    target.tv_all_refuse = null;
    target.tv_some_refuse = null;
    target.tv_TOTQTY = null;
    target.unitname_inprc = null;
    target.v_scrollview = null;

    view2131230905.setOnClickListener(null);
    view2131230905 = null;
    view2131230927.setOnClickListener(null);
    view2131230927 = null;
    view2131230940.setOnClickListener(null);
    view2131230940 = null;
    view2131230911.setOnClickListener(null);
    view2131230911 = null;
    view2131230904.setOnClickListener(null);
    view2131230904 = null;
    view2131230804.setOnClickListener(null);
    view2131230804 = null;

    this.target = null;
  }
}
