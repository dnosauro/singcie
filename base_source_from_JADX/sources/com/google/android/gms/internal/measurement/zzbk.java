package com.google.android.gms.internal.measurement;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzhc;

final class zzbk extends zzag.zzb {
    private final /* synthetic */ zzhc zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbk(zzag zzag, zzhc zzhc) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzhc;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        Pair pair;
        int i = 0;
        while (true) {
            if (i >= this.zzd.zzf.size()) {
                pair = null;
                break;
            } else if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                pair = (Pair) this.zzd.zzf.get(i);
                break;
            } else {
                i++;
            }
        }
        if (pair == null) {
            Log.w(this.zzd.zzc, "OnEventListener had not been registered.");
            return;
        }
        this.zzd.zzm.unregisterOnMeasurementEventListener((zzab) pair.second);
        this.zzd.zzf.remove(pair);
    }
}
