package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdbv implements zzdfi<zzdfj<Bundle>> {
    private final zzdjv zzgzi;

    zzdbv(zzdjv zzdjv) {
        this.zzgzi = zzdjv;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        zzdjv zzdjv = this.zzgzi;
        return zzdyr.zzag((zzdjv == null || zzdjv.zzauc() == null || this.zzgzi.zzauc().isEmpty()) ? null : new zzdbu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Bundle bundle) {
        bundle.putString("key_schema", this.zzgzi.zzauc());
    }
}
