package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Set;

public final class zzdds implements zzdfi<zzddt> {
    private final Context context;
    private final zzdzc zzgyd;
    private final Set<String> zzgyn;

    public zzdds(zzdzc zzdzc, Context context2, Set<String> set) {
        this.zzgyd = zzdzc;
        this.context = context2;
        this.zzgyn = set;
    }

    public final zzdyz<zzddt> zzasm() {
        return this.zzgyd.zze(new zzddv(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzddt zzasx() {
        return (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcui)).booleanValue() || !zzddt.zze(this.zzgyn)) ? new zzddt((String) null) : new zzddt(zzp.zzlf().getVersion(this.context));
    }
}
