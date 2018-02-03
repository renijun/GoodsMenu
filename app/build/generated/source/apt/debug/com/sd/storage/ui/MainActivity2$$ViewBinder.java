// Generated code from Butter Knife. Do not modify!
package com.sd.storage.ui;

import android.content.res.Resources;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.sd.storage.ui.main.BaseTabActivity$$ViewBinder;
import java.lang.Object;
import java.lang.Override;
import java.lang.SuppressWarnings;

public class MainActivity2$$ViewBinder<T extends MainActivity2> extends BaseTabActivity$$ViewBinder<T> {
  @Override
  @SuppressWarnings("ResourceType")
  public Unbinder bind(final Finder finder, final T target, Object source) {
    Unbinder unbinder = super.bind(finder, target, source);
    Resources res = finder.getContext(source).getResources();
    target.mMainTabTitle = res.getStringArray(2131492864);
    return unbinder;
  }
}
