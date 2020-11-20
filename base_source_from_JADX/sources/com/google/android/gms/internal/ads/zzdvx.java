package com.google.android.gms.internal.ads;

import java.util.Iterator;

public final class zzdvx {
    /* access modifiers changed from: private */
    public final int limit;
    /* access modifiers changed from: private */
    public final zzdvd zzhtf;
    private final boolean zzhtg;
    private final zzdwa zzhth;

    private zzdvx(zzdwa zzdwa) {
        this(zzdwa, false, zzdvh.zzhsy, Integer.MAX_VALUE);
    }

    private zzdvx(zzdwa zzdwa, boolean z, zzdvd zzdvd, int i) {
        this.zzhth = zzdwa;
        this.zzhtg = false;
        this.zzhtf = zzdvd;
        this.limit = Integer.MAX_VALUE;
    }

    public static zzdvx zza(zzdvd zzdvd) {
        zzdvv.checkNotNull(zzdvd);
        return new zzdvx(new zzdvw(zzdvd));
    }

    /* access modifiers changed from: private */
    public final Iterator<String> zzb(CharSequence charSequence) {
        return this.zzhth.zza(this, charSequence);
    }

    public final Iterable<String> zza(CharSequence charSequence) {
        zzdvv.checkNotNull(charSequence);
        return new zzdvy(this, charSequence);
    }
}
