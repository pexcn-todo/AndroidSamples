package me.pexcn.android.samples;

import me.pexcn.android.samples.base.BaseListActivity;
import me.pexcn.android.samples.customview.CustomViewActivity;
import me.pexcn.android.samples.feature.FeatureActivity;
import me.pexcn.android.samples.fixes.FixesActivity;
import me.pexcn.android.samples.recyclerview.RecyclerViewActivity;
import me.pexcn.android.samples.rxjava.RxJavaActivity;

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
