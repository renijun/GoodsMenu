// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.main;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class PutInStorageActivity$$ViewBinder<T extends PutInStorageActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558558, "field 'tv_title'");
    target.tv_title = finder.castView(view, 2131558558, "field 'tv_title'");
    view = finder.findRequiredView(source, 2131558514, "field 'tv_page_show'");
    target.tv_page_show = finder.castView(view, 2131558514, "field 'tv_page_show'");
    view = finder.findRequiredView(source, 2131558513, "field 'tv_back_page' and method 'onClick'");
    target.tv_back_page = finder.castView(view, 2131558513, "field 'tv_back_page'");
    unbinder.view2131558513 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558515, "field 'tv_next_page' and method 'onClick'");
    target.tv_next_page = finder.castView(view, 2131558515, "field 'tv_next_page'");
    unbinder.view2131558515 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558516, "field 'et_number'");
    target.et_number = finder.castView(view, 2131558516, "field 'et_number'");
    view = finder.findRequiredView(source, 2131558517, "field 'tv_select' and method 'onClick'");
    target.tv_select = finder.castView(view, 2131558517, "field 'tv_select'");
    unbinder.view2131558517 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558518, "field 'tv_supplier'");
    target.tv_supplier = finder.castView(view, 2131558518, "field 'tv_supplier'");
    view = finder.findRequiredView(source, 2131558519, "field 'tv_department'");
    target.tv_department = finder.castView(view, 2131558519, "field 'tv_department'");
    view = finder.findRequiredView(source, 2131558520, "field 'tv_product_name'");
    target.tv_product_name = finder.castView(view, 2131558520, "field 'tv_product_name'");
    view = finder.findRequiredView(source, 2131558521, "field 'tv_specifications'");
    target.tv_specifications = finder.castView(view, 2131558521, "field 'tv_specifications'");
    view = finder.findRequiredView(source, 2131558522, "field 'tv_storage_location'");
    target.tv_storage_location = finder.castView(view, 2131558522, "field 'tv_storage_location'");
    view = finder.findRequiredView(source, 2131558523, "field 'tv_vender'");
    target.tv_vender = finder.castView(view, 2131558523, "field 'tv_vender'");
    view = finder.findRequiredView(source, 2131558524, "field 'tv_batch_number'");
    target.tv_batch_number = finder.castView(view, 2131558524, "field 'tv_batch_number'");
    view = finder.findRequiredView(source, 2131558525, "field 'tv_validity_time'");
    target.tv_validity_time = finder.castView(view, 2131558525, "field 'tv_validity_time'");
    view = finder.findRequiredView(source, 2131558526, "field 'tv_gz_str'");
    target.tv_gz_str = finder.castView(view, 2131558526, "field 'tv_gz_str'");
    view = finder.findRequiredView(source, 2131558548, "field 'et_wait_check'");
    target.et_wait_check = finder.castView(view, 2131558548, "field 'et_wait_check'");
    view = finder.findRequiredView(source, 2131558546, "field 'tv_have_check'");
    target.tv_have_check = finder.castView(view, 2131558546, "field 'tv_have_check'");
    view = finder.findRequiredView(source, 2131558547, "field 'tv_have_refuse'");
    target.tv_have_refuse = finder.castView(view, 2131558547, "field 'tv_have_refuse'");
    view = finder.findRequiredView(source, 2131558549, "field 'tv_check_str' and method 'onClick'");
    target.tv_check_str = finder.castView(view, 2131558549, "field 'tv_check_str'");
    unbinder.view2131558549 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558551, "field 'tv_all_refuse' and method 'onClick'");
    target.tv_all_refuse = finder.castView(view, 2131558551, "field 'tv_all_refuse'");
    unbinder.view2131558551 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131558552, "field 'tv_some_refuse'");
    target.tv_some_refuse = finder.castView(view, 2131558552, "field 'tv_some_refuse'");
    view = finder.findRequiredView(source, 2131558550, "field 'tv_TOTQTY'");
    target.tv_TOTQTY = finder.castView(view, 2131558550, "field 'tv_TOTQTY'");
    view = finder.findRequiredView(source, 2131558545, "field 'v_scrollview'");
    target.v_scrollview = finder.castView(view, 2131558545, "field 'v_scrollview'");
    view = finder.findRequiredView(source, 2131558559, "method 'onClick'");
    unbinder.view2131558559 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends PutInStorageActivity> implements Unbinder {
    private T target;

    View view2131558513;

    View view2131558515;

    View view2131558517;

    View view2131558549;

    View view2131558551;

    View view2131558559;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.tv_title = null;
      target.tv_page_show = null;
      view2131558513.setOnClickListener(null);
      target.tv_back_page = null;
      view2131558515.setOnClickListener(null);
      target.tv_next_page = null;
      target.et_number = null;
      view2131558517.setOnClickListener(null);
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
      view2131558549.setOnClickListener(null);
      target.tv_check_str = null;
      view2131558551.setOnClickListener(null);
      target.tv_all_refuse = null;
      target.tv_some_refuse = null;
      target.tv_TOTQTY = null;
      target.v_scrollview = null;
      view2131558559.setOnClickListener(null);
    }
  }
}