package me.pexcn.demos.recyclerview;

import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;

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

    @SuppressWarnings("WeakerAccess")
    public static class PullToRefreshAdapter extends RecyclerView.Adapter<PullToRefreshAdapter.TextViewHolder> {
        private ArrayList<String> mItems = new ArrayList<>();

        @Override
        public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new TextViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TextViewHolder holder, int position) {
            holder.setText(mItems.get(position));
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class TextViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;

            public TextViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(android.R.id.text1);
            }

            public void setText(CharSequence text) {
                mTextView.setText(text);
            }
        }

        public void init() {
            for (int i = 0; i < 50; i++) {
                mItems.add("Item " + i);
            }
        }

        public void add(String text) {
            mItems.add(text);
            notifyItemInserted(mItems.size());
        }

        public void add(int index, String text) {
            mItems.add(index, text);
            notifyItemInserted(index);
        }
    }
}
