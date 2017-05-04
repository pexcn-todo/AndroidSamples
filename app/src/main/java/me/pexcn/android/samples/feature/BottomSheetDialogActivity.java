package me.pexcn.android.samples.feature;

import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.BaseActivity;

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
    protected void init() {
        super.init();

        Button show = (Button) findViewById(R.id.show);
        mRootView = (ViewGroup) findViewById(android.R.id.content);

        show.setOnClickListener(v -> {
            BottomSheetDialog dialog = new BottomSheetDialog(this);

            View view = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_sheet, mRootView, false);
            ListView listView = (ListView) view.findViewById(R.id.list_view);
            ArrayList<String> datas = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                datas.add("Item " + i);
            }
            listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datas));

            dialog.setContentView(view);
            dialog.show();
        });
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
