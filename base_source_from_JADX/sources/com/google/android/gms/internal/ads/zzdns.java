package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

public final class zzdns {
    public static zzdmx zza(List<zzdmx> list, zzdmx zzdmx) {
        return list.get(0);
    }

    public static zzvn zzb(Context context, List<zzdmx> list) {
        ArrayList arrayList = new ArrayList();
        for (zzdmx next : list) {
            if (next.zzhhw) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(next.width, next.height));
            }
        }
        return new zzvn(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzdmx zzg(zzvn zzvn) {
        return zzvn.zzchr ? new zzdmx(-3, 0, true) : new zzdmx(zzvn.width, zzvn.height, false);
    }
}
