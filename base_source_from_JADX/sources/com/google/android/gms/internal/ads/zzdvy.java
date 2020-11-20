package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzdvy implements Iterable<String> {
    private final /* synthetic */ CharSequence zzhti;
    private final /* synthetic */ zzdvx zzhtj;

    zzdvy(zzdvx zzdvx, CharSequence charSequence) {
        this.zzhtj = zzdvx;
        this.zzhti = charSequence;
    }

    public final Iterator<String> iterator() {
        return this.zzhtj.zzb(this.zzhti);
    }

    public final String toString() {
        StringBuilder zza = zzdvl.zzhe(", ").zza(new StringBuilder("["), iterator());
        zza.append(']');
        return zza.toString();
    }
}
