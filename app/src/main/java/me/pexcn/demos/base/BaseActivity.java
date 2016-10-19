package me.pexcn.demos.base;

import android.support.v7.app.ActionBar;

import me.pexcn.simpleutils.base.AbsBaseActivity;

/**
 * Created by pexcn on 2016-10-04.
 */
public abstract class BaseActivity extends AbsBaseActivity {
    @Override
    protected void init() {
        String title;
        ActionBar actionBar;
        if ((actionBar = getSupportActionBar()) != null && (title = getIntent().getStringExtra("activity_title")) != null && isSubActivity()) {
            actionBar.setTitle(title);
        }
    }
}
