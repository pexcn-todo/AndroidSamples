package me.pexcn.demos.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

    @SuppressWarnings("deprecation")
    @Override
    protected void init() {
        super.init();
        mButton = (Button) findViewById(R.id.open);
        mButton.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                    .setToolbarColor(getResources().getColor(R.color.colorPrimary))
                    .setShowTitle(true)
                    .addMenuItem("Menus", PendingIntent.getActivity(this, 1, new Intent(), 0))
                    .setActionButton(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_crop), "Test", PendingIntent.getActivity(this, 2, new Intent(), 0))
                    .addDefaultShareMenuItem()
                    .build();
            customTabsIntent.intent.setPackage("com.android.chrome");
            customTabsIntent.launchUrl(this, Uri.parse("https://source.android.com"));
        });
    }
}
