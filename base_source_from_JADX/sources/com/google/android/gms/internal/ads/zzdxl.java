package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdxl implements FilenameFilter {
    private final Pattern zzhjd;

    public zzdxl(Pattern pattern) {
        this.zzhjd = (Pattern) zzdvv.checkNotNull(pattern);
    }

    public final boolean accept(@NullableDecl File file, String str) {
        return this.zzhjd.matcher(str).matches();
    }
}
