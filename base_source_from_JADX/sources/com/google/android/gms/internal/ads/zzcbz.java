package com.google.android.gms.internal.ads;

public final class zzcbz {
    private zzaee zzckp;

    public zzcbz(zzcbr zzcbr) {
        this.zzckp = zzcbr;
    }

    public final synchronized void zza(zzaee zzaee) {
        this.zzckp = zzaee;
    }

    public final synchronized zzaee zzth() {
        return this.zzckp;
    }
}
