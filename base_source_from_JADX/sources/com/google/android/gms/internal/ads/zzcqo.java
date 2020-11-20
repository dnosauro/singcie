package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcqo extends SQLiteOpenHelper {
    private final Context context;
    private final zzdzc zzgov;

    public zzcqo(Context context2, zzdzc zzdzc) {
        super(context2, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzwq.zzqe().zzd(zzabf.zzczd)).intValue());
        this.context = context2;
        this.zzgov = zzdzc;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static void zza(SQLiteDatabase sQLiteDatabase, zzaze zzaze) {
        sQLiteDatabase.beginTransaction();
        try {
            String[] strArr = {ImagesContract.URL};
            StringBuilder sb = new StringBuilder(25);
            sb.append("event_state = 1");
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", strArr, sb.toString(), (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            String[] strArr2 = new String[query.getCount()];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex(ImagesContract.URL);
                if (columnIndex != -1) {
                    strArr2[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            for (String zzeo : strArr2) {
                zzaze.zzeo(zzeo);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    static void zza(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    static final /* synthetic */ void zza(SQLiteDatabase sQLiteDatabase, String str, zzaze zzaze) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zza(sQLiteDatabase, zzaze);
    }

    private final void zza(zzdqv<SQLiteDatabase, Void> zzdqv) {
        zzdyr.zza(this.zzgov.zze(new zzcqn(this)), new zzcqt(this, zzdqv), this.zzgov);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(zzaze zzaze, String str, SQLiteDatabase sQLiteDatabase) {
        zza(sQLiteDatabase, zzaze, str);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(zzcqv zzcqv, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzcqv.timestamp));
        contentValues.put("gws_query_id", zzcqv.zzbvf);
        contentValues.put(ImagesContract.URL, zzcqv.url);
        contentValues.put("event_state", Integer.valueOf(zzcqv.zzgqk - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzp.zzkq();
        zzbf zzbf = zzm.zzbf(this.context);
        if (zzbf != null) {
            try {
                zzbf.zzap(ObjectWrapper.wrap(this.context));
            } catch (RemoteException e) {
                zzd.zza("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(SQLiteDatabase sQLiteDatabase, zzaze zzaze, String str) {
        this.zzgov.execute(new zzcqp(sQLiteDatabase, str, zzaze));
    }

    public final void zza(zzaze zzaze) {
        zza((zzdqv<SQLiteDatabase, Void>) new zzcqq(zzaze));
    }

    public final void zza(zzcqv zzcqv) {
        zza((zzdqv<SQLiteDatabase, Void>) new zzcqu(this, zzcqv));
    }

    public final void zzb(zzaze zzaze, String str) {
        zza((zzdqv<SQLiteDatabase, Void>) new zzcqs(this, zzaze, str));
    }

    public final void zzgk(String str) {
        zza((zzdqv<SQLiteDatabase, Void>) new zzcqr(this, str));
    }
}
