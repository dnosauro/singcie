package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.atomic.AtomicReference;

public final class zzdkb {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdka<T> zzdka) {
        T t = atomicReference.get();
        if (t != null) {
            try {
                zzdka.zzq(t);
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
