package me.pexcn.demos.feature;

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
    @Override
    protected int getLayoutId() {
        return R.layout.activity_feature_transparent_nav_bar;
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void init() {
        super.init();
        ListView listView = (ListView) findViewById(R.id.list_view);
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add("Item " + i);
        }
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Toolbar fixes
            AppBarLayout layout = (AppBarLayout) (findViewById(R.id.toolbar).getParent());
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

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
