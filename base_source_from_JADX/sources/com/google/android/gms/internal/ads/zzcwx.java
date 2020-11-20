package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

public final class zzcwx {
    private final zzciq zzglg;
    private final ConcurrentHashMap<String, zzapo> zzgvb = new ConcurrentHashMap<>();

    public zzcwx(zzciq zzciq) {
        this.zzglg = zzciq;
    }

    public final void zzgl(String str) {
        try {
            this.zzgvb.put(str, this.zzglg.zzdg(str));
        } catch (RemoteException e) {
            zzd.zzc("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzapo zzgm(String str) {
        if (this.zzgvb.containsKey(str)) {
            return this.zzgvb.get(str);
        }
        return null;
    }
}
