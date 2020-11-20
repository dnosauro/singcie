package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzdoa {
    private final Pattern zzhjd;

    @VisibleForTesting
    public zzdoa() {
        Pattern pattern;
        try {
            pattern = Pattern.compile((String) zzwq.zzqe().zzd(zzabf.zzcxy));
        } catch (PatternSyntaxException unused) {
            pattern = null;
        }
        this.zzhjd = pattern;
    }

    public final String zzgr(String str) {
        Pattern pattern = this.zzhjd;
        if (!(pattern == null || str == null)) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
