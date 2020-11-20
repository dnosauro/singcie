package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzdsk implements Continuation {
    private final int zzeds;
    private final zzbw.zza.C3701zza zzhpt;

    zzdsk(zzbw.zza.C3701zza zza, int i) {
        this.zzhpt = zza;
        this.zzeds = i;
    }

    public final Object then(Task task) {
        return zzdsi.zza(this.zzhpt, this.zzeds, task);
    }
}
