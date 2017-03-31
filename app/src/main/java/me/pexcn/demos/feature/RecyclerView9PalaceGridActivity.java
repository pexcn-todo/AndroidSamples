package me.pexcn.demos.feature;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;
import me.pexcn.demos.feature.adapter.RecyclerView9PalaceGridAdapter;

/**
 * Created by pexcn on 2017-03-30.
 */
public class RecyclerView9PalaceGridActivity extends BaseActivity {
    public static final int REQUEST_CODE_PICK_PICTURE = 0x01;

    private ArrayList<Uri> mUris;
    private RecyclerView mRecyclerView;
    private RecyclerView9PalaceGridAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feature_recyclerview_9_palace_grid;
    }

    @Override
    protected void init() {
        super.init();

        mUris = new ArrayList<>();
        mAdapter = new RecyclerView9PalaceGridAdapter(mUris);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((view, position) -> {
            if (mUris != null && position < mUris.size()) {
                view.findViewById(R.id.delete).setOnClickListener(v -> mAdapter.remove(position));
            } else {
                pickPicture();
            }
        });
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
