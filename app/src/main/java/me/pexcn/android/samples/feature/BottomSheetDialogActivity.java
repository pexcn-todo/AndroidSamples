package me.pexcn.android.samples.feature;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.base.BaseActivity;

/**
 * Created by pexcn on 2017-03-31.
 */
public class BottomSheetDialogActivity extends BaseActivity {
    private ViewGroup mRootView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feature_bottom_sheet_dialog;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        super.init(savedInstanceState);


        Button show = (Button) findViewById(R.id.show);
        mRootView = (ViewGroup) findViewById(android.R.id.content);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(BottomSheetDialogActivity.this);

                View view = LayoutInflater.from(BottomSheetDialogActivity.this).inflate(R.layout.dialog_bottom_sheet, mRootView, false);
                ListView listView = (ListView) view.findViewById(R.id.list_view);
                ArrayList<String> datas = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    datas.add("Item " + i);
                }
                listView.setAdapter(new ArrayAdapter<>(BottomSheetDialogActivity.this, android.R.layout.simple_list_item_1, datas));

                dialog.setContentView(view);
                dialog.show();
            }
        });
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
