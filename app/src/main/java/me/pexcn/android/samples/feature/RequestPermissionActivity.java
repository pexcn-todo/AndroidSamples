package me.pexcn.android.samples.feature;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Button;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.base.BaseActivity;

/**
 * Created by pexcn on 2016-10-05.
 */
public class RequestPermissionActivity extends BaseActivity {
    private static final int READ_CONTACTS_REQUEST_CODE = 0x01;
    @SuppressWarnings("FieldCanBeLocal")
    private Button mButton;
    private Snackbar mSnackbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feature_request_permission;
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }

    @Override
    protected void init() {
        super.init();
        mButton = (Button) findViewById(R.id.request);
        mButton.setOnClickListener(v -> {
            // 检查是否已授权
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                    // 可以请求权限
                    mSnackbar = Snackbar.make(findViewById(android.R.id.content), "可以请求权限", Snackbar.LENGTH_LONG);
                    mSnackbar.show();
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, READ_CONTACTS_REQUEST_CODE);
                } else {
                    // 已经“不再询问”地拒绝了该权限
                    mSnackbar = Snackbar.make(findViewById(android.R.id.content), "已经不再询问地拒绝了", Snackbar.LENGTH_LONG);
                    mSnackbar.show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (mSnackbar.isShown()) {
            mSnackbar.dismiss();
        }

        switch (requestCode) {
            case READ_CONTACTS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mSnackbar = Snackbar.make(findViewById(android.R.id.content), "请求权限成功", Snackbar.LENGTH_LONG);
                    mSnackbar.show();
                } else {
                    mSnackbar = Snackbar.make(findViewById(android.R.id.content), "请求权限失败", Snackbar.LENGTH_LONG);
                    mSnackbar.show();
                }
                break;
        }
    }
}
