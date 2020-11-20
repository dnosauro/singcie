package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final /* synthetic */ class zzcym implements zzbrz {
    private final zzcxq zzgwa;
    private final zzajt zzgww;

    zzcym(zzcxq zzcxq, zzajt zzajt) {
        this.zzgwa = zzcxq;
        this.zzgww = zzajt;
    }

    public final void zzk(zzve zzve) {
        zzcxq zzcxq = this.zzgwa;
        zzajt zzajt = this.zzgww;
        zzcxq.zzk(zzve);
        if (zzajt != null) {
            try {
                zzajt.zzd(zzve);
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
        if (zzajt != null) {
            try {
                zzajt.onInstreamAdFailedToLoad(zzve.errorCode);
            } catch (RemoteException e2) {
                zzaza.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
