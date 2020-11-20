package com.google.firebase.crashlytics.internal.ndk;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public final class NativeFileUtils {
    private NativeFileUtils() {
    }

    public static byte[] binaryImagesJsonFromMapsFile(File file, Context context) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists()) {
            return new byte[0];
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                byte[] convert = new BinaryImagesConverter(context, new Sha1FileIdStrategy()).convert(bufferedReader);
                CommonUtils.closeQuietly(bufferedReader);
                return convert;
            } catch (Throwable th) {
                th = th;
                CommonUtils.closeQuietly(bufferedReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            CommonUtils.closeQuietly(bufferedReader);
            throw th;
        }
    }
}
