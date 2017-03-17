package me.pexcn.demos.base;

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
        final String title;
        final ActionBar actionBar;
        if ((actionBar = getSupportActionBar()) != null
                && (title = getIntent().getStringExtra(KEY_ACTIVITY_TITLE)) != null
                && isSubActivity()) {
            actionBar.setTitle(title);
        }
    }
}
