package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

public final class zzajz {
    private final Context context;
    private final zzvl zzacp;
    private final zzwy zzacq;

    zzajz(Context context2, zzwy zzwy) {
        this(context2, zzwy, zzvl.zzcho);
    }

    private zzajz(Context context2, zzwy zzwy, zzvl zzvl) {
        this.context = context2;
        this.zzacq = zzwy;
        this.zzacp = zzvl;
    }

    private final void zza(zzza zzza) {
        try {
            this.zzacq.zzb(zzvl.zza(this.context, zzza));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzds());
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzds());
    }
}
