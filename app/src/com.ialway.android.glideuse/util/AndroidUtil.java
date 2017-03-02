package com.ialway.android.glideuse.util;

import android.content.Context;
import android.content.pm.PackageInfo;

/**
 * Created by dingchao on 2017/3/2.
 */
public class AndroidUtil {

    public static int getVersionCode(Context ctx) {
        try {
            android.content.pm.PackageManager mgr = ctx.getPackageManager();
            PackageInfo info = mgr.getPackageInfo(ctx.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            return 0;
        }
    }
}
