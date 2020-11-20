package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.zzd;

final class zzcqt implements zzdyo<SQLiteDatabase> {
    private final /* synthetic */ zzdqv zzgow;

    zzcqt(zzcqo zzcqo, zzdqv zzdqv) {
        this.zzgow = zzdqv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zzgow.apply((SQLiteDatabase) obj);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.zzey(valueOf.length() != 0 ? "Error executing function on offline buffered ping database: ".concat(valueOf) : new String("Error executing function on offline buffered ping database: "));
        }
    }

    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzd.zzey(valueOf.length() != 0 ? "Failed to get offline buffered ping database: ".concat(valueOf) : new String("Failed to get offline buffered ping database: "));
    }
}
