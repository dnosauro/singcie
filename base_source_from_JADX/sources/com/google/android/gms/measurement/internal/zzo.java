package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

final class zzo extends zzkm {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzq> zzd;
    private Long zze;
    private Long zzf;

    zzo(zzkp zzkp) {
        super(zzkp);
    }

    private final zzq zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzq zzq = new zzq(this, this.zzb, (zzr) null);
        this.zzd.put(Integer.valueOf(i), zzq);
        return zzq;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.zzd.get(Integer.valueOf(i)).zzd.get(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x02d1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzcd.zza> zza(java.lang.String r47, java.util.List<com.google.android.gms.internal.measurement.zzcd.zzc> r48, java.util.List<com.google.android.gms.internal.measurement.zzcd.zzk> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
            r46 = this;
            r10 = r46
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r47)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r48)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r49)
            r0 = r47
            r10.zzb = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzc = r0
            androidx.c.a r0 = new androidx.c.a
            r0.<init>()
            r10.zzd = r0
            r0 = r50
            r10.zze = r0
            r0 = r51
            r10.zzf = r0
            java.util.Iterator r0 = r48.iterator()
        L_0x0029:
            boolean r1 = r0.hasNext()
            r11 = 0
            r12 = 1
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzcd$zzc r1 = (com.google.android.gms.internal.measurement.zzcd.zzc) r1
            java.lang.String r2 = "_s"
            java.lang.String r1 = r1.zzc()
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0029
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            boolean r0 = com.google.android.gms.internal.measurement.zzms.zzb()
            if (r0 == 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzy r0 = r46.zzs()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbc
            boolean r0 = r0.zzd(r2, r3)
            if (r0 == 0) goto L_0x005c
            r13 = 1
            goto L_0x005d
        L_0x005c:
            r13 = 0
        L_0x005d:
            boolean r0 = com.google.android.gms.internal.measurement.zzms.zzb()
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzy r0 = r46.zzs()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbb
            boolean r0 = r0.zzd(r2, r3)
            if (r0 == 0) goto L_0x0073
            r14 = 1
            goto L_0x0074
        L_0x0073:
            r14 = 0
        L_0x0074:
            if (r1 == 0) goto L_0x00b5
            com.google.android.gms.measurement.internal.zzac r2 = r46.zzi()
            java.lang.String r3 = r10.zzb
            r2.zzaj()
            r2.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r4 = "current_session_count"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r0.put(r4, r5)
            android.database.sqlite.SQLiteDatabase r4 = r2.mo18354c_()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x00a3 }
            r7[r11] = r3     // Catch:{ SQLiteException -> 0x00a3 }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00a3 }
            goto L_0x00b5
        L_0x00a3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)
            r2.zza(r4, r3, r0)
        L_0x00b5:
            java.util.Map r0 = java.util.Collections.emptyMap()
            if (r14 == 0) goto L_0x00c7
            if (r13 == 0) goto L_0x00c7
            com.google.android.gms.measurement.internal.zzac r0 = r46.zzi()
            java.lang.String r2 = r10.zzb
            java.util.Map r0 = r0.zze(r2)
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzac r2 = r46.zzi()
            java.lang.String r3 = r10.zzb
            java.util.Map r15 = r2.zzg(r3)
            boolean r2 = com.google.android.gms.internal.measurement.zzmy.zzb()
            if (r2 == 0) goto L_0x00e5
            com.google.android.gms.measurement.internal.zzy r2 = r46.zzs()
            java.lang.String r3 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzcm
            boolean r2 = r2.zzd(r3, r4)
            if (r2 != 0) goto L_0x00e7
        L_0x00e5:
            if (r15 == 0) goto L_0x036c
        L_0x00e7:
            boolean r2 = r15.isEmpty()
            if (r2 == 0) goto L_0x00ef
            goto L_0x036c
        L_0x00ef:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r3 = r15.keySet()
            r2.<init>(r3)
            if (r1 == 0) goto L_0x01d7
            java.lang.String r1 = r10.zzb
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            androidx.c.a r3 = new androidx.c.a
            r3.<init>()
            boolean r4 = r15.isEmpty()
            if (r4 != 0) goto L_0x01d5
            com.google.android.gms.measurement.internal.zzac r4 = r46.zzi()
            java.util.Map r1 = r4.zzf(r1)
            java.util.Set r4 = r15.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x011d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d5
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r15.get(r6)
            com.google.android.gms.internal.measurement.zzcd$zzi r6 = (com.google.android.gms.internal.measurement.zzcd.zzi) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r7 = r1.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x01cb
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x014b
            goto L_0x01cb
        L_0x014b:
            com.google.android.gms.measurement.internal.zzkt r8 = r46.mo18590f_()
            java.util.List r9 = r6.zzc()
            java.util.List r8 = r8.zza((java.util.List<java.lang.Long>) r9, (java.util.List<java.lang.Integer>) r7)
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x011d
            com.google.android.gms.internal.measurement.zzhv$zzb r9 = r6.zzbo()
            com.google.android.gms.internal.measurement.zzhv$zzb r9 = (com.google.android.gms.internal.measurement.zzhv.zzb) r9
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r9 = (com.google.android.gms.internal.measurement.zzcd.zzi.zza) r9
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r9 = r9.zzb()
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r8 = r9.zzb((java.lang.Iterable<? extends java.lang.Long>) r8)
            com.google.android.gms.measurement.internal.zzkt r9 = r46.mo18590f_()
            java.util.List r11 = r6.zza()
            java.util.List r9 = r9.zza((java.util.List<java.lang.Long>) r11, (java.util.List<java.lang.Integer>) r7)
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r11 = r8.zza()
            r11.zza((java.lang.Iterable<? extends java.lang.Long>) r9)
            r9 = 0
        L_0x0181:
            int r11 = r6.zzf()
            if (r9 >= r11) goto L_0x019f
            com.google.android.gms.internal.measurement.zzcd$zzb r11 = r6.zza((int) r9)
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x019c
            r8.zza((int) r9)
        L_0x019c:
            int r9 = r9 + 1
            goto L_0x0181
        L_0x019f:
            r9 = 0
        L_0x01a0:
            int r11 = r6.zzh()
            if (r9 >= r11) goto L_0x01be
            com.google.android.gms.internal.measurement.zzcd$zzj r11 = r6.zzb((int) r9)
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x01bb
            r8.zzb((int) r9)
        L_0x01bb:
            int r9 = r9 + 1
            goto L_0x01a0
        L_0x01be:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.zzjg r6 = r8.zzy()
            com.google.android.gms.internal.measurement.zzhv r6 = (com.google.android.gms.internal.measurement.zzhv) r6
            com.google.android.gms.internal.measurement.zzcd$zzi r6 = (com.google.android.gms.internal.measurement.zzcd.zzi) r6
            goto L_0x01cf
        L_0x01cb:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        L_0x01cf:
            r3.put(r5, r6)
            r11 = 0
            goto L_0x011d
        L_0x01d5:
            r11 = r3
            goto L_0x01d8
        L_0x01d7:
            r11 = r15
        L_0x01d8:
            java.util.Iterator r16 = r2.iterator()
        L_0x01dc:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x036c
            java.lang.Object r1 = r16.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r17 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzcd$zzi r1 = (com.google.android.gms.internal.measurement.zzcd.zzi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.c.a r7 = new androidx.c.a
            r7.<init>()
            if (r1 == 0) goto L_0x0244
            int r2 = r1.zzf()
            if (r2 != 0) goto L_0x020e
            goto L_0x0244
        L_0x020e:
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
        L_0x0216:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0244
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcd$zzb r3 = (com.google.android.gms.internal.measurement.zzcd.zzb) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x0216
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzc()
            if (r8 == 0) goto L_0x023f
            long r8 = r3.zzd()
            java.lang.Long r9 = java.lang.Long.valueOf(r8)
            goto L_0x0240
        L_0x023f:
            r9 = 0
        L_0x0240:
            r7.put(r4, r9)
            goto L_0x0216
        L_0x0244:
            androidx.c.a r8 = new androidx.c.a
            r8.<init>()
            if (r1 == 0) goto L_0x028b
            int r2 = r1.zzh()
            if (r2 != 0) goto L_0x0252
            goto L_0x028b
        L_0x0252:
            java.util.List r2 = r1.zzg()
            java.util.Iterator r2 = r2.iterator()
        L_0x025a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x028b
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcd$zzj r3 = (com.google.android.gms.internal.measurement.zzcd.zzj) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x025a
            int r4 = r3.zzd()
            if (r4 <= 0) goto L_0x025a
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r9 = r3.zzd()
            int r9 = r9 - r12
            long r18 = r3.zza((int) r9)
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r8.put(r4, r3)
            goto L_0x025a
        L_0x028b:
            if (r1 == 0) goto L_0x02d5
            r2 = 0
        L_0x028e:
            int r3 = r1.zzb()
            int r3 = r3 << 6
            if (r2 >= r3) goto L_0x02d5
            java.util.List r3 = r1.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzkt.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02c7
            com.google.android.gms.measurement.internal.zzex r3 = r46.zzq()
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzw()
            java.lang.String r4 = "Filter already evaluated. audience ID, filter ID"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r17)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
            r3.zza(r4, r9, r12)
            r6.set(r2)
            java.util.List r3 = r1.zzc()
            boolean r3 = com.google.android.gms.measurement.internal.zzkt.zza((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02c7
            r5.set(r2)
            r3 = 1
            goto L_0x02c8
        L_0x02c7:
            r3 = 0
        L_0x02c8:
            if (r3 != 0) goto L_0x02d1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r7.remove(r3)
        L_0x02d1:
            int r2 = r2 + 1
            r12 = 1
            goto L_0x028e
        L_0x02d5:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r15.get(r1)
            r4 = r1
            com.google.android.gms.internal.measurement.zzcd$zzi r4 = (com.google.android.gms.internal.measurement.zzcd.zzi) r4
            if (r14 == 0) goto L_0x0350
            if (r13 == 0) goto L_0x0350
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r0.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0350
            java.lang.Long r2 = r10.zzf
            if (r2 == 0) goto L_0x0350
            java.lang.Long r2 = r10.zze
            if (r2 != 0) goto L_0x02f9
            goto L_0x0350
        L_0x02f9:
            java.util.Iterator r1 = r1.iterator()
        L_0x02fd:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0350
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbv$zzb r2 = (com.google.android.gms.internal.measurement.zzbv.zzb) r2
            int r3 = r2.zzb()
            java.lang.Long r9 = r10.zzf
            long r18 = r9.longValue()
            r20 = 1000(0x3e8, double:4.94E-321)
            long r18 = r18 / r20
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x0325
            java.lang.Long r2 = r10.zze
            long r18 = r2.longValue()
            long r18 = r18 / r20
        L_0x0325:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r7.containsKey(r2)
            if (r2 == 0) goto L_0x033a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Long r9 = java.lang.Long.valueOf(r18)
            r7.put(r2, r9)
        L_0x033a:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r8.containsKey(r2)
            if (r2 == 0) goto L_0x02fd
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r8.put(r2, r3)
            goto L_0x02fd
        L_0x0350:
            com.google.android.gms.measurement.internal.zzq r12 = new com.google.android.gms.measurement.internal.zzq
            java.lang.String r3 = r10.zzb
            r9 = 0
            r1 = r12
            r2 = r46
            r18 = r11
            r11 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzq> r1 = r10.zzd
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r1.put(r2, r12)
            r11 = r18
            r12 = 1
            goto L_0x01dc
        L_0x036c:
            r11 = 0
            boolean r0 = r48.isEmpty()
            if (r0 != 0) goto L_0x04e5
            com.google.android.gms.measurement.internal.zzt r0 = new com.google.android.gms.measurement.internal.zzt
            r0.<init>(r10)
            androidx.c.a r1 = new androidx.c.a
            r1.<init>()
            java.util.Iterator r2 = r48.iterator()
        L_0x0381:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04e5
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcd$zzc r3 = (com.google.android.gms.internal.measurement.zzcd.zzc) r3
            java.lang.String r4 = r10.zzb
            com.google.android.gms.internal.measurement.zzcd$zzc r4 = r0.zza(r4, r3)
            if (r4 == 0) goto L_0x0381
            com.google.android.gms.measurement.internal.zzac r5 = r46.zzi()
            java.lang.String r13 = r10.zzb
            java.lang.String r6 = r4.zzc()
            java.lang.String r7 = r3.zzc()
            com.google.android.gms.measurement.internal.zzan r7 = r5.zza((java.lang.String) r13, (java.lang.String) r7)
            if (r7 != 0) goto L_0x03e2
            com.google.android.gms.measurement.internal.zzex r7 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzh()
            java.lang.String r8 = "Event aggregate wasn't created during raw event logging. appId, event"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r13)
            com.google.android.gms.measurement.internal.zzev r5 = r5.zzn()
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            r7.zza(r8, r9, r5)
            com.google.android.gms.measurement.internal.zzan r5 = new com.google.android.gms.measurement.internal.zzan
            r12 = r5
            java.lang.String r14 = r3.zzc()
            r15 = 1
            r17 = 1
            r19 = 1
            long r21 = r3.zze()
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)
            r3 = r5
            goto L_0x0417
        L_0x03e2:
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan
            r29 = r3
            java.lang.String r5 = r7.zza
            r30 = r5
            java.lang.String r5 = r7.zzb
            r31 = r5
            long r5 = r7.zzc
            r8 = 1
            long r32 = r5 + r8
            long r5 = r7.zzd
            long r34 = r5 + r8
            long r5 = r7.zze
            long r36 = r5 + r8
            long r5 = r7.zzf
            r38 = r5
            long r5 = r7.zzg
            r40 = r5
            java.lang.Long r5 = r7.zzh
            r42 = r5
            java.lang.Long r5 = r7.zzi
            r43 = r5
            java.lang.Long r5 = r7.zzj
            r44 = r5
            java.lang.Boolean r5 = r7.zzk
            r45 = r5
            r29.<init>(r30, r31, r32, r34, r36, r38, r40, r42, r43, r44, r45)
        L_0x0417:
            com.google.android.gms.measurement.internal.zzac r5 = r46.zzi()
            r5.zza((com.google.android.gms.measurement.internal.zzan) r3)
            long r5 = r3.zzc
            java.lang.String r7 = r4.zzc()
            java.lang.Object r8 = r1.get(r7)
            java.util.Map r8 = (java.util.Map) r8
            if (r8 != 0) goto L_0x0454
            com.google.android.gms.measurement.internal.zzac r8 = r46.zzi()
            java.lang.String r9 = r10.zzb
            java.util.Map r8 = r8.zzf(r9, r7)
            boolean r9 = com.google.android.gms.internal.measurement.zzmy.zzb()
            if (r9 == 0) goto L_0x044a
            com.google.android.gms.measurement.internal.zzy r9 = r46.zzs()
            java.lang.String r12 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzat.zzcm
            boolean r9 = r9.zzd(r12, r13)
            if (r9 != 0) goto L_0x0451
        L_0x044a:
            if (r8 != 0) goto L_0x0451
            androidx.c.a r8 = new androidx.c.a
            r8.<init>()
        L_0x0451:
            r1.put(r7, r8)
        L_0x0454:
            java.util.Set r7 = r8.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x045c:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0381
            java.lang.Object r9 = r7.next()
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.util.Set<java.lang.Integer> r12 = r10.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)
            boolean r12 = r12.contains(r13)
            if (r12 == 0) goto L_0x048a
            com.google.android.gms.measurement.internal.zzex r12 = r46.zzq()
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzw()
            java.lang.String r13 = "Skipping failed audience ID"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r12.zza(r13, r9)
            goto L_0x045c
        L_0x048a:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)
            java.lang.Object r12 = r8.get(r12)
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r20 = r12.iterator()
            r12 = 1
        L_0x0499:
            boolean r13 = r20.hasNext()
            if (r13 == 0) goto L_0x04d7
            java.lang.Object r12 = r20.next()
            com.google.android.gms.internal.measurement.zzbv$zzb r12 = (com.google.android.gms.internal.measurement.zzbv.zzb) r12
            com.google.android.gms.measurement.internal.zzs r15 = new com.google.android.gms.measurement.internal.zzs
            java.lang.String r13 = r10.zzb
            r15.<init>(r10, r13, r9, r12)
            java.lang.Long r13 = r10.zze
            java.lang.Long r14 = r10.zzf
            int r12 = r12.zzb()
            boolean r19 = r10.zza(r9, r12)
            r12 = r15
            r11 = r15
            r15 = r4
            r16 = r5
            r18 = r3
            boolean r12 = r12.zza(r13, r14, r15, r16, r18, r19)
            if (r12 == 0) goto L_0x04ce
            com.google.android.gms.measurement.internal.zzq r13 = r10.zza(r9)
            r13.zza((com.google.android.gms.measurement.internal.zzv) r11)
            r11 = 0
            goto L_0x0499
        L_0x04ce:
            java.util.Set<java.lang.Integer> r11 = r10.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)
            r11.add(r13)
        L_0x04d7:
            if (r12 != 0) goto L_0x04e2
            java.util.Set<java.lang.Integer> r11 = r10.zzc
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r11.add(r9)
        L_0x04e2:
            r11 = 0
            goto L_0x045c
        L_0x04e5:
            boolean r0 = r49.isEmpty()
            if (r0 != 0) goto L_0x0642
            androidx.c.a r0 = new androidx.c.a
            r0.<init>()
            java.util.Iterator r1 = r49.iterator()
        L_0x04f4:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0642
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzcd$zzk r2 = (com.google.android.gms.internal.measurement.zzcd.zzk) r2
            java.lang.String r3 = r2.zzc()
            java.lang.Object r4 = r0.get(r3)
            java.util.Map r4 = (java.util.Map) r4
            if (r4 != 0) goto L_0x0534
            com.google.android.gms.measurement.internal.zzac r4 = r46.zzi()
            java.lang.String r5 = r10.zzb
            java.util.Map r4 = r4.zzg(r5, r3)
            boolean r5 = com.google.android.gms.internal.measurement.zzmy.zzb()
            if (r5 == 0) goto L_0x052a
            com.google.android.gms.measurement.internal.zzy r5 = r46.zzs()
            java.lang.String r6 = r10.zzb
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzcm
            boolean r5 = r5.zzd(r6, r7)
            if (r5 != 0) goto L_0x0531
        L_0x052a:
            if (r4 != 0) goto L_0x0531
            androidx.c.a r4 = new androidx.c.a
            r4.<init>()
        L_0x0531:
            r0.put(r3, r4)
        L_0x0534:
            java.util.Set r3 = r4.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x053c:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x04f4
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set<java.lang.Integer> r6 = r10.zzc
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x056a
            com.google.android.gms.measurement.internal.zzex r2 = r46.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzw()
            java.lang.String r3 = "Skipping failed audience ID"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r2.zza(r3, r4)
            goto L_0x04f4
        L_0x056a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r4.get(r6)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r11 = 1
        L_0x0579:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0635
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzbv$zze r7 = (com.google.android.gms.internal.measurement.zzbv.zze) r7
            com.google.android.gms.measurement.internal.zzex r8 = r46.zzq()
            r9 = 2
            boolean r8 = r8.zza((int) r9)
            if (r8 == 0) goto L_0x05d2
            com.google.android.gms.measurement.internal.zzex r8 = r46.zzq()
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzw()
            java.lang.String r9 = "Evaluating filter. audience, filter, property"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
            boolean r12 = r7.zza()
            if (r12 == 0) goto L_0x05ad
            int r12 = r7.zzb()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x05ae
        L_0x05ad:
            r12 = 0
        L_0x05ae:
            com.google.android.gms.measurement.internal.zzev r13 = r46.zzn()
            java.lang.String r14 = r7.zzc()
            java.lang.String r13 = r13.zzc(r14)
            r8.zza(r9, r11, r12, r13)
            com.google.android.gms.measurement.internal.zzex r8 = r46.zzq()
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzw()
            java.lang.String r9 = "Filter definition"
            com.google.android.gms.measurement.internal.zzkt r11 = r46.mo18590f_()
            java.lang.String r11 = r11.zza((com.google.android.gms.internal.measurement.zzbv.zze) r7)
            r8.zza(r9, r11)
        L_0x05d2:
            boolean r8 = r7.zza()
            if (r8 == 0) goto L_0x060d
            int r8 = r7.zzb()
            r9 = 256(0x100, float:3.59E-43)
            if (r8 <= r9) goto L_0x05e1
            goto L_0x060d
        L_0x05e1:
            com.google.android.gms.measurement.internal.zzu r8 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r9 = r10.zzb
            r8.<init>(r10, r9, r5, r7)
            java.lang.Long r9 = r10.zze
            java.lang.Long r11 = r10.zzf
            int r7 = r7.zzb()
            boolean r7 = r10.zza(r5, r7)
            boolean r11 = r8.zza(r9, r11, r2, r7)
            if (r11 == 0) goto L_0x0603
            com.google.android.gms.measurement.internal.zzq r7 = r10.zza(r5)
            r7.zza((com.google.android.gms.measurement.internal.zzv) r8)
            goto L_0x0579
        L_0x0603:
            java.util.Set<java.lang.Integer> r6 = r10.zzc
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r6.add(r7)
            goto L_0x0635
        L_0x060d:
            com.google.android.gms.measurement.internal.zzex r6 = r46.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            java.lang.String r9 = r10.zzb
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r9)
            boolean r11 = r7.zza()
            if (r11 == 0) goto L_0x062c
            int r7 = r7.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x062d
        L_0x062c:
            r7 = 0
        L_0x062d:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r6.zza(r8, r9, r7)
            r11 = 0
        L_0x0635:
            if (r11 != 0) goto L_0x053c
            java.util.Set<java.lang.Integer> r6 = r10.zzc
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.add(r5)
            goto L_0x053c
        L_0x0642:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzq> r0 = r10.zzd
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r2 = r10.zzc
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0656:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x06e6
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzq> r3 = r10.zzd
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzq r3 = (com.google.android.gms.measurement.internal.zzq) r3
            com.google.android.gms.internal.measurement.zzcd$zza r3 = r3.zza((int) r0)
            r1.add(r3)
            com.google.android.gms.measurement.internal.zzac r4 = r46.zzi()
            java.lang.String r5 = r10.zzb
            com.google.android.gms.internal.measurement.zzcd$zzi r3 = r3.zzc()
            r4.zzaj()
            r4.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.zzbk()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            java.lang.String r7 = "audience_id"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.put(r7, r0)
            java.lang.String r0 = "current_results"
            r6.put(r0, r3)
            android.database.sqlite.SQLiteDatabase r0 = r4.mo18354c_()     // Catch:{ SQLiteException -> 0x06d1 }
            java.lang.String r3 = "audience_filter_values"
            r7 = 5
            r8 = 0
            long r6 = r0.insertWithOnConflict(r3, r8, r6, r7)     // Catch:{ SQLiteException -> 0x06cf }
            r11 = -1
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0656
            com.google.android.gms.measurement.internal.zzex r0 = r4.zzq()     // Catch:{ SQLiteException -> 0x06cf }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteException -> 0x06cf }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r5)     // Catch:{ SQLiteException -> 0x06cf }
            r0.zza(r3, r6)     // Catch:{ SQLiteException -> 0x06cf }
            goto L_0x0656
        L_0x06cf:
            r0 = move-exception
            goto L_0x06d3
        L_0x06d1:
            r0 = move-exception
            r8 = 0
        L_0x06d3:
            com.google.android.gms.measurement.internal.zzex r3 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()
            java.lang.String r4 = "Error storing filter results. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r5)
            r3.zza(r4, r5, r0)
            goto L_0x0656
        L_0x06e6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzo.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }
}
