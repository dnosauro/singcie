package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzcku implements zzdru {
    private final Clock zzbpw;
    private final Map<zzdrl, Long> zzgkm = new HashMap();
    private final zzcko zzgkn;
    private final Map<zzdrl, zzckt> zzgko = new HashMap();

    public zzcku(zzcko zzcko, Set<zzckt> set, Clock clock) {
        this.zzgkn = zzcko;
        for (zzckt next : set) {
            this.zzgko.put(next.zzgkl, next);
        }
        this.zzbpw = clock;
    }

    private final void zza(zzdrl zzdrl, boolean z) {
        zzdrl zzb = this.zzgko.get(zzdrl).zzgkk;
        String str = z ? "s." : "f.";
        if (this.zzgkm.containsKey(zzb)) {
            long elapsedRealtime = this.zzbpw.elapsedRealtime() - this.zzgkm.get(zzb).longValue();
            Map<String, String> zzrx = this.zzgkn.zzrx();
            String valueOf = String.valueOf(this.zzgko.get(zzdrl).label);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(str);
            String valueOf3 = String.valueOf(Long.toString(elapsedRealtime));
            zzrx.put(concat, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }

    public final void zza(zzdrl zzdrl, String str) {
    }

    public final void zza(zzdrl zzdrl, String str, Throwable th) {
        if (this.zzgkm.containsKey(zzdrl)) {
            long elapsedRealtime = this.zzbpw.elapsedRealtime() - this.zzgkm.get(zzdrl).longValue();
            Map<String, String> zzrx = this.zzgkn.zzrx();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzrx.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.zzgko.containsKey(zzdrl)) {
            zza(zzdrl, false);
        }
    }

    public final void zzb(zzdrl zzdrl, String str) {
        this.zzgkm.put(zzdrl, Long.valueOf(this.zzbpw.elapsedRealtime()));
    }

    public final void zzc(zzdrl zzdrl, String str) {
        if (this.zzgkm.containsKey(zzdrl)) {
            long elapsedRealtime = this.zzbpw.elapsedRealtime() - this.zzgkm.get(zzdrl).longValue();
            Map<String, String> zzrx = this.zzgkn.zzrx();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzrx.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.zzgko.containsKey(zzdrl)) {
            zza(zzdrl, true);
        }
    }
}
