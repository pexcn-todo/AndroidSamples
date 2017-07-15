package me.pexcn.android.samples.fixes;

import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.base.BaseActivity;

public class ListNestedScrollActivity extends BaseActivity {
    @SuppressWarnings("FieldCanBeLocal")
    private ListView mListView;
    @SuppressWarnings("FieldCanBeLocal")
    private List<String> mItems;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fixes_list_nested_scroll;
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

        mListView.setOnTouchListener((v, event) -> {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case MotionEvent.ACTION_UP:
                    v.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
            }
            v.onTouchEvent(event);
            return true;
        });
    }
}
