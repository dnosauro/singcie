package com.google.android.gms.internal.ads;

public final class zzno extends zzhz {
    private static final Object zzbgn = new Object();
    private final boolean zzaiq;
    private final boolean zzair;
    private final long zzbgo;
    private final long zzbgp;
    private final long zzbgq;
    private final long zzbgr;

    private zzno(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbgo = j;
        this.zzbgp = j2;
        this.zzbgq = 0;
        this.zzbgr = 0;
        this.zzaiq = z;
        this.zzair = false;
    }

    public zzno(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public final zzib zza(int i, zzib zzib, boolean z) {
        zzpc.zzc(i, 0, 1);
        Object obj = z ? zzbgn : null;
        return zzib.zza(obj, obj, 0, this.zzbgo, 0, false);
    }

    public final zzie zza(int i, zzie zzie, boolean z, long j) {
        zzpc.zzc(i, 0, 1);
        boolean z2 = this.zzaiq;
        long j2 = this.zzbgp;
        zzie.zzaie = null;
        zzie.zzaio = -9223372036854775807L;
        zzie.zzaip = -9223372036854775807L;
        zzie.zzaiq = z2;
        zzie.zzair = false;
        zzie.zzaiu = 0;
        zzie.zzaif = j2;
        zzie.zzais = 0;
        zzie.zzait = 0;
        zzie.zzaiv = 0;
        return zzie;
    }

    public final int zzc(Object obj) {
        return zzbgn.equals(obj) ? 0 : -1;
    }

    public final int zzff() {
        return 1;
    }

    public final int zzfg() {
        return 1;
    }
}
