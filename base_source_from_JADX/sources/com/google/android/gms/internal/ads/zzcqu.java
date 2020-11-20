package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final /* synthetic */ class zzcqu implements zzdqv {
    private final zzcqo zzgqf;
    private final zzcqv zzgqj;

    zzcqu(zzcqo zzcqo, zzcqv zzcqv) {
        this.zzgqf = zzcqo;
        this.zzgqj = zzcqv;
    }

    public final Object apply(Object obj) {
        return this.zzgqf.zza(this.zzgqj, (SQLiteDatabase) obj);
    }
}
