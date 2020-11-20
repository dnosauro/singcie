package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final /* synthetic */ class zzcqp implements Runnable {
    private final String zzdha;
    private final SQLiteDatabase zzgqg;
    private final zzaze zzgqh;

    zzcqp(SQLiteDatabase sQLiteDatabase, String str, zzaze zzaze) {
        this.zzgqg = sQLiteDatabase;
        this.zzdha = str;
        this.zzgqh = zzaze;
    }

    public final void run() {
        zzcqo.zza(this.zzgqg, this.zzdha, this.zzgqh);
    }
}
