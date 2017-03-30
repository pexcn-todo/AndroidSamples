package me.pexcn.demos.feature;

import android.content.Intent;

import java.util.Arrays;
import java.util.List;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseListActivity;

/**
 * Created by pexcn on 2017-03-17.
 */
public class FeatureActivity extends BaseListActivity {
    @Override
    public List<String> getList() {
        return Arrays.asList(getResources().getStringArray(R.array.activity_titles_sub_feature));
    }

    @Override
    public void setUpSubActivity(Intent intent, int position) {
        switch (position) {
            case 0:
                intent.setClass(this, ChromeCustomTabsActivity.class);
                break;
            case 1:
                intent.setClass(this, RequestPermissionActivity.class);
                break;
            case 2:
                intent.setClass(this, SwipeBackLayoutActivity.class);
                break;
            case 3:
                intent.setClass(this, TransparentNavBarActivity.class);
                break;
            case 4:
                intent.setClass(this, GridView9PalaceGridActivity.class);
                break;
        }
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
