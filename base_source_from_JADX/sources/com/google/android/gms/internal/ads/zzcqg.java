package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

final /* synthetic */ class zzcqg implements zzdqv {
    private final boolean zzejc;
    private final zzcqd zzgpu;
    private final ArrayList zzgpv;
    private final zzue.zzm zzgpw;
    private final zzue.zzo.zzc zzgpx;

    zzcqg(zzcqd zzcqd, boolean z, ArrayList arrayList, zzue.zzm zzm, zzue.zzo.zzc zzc) {
        this.zzgpu = zzcqd;
        this.zzejc = z;
        this.zzgpv = arrayList;
        this.zzgpw = zzm;
        this.zzgpx = zzc;
    }

    public final Object apply(Object obj) {
        zzcqd zzcqd = this.zzgpu;
        boolean z = this.zzejc;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        byte[] zza = zzcqd.zzgpo.zza(z, this.zzgpv, this.zzgpw, this.zzgpx);
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzp.zzkx().currentTimeMillis()));
        contentValues.put("serialized_proto_data", zza);
        sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
        if (!z) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
        }
        return null;
    }
}
