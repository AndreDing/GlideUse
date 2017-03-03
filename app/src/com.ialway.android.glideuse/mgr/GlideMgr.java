package com.ialway.android.glideuse.mgr;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ialway.android.glideuse.content.diskcache.CustomFileSignature;
import com.ialway.android.glideuse.content.diskcache.IntegerVersionSignature;

import java.io.File;

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

    /**
     * custom file signature invalidation example
     */
    public void loadCacheWithCustom(Context context, File file, ImageView view) {

        Glide.with(context).load(file).signature(new CustomFileSignature(file.getName(), file.lastModified(), file.getAbsolutePath())).into(view);
    }

    /**
     * version signature invalidation example
     */
    public void loadCacheWithCustom(Context context, String imageUrl, ImageView view, int version) {

        Glide.with(context).load(imageUrl).signature(new IntegerVersionSignature(version)).into(view);
    }

    /**
     * no disk cache example
     */
    public void loadWithNoDiskCache(Context context, String imageUrl, ImageView view) {

        Glide.with(context).load(imageUrl).diskCacheStrategy(DiskCacheStrategy.NONE).into(view);
    }
}
