package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzfb {
    public String zza;
    public Bundle zzb;
    private String zzc;
    private long zzd;

    private zzfb(String str, String str2, Bundle bundle, long j) {
        this.zza = str;
        this.zzc = str2;
        this.zzb = bundle == null ? new Bundle() : bundle;
        this.zzd = j;
    }

    public static zzfb zza(zzar zzar) {
        return new zzfb(zzar.zza, zzar.zzc, zzar.zzb.zzb(), zzar.zzd);
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final zzar zza() {
        return new zzar(this.zza, new zzam(new Bundle(this.zzb)), this.zzc, this.zzd);
    }
}
