package com.ialway.android.glideuse.mgr;

import android.content.Context;

import com.ialway.android.glideuse.ui.Constants;
import com.ialway.android.glideuse.ui.MainApp;
import com.ialway.android.glideuse.util.AndroidUtil;

import java.io.File;

/**
 * Created by dingchao on 2017/3/2.
 */
public class FileMgr {

    private static FileMgr sFileMgr = new FileMgr();

    public static FileMgr shared() {
        return sFileMgr;
    }

    public String getPicPath(String picName) {

        File dir = MainApp.shared().getDir(Constants.PIC_PATH_NAME, Context.MODE_PRIVATE);
        return dir.getAbsolutePath() + "/" + AndroidUtil.getVersionCode(MainApp.shared()) + "/" + picName;
    }
}
