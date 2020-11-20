package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzbjz {
    /* access modifiers changed from: private */
    public final Executor executor;
    private final String zzbre;
    private final zzamq zzfqd;
    /* access modifiers changed from: private */
    public zzbki zzfqe;
    private final zzahv<Object> zzfqf = new zzbkc(this);
    private final zzahv<Object> zzfqg = new zzbke(this);

    public zzbjz(String str, zzamq zzamq, Executor executor2) {
        this.zzbre = str;
        this.zzfqd = zzamq;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    public final boolean zzn(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzbre);
    }

    public final void zza(zzbki zzbki) {
        this.zzfqd.zzc("/updateActiveView", this.zzfqf);
        this.zzfqd.zzc("/untrackActiveViewUnit", this.zzfqg);
        this.zzfqe = zzbki;
    }

    public final void zzaif() {
        this.zzfqd.zzd("/updateActiveView", this.zzfqf);
        this.zzfqd.zzd("/untrackActiveViewUnit", this.zzfqg);
    }

    public final void zzd(zzbdv zzbdv) {
        zzbdv.zza("/updateActiveView", (zzahv<? super zzbdv>) this.zzfqf);
        zzbdv.zza("/untrackActiveViewUnit", (zzahv<? super zzbdv>) this.zzfqg);
    }

    public final void zze(zzbdv zzbdv) {
        zzbdv.zzb("/updateActiveView", this.zzfqf);
        zzbdv.zzb("/untrackActiveViewUnit", this.zzfqg);
    }
}
