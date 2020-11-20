package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

final /* synthetic */ class zzaks implements Predicate {
    private final zzahv zzdij;

    zzaks(zzahv zzahv) {
        this.zzdij = zzahv;
    }

    public final boolean apply(Object obj) {
        zzahv zzahv = (zzahv) obj;
        return (zzahv instanceof zzakz) && ((zzakz) zzahv).zzdip.equals(this.zzdij);
    }
}
