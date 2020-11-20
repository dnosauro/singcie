package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

final class zzczk implements zzdyo<zzczx> {
    private final /* synthetic */ zzaxp zzgxq;
    private final /* synthetic */ zzcyx zzgxr;

    zzczk(zzcyx zzcyx, zzaxp zzaxp) {
        this.zzgxr = zzcyx;
        this.zzgxq = zzaxp;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzczx zzczx = (zzczx) obj;
        try {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxz)).booleanValue()) {
                if (this.zzgxr.zzbos.zzegm >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcyb)).intValue()) {
                    if (zzczx == null) {
                        this.zzgxq.zza((String) null, (String) null, (Bundle) null);
                        return;
                    } else {
                        this.zzgxq.zza(zzczx.zzgxz, zzczx.zzgya, zzczx.zzgyb);
                        return;
                    }
                }
            }
            if (zzczx == null) {
                this.zzgxq.zzk((String) null, (String) null);
            } else {
                this.zzgxq.zzk(zzczx.zzgxz, zzczx.zzgya);
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            zzaxp zzaxp = this.zzgxq;
            String valueOf = String.valueOf(th.getMessage());
            zzaxp.onError(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
