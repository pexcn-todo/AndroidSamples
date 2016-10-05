package me.pexcn.demos.activity;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.support.customtabs.CustomTabsIntent;
import android.widget.Button;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;

/**
 * Created by pexcn on 2016-10-04.
 */
public class ChromeCustomTabsActivity extends BaseActivity {
    private Button mButton;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chrome_custom_tabs;
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void init() {
        super.init();
        mButton = (Button) findViewById(R.id.open);
        mButton.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                    .setToolbarColor(getResources().getColor(R.color.colorPrimary, null))
                    .addDefaultShareMenuItem()
                    .build();
            customTabsIntent.intent.setPackage("com.android.chrome");
            customTabsIntent.launchUrl(this, Uri.parse("https://www.google.com"));
        });
    }
}
