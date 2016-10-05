package me.pexcn.demos.base;

import me.pexcn.simpleutils.base.AbsBaseActivity;

/**
 * Created by pexcn on 2016-10-04.
 */
public abstract class BaseActivity extends AbsBaseActivity {
    @Override
    protected void init() {
        if (getSupportActionBar() != null && getIntent() != null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra("activity_title"));
        }
    }
}
