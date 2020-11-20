package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmd;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzka {
    private static final zzml zzaov = new zzkd();
    private static final Pattern zzaow = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzahn = -1;
    public int zzaho = -1;

    private final boolean zzb(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = zzaow.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzahn = parseInt;
                    this.zzaho = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean zzb(zzmd zzmd) {
        for (int i = 0; i < zzmd.length(); i++) {
            zzmd.zza zzay = zzmd.zzay(i);
            if (zzay instanceof zzmj) {
                zzmj zzmj = (zzmj) zzay;
                if (zzb(zzmj.description, zzmj.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzgs() {
        return (this.zzahn == -1 || this.zzaho == -1) ? false : true;
    }
}
