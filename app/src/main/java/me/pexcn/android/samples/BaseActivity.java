package me.pexcn.android.samples;

import android.support.annotation.CallSuper;
import android.support.v7.app.ActionBar;

/**
 * Created by pexcn on 2016-10-04.
 */
public abstract class BaseActivity extends me.pexcn.android.base.ui.BaseActivity {
    public static final String KEY_ACTIVITY_TITLE = "activity_title";

    @CallSuper
    @Override
    protected void init() {
        final ActionBar actionBar = getSupportActionBar();
        final String title = getIntent().getStringExtra(KEY_ACTIVITY_TITLE);
        if (actionBar != null && title != null && isSubActivity()) {
            actionBar.setTitle(title);
        }
    }
}
