package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

final /* synthetic */ class zzcdg implements zzahv {
    private final zzcdd zzgev;
    private final zzage zzgew;

    zzcdg(zzcdd zzcdd, zzage zzage) {
        this.zzgev = zzcdd;
        this.zzgew = zzage;
    }

    public final void zza(Object obj, Map map) {
        zzcdd zzcdd = this.zzgev;
        zzage zzage = this.zzgew;
        try {
            zzcdd.zzget = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzd.zzey("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzcdd.zzges = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzage == null) {
            zzd.zzeb("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzage.onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
