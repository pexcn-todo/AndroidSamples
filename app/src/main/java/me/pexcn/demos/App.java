package me.pexcn.demos;

import android.app.Application;

import me.pexcn.simpleutils.SimpleUtils;

/**
 * Created by pexcn on 2016-09-25.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SimpleUtils.init(this);
    }
}
