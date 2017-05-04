package me.pexcn.android.samples.customview;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.BaseListActivity;

/**
 * Created by pexcn on 2017-03-17.
 */
public class CustomViewActivity extends BaseListActivity {
    @Override
    public String[] getActivityList() {
        return getResources().getStringArray(R.array.activity_titles_sub_customview);
    }

    @Override
    protected void startSubActivity(int position) {
        switch (position) {
            case 0:
                setSubActivity(position, CoordinateSystemActivity.class);
                break;
        }
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
