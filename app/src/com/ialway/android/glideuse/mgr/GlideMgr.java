package com.ialway.android.glideuse.mgr;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by dingchao on 2017/2/28.
 */
public class GlideMgr {

    private static GlideMgr sGlideMgr = new GlideMgr();

    public static GlideMgr shared() {
        return sGlideMgr;
    }

    /**
     * sample example
     */
    public void sampleLoad(Context context, String imageUrl, ImageView view) {

        Glide.with(context).load(imageUrl).into(view);
    }

    /**
     * with default icon
     */
    public void sampleLoad(Context context, String imageUrl, int defaultIcon, ImageView view) {

        Glide.with(context).load(imageUrl).placeholder(defaultIcon).into(view);
    }

    /**
     * with default icon
     */
    public void sampleLoad(Context context, String imageUrl, float thumbSize, ImageView view) {

        Glide.with(context).load(imageUrl).thumbnail(thumbSize).into(view);
    }
}
