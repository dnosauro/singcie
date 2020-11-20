package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.AdError;

final class zzcvz implements zzbtf {
    private final /* synthetic */ zzcrb zzgtr;
    private boolean zzgud = false;
    private final /* synthetic */ zzazq zzgue;
    private final /* synthetic */ zzcvy zzguf;

    zzcvz(zzcvy zzcvy, zzcrb zzcrb, zzazq zzazq) {
        this.zzguf = zzcvy;
        this.zzgtr = zzcrb;
        this.zzgue = zzazq;
    }

    private final void zzm(zzve zzve) {
        zzdok zzdok = zzdok.INTERNAL_ERROR;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvf)).booleanValue()) {
            zzdok = zzdok.NO_FILL;
        }
        this.zzgue.setException(new zzcrd(zzdok, zzve));
    }

    public final void onAdFailedToLoad(int i) {
        if (!this.zzgud) {
            zzm(new zzve(i, zzcvy.zza(this.zzgtr.zzchy, i), AdError.UNDEFINED_DOMAIN, (zzve) null, (IBinder) null));
        }
    }

    public final synchronized void onAdLoaded() {
        this.zzgue.set(null);
    }

    public final synchronized void zzf(int i, String str) {
        if (!this.zzgud) {
            this.zzgud = true;
            if (str == null) {
                str = zzcvy.zza(this.zzgtr.zzchy, i);
            }
            zzm(new zzve(i, str, AdError.UNDEFINED_DOMAIN, (zzve) null, (IBinder) null));
        }
    }

    public final synchronized void zzk(zzve zzve) {
        this.zzgud = true;
        zzm(zzve);
    }
}
