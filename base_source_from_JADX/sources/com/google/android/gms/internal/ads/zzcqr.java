package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final /* synthetic */ class zzcqr implements zzdqv {
    private final String zzdha;
    private final zzcqo zzgqf;

    zzcqr(zzcqo zzcqo, String str) {
        this.zzgqf = zzcqo;
        this.zzdha = str;
    }

    public final Object apply(Object obj) {
        zzcqo.zza((SQLiteDatabase) obj, this.zzdha);
        return null;
    }
}
