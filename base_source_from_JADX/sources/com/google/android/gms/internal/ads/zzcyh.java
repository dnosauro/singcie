package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import javax.annotation.concurrent.GuardedBy;

public final class zzcyh {
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzyn zzads;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public boolean zzafb = false;
    private final String zzbum;
    private final zzcyl<zzboc> zzgwn;

    public zzcyh(zzcyl<zzboc> zzcyl, String str) {
        this.zzgwn = zzcyl;
        this.zzbum = str;
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            if (this.zzads == null) {
                return null;
            }
            return this.zzads.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final synchronized boolean isLoading() {
        return this.zzgwn.isLoading();
    }

    public final synchronized void zza(zzvk zzvk, int i) {
        this.zzads = null;
        this.zzafb = this.zzgwn.zza(zzvk, this.zzbum, new zzcyq(i), new zzcyk(this));
    }

    public final synchronized String zzkg() {
        try {
            if (this.zzads == null) {
                return null;
            }
            return this.zzads.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
