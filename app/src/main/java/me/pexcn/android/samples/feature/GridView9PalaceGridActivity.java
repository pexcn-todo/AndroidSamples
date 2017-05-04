package me.pexcn.android.samples.feature;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.BaseActivity;
import me.pexcn.android.samples.feature.adapter.GridView9PalaceGridAdapter;

/**
 * Created by pexcn on 2017-03-30.
 */
public class GridView9PalaceGridActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final int REQUEST_CODE_PICK_PICTURE = 0x01;

    @SuppressWarnings("FieldCanBeLocal")
    private GridView mGridView;
    private GridView9PalaceGridAdapter mAdapter;
    private ArrayList<Uri> mUris;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feature_gridview_9_palace_grid;
    }

    @Override
    protected void init() {
        super.init();

        mUris = new ArrayList<>();
        mAdapter = new GridView9PalaceGridAdapter(mUris);
        mGridView = (GridView) findViewById(R.id.gridview);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mUris != null && position < mUris.size()) {
            view.findViewById(R.id.delete).setOnClickListener(v -> mAdapter.remove(position));
        } else {
            pickPicture();
        }
    }

    private void pickPicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE_PICK_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_PICK_PICTURE:
                    if (data == null) {
                        return;
                    }
                    mAdapter.add(data.getData());
                    break;
            }
        }
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
