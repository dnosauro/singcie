package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.regex.Pattern;

public final class zzabh {
    public static boolean zzcp(String str) {
        return zzf((String) zzwq.zzqe().zzd(zzabf.zzcuz), str);
    }

    private static boolean zzf(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzp.zzku().zza(e, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
