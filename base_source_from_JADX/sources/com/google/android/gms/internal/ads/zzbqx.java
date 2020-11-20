package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

final class zzbqx implements zzbsp, zzbtj {
    private final Context context;
    private final zzarq zzbol;
    private final zzdmu zzeri;

    public zzbqx(Context context2, zzdmu zzdmu, zzarq zzarq) {
        this.context = context2;
        this.zzeri = zzdmu;
        this.zzbol = zzarq;
    }

    public final void onAdLoaded() {
        if (this.zzeri.zzhhl != null && this.zzeri.zzhhl.zzdry) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzeri.zzhhl.zzdrz.isEmpty()) {
                arrayList.add(this.zzeri.zzhhl.zzdrz);
            }
            this.zzbol.zza(this.context, arrayList);
        }
    }

    public final void zzcc(Context context2) {
    }

    public final void zzcd(Context context2) {
    }

    public final void zzce(Context context2) {
        this.zzbol.detach();
    }
}
