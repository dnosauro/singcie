package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzet extends zzg {
    private final zzes zza = new zzes(this, zzm(), "google_app_measurement_local.db");
    private boolean zzb;

    zzet(zzgb zzgb) {
        super(zzgb);
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, (String) null, (String) null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c3 A[SYNTHETIC, Splitter:B:49:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0114 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0114 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0114 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzc()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r0 = "type"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            r3.put(r0, r4)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0023:
            if (r5 >= r4) goto L_0x0127
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.zzad()     // Catch:{ SQLiteFullException -> 0x00fb, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00bf, all -> 0x00bb }
            if (r9 != 0) goto L_0x0035
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b5 }
            if (r9 == 0) goto L_0x0034
            r9.close()
        L_0x0034:
            return r2
        L_0x0035:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b5 }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b5 }
            if (r12 == 0) goto L_0x0056
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            if (r0 == 0) goto L_0x0056
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            goto L_0x0056
        L_0x004d:
            r0 = move-exception
            goto L_0x011c
        L_0x0050:
            r0 = move-exception
            goto L_0x00b7
        L_0x0052:
            r0 = move-exception
            r7 = r12
            goto L_0x00fd
        L_0x0056:
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x009d
            com.google.android.gms.measurement.internal.zzex r0 = r16.zzq()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r15 = "Data loss, local db full"
            r0.zza(r15)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r0 = "messages"
            java.lang.String r10 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r15 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            r11[r2] = r15     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            int r0 = r9.delete(r0, r10, r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            long r10 = (long) r0     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            int r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x009d
            com.google.android.gms.measurement.internal.zzex r0 = r16.zzq()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r4 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.Long r2 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            r0.zza(r15, r4, r2, r10)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
        L_0x009d:
            java.lang.String r0 = "messages"
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0050, all -> 0x004d }
            if (r12 == 0) goto L_0x00ad
            r12.close()
        L_0x00ad:
            if (r9 == 0) goto L_0x00b2
            r9.close()
        L_0x00b2:
            return r8
        L_0x00b3:
            r7 = r12
            goto L_0x00ea
        L_0x00b5:
            r0 = move-exception
            r12 = r7
        L_0x00b7:
            r7 = r9
            goto L_0x00c1
        L_0x00b9:
            r0 = move-exception
            goto L_0x00fd
        L_0x00bb:
            r0 = move-exception
            r9 = r7
            r12 = r9
            goto L_0x011c
        L_0x00bf:
            r0 = move-exception
            r12 = r7
        L_0x00c1:
            if (r7 == 0) goto L_0x00cc
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x00cc
            r7.endTransaction()     // Catch:{ all -> 0x00e6 }
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzex r2 = r16.zzq()     // Catch:{ all -> 0x00e6 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x00e6 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x00e6 }
            r1.zzb = r8     // Catch:{ all -> 0x00e6 }
            if (r12 == 0) goto L_0x00e0
            r12.close()
        L_0x00e0:
            if (r7 == 0) goto L_0x0114
            r7.close()
            goto L_0x0114
        L_0x00e6:
            r0 = move-exception
            r9 = r7
            goto L_0x011c
        L_0x00e9:
            r9 = r7
        L_0x00ea:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x011a }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00f5
            r7.close()
        L_0x00f5:
            if (r9 == 0) goto L_0x0114
        L_0x00f7:
            r9.close()
            goto L_0x0114
        L_0x00fb:
            r0 = move-exception
            r9 = r7
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzex r2 = r16.zzq()     // Catch:{ all -> 0x011a }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x011a }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)     // Catch:{ all -> 0x011a }
            r1.zzb = r8     // Catch:{ all -> 0x011a }
            if (r7 == 0) goto L_0x0111
            r7.close()
        L_0x0111:
            if (r9 == 0) goto L_0x0114
            goto L_0x00f7
        L_0x0114:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0023
        L_0x011a:
            r0 = move-exception
            r12 = r7
        L_0x011c:
            if (r12 == 0) goto L_0x0121
            r12.close()
        L_0x0121:
            if (r9 == 0) goto L_0x0126
            r9.close()
        L_0x0126:
            throw r0
        L_0x0127:
            com.google.android.gms.measurement.internal.zzex r0 = r16.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzw()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzet.zza(int, byte[]):boolean");
    }

    @VisibleForTesting
    private final SQLiteDatabase zzad() {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    @VisibleForTesting
    private final boolean zzae() {
        return zzm().getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:64|65|66|67) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:79|80|81|82) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:51|52|53|54|169) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0187, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x019b, code lost:
        if (r4.inTransaction() != false) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x019d, code lost:
        r4.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01b1, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01c1, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x01e9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x01ec, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x01f1, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        r9 = null;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        r9 = null;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        r9 = null;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        zzq().zze().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r10.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        zzq().zze().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r10.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        zzq().zze().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r10.recycle();
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00a7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x00d7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x010a */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0197 A[SYNTHETIC, Splitter:B:124:0x0197] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01e4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01e4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01e4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r21) {
        /*
            r20 = this;
            r1 = r20
            r20.zzc()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            boolean r0 = r20.zzae()
            if (r0 != 0) goto L_0x0017
            return r3
        L_0x0017:
            r4 = 5
            r5 = 0
            r6 = 0
            r7 = 5
        L_0x001b:
            if (r6 >= r4) goto L_0x01f5
            r8 = 1
            android.database.sqlite.SQLiteDatabase r15 = r20.zzad()     // Catch:{ SQLiteFullException -> 0x01ca, SQLiteDatabaseLockedException -> 0x01b7, SQLiteException -> 0x0192, all -> 0x018e }
            if (r15 != 0) goto L_0x003b
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0031, all -> 0x002c }
            if (r15 == 0) goto L_0x002b
            r15.close()
        L_0x002b:
            return r2
        L_0x002c:
            r0 = move-exception
            r9 = r2
            r4 = r15
            goto L_0x01ea
        L_0x0031:
            r0 = move-exception
            r9 = r2
            r4 = r15
            goto L_0x0195
        L_0x0036:
            r0 = move-exception
            r9 = r2
            r4 = r15
            goto L_0x01cd
        L_0x003b:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0183, all -> 0x017e }
            long r9 = zza((android.database.sqlite.SQLiteDatabase) r15)     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0183, all -> 0x017e }
            r18 = -1
            int r0 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0031, all -> 0x002c }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0031, all -> 0x002c }
            r11[r5] = r9     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0031, all -> 0x002c }
            r12 = r0
            r13 = r11
            goto L_0x0057
        L_0x0055:
            r12 = r2
            r13 = r12
        L_0x0057:
            java.lang.String r10 = "messages"
            java.lang.String r0 = "rowid"
            java.lang.String r9 = "type"
            java.lang.String r11 = "entry"
            java.lang.String[] r11 = new java.lang.String[]{r0, r9, r11}     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0183, all -> 0x017e }
            r14 = 0
            r0 = 0
            java.lang.String r16 = "rowid asc"
            r9 = 100
            java.lang.String r17 = java.lang.Integer.toString(r9)     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0187, SQLiteException -> 0x0183, all -> 0x017e }
            r9 = r15
            r4 = r15
            r15 = r0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteFullException -> 0x017c, SQLiteDatabaseLockedException -> 0x0188, SQLiteException -> 0x017a, all -> 0x0178 }
        L_0x0074:
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            if (r0 == 0) goto L_0x013f
            long r18 = r9.getLong(r5)     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            int r0 = r9.getInt(r8)     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            r10 = 2
            byte[] r11 = r9.getBlob(r10)     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            if (r0 != 0) goto L_0x00bc
            android.os.Parcel r10 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            int r0 = r11.length     // Catch:{ ParseException -> 0x00a7 }
            r10.unmarshall(r11, r5, r0)     // Catch:{ ParseException -> 0x00a7 }
            r10.setDataPosition(r5)     // Catch:{ ParseException -> 0x00a7 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r0 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ ParseException -> 0x00a7 }
            java.lang.Object r0 = r0.createFromParcel(r10)     // Catch:{ ParseException -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzar r0 = (com.google.android.gms.measurement.internal.zzar) r0     // Catch:{ ParseException -> 0x00a7 }
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            if (r0 == 0) goto L_0x0074
        L_0x00a1:
            r3.add(r0)     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            goto L_0x0074
        L_0x00a5:
            r0 = move-exception
            goto L_0x00b8
        L_0x00a7:
            com.google.android.gms.measurement.internal.zzex r0 = r20.zzq()     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ all -> 0x00a5 }
            java.lang.String r11 = "Failed to load event from local database"
            r0.zza(r11)     // Catch:{ all -> 0x00a5 }
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            goto L_0x0074
        L_0x00b8:
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
        L_0x00bc:
            if (r0 != r8) goto L_0x00ef
            android.os.Parcel r10 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            int r0 = r11.length     // Catch:{ ParseException -> 0x00d7 }
            r10.unmarshall(r11, r5, r0)     // Catch:{ ParseException -> 0x00d7 }
            r10.setDataPosition(r5)     // Catch:{ ParseException -> 0x00d7 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkw> r0 = com.google.android.gms.measurement.internal.zzkw.CREATOR     // Catch:{ ParseException -> 0x00d7 }
            java.lang.Object r0 = r0.createFromParcel(r10)     // Catch:{ ParseException -> 0x00d7 }
            com.google.android.gms.measurement.internal.zzkw r0 = (com.google.android.gms.measurement.internal.zzkw) r0     // Catch:{ ParseException -> 0x00d7 }
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            goto L_0x00e8
        L_0x00d5:
            r0 = move-exception
            goto L_0x00eb
        L_0x00d7:
            com.google.android.gms.measurement.internal.zzex r0 = r20.zzq()     // Catch:{ all -> 0x00d5 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ all -> 0x00d5 }
            java.lang.String r11 = "Failed to load user property from local database"
            r0.zza(r11)     // Catch:{ all -> 0x00d5 }
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            r0 = r2
        L_0x00e8:
            if (r0 == 0) goto L_0x0074
            goto L_0x00a1
        L_0x00eb:
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
        L_0x00ef:
            if (r0 != r10) goto L_0x0122
            android.os.Parcel r10 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            int r0 = r11.length     // Catch:{ ParseException -> 0x010a }
            r10.unmarshall(r11, r5, r0)     // Catch:{ ParseException -> 0x010a }
            r10.setDataPosition(r5)     // Catch:{ ParseException -> 0x010a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r0 = com.google.android.gms.measurement.internal.zzw.CREATOR     // Catch:{ ParseException -> 0x010a }
            java.lang.Object r0 = r0.createFromParcel(r10)     // Catch:{ ParseException -> 0x010a }
            com.google.android.gms.measurement.internal.zzw r0 = (com.google.android.gms.measurement.internal.zzw) r0     // Catch:{ ParseException -> 0x010a }
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            goto L_0x011b
        L_0x0108:
            r0 = move-exception
            goto L_0x011e
        L_0x010a:
            com.google.android.gms.measurement.internal.zzex r0 = r20.zzq()     // Catch:{ all -> 0x0108 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ all -> 0x0108 }
            java.lang.String r11 = "Failed to load conditional user property from local database"
            r0.zza(r11)     // Catch:{ all -> 0x0108 }
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            r0 = r2
        L_0x011b:
            if (r0 == 0) goto L_0x0074
            goto L_0x00a1
        L_0x011e:
            r10.recycle()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
        L_0x0122:
            r10 = 3
            if (r0 != r10) goto L_0x0134
            com.google.android.gms.measurement.internal.zzex r0 = r20.zzq()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            java.lang.String r10 = "Skipping app launch break"
        L_0x012f:
            r0.zza(r10)     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            goto L_0x0074
        L_0x0134:
            com.google.android.gms.measurement.internal.zzex r0 = r20.zzq()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            java.lang.String r10 = "Unknown record type in local database"
            goto L_0x012f
        L_0x013f:
            java.lang.String r0 = "messages"
            java.lang.String r10 = "rowid <= ?"
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            java.lang.String r12 = java.lang.Long.toString(r18)     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            r11[r5] = r12     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            int r0 = r4.delete(r0, r10, r11)     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            int r10 = r3.size()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            if (r0 >= r10) goto L_0x0162
            com.google.android.gms.measurement.internal.zzex r0 = r20.zzq()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            java.lang.String r10 = "Fewer entries removed from local database than expected"
            r0.zza(r10)     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
        L_0x0162:
            r4.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            r4.endTransaction()     // Catch:{ SQLiteFullException -> 0x0175, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x0173 }
            if (r9 == 0) goto L_0x016d
            r9.close()
        L_0x016d:
            if (r4 == 0) goto L_0x0172
            r4.close()
        L_0x0172:
            return r3
        L_0x0173:
            r0 = move-exception
            goto L_0x0195
        L_0x0175:
            r0 = move-exception
            goto L_0x01cd
        L_0x0178:
            r0 = move-exception
            goto L_0x0180
        L_0x017a:
            r0 = move-exception
            goto L_0x0185
        L_0x017c:
            r0 = move-exception
            goto L_0x018c
        L_0x017e:
            r0 = move-exception
            r4 = r15
        L_0x0180:
            r9 = r2
            goto L_0x01ea
        L_0x0183:
            r0 = move-exception
            r4 = r15
        L_0x0185:
            r9 = r2
            goto L_0x0195
        L_0x0187:
            r4 = r15
        L_0x0188:
            r9 = r2
            goto L_0x01b9
        L_0x018a:
            r0 = move-exception
            r4 = r15
        L_0x018c:
            r9 = r2
            goto L_0x01cd
        L_0x018e:
            r0 = move-exception
            r4 = r2
            r9 = r4
            goto L_0x01ea
        L_0x0192:
            r0 = move-exception
            r4 = r2
            r9 = r4
        L_0x0195:
            if (r4 == 0) goto L_0x01a0
            boolean r10 = r4.inTransaction()     // Catch:{ all -> 0x01e9 }
            if (r10 == 0) goto L_0x01a0
            r4.endTransaction()     // Catch:{ all -> 0x01e9 }
        L_0x01a0:
            com.google.android.gms.measurement.internal.zzex r10 = r20.zzq()     // Catch:{ all -> 0x01e9 }
            com.google.android.gms.measurement.internal.zzez r10 = r10.zze()     // Catch:{ all -> 0x01e9 }
            java.lang.String r11 = "Error reading entries from local database"
            r10.zza(r11, r0)     // Catch:{ all -> 0x01e9 }
            r1.zzb = r8     // Catch:{ all -> 0x01e9 }
            if (r9 == 0) goto L_0x01b4
            r9.close()
        L_0x01b4:
            if (r4 == 0) goto L_0x01e4
            goto L_0x01c6
        L_0x01b7:
            r4 = r2
            r9 = r4
        L_0x01b9:
            long r10 = (long) r7
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x01e9 }
            int r7 = r7 + 20
            if (r9 == 0) goto L_0x01c4
            r9.close()
        L_0x01c4:
            if (r4 == 0) goto L_0x01e4
        L_0x01c6:
            r4.close()
            goto L_0x01e4
        L_0x01ca:
            r0 = move-exception
            r4 = r2
            r9 = r4
        L_0x01cd:
            com.google.android.gms.measurement.internal.zzex r10 = r20.zzq()     // Catch:{ all -> 0x01e9 }
            com.google.android.gms.measurement.internal.zzez r10 = r10.zze()     // Catch:{ all -> 0x01e9 }
            java.lang.String r11 = "Error reading entries from local database"
            r10.zza(r11, r0)     // Catch:{ all -> 0x01e9 }
            r1.zzb = r8     // Catch:{ all -> 0x01e9 }
            if (r9 == 0) goto L_0x01e1
            r9.close()
        L_0x01e1:
            if (r4 == 0) goto L_0x01e4
            goto L_0x01c6
        L_0x01e4:
            int r6 = r6 + 1
            r4 = 5
            goto L_0x001b
        L_0x01e9:
            r0 = move-exception
        L_0x01ea:
            if (r9 == 0) goto L_0x01ef
            r9.close()
        L_0x01ef:
            if (r4 == 0) goto L_0x01f4
            r4.close()
        L_0x01f4:
            throw r0
        L_0x01f5:
            com.google.android.gms.measurement.internal.zzex r0 = r20.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()
            java.lang.String r3 = "Failed to read events from database in reasonable time"
            r0.zza(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzet.zza(int):java.util.List");
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final boolean zza(zzar zzar) {
        Parcel obtain = Parcel.obtain();
        zzar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzq().zzf().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkw zzkw) {
        Parcel obtain = Parcel.obtain();
        zzkw.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzq().zzf().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzw zzw) {
        zzo();
        byte[] zza2 = zzkx.zza((Parcelable) zzw);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzq().zzf().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final void zzaa() {
        zzc();
        try {
            int delete = zzad().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzq().zzw().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzab() {
        return zza(3, new byte[0]);
    }

    public final boolean zzac() {
        zzc();
        if (this.zzb || !zzae()) {
            return false;
        }
        int i = 0;
        int i2 = 5;
        while (i < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = zzad();
                if (sQLiteDatabase == null) {
                    this.zzb = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return false;
                }
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return true;
            } catch (SQLiteFullException e) {
                zzq().zze().zza("Error deleting app launch break from local database", e);
                this.zzb = true;
                if (sQLiteDatabase == null) {
                    i++;
                }
                sQLiteDatabase.close();
                i++;
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep((long) i2);
                i2 += 20;
                if (sQLiteDatabase == null) {
                    i++;
                }
                sQLiteDatabase.close();
                i++;
            } catch (SQLiteException e2) {
                if (sQLiteDatabase != null) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                zzq().zze().zza("Error deleting app launch break from local database", e2);
                this.zzb = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    i++;
                } else {
                    i++;
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        zzq().zzh().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzhe zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzeq zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zziv zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzim zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzet zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzkb zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzev zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfu zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzex zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return false;
    }
}
