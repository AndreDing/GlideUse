package com.ialway.android.glideuse.content.diskcache;

import com.bumptech.glide.load.Key;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/**
 * Created by dingchao on 2017/3/2.
 */
public class CustomFileSignature implements Key {

    private final String fileName;
    private final long dateModified;
    private final String filePath;

    /**
     * dateModified：文件修改日期
     */
    public CustomFileSignature(String fileName, long dateModified, String filePath) {
        this.fileName = fileName;
        this.dateModified = dateModified;
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomFileSignature that = (CustomFileSignature) o;

        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) {
            return false;
        }
        if (dateModified != that.dateModified) {
            return false;
        }
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileName != null ? fileName.hashCode() : 0;
        // dateModified >>> 32 ——> dateModified / ((int) Math.pow(2, 32))
        result = 31 * result + (int) (dateModified ^ (dateModified >>> 32));
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        return result;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] data = ByteBuffer.allocate(12)
                .putLong(dateModified)
                .array();
        messageDigest.update(data);
        messageDigest.update(fileName.getBytes(STRING_CHARSET_NAME));
        messageDigest.update(filePath.getBytes(STRING_CHARSET_NAME));
    }
}
