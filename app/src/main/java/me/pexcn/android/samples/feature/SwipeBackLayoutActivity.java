package me.pexcn.android.samples.feature;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RadioGroup;

import me.pexcn.android.samples.R;
import me.pexcn.android.utils.common.LogUtils;
import me.pexcn.android.utils.common.UIUtils;
import me.pexcn.swipebacklayout.SwipeBackLayout;
import me.pexcn.swipebacklayout.app.SwipeBackActivity;

public class SwipeBackLayoutActivity extends SwipeBackActivity {
    @SuppressWarnings("FieldCanBeLocal")
    private Toolbar mToolbar;
    @SuppressWarnings("FieldCanBeLocal")
    private RadioGroup mModeGroup;
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_swipe_back_layout);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getIntent().getStringExtra("activity_title"));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        AppBarLayout layout = (AppBarLayout) (mToolbar.getParent());
        layout.setPadding(0, UIUtils.getStatusBarHeight(), 0, 0);

        init();
    }

    private void init() {
        mModeGroup = (RadioGroup) findViewById(R.id.tracking_mode);
        mSwipeBackLayout = getSwipeBackLayout();

        mModeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int flag = SwipeBackLayout.EDGE_LEFT;
                switch (checkedId) {
                    case R.id.mode_left:
                        flag = SwipeBackLayout.EDGE_LEFT;
                        break;
                    case R.id.mode_right:
                        flag = SwipeBackLayout.EDGE_RIGHT;
                        break;
                    case R.id.mode_down:
                        flag = SwipeBackLayout.EDGE_BOTTOM;
                        break;
                    case R.id.mode_all:
                        flag = SwipeBackLayout.EDGE_ALL;
                        break;
                }
                mSwipeBackLayout.setEdgeTrackingEnabled(flag);
            }
        });

        mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onScrollStateChange(int state, float scrollPercent) {
                LogUtils.d("State: " + state + ", ScrollPercent: " + scrollPercent);
            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
                LogUtils.d("EdgeFlag: " + edgeFlag);
            }

            @Override
            public void onScrollOverThreshold() {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
