package com.ialway.android.glideuse.content.module;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by dingchao on 2017/3/3.
 */
public class CustomSimpleGlideModule implements GlideModule {

    private static final String CACHE_DIR = "custom_module_dir";
    private static final int CHAHE_MAX_SIXE = 10 * 1024 * 1024;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        // /data/data/com.ialway.android.glideuse/cache/custom_module_dir
//        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, CACHE_DIR, CHAHE_MAX_SIXE));
        // /sdcard/Android/data/com.ialway.android.glideuse/cache/custom_module_dir
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, CACHE_DIR, CHAHE_MAX_SIXE));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
