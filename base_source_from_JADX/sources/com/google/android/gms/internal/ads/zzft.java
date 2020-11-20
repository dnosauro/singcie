package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.Callable;

public final class zzft implements Callable {
    private final zzcf.zza.C3704zza zzaay;
    private final zzfa zzwb;

    public zzft(zzfa zzfa, zzcf.zza.C3704zza zza) {
        this.zzwb = zzfa;
        this.zzaay = zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcy */
    public final Void call() {
        if (this.zzwb.zzcp() != null) {
            this.zzwb.zzcp().get();
        }
        zzcf.zza zzco = this.zzwb.zzco();
        if (zzco == null) {
            return null;
        }
        try {
            synchronized (this.zzaay) {
                zzcf.zza.C3704zza zza = this.zzaay;
                byte[] byteArray = zzco.toByteArray();
                zza.zza(byteArray, 0, byteArray.length, zzeju.zzbhf());
            }
            return null;
        } catch (zzeks unused) {
            return null;
        }
    }
}
