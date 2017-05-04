package me.pexcn.demos;

import me.pexcn.demos.base.BaseListActivity;
import me.pexcn.demos.customview.CustomViewActivity;
import me.pexcn.demos.feature.FeatureActivity;
import me.pexcn.demos.fixes.FixesActivity;
import me.pexcn.demos.recyclerview.RecyclerViewActivity;
import me.pexcn.demos.rxjava.RxJavaActivity;

public class MainActivity extends BaseListActivity {
    @Override
    public String[] getActivityList() {
        return getResources().getStringArray(R.array.activity_titles_top);
    }

    @Override
    protected void startSubActivity(int position) {
        switch (position) {
            case 0:
                setSubActivity(position, FeatureActivity.class);
                break;
            case 1:
                setSubActivity(position, FixesActivity.class);
                break;
            case 2:
                setSubActivity(position, RxJavaActivity.class);
                break;
            case 3:
                setSubActivity(position, CustomViewActivity.class);
                break;
            case 4:
                setSubActivity(position, RecyclerViewActivity.class);
                break;
        }
    }
}
