package me.pexcn.demos;

import android.content.Intent;

import java.util.Arrays;
import java.util.List;

import me.pexcn.demos.base.BaseListActivity;
import me.pexcn.demos.feature.FeatureActivity;
import me.pexcn.demos.fixes.FixesActivity;
import me.pexcn.demos.rxjava.RxJavaActivity;

public class MainActivity extends BaseListActivity {
    @Override
    public List<String> getList() {
        return Arrays.asList(getResources().getStringArray(R.array.activity_titles_top));
    }

    @Override
    public void setUpSubActivity(Intent intent, int position) {
        switch (position) {
            case 0:
                intent.setClass(this, FeatureActivity.class);
                break;
            case 1:
                intent.setClass(this, FixesActivity.class);
                break;
            case 2:
                intent.setClass(this, RxJavaActivity.class);
                break;
        }
    }
}
