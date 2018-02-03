// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui.login;

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

public class LoginActivity_ViewBinding<T extends LoginActivity> implements Unbinder {
  protected T target;

  private View view2131230914;

  private View view2131230924;

  @UiThread
  public LoginActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_department, "field 'tvDepartment' and method 'onClick'");
    target.tvDepartment = Utils.castView(view, R.id.tv_department, "field 'tvDepartment'", TextView.class);
    view2131230914 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.etAccount = Utils.findRequiredViewAsType(source, R.id.et_account, "field 'etAccount'", EditText.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'etPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_login, "method 'onClick'");
    view2131230924 = view;
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

    target.tvDepartment = null;
    target.etAccount = null;
    target.etPassword = null;

    view2131230914.setOnClickListener(null);
    view2131230914 = null;
    view2131230924.setOnClickListener(null);
    view2131230924 = null;

    this.target = null;
  }
}
