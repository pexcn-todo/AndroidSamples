package me.pexcn.android.samples.fixes;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.BaseActivity;

public class NestedScrollViewActivity extends BaseActivity {
    @SuppressWarnings("FieldCanBeLocal")
    private ListView mListView;
    @SuppressWarnings("FieldCanBeLocal")
    private List<String> mItems;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fixes_nested_scroll_view;
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }

    @Override
    protected void init() {
        super.init();

        mItems = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mItems.add("Item " + i);
        }

        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItems));
        mListView.setNestedScrollingEnabled(true);
    }
}
