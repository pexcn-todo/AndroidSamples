package me.pexcn.demos.rxjava;

import android.Manifest;
import android.widget.Toast;

import com.tbruyelle.rxpermissions.RxPermissions;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;

/**
 * Created by pexcn on 2017-03-17.
 */
public class RxPermissionsActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava_rxpermissions;
    }

    @Override
    protected void init() {
        super.init();

        findViewById(R.id.request).setOnClickListener(v -> {
            RxPermissions permissions = new RxPermissions(this);
            permissions.request(Manifest.permission.READ_CONTACTS)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            Toast.makeText(this, "获得权限", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "权限请求被拒绝", Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
