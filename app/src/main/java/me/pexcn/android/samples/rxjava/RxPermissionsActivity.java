package me.pexcn.android.samples.rxjava;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.tbruyelle.rxpermissions.RxPermissions;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.base.BaseActivity;
import rx.functions.Action1;

/**
 * Created by pexcn on 2017-03-17.
 */
public class RxPermissionsActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava_rxpermissions;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        super.init(savedInstanceState);

        findViewById(R.id.request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxPermissions permissions = new RxPermissions(RxPermissionsActivity.this);
                permissions.request(Manifest.permission.READ_CONTACTS)
                        .subscribe(new Action1<Boolean>() {
                            @Override
                            public void call(Boolean bool) {
                                if (bool) {
                                    Toast.makeText(RxPermissionsActivity.this, "获得权限", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(RxPermissionsActivity.this, "权限请求被拒绝", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
