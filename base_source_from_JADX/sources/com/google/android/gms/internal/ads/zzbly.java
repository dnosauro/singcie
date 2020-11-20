package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbly extends zzsj {
    private final zzxg zzbul;
    private final zzblv zzfsv;
    private final zzdir zzfsw;

    public zzbly(zzblv zzblv, zzxg zzxg, zzdir zzdir) {
        this.zzfsv = zzblv;
        this.zzbul = zzxg;
        this.zzfsw = zzdir;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzsq zzsq) {
        try {
            this.zzfsw.zza(zzsq);
            this.zzfsv.zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzsq);
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzsm zzsm) {
    }

    public final zzxg zzdx() {
        return this.zzbul;
    }

    public final zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        return this.zzfsv.zzajz();
    }
}
