package me.pexcn.demos.feature;

import android.support.design.widget.BottomSheetDialog;
import android.widget.Button;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;

/**
 * Created by pexcn on 2017-03-31.
 */
public class BottomSheetDialogActivity extends BaseActivity {
    private Button mShow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feature_bottom_sheet_dialog;
    }

    @Override
    protected void init() {
        super.init();

        mShow = (Button) findViewById(R.id.show);
        mShow.setOnClickListener(v -> {
            BottomSheetDialog dialog = new BottomSheetDialog(this);
            dialog.setContentView(R.layout.dialog_bottom_sheet);
            dialog.show();
        });
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
