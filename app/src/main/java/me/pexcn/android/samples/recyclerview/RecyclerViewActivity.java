package me.pexcn.android.samples.recyclerview;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.base.BaseListActivity;

/**
 * Created by pexcn on 2017-03-17.
 */
public class RecyclerViewActivity extends BaseListActivity {
    @Override
    public String[] getActivityList() {
        return getResources().getStringArray(R.array.activity_titles_sub_recyclerview);
    }

    @Override
    protected void startSubActivity(int position) {
        switch (position) {
            case 0:
                setSubActivity(position, PullToRefreshActivity.class);
                break;
            case 1:
                setSubActivity(position, XRecyclerViewActivity.class);
                break;
        }
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
