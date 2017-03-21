package me.pexcn.demos.recyclerview;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;

/**
 * Created by pexcn on 2017-03-21.
 */
public class PullToRefresh2Activity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recyclerview_pull_to_refresh_2;
    }

    @Override
    protected void init() {
        super.init();


    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
