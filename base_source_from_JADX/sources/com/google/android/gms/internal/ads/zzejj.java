package com.google.android.gms.internal.ads;

public abstract class zzejj {
    int zzijl;
    int zzijm;
    int zzijn;
    zzejm zzijo;
    private boolean zzijp;

    private zzejj() {
        this.zzijm = 100;
        this.zzijn = Integer.MAX_VALUE;
        this.zzijp = false;
    }

    static zzejj zzb(byte[] bArr, int i, int i2, boolean z) {
        zzejl zzejl = new zzejl(bArr, i, i2, z);
        try {
            zzejl.zzge(i2);
            return zzejl;
        } catch (zzeks e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzfg(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzgg(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract int zzbga();

    public abstract long zzbgb();

    public abstract long zzbgc();

    public abstract int zzbgd();

    public abstract long zzbge();

    public abstract int zzbgf();

    public abstract boolean zzbgg();

    public abstract String zzbgh();

    public abstract zzeiu zzbgi();

    public abstract int zzbgj();

    public abstract int zzbgk();

    public abstract int zzbgl();

    public abstract long zzbgm();

    public abstract int zzbgn();

    public abstract long zzbgo();

    /* access modifiers changed from: package-private */
    public abstract long zzbgp();

    public abstract boolean zzbgq();

    public abstract int zzbgr();

    public abstract void zzgc(int i);

    public abstract boolean zzgd(int i);

    public abstract int zzge(int i);

    public abstract void zzgf(int i);
}
