package me.pexcn.android.samples.recyclerview;

import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.BaseActivity;

/**
 * Created by pexcn on 2017-03-22.
 */
public class XRecyclerViewActivity extends BaseActivity {
    private XRecyclerView mXRecyclerView;
    private ArrayList<String> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter() {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((TextView) holder.itemView).setText(mItems.get(position));
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ViewHolder(View itemView) {
                super(itemView);
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recyclerview_x_recycler_view;
    }

    @Override
    protected void init() {
        super.init();

        for (int i = 0; i < 50; i++) {
            mItems.add("Item " + i);
        }

        mXRecyclerView = (XRecyclerView) findViewById(R.id.x_recycler_view);
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mXRecyclerView.setAdapter(mAdapter);
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Thread(() -> {
                    SystemClock.sleep(1500);
                    mItems.add(0, "New Item");
                    runOnUiThread(() -> {
                        mAdapter.notifyItemInserted(0);
                        mXRecyclerView.refreshComplete();
                    });
                }).start();
            }

            @Override
            public void onLoadMore() {
                new Thread(() -> {
                    SystemClock.sleep(1500);
                    mItems.add("Load More");
                    runOnUiThread(() -> {
                        mAdapter.notifyItemInserted(mItems.size());
                        mXRecyclerView.loadMoreComplete();
                    });
                }).start();
            }
        });
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
