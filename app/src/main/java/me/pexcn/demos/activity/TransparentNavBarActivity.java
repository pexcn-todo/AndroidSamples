package me.pexcn.demos.activity;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;

/**
 * Created by pexcn on 2016-10-19.
 */
public class TransparentNavBarActivity extends BaseActivity {
    @SuppressWarnings("FieldCanBeLocal")
    private ListView mListView;
    @SuppressWarnings("FieldCanBeLocal")
    private List<String> mItems;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_transparent_navbar;
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void init() {
        super.init();
        mListView = (ListView) findViewById(R.id.listview);
        mItems = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mItems.add("Item " + i);
        }
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItems));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }
    }
}
