package me.pexcn.demos.base;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.pexcn.demos.R;

/**
 * Created by pexcn on 2017-03-17.
 */
public abstract class BaseListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ArrayList<String> mItems;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list;
    }

    @Override
    protected void init() {
        super.init();
        mItems = new ArrayList<>(getList());
        ListView list = (ListView) findViewById(R.id.listview);
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItems));
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Intent intent = new Intent();
        intent.putExtra(BaseActivity.KEY_ACTIVITY_TITLE, mItems.get(position));
        setUpSubActivity(intent, position);
        startActivity(intent);
    }

    public abstract List<String> getList();

    public abstract void setUpSubActivity(Intent intent, int position);
}
