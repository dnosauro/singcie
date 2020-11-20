package com.google.android.gms.internal.measurement;

public abstract class zzgy {
    int zza;
    int zzb;
    zzhd zzc;
    private int zzd;
    private boolean zze;

    private zzgy() {
        this.zzb = 100;
        this.zzd = Integer.MAX_VALUE;
        this.zze = false;
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static zzgy zza(byte[] bArr, int i, int i2, boolean z) {
        zzha zzha = new zzha(bArr, i2);
        try {
            zzha.zzc(i2);
            return zzha;
        } catch (zzig e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zza();

    public abstract void zza(int i);

    public abstract double zzb();

    public abstract boolean zzb(int i);

    public abstract float zzc();

    public abstract int zzc(int i);

    public abstract long zzd();

    public abstract void zzd(int i);

    public abstract long zze();

    public abstract int zzf();

    public abstract long zzg();

    public abstract int zzh();

    public abstract boolean zzi();

    public abstract String zzj();

    public abstract String zzk();

    public abstract zzgm zzl();

    public abstract int zzm();

    public abstract int zzn();

    public abstract int zzo();

    public abstract long zzp();

    public abstract int zzq();

    public abstract long zzr();

    /* access modifiers changed from: package-private */
    public abstract long zzs();

    public abstract boolean zzt();

    public abstract int zzu();
}
