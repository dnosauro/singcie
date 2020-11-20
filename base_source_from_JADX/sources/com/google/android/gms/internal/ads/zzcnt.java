package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzap;
import com.google.android.gms.ads.internal.util.zzas;

public final class zzcnt extends zzate {
    private final /* synthetic */ zzcnu zzgne;

    protected zzcnt(zzcnu zzcnu) {
        this.zzgne = zzcnu;
    }

    public final void zza(zzap zzap) {
        this.zzgne.zzdkm.setException(new zzas(zzap.zzacm, zzap.errorCode));
    }

    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzgne.zzdkm.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
