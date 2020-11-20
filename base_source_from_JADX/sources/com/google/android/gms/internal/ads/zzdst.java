package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdte;
import com.google.android.gms.internal.ads.zzdti;

@ShowFirstParty
public final class zzdst {
    private final Context context;
    private final Looper zzhqa;

    public zzdst(Context context2, Looper looper) {
        this.context = context2;
        this.zzhqa = looper;
    }

    public final void zzgz(String str) {
        new zzdsw(this.context, this.zzhqa, (zzdti) ((zzekh) zzdti.zzaxl().zzhc(this.context.getPackageName()).zzb(zzdti.zzb.BLOCKED_IMPRESSION).zza(zzdte.zzaxj().zzhb(str).zzb(zzdte.zza.BLOCKED_REASON_BACKGROUND)).zzbhv())).zzaxh();
    }
}
