package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdfl<T> {
    private final Executor executor;
    private final Set<zzdfi<? extends zzdfj<T>>> zzhbo;

    public zzdfl(Executor executor2, Set<zzdfi<? extends zzdfj<T>>> set) {
        this.executor = executor2;
        this.zzhbo = set;
    }

    public final zzdyz<T> zzt(T t) {
        ArrayList arrayList = new ArrayList(this.zzhbo.size());
        for (zzdfi next : this.zzhbo) {
            zzdyz zzasm = next.zzasm();
            if (zzada.zzdcs.get().booleanValue()) {
                zzasm.addListener(new zzdfk(next, zzp.zzkx().elapsedRealtime()), zzazj.zzegu);
            }
            arrayList.add(zzasm);
        }
        return zzdyr.zzk(arrayList).zza(new zzdfn(arrayList, t), this.executor);
    }
}
