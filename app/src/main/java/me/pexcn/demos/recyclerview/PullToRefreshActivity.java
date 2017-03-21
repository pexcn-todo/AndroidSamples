package me.pexcn.demos.recyclerview;

import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;
import me.pexcn.demos.recyclerview.adapter.PullToRefreshAdapter;

/**
 * Created by pexcn on 2017-03-21.
 */
public class PullToRefreshActivity extends BaseActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private PullToRefreshAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recyclerview_pull_to_refresh;
    }

    @Override
    protected void init() {
        super.init();

        mAdapter = new PullToRefreshAdapter();
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(() -> new Thread(() -> {
            SystemClock.sleep(1500);
            runOnUiThread(() -> {
                mAdapter.add(0, "New item");
                mRecyclerView.scrollToPosition(0);
                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            });
        }).start());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.init();
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
