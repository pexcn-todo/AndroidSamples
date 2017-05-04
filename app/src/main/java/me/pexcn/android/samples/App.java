package me.pexcn.android.samples;

import android.app.Application;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2016-09-25.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
