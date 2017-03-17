package me.pexcn.demos.rxjava;

import android.content.Intent;

import java.util.Arrays;
import java.util.List;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseListActivity;

/**
 * Created by pexcn on 2017-03-17.
 */
public class RxJavaActivity extends BaseListActivity {
    @Override
    public List<String> getList() {
        return Arrays.asList(getResources().getStringArray(R.array.activity_titles_sub_rxjava));
    }

    @Override
    public void setUpSubActivity(Intent intent, int position) {
        switch (position) {
            case 0:
                intent.setClass(this, RxJavaSubscribeAndObserverActivity.class);
                break;
            case 1:
                intent.setClass(this, RxPermissionsActivity.class);
                break;
        }
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
