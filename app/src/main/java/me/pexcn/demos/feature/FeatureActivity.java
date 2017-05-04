package me.pexcn.demos.feature;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseListActivity;

/**
 * Created by pexcn on 2017-03-17.
 */
public class FeatureActivity extends BaseListActivity {
    @Override
    public String[] getActivityList() {
        return getResources().getStringArray(R.array.activity_titles_sub_feature);
    }

    @Override
    protected void startSubActivity(int position) {
        switch (position) {
            case 0:
                setSubActivity(position, ChromeCustomTabsActivity.class);
                break;
            case 1:
                setSubActivity(position, RequestPermissionActivity.class);
                break;
            case 2:
                setSubActivity(position, SwipeBackLayoutActivity.class);
                break;
            case 3:
                setSubActivity(position, TransparentNavBarActivity.class);
                break;
            case 4:
                setSubActivity(position, GridView9PalaceGridActivity.class);
                break;
            case 5:
                setSubActivity(position, RecyclerView9PalaceGridActivity.class);
                break;
            case 6:
                setSubActivity(position, BottomSheetDialogActivity.class);
                break;
            case 7:
                setSubActivity(position, LruCacheActivity.class);
                break;
            case 8:
                setSubActivity(position, DiskLruCacheActivity.class);
                break;
        }
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
