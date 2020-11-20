package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

public final class zzdon implements zzaym, zzbrz {
    private final Context context;
    private final zzayq zzeaj;
    @GuardedBy("this")
    private final HashSet<zzayf> zzhka = new HashSet<>();

    public zzdon(Context context2, zzayq zzayq) {
        this.context = context2;
        this.zzeaj = zzayq;
    }

    public final synchronized void zza(HashSet<zzayf> hashSet) {
        this.zzhka.clear();
        this.zzhka.addAll(hashSet);
    }

    public final Bundle zzauy() {
        return this.zzeaj.zza(this.context, (zzaym) this);
    }

    public final synchronized void zzk(zzve zzve) {
        if (zzve.errorCode != 3) {
            this.zzeaj.zzb(this.zzhka);
        }
    }
}
