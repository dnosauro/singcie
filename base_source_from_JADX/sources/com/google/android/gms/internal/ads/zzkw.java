package com.google.android.gms.internal.ads;

final class zzkw {
    public int index;
    public final int length;
    public int zzawk;
    public long zzawl;
    private final boolean zzawm;
    private final zzpn zzawn;
    private final zzpn zzawo;
    private int zzawp;
    private int zzawq;

    public zzkw(zzpn zzpn, zzpn zzpn2, boolean z) {
        this.zzawo = zzpn;
        this.zzawn = zzpn2;
        this.zzawm = z;
        zzpn2.zzbl(12);
        this.length = zzpn2.zzjf();
        zzpn.zzbl(12);
        this.zzawq = zzpn.zzjf();
        zzpc.checkState(zzpn.readInt() != 1 ? false : true, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzgx() {
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        this.zzawl = this.zzawm ? this.zzawn.zzjg() : this.zzawn.zzjc();
        if (this.index == this.zzawp) {
            this.zzawk = this.zzawo.zzjf();
            this.zzawo.zzbm(4);
            int i2 = this.zzawq - 1;
            this.zzawq = i2;
            this.zzawp = i2 > 0 ? this.zzawo.zzjf() - 1 : -1;
        }
        return true;
    }
}
