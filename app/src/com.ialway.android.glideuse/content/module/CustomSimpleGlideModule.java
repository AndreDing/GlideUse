package com.ialway.android.glideuse.content.module;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by dingchao on 2017/3/3.
 */
public class CustomSimpleGlideModule implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, "custom_module_dir", 10 * 1024 * 1024));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
