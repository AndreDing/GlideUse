package com.ialway.android.glideuse.content.diskcache;

import com.bumptech.glide.load.Key;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/**
 * from https://github.com/bumptech/glide/wiki/Caching-and-Cache-Invalidation
 */
public class IntegerVersionSignature implements Key {

    private int currentVersion;

    public IntegerVersionSignature(int currentVersion) {
        this.currentVersion = currentVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerVersionSignature) {
            IntegerVersionSignature other = (IntegerVersionSignature) o;
            return currentVersion == other.currentVersion;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return currentVersion;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {

        messageDigest.update(ByteBuffer.allocate(Integer.SIZE).putInt(currentVersion).array());
    }
}
