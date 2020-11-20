package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import javax.annotation.Nonnull;

final class zzczj implements zzdyo<ArrayList<Uri>> {
    private final /* synthetic */ zzasa zzgxp;

    zzczj(zzcyx zzcyx, zzasa zzasa) {
        this.zzgxp = zzasa;
    }

    public final /* synthetic */ void onSuccess(@Nonnull Object obj) {
        try {
            this.zzgxp.onSuccess((ArrayList) obj);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            zzasa zzasa = this.zzgxp;
            String valueOf = String.valueOf(th.getMessage());
            zzasa.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
