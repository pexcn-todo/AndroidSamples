package me.pexcn.demos;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import me.pexcn.demos.activities.ChromeCustomTabsActivity;
import me.pexcn.demos.activities.ListNestedScrollActivity;
import me.pexcn.demos.activities.NestedScrollViewActivity;
import me.pexcn.demos.activities.RequestPermissionActivity;
import me.pexcn.demos.activities.RxJavaSubscribeAndObserverActivity;
import me.pexcn.demos.activities.RxPermissionsActivity;
import me.pexcn.demos.activities.SwipeBackLayoutActivity;
import me.pexcn.demos.activities.TransparentNavBarActivity;
import me.pexcn.demos.base.BaseActivity;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ArrayList<String> mItems;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        mItems = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.activity_titles)));
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItems));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Intent intent = new Intent();
        intent.putExtra("activity_title", mItems.get(position));
        switch (position) {
            case 0:
                intent.setClass(this, RxJavaSubscribeAndObserverActivity.class);
                break;
            case 1:
                intent.setClass(this, ChromeCustomTabsActivity.class);
                break;
            case 2:
                intent.setClass(this, RequestPermissionActivity.class);
                break;
            case 3:
                intent.setClass(this, TransparentNavBarActivity.class);
                break;
            case 4:
                intent.setClass(this, ListNestedScrollActivity.class);
                break;
            case 5:
                intent.setClass(this, NestedScrollViewActivity.class);
                break;
            case 6:
                intent.setClass(this, SwipeBackLayoutActivity.class);
                break;
            case 7:
                intent.setClass(this, RxPermissionsActivity.class);
                break;
        }
        startActivity(intent);
    }
}
