package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;

public final class zzdcn implements zzdfi<zzdco> {
    private final Context zzaaa;
    private final zzdzc zzggb;

    zzdcn(Context context, zzdzc zzdzc) {
        this.zzaaa = context;
        this.zzggb = zzdzc;
    }

    public final zzdyz<zzdco> zzasm() {
        return this.zzggb.zze(new zzdcm(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdco zzast() {
        zzp.zzkq();
        String zzax = zzm.zzax(this.zzaaa);
        String string = !((Boolean) zzwq.zzqe().zzd(zzabf.zzcwp)).booleanValue() ? "" : this.zzaaa.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "");
        zzp.zzkq();
        return new zzdco(zzax, string, zzm.zzay(this.zzaaa));
    }
}
