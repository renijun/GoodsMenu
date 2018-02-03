// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui;

import android.content.res.Resources;
import android.support.annotation.UiThread;
import android.view.View;
import com.sd.storage.R;
import com.sd.storage.ui.main.BaseTabActivity_ViewBinding;

public class MainActivity2_ViewBinding<T extends MainActivity2> extends BaseTabActivity_ViewBinding<T> {
  @UiThread
  public MainActivity2_ViewBinding(T target, View source) {
    super(target, source);

    Resources res = source.getResources();
    target.mMainTabTitle = res.getStringArray(R.array.tab_main_temp);
  }
}
