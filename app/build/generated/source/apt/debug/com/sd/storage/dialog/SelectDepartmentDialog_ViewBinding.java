// Generated code from Butter Knife. Do not modify!
package com.sd.storage.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sd.storage.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectDepartmentDialog_ViewBinding<T extends SelectDepartmentDialog> implements Unbinder {
  protected T target;

  private View view2131230940;

  @UiThread
  public SelectDepartmentDialog_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.et_key = Utils.findRequiredViewAsType(source, R.id.et_key, "field 'et_key'", EditText.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.v_list, "field 'listView'", ListView.class);
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

    target.et_key = null;
    target.listView = null;

    view2131230940.setOnClickListener(null);
    view2131230940 = null;

    this.target = null;
  }
}
