package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.apache.commons.p172io.IOUtils;

public abstract class zzdvd {
    protected zzdvd() {
    }

    public static zzdvd zzb(char c) {
        return new zzdvf(';');
    }

    /* access modifiers changed from: private */
    public static String zzd(char c) {
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzdvv.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (zzc(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean zzc(char c);
}
