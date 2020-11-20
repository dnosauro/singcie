package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final /* synthetic */ class zzcqs implements zzdqv {
    private final String zzdgt;
    private final zzcqo zzgqf;
    private final zzaze zzgqi;

    zzcqs(zzcqo zzcqo, zzaze zzaze, String str) {
        this.zzgqf = zzcqo;
        this.zzgqi = zzaze;
        this.zzdgt = str;
    }

    public final Object apply(Object obj) {
        return this.zzgqf.zza(this.zzgqi, this.zzdgt, (SQLiteDatabase) obj);
    }
}
