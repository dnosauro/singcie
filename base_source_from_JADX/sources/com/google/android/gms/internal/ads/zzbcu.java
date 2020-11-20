package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzbcu implements Iterable<zzbcs> {
    private final List<zzbcs> zzenz = new ArrayList();

    public static boolean zzc(zzbbe zzbbe) {
        zzbcs zzd = zzd(zzbbe);
        if (zzd == null) {
            return false;
        }
        zzd.zzeny.abort();
        return true;
    }

    static zzbcs zzd(zzbbe zzbbe) {
        Iterator<zzbcs> it = zzp.zzlm().iterator();
        while (it.hasNext()) {
            zzbcs next = it.next();
            if (next.zzehi == zzbbe) {
                return next;
            }
        }
        return null;
    }

    public final Iterator<zzbcs> iterator() {
        return this.zzenz.iterator();
    }

    public final void zza(zzbcs zzbcs) {
        this.zzenz.add(zzbcs);
    }

    public final void zzb(zzbcs zzbcs) {
        this.zzenz.remove(zzbcs);
    }
}
