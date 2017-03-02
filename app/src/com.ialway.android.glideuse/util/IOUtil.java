package com.ialway.android.glideuse.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dingchao on 2017/3/2.
 */
public class IOUtil {

    public static long copy(InputStream input, OutputStream output, int bufferSize) throws IOException {
        final byte[] buffer = new byte[bufferSize];
        long count = 0L;
        int read = 0;
        while ((read = input.read(buffer)) > 0) {
            output.write(buffer, 0, read);
            count += read;
        }
        return count;
    }

    public static void closeQuietly(Closeable c) {
        if (c == null)
            return;

        try {
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
