package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

public final class zzcqh {
    private Context context;
    private zzazh zzdsm;
    private zzcpr zzgpq;
    private zzts zzgpy;

    public zzcqh(Context context2, zzazh zzazh, zzts zzts, zzcpr zzcpr) {
        this.context = context2;
        this.zzdsm = zzazh;
        this.zzgpy = zzts;
        this.zzgpq = zzcpr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzue.zzo.zza> zzb = zzcqi.zzb(sQLiteDatabase);
        int i = 2;
        zzue.zzo zzo = (zzue.zzo) ((zzekh) zzue.zzo.zzon().zzca(this.context.getPackageName()).zzcb(Build.MODEL).zzcj(zzcqi.zza(sQLiteDatabase, 0)).zze(zzb).zzck(zzcqi.zza(sQLiteDatabase, 1)).zzes(zzp.zzkx().currentTimeMillis()).zzet(zzcqi.zzb(sQLiteDatabase, 2)).zzbhv());
        ArrayList arrayList = zzb;
        int size = arrayList.size();
        long j = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            zzue.zzo.zza zza = (zzue.zzo.zza) obj;
            if (zza.zzop() == zzuo.ENUM_TRUE && zza.getTimestamp() > j) {
                j = zza.getTimestamp();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
        }
        this.zzgpy.zza((zztv) new zzcqj(zzo));
        zzue.zzu.zza zzcr = zzue.zzu.zzox().zzcq(this.zzdsm.zzegl).zzcr(this.zzdsm.zzegm);
        if (this.zzdsm.zzegn) {
            i = 0;
        }
        this.zzgpy.zza((zztv) new zzcqm((zzue.zzu) ((zzekh) zzcr.zzcs(i).zzbhv())));
        this.zzgpy.zza(zztu.zza.C3718zza.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", (String) null, (String[]) null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("value", 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues3, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }

    public final void zzari() {
        try {
            this.zzgpq.zza(new zzcqk(this));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.zzey(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }
}
