package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzfm {
    @VisibleForTesting
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final /* synthetic */ zzfj zze;

    private zzfm(zzfj zzfj, String str, long j) {
        this.zze = zzfj;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zza = String.valueOf(str).concat(":start");
        this.zzb = String.valueOf(str).concat(":count");
        this.zzc = String.valueOf(str).concat(":value");
        this.zzd = j;
    }

    private final void zzb() {
        this.zze.zzc();
        long currentTimeMillis = this.zze.zzl().currentTimeMillis();
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        edit.remove(this.zzb);
        edit.remove(this.zzc);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    private final long zzc() {
        return this.zze.zzf().getLong(this.zza, 0);
    }

    public final Pair<String, Long> zza() {
        long j;
        this.zze.zzc();
        this.zze.zzc();
        long zzc2 = zzc();
        if (zzc2 == 0) {
            zzb();
            j = 0;
        } else {
            j = Math.abs(zzc2 - this.zze.zzl().currentTimeMillis());
        }
        long j2 = this.zzd;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            zzb();
            return null;
        }
        String string = this.zze.zzf().getString(this.zzc, (String) null);
        long j3 = this.zze.zzf().getLong(this.zzb, 0);
        zzb();
        return (string == null || j3 <= 0) ? zzfj.zza : new Pair<>(string, Long.valueOf(j3));
    }

    public final void zza(String str, long j) {
        this.zze.zzc();
        if (zzc() == 0) {
            zzb();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zze.zzf().getLong(this.zzb, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zze.zzf().edit();
            edit.putString(this.zzc, str);
            edit.putLong(this.zzb, 1);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.zze.zzo().zzg().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = this.zze.zzf().edit();
        if (z) {
            edit2.putString(this.zzc, str);
        }
        edit2.putLong(this.zzb, j3);
        edit2.apply();
    }
}
