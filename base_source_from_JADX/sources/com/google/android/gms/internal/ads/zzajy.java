package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.Preconditions;

public final class zzajy {
    private final Context context;
    private final zzwz zzacs;

    private zzajy(Context context2, zzwz zzwz) {
        this.context = context2;
        this.zzacs = zzwz;
    }

    public zzajy(Context context2, String str) {
        this((Context) Preconditions.checkNotNull(context2, "context cannot be null"), zzwq.zzqb().zzb(context2, str, new zzanj()));
    }

    public final zzajy zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.zzacs.zza((zzajt) new zzajw(instreamAdLoadCallback));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzajy zza(zzajx zzajx) {
        try {
            this.zzacs.zza(new zzajl(zzajx));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzajz zztr() {
        try {
            return new zzajz(this.context, this.zzacs.zzqj());
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
