package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

final class zzcmc extends zzaja {
    private final /* synthetic */ zzclp zzgls;
    private final /* synthetic */ Object zzglv;
    private final /* synthetic */ String zzglw;
    private final /* synthetic */ long zzglx;
    private final /* synthetic */ zzazq zzgly;

    zzcmc(zzclp zzclp, Object obj, String str, long j, zzazq zzazq) {
        this.zzgls = zzclp;
        this.zzglv = obj;
        this.zzglw = str;
        this.zzglx = j;
        this.zzgly = zzazq;
    }

    public final void onInitializationFailed(String str) {
        synchronized (this.zzglv) {
            this.zzgls.zza(this.zzglw, false, str, (int) (zzp.zzkx().elapsedRealtime() - this.zzglx));
            this.zzgls.zzglh.zzs(this.zzglw, "error");
            this.zzgly.set(false);
        }
    }

    public final void onInitializationSucceeded() {
        synchronized (this.zzglv) {
            this.zzgls.zza(this.zzglw, true, "", (int) (zzp.zzkx().elapsedRealtime() - this.zzglx));
            this.zzgls.zzglh.zzgg(this.zzglw);
            this.zzgly.set(true);
        }
    }
}
