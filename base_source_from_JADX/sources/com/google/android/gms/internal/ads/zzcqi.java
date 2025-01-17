package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

public final class zzcqi {
    public static int zza(SQLiteDatabase sQLiteDatabase, int i) {
        int i2 = 0;
        if (i == 2) {
            return 0;
        }
        Cursor zzc = zzc(sQLiteDatabase, i);
        if (zzc.getCount() > 0) {
            zzc.moveToNext();
            i2 = 0 + zzc.getInt(zzc.getColumnIndexOrThrow("value"));
        }
        zzc.close();
        return i2;
    }

    public static long zzb(SQLiteDatabase sQLiteDatabase, int i) {
        Cursor zzc = zzc(sQLiteDatabase, 2);
        long j = 0;
        if (zzc.getCount() > 0) {
            zzc.moveToNext();
            j = 0 + zzc.getLong(zzc.getColumnIndexOrThrow("value"));
        }
        zzc.close();
        return j;
    }

    public static ArrayList<zzue.zzo.zza> zzb(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzue.zzo.zza> arrayList = new ArrayList<>();
        Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zzue.zzo.zza.zzg(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzeks e) {
                zzd.zzey("Unable to deserialize proto from offline signals database:");
                zzd.zzey(e.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    private static Cursor zzc(SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = {"value"};
        String[] strArr2 = new String[1];
        switch (i) {
            case 0:
                strArr2[0] = "failed_requests";
                break;
            case 1:
                strArr2[0] = "total_requests";
                break;
            case 2:
                strArr2[0] = "last_successful_request_time";
                break;
        }
        return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, (String) null, (String) null, (String) null);
    }
}
