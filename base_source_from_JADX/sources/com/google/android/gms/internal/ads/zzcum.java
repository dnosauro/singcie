package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzcum {
    /* access modifiers changed from: private */
    public final Clock zzbpw;
    /* access modifiers changed from: private */
    public final zzcrg zzfvu;
    /* access modifiers changed from: private */
    public final zzcuo zzgta;
    private final List<String> zzgtb = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zzgtc;

    public zzcum(Clock clock, zzcuo zzcuo, zzcrg zzcrg) {
        this.zzbpw = clock;
        this.zzgta = zzcuo;
        this.zzgtc = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcxx)).booleanValue();
        this.zzfvu = zzcrg;
    }

    /* access modifiers changed from: private */
    public final void zza(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        this.zzgtb.add(sb2);
    }

    /* access modifiers changed from: package-private */
    public final <T> zzdyz<T> zza(zzdmz zzdmz, zzdmu zzdmu, zzdyz<T> zzdyz) {
        long elapsedRealtime = this.zzbpw.elapsedRealtime();
        String str = zzdmu.zzdkx;
        if (str != null) {
            zzdyr.zza(zzdyz, new zzcul(this, elapsedRealtime, str, zzdmu, zzdmz), zzazj.zzegu);
        }
        return zzdyz;
    }

    public final String zzarn() {
        return TextUtils.join("_", this.zzgtb);
    }
}
