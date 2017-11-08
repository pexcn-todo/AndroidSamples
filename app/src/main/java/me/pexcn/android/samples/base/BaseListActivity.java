package me.pexcn.android.samples.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import me.pexcn.android.samples.R;

/**
 * Created by pexcn on 2017-03-17.
 */
public abstract class BaseListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private String[] mItems;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mItems = getActivityList();
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItems));
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startSubActivity(position);
    }

    public void setSubActivity(int position, Class<?> clazz) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        intent.putExtra(BaseActivity.KEY_ACTIVITY_TITLE, mItems[position]);
        startActivity(intent);
    }

    protected abstract void startSubActivity(int position);

    protected abstract String[] getActivityList();
}
