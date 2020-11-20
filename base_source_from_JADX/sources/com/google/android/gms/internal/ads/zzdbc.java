package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdbc implements zzdfi<Object> {
    private static final Object lock = new Object();
    private final String zzciz;
    private final String zzdsu;
    private final zzdnn zzfvl;
    private final zzbpo zzgyw;
    private final zzdon zzgyx;

    public zzdbc(String str, String str2, zzbpo zzbpo, zzdon zzdon, zzdnn zzdnn) {
        this.zzdsu = str;
        this.zzciz = str2;
        this.zzgyw = zzbpo;
        this.zzgyx = zzdon;
        this.zzfvl = zzdnn;
    }

    public final zzdyz<Object> zzasm() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvm)).booleanValue()) {
            this.zzgyw.zzf(this.zzfvl.zzhio);
            bundle.putAll(this.zzgyx.zzauy());
        }
        return zzdyr.zzag(new zzdbf(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvm)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvl)).booleanValue()) {
                synchronized (lock) {
                    this.zzgyw.zzf(this.zzfvl.zzhio);
                    bundle2.putBundle("quality_signals", this.zzgyx.zzauy());
                }
            } else {
                this.zzgyw.zzf(this.zzfvl.zzhio);
                bundle2.putBundle("quality_signals", this.zzgyx.zzauy());
            }
        }
        bundle2.putString("seq_num", this.zzdsu);
        bundle2.putString("session_id", this.zzciz);
    }
}
