package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzcso implements zzcaf {
    private final zzazq zzbvq;

    zzcso(zzazq zzazq) {
        this.zzbvq = zzazq;
    }

    public final void zza(boolean z, Context context) {
        zzazq zzazq = this.zzbvq;
        try {
            zzp.zzkp();
            zzo.zza(context, (AdOverlayInfoParcel) zzazq.get(), true);
        } catch (Exception unused) {
        }
    }
}
