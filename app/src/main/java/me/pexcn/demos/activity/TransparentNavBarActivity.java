package me.pexcn.demos.activity;

import android.os.Build;
import android.support.design.widget.AppBarLayout;
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
            // Toolbar fixes
            AppBarLayout layout = (AppBarLayout) (mToolbar.getParent());
            layout.setPadding(0, getStatusBarHeight(), 0, 0);

//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
//            window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));

//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
