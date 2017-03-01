package com.ialway.android.glideuse.ui;

import android.app.Application;

/**
 * Created by dingchao on 2017/3/1.
 */
public class MainApp extends Application {

    private static MainApp sInstance;

    public static MainApp shared() {
        if (sInstance != null) {
            return sInstance;
        }
        return new MainApp();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
    }
}
