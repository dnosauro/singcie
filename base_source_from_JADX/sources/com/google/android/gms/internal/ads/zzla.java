package com.google.android.gms.internal.ads;

final class zzla implements zzkz {
    private final zzpn zzawg;
    private final int zzaxa = this.zzawg.zzjf();
    private final int zzaxb = (this.zzawg.zzjf() & 255);
    private int zzaxc;
    private int zzaxd;

    public zzla(zzku zzku) {
        this.zzawg = zzku.zzawg;
        this.zzawg.zzbl(12);
    }

    public final int zzgy() {
        return this.zzaxa;
    }

    public final int zzgz() {
        int i = this.zzaxb;
        if (i == 8) {
            return this.zzawg.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzawg.readUnsignedShort();
        }
        int i2 = this.zzaxc;
        this.zzaxc = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzaxd & 15;
        }
        this.zzaxd = this.zzawg.readUnsignedByte();
        return (this.zzaxd & 240) >> 4;
    }

    public final boolean zzha() {
        return false;
    }
}
