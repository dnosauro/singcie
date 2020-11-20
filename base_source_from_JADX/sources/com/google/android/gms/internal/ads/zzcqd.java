package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

final class zzcqd implements zzdyo<Bundle> {
    private final /* synthetic */ boolean zzgpn;
    final /* synthetic */ zzcqe zzgpo;

    zzcqd(zzcqe zzcqe, boolean z) {
        this.zzgpo = zzcqe;
        this.zzgpn = z;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Bundle bundle = (Bundle) obj;
        ArrayList zza = zzcqe.zzl(bundle);
        zzue.zzo.zzc zzb = zzcqe.zzk(bundle);
        this.zzgpo.zzgpq.zza(new zzcqg(this, this.zzgpn, zza, this.zzgpo.zzj(bundle), zzb));
    }

    public final void zzb(Throwable th) {
        zzd.zzey("Failed to get signals bundle");
    }
}
