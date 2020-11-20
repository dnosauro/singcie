package com.google.android.gms.internal.ads;

public final class zzcpv implements zzbrz, zzbtj {
    private static final Object zzgoy = new Object();
    private static int zzgoz = 0;
    private final zzcqe zzgpa;

    public zzcpv(zzcqe zzcqe) {
        this.zzgpa = zzcqe;
    }

    private static boolean zzarc() {
        boolean z;
        synchronized (zzgoy) {
            z = zzgoz < ((Integer) zzwq.zzqe().zzd(zzabf.zzcwv)).intValue();
        }
        return z;
    }

    private final void zzbj(boolean z) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue() && zzarc()) {
            this.zzgpa.zzbj(z);
            synchronized (zzgoy) {
                zzgoz++;
            }
        }
    }

    public final void onAdLoaded() {
        zzbj(true);
    }

    public final void zzk(zzve zzve) {
        zzbj(false);
    }
}
