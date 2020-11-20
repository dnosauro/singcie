package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbv;

final class zzs extends zzv {
    private zzbv.zzb zzg;
    private final /* synthetic */ zzo zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzs(zzo zzo, String str, int i, zzbv.zzb zzb) {
        super(str, i);
        this.zzh = zzo;
        this.zzg = zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzg.zzb();
    }

    /* JADX WARNING: type inference failed for: r7v3, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r7v11, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0105, code lost:
        if (r4.booleanValue() == false) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0107, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x013c, code lost:
        r4.zza(r5, r0.zzh.zzn().zza(r9));
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0342 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0343  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.Long r16, java.lang.Long r17, com.google.android.gms.internal.measurement.zzcd.zzc r18, long r19, com.google.android.gms.measurement.internal.zzan r21, boolean r22) {
        /*
            r15 = this;
            r0 = r15
            boolean r1 = com.google.android.gms.internal.measurement.zzms.zzb()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001b
            com.google.android.gms.measurement.internal.zzo r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzy r1 = r1.zzs()
            java.lang.String r4 = r0.zza
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzbc
            boolean r1 = r1.zzd(r4, r5)
            if (r1 == 0) goto L_0x001b
            r1 = 1
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            com.google.android.gms.internal.measurement.zzbv$zzb r4 = r0.zzg
            boolean r4 = r4.zzk()
            if (r4 == 0) goto L_0x0029
            r4 = r21
            long r4 = r4.zze
            goto L_0x002b
        L_0x0029:
            r4 = r19
        L_0x002b:
            com.google.android.gms.measurement.internal.zzo r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            r7 = 2
            boolean r6 = r6.zza((int) r7)
            r7 = 0
            if (r6 == 0) goto L_0x008d
            com.google.android.gms.measurement.internal.zzo r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzw()
            java.lang.String r8 = "Evaluating filter. audience, filter, event"
            int r9 = r0.zzb
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            com.google.android.gms.internal.measurement.zzbv$zzb r10 = r0.zzg
            boolean r10 = r10.zza()
            if (r10 == 0) goto L_0x005e
            com.google.android.gms.internal.measurement.zzbv$zzb r10 = r0.zzg
            int r10 = r10.zzb()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x005f
        L_0x005e:
            r10 = r7
        L_0x005f:
            com.google.android.gms.measurement.internal.zzo r11 = r0.zzh
            com.google.android.gms.measurement.internal.zzev r11 = r11.zzn()
            com.google.android.gms.internal.measurement.zzbv$zzb r12 = r0.zzg
            java.lang.String r12 = r12.zzc()
            java.lang.String r11 = r11.zza((java.lang.String) r12)
            r6.zza(r8, r9, r10, r11)
            com.google.android.gms.measurement.internal.zzo r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzw()
            java.lang.String r8 = "Filter definition"
            com.google.android.gms.measurement.internal.zzo r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzkt r9 = r9.mo18590f_()
            com.google.android.gms.internal.measurement.zzbv$zzb r10 = r0.zzg
            java.lang.String r9 = r9.zza((com.google.android.gms.internal.measurement.zzbv.zzb) r10)
            r6.zza(r8, r9)
        L_0x008d:
            com.google.android.gms.internal.measurement.zzbv$zzb r6 = r0.zzg
            boolean r6 = r6.zza()
            if (r6 == 0) goto L_0x038c
            com.google.android.gms.internal.measurement.zzbv$zzb r6 = r0.zzg
            int r6 = r6.zzb()
            r8 = 256(0x100, float:3.59E-43)
            if (r6 <= r8) goto L_0x00a1
            goto L_0x038c
        L_0x00a1:
            com.google.android.gms.internal.measurement.zzbv$zzb r6 = r0.zzg
            boolean r6 = r6.zzh()
            com.google.android.gms.internal.measurement.zzbv$zzb r8 = r0.zzg
            boolean r8 = r8.zzi()
            com.google.android.gms.internal.measurement.zzbv$zzb r9 = r0.zzg
            boolean r9 = r9.zzk()
            if (r6 != 0) goto L_0x00bc
            if (r8 != 0) goto L_0x00bc
            if (r9 == 0) goto L_0x00ba
            goto L_0x00bc
        L_0x00ba:
            r6 = 0
            goto L_0x00bd
        L_0x00bc:
            r6 = 1
        L_0x00bd:
            if (r22 == 0) goto L_0x00e9
            if (r6 != 0) goto L_0x00e9
            com.google.android.gms.measurement.internal.zzo r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            int r4 = r0.zzb
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzbv$zzb r5 = r0.zzg
            boolean r5 = r5.zza()
            if (r5 == 0) goto L_0x00e5
            com.google.android.gms.internal.measurement.zzbv$zzb r5 = r0.zzg
            int r5 = r5.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
        L_0x00e5:
            r1.zza(r3, r4, r7)
            return r2
        L_0x00e9:
            com.google.android.gms.internal.measurement.zzbv$zzb r8 = r0.zzg
            java.lang.String r9 = r18.zzc()
            boolean r10 = r8.zzf()
            if (r10 == 0) goto L_0x010d
            com.google.android.gms.internal.measurement.zzbv$zzd r10 = r8.zzg()
            java.lang.Boolean r4 = zza((long) r4, (com.google.android.gms.internal.measurement.zzbv.zzd) r10)
            if (r4 != 0) goto L_0x0101
            goto L_0x032b
        L_0x0101:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x010d
        L_0x0107:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            goto L_0x032b
        L_0x010d:
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.List r5 = r8.zzd()
            java.util.Iterator r5 = r5.iterator()
        L_0x011a:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x0153
            java.lang.Object r10 = r5.next()
            com.google.android.gms.internal.measurement.zzbv$zzc r10 = (com.google.android.gms.internal.measurement.zzbv.zzc) r10
            java.lang.String r11 = r10.zzh()
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x014b
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "null or empty param name in filter. event"
        L_0x013c:
            com.google.android.gms.measurement.internal.zzo r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzn()
            java.lang.String r8 = r8.zza((java.lang.String) r9)
            r4.zza(r5, r8)
            goto L_0x032b
        L_0x014b:
            java.lang.String r10 = r10.zzh()
            r4.add(r10)
            goto L_0x011a
        L_0x0153:
            androidx.c.a r5 = new androidx.c.a
            r5.<init>()
            java.util.List r10 = r18.zza()
            java.util.Iterator r10 = r10.iterator()
        L_0x0160:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x01e5
            java.lang.Object r11 = r10.next()
            com.google.android.gms.internal.measurement.zzcd$zze r11 = (com.google.android.gms.internal.measurement.zzcd.zze) r11
            java.lang.String r12 = r11.zzb()
            boolean r12 = r4.contains(r12)
            if (r12 == 0) goto L_0x0160
            boolean r12 = r11.zze()
            if (r12 == 0) goto L_0x0191
            java.lang.String r12 = r11.zzb()
            boolean r13 = r11.zze()
            if (r13 == 0) goto L_0x018f
            long r13 = r11.zzf()
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            goto L_0x01b8
        L_0x018f:
            r11 = r7
            goto L_0x01b8
        L_0x0191:
            boolean r12 = r11.zzi()
            if (r12 == 0) goto L_0x01aa
            java.lang.String r12 = r11.zzb()
            boolean r13 = r11.zzi()
            if (r13 == 0) goto L_0x018f
            double r13 = r11.zzj()
            java.lang.Double r11 = java.lang.Double.valueOf(r13)
            goto L_0x01b8
        L_0x01aa:
            boolean r12 = r11.zzc()
            if (r12 == 0) goto L_0x01bc
            java.lang.String r12 = r11.zzb()
            java.lang.String r11 = r11.zzd()
        L_0x01b8:
            r5.put(r12, r11)
            goto L_0x0160
        L_0x01bc:
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "Unknown value for param. event, param"
            com.google.android.gms.measurement.internal.zzo r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzn()
            java.lang.String r8 = r8.zza((java.lang.String) r9)
            com.google.android.gms.measurement.internal.zzo r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzn()
            java.lang.String r10 = r11.zzb()
            java.lang.String r9 = r9.zzb(r10)
        L_0x01e0:
            r4.zza(r5, r8, r9)
            goto L_0x032b
        L_0x01e5:
            java.util.List r4 = r8.zzd()
            java.util.Iterator r4 = r4.iterator()
        L_0x01ed:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x0327
            java.lang.Object r8 = r4.next()
            com.google.android.gms.internal.measurement.zzbv$zzc r8 = (com.google.android.gms.internal.measurement.zzbv.zzc) r8
            boolean r10 = r8.zze()
            if (r10 == 0) goto L_0x0207
            boolean r10 = r8.zzf()
            if (r10 == 0) goto L_0x0207
            r10 = 1
            goto L_0x0208
        L_0x0207:
            r10 = 0
        L_0x0208:
            java.lang.String r11 = r8.zzh()
            boolean r12 = r11.isEmpty()
            if (r12 == 0) goto L_0x0220
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "Event has empty param name. event"
            goto L_0x013c
        L_0x0220:
            java.lang.Object r12 = r5.get(r11)
            boolean r13 = r12 instanceof java.lang.Long
            if (r13 == 0) goto L_0x0269
            boolean r13 = r8.zzc()
            if (r13 != 0) goto L_0x024f
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "No number filter for long param. event, param"
        L_0x023a:
            com.google.android.gms.measurement.internal.zzo r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzn()
            java.lang.String r8 = r8.zza((java.lang.String) r9)
            com.google.android.gms.measurement.internal.zzo r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzn()
            java.lang.String r9 = r9.zzb(r11)
            goto L_0x01e0
        L_0x024f:
            java.lang.Long r12 = (java.lang.Long) r12
            long r11 = r12.longValue()
            com.google.android.gms.internal.measurement.zzbv$zzd r8 = r8.zzd()
            java.lang.Boolean r8 = zza((long) r11, (com.google.android.gms.internal.measurement.zzbv.zzd) r8)
            if (r8 != 0) goto L_0x0261
            goto L_0x032b
        L_0x0261:
            boolean r8 = r8.booleanValue()
            if (r8 != r10) goto L_0x01ed
            goto L_0x0107
        L_0x0269:
            boolean r13 = r12 instanceof java.lang.Double
            if (r13 == 0) goto L_0x029a
            boolean r13 = r8.zzc()
            if (r13 != 0) goto L_0x0280
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "No number filter for double param. event, param"
            goto L_0x023a
        L_0x0280:
            java.lang.Double r12 = (java.lang.Double) r12
            double r11 = r12.doubleValue()
            com.google.android.gms.internal.measurement.zzbv$zzd r8 = r8.zzd()
            java.lang.Boolean r8 = zza((double) r11, (com.google.android.gms.internal.measurement.zzbv.zzd) r8)
            if (r8 != 0) goto L_0x0292
            goto L_0x032b
        L_0x0292:
            boolean r8 = r8.booleanValue()
            if (r8 != r10) goto L_0x01ed
            goto L_0x0107
        L_0x029a:
            boolean r13 = r12 instanceof java.lang.String
            if (r13 == 0) goto L_0x02f2
            boolean r13 = r8.zza()
            if (r13 == 0) goto L_0x02b5
            java.lang.String r12 = (java.lang.String) r12
            com.google.android.gms.internal.measurement.zzbv$zzf r8 = r8.zzb()
            com.google.android.gms.measurement.internal.zzo r11 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r11 = r11.zzq()
            java.lang.Boolean r8 = zza((java.lang.String) r12, (com.google.android.gms.internal.measurement.zzbv.zzf) r8, (com.google.android.gms.measurement.internal.zzex) r11)
            goto L_0x02cb
        L_0x02b5:
            boolean r13 = r8.zzc()
            if (r13 == 0) goto L_0x02e4
            java.lang.String r12 = (java.lang.String) r12
            boolean r13 = com.google.android.gms.measurement.internal.zzkt.zza((java.lang.String) r12)
            if (r13 == 0) goto L_0x02d6
            com.google.android.gms.internal.measurement.zzbv$zzd r8 = r8.zzd()
            java.lang.Boolean r8 = zza((java.lang.String) r12, (com.google.android.gms.internal.measurement.zzbv.zzd) r8)
        L_0x02cb:
            if (r8 != 0) goto L_0x02ce
            goto L_0x032b
        L_0x02ce:
            boolean r8 = r8.booleanValue()
            if (r8 != r10) goto L_0x01ed
            goto L_0x0107
        L_0x02d6:
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "Invalid param value for number filter. event, param"
            goto L_0x023a
        L_0x02e4:
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "No filter for String param. event, param"
            goto L_0x023a
        L_0x02f2:
            if (r12 != 0) goto L_0x0319
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzw()
            java.lang.String r5 = "Missing param for filter. event, param"
            com.google.android.gms.measurement.internal.zzo r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzn()
            java.lang.String r7 = r7.zza((java.lang.String) r9)
            com.google.android.gms.measurement.internal.zzo r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzn()
            java.lang.String r8 = r8.zzb(r11)
            r4.zza(r5, r7, r8)
            goto L_0x0107
        L_0x0319:
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzh()
            java.lang.String r5 = "Unknown param type. event, param"
            goto L_0x023a
        L_0x0327:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
        L_0x032b:
            com.google.android.gms.measurement.internal.zzo r4 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzw()
            java.lang.String r5 = "Event filter result"
            if (r7 != 0) goto L_0x033c
            java.lang.String r8 = "null"
            goto L_0x033d
        L_0x033c:
            r8 = r7
        L_0x033d:
            r4.zza(r5, r8)
            if (r7 != 0) goto L_0x0343
            return r3
        L_0x0343:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r0.zzc = r3
            boolean r3 = r7.booleanValue()
            if (r3 != 0) goto L_0x0350
            return r2
        L_0x0350:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r0.zzd = r3
            if (r6 == 0) goto L_0x038b
            boolean r3 = r18.zzd()
            if (r3 == 0) goto L_0x038b
            long r3 = r18.zze()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            com.google.android.gms.internal.measurement.zzbv$zzb r4 = r0.zzg
            boolean r4 = r4.zzi()
            if (r4 == 0) goto L_0x037d
            if (r1 == 0) goto L_0x037a
            com.google.android.gms.internal.measurement.zzbv$zzb r1 = r0.zzg
            boolean r1 = r1.zzf()
            if (r1 == 0) goto L_0x037a
            r3 = r16
        L_0x037a:
            r0.zzf = r3
            goto L_0x038b
        L_0x037d:
            if (r1 == 0) goto L_0x0389
            com.google.android.gms.internal.measurement.zzbv$zzb r1 = r0.zzg
            boolean r1 = r1.zzf()
            if (r1 == 0) goto L_0x0389
            r3 = r17
        L_0x0389:
            r0.zze = r3
        L_0x038b:
            return r2
        L_0x038c:
            com.google.android.gms.measurement.internal.zzo r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzh()
            java.lang.String r2 = "Invalid event filter ID. appId, id"
            java.lang.String r4 = r0.zza
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r4)
            com.google.android.gms.internal.measurement.zzbv$zzb r5 = r0.zzg
            boolean r5 = r5.zza()
            if (r5 == 0) goto L_0x03b0
            com.google.android.gms.internal.measurement.zzbv$zzb r5 = r0.zzg
            int r5 = r5.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
        L_0x03b0:
            java.lang.String r5 = java.lang.String.valueOf(r7)
            r1.zza(r2, r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzs.zza(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzcd$zzc, long, com.google.android.gms.measurement.internal.zzan, boolean):boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return this.zzg.zzf();
    }
}
