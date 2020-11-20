package com.google.android.gms.measurement.internal;

final class zzil extends zzkm {
    public zzil(zzkp zzkp) {
        super(zzkp);
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ac, code lost:
        if (android.text.TextUtils.isEmpty((java.lang.CharSequence) null) == false) goto L_0x01ae;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02ad A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02ca A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0324 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x038a A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }, LOOP:2: B:139:0x0384->B:141:0x038a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03e7 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x040e A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0441 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0467 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0499 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x04e9 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }, LOOP:3: B:158:0x04e3->B:160:0x04e9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0556 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x056d A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0578 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x057c A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02db A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a2 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01b2 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0220 A[Catch:{ SecurityException -> 0x022c, all -> 0x0616 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(com.google.android.gms.measurement.internal.zzar r30, java.lang.String r31) {
        /*
            r29 = this;
            r1 = r29
            r0 = r30
            r15 = r31
            r29.zzc()
            com.google.android.gms.measurement.internal.zzgb r2 = r1.zzy
            r2.zzad()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            com.google.android.gms.measurement.internal.zzy r2 = r29.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzaw
            boolean r2 = r2.zze(r15, r3)
            r3 = 0
            if (r2 != 0) goto L_0x0031
            com.google.android.gms.measurement.internal.zzex r0 = r29.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()
            java.lang.String r2 = "Generating ScionPayload disabled. packageName"
            r0.zza(r2, r15)
            byte[] r0 = new byte[r3]
            return r0
        L_0x0031:
            java.lang.String r2 = "_iap"
            java.lang.String r4 = r0.zza
            boolean r2 = r2.equals(r4)
            r14 = 0
            if (r2 != 0) goto L_0x0056
            java.lang.String r2 = "_iapx"
            java.lang.String r4 = r0.zza
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzex r2 = r29.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzv()
            java.lang.String r3 = "Generating a payload for this event is not available. package_name, event_name"
            java.lang.String r0 = r0.zza
            r2.zza(r3, r15, r0)
            return r14
        L_0x0056:
            com.google.android.gms.internal.measurement.zzcd$zzf$zza r13 = com.google.android.gms.internal.measurement.zzcd.zzf.zzb()
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()
            r2.zze()
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzf r11 = r2.zzb(r15)     // Catch:{ all -> 0x0616 }
            if (r11 != 0) goto L_0x0082
            com.google.android.gms.measurement.internal.zzex r0 = r29.zzq()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()     // Catch:{ all -> 0x0616 }
            java.lang.String r2 = "Log and bundle not available. package_name"
            r0.zza(r2, r15)     // Catch:{ all -> 0x0616 }
            byte[] r0 = new byte[r3]     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()
            r2.zzg()
            return r0
        L_0x0082:
            boolean r2 = r11.zzr()     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x009f
            com.google.android.gms.measurement.internal.zzex r0 = r29.zzq()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()     // Catch:{ all -> 0x0616 }
            java.lang.String r2 = "Log and bundle disabled. package_name"
            r0.zza(r2, r15)     // Catch:{ all -> 0x0616 }
            byte[] r0 = new byte[r3]     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()
            r2.zzg()
            return r0
        L_0x009f:
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = com.google.android.gms.internal.measurement.zzcd.zzg.zzbh()     // Catch:{ all -> 0x0616 }
            r4 = 1
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r2.zza((int) r4)     // Catch:{ all -> 0x0616 }
            java.lang.String r4 = "android"
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r12 = r2.zza((java.lang.String) r4)     // Catch:{ all -> 0x0616 }
            java.lang.String r2 = r11.zzc()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x00bf
            java.lang.String r2 = r11.zzc()     // Catch:{ all -> 0x0616 }
            r12.zzf((java.lang.String) r2)     // Catch:{ all -> 0x0616 }
        L_0x00bf:
            java.lang.String r2 = r11.zzn()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x00d0
            java.lang.String r2 = r11.zzn()     // Catch:{ all -> 0x0616 }
            r12.zze((java.lang.String) r2)     // Catch:{ all -> 0x0616 }
        L_0x00d0:
            java.lang.String r2 = r11.zzl()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x00e1
            java.lang.String r2 = r11.zzl()     // Catch:{ all -> 0x0616 }
            r12.zzg((java.lang.String) r2)     // Catch:{ all -> 0x0616 }
        L_0x00e1:
            long r4 = r11.zzm()     // Catch:{ all -> 0x0616 }
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x00f4
            long r4 = r11.zzm()     // Catch:{ all -> 0x0616 }
            int r2 = (int) r4     // Catch:{ all -> 0x0616 }
            r12.zzh((int) r2)     // Catch:{ all -> 0x0616 }
        L_0x00f4:
            long r4 = r11.zzo()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r12.zzf((long) r4)     // Catch:{ all -> 0x0616 }
            long r4 = r11.zzq()     // Catch:{ all -> 0x0616 }
            r2.zzk((long) r4)     // Catch:{ all -> 0x0616 }
            boolean r2 = com.google.android.gms.internal.measurement.zznq.zzb()     // Catch:{ all -> 0x0616 }
            if (r2 == 0) goto L_0x014f
            com.google.android.gms.measurement.internal.zzy r2 = r29.zzs()     // Catch:{ all -> 0x0616 }
            java.lang.String r4 = r11.zzc()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzbj     // Catch:{ all -> 0x0616 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x0616 }
            if (r2 == 0) goto L_0x014f
            java.lang.String r2 = r11.zze()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x012b
            java.lang.String r2 = r11.zze()     // Catch:{ all -> 0x0616 }
        L_0x0127:
            r12.zzk((java.lang.String) r2)     // Catch:{ all -> 0x0616 }
            goto L_0x016d
        L_0x012b:
            java.lang.String r2 = r11.zzg()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x013d
            java.lang.String r2 = r11.zzg()     // Catch:{ all -> 0x0616 }
            r12.zzp(r2)     // Catch:{ all -> 0x0616 }
            goto L_0x016d
        L_0x013d:
            java.lang.String r2 = r11.zzf()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x016d
            java.lang.String r2 = r11.zzf()     // Catch:{ all -> 0x0616 }
        L_0x014b:
            r12.zzo(r2)     // Catch:{ all -> 0x0616 }
            goto L_0x016d
        L_0x014f:
            java.lang.String r2 = r11.zze()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x015e
            java.lang.String r2 = r11.zze()     // Catch:{ all -> 0x0616 }
            goto L_0x0127
        L_0x015e:
            java.lang.String r2 = r11.zzf()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x016d
            java.lang.String r2 = r11.zzf()     // Catch:{ all -> 0x0616 }
            goto L_0x014b
        L_0x016d:
            com.google.android.gms.measurement.internal.zzkp r2 = r1.zza     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzad r2 = r2.zza((java.lang.String) r15)     // Catch:{ all -> 0x0616 }
            long r4 = r11.zzp()     // Catch:{ all -> 0x0616 }
            r12.zzh((long) r4)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzgb r4 = r1.zzy     // Catch:{ all -> 0x0616 }
            boolean r4 = r4.zzaa()     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01bc
            com.google.android.gms.measurement.internal.zzy r4 = r29.zzs()     // Catch:{ all -> 0x0616 }
            java.lang.String r5 = r12.zzj()     // Catch:{ all -> 0x0616 }
            boolean r4 = r4.zzh(r5)     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01bc
            boolean r4 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01b2
            com.google.android.gms.measurement.internal.zzy r4 = r29.zzs()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0616 }
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r5)     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01b2
            boolean r4 = r2.zzc()     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01bc
            boolean r4 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0616 }
            if (r4 != 0) goto L_0x01bc
        L_0x01ae:
            r12.zzn(r14)     // Catch:{ all -> 0x0616 }
            goto L_0x01bc
        L_0x01b2:
            r12.zzj()     // Catch:{ all -> 0x0616 }
            boolean r4 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0616 }
            if (r4 != 0) goto L_0x01bc
            goto L_0x01ae
        L_0x01bc:
            boolean r4 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01d5
            com.google.android.gms.measurement.internal.zzy r4 = r29.zzs()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0616 }
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r5)     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01d5
            java.lang.String r4 = r2.zza()     // Catch:{ all -> 0x0616 }
            r12.zzq(r4)     // Catch:{ all -> 0x0616 }
        L_0x01d5:
            boolean r4 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01ed
            com.google.android.gms.measurement.internal.zzy r4 = r29.zzs()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ all -> 0x0616 }
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r5)     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x01ed
            boolean r4 = r2.zzc()     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x0248
        L_0x01ed:
            com.google.android.gms.measurement.internal.zzjv r4 = r29.zzf()     // Catch:{ all -> 0x0616 }
            java.lang.String r5 = r11.zzc()     // Catch:{ all -> 0x0616 }
            android.util.Pair r4 = r4.zza(r5, r2)     // Catch:{ all -> 0x0616 }
            boolean r5 = r11.zzaf()     // Catch:{ all -> 0x0616 }
            if (r5 == 0) goto L_0x0248
            if (r4 == 0) goto L_0x0248
            java.lang.Object r5 = r4.first     // Catch:{ all -> 0x0616 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x0616 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0616 }
            if (r5 != 0) goto L_0x0248
            java.lang.Object r5 = r4.first     // Catch:{ SecurityException -> 0x022c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ SecurityException -> 0x022c }
            long r6 = r0.zzd     // Catch:{ SecurityException -> 0x022c }
            java.lang.String r6 = java.lang.Long.toString(r6)     // Catch:{ SecurityException -> 0x022c }
            java.lang.String r5 = zza((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ SecurityException -> 0x022c }
            r12.zzh((java.lang.String) r5)     // Catch:{ SecurityException -> 0x022c }
            java.lang.Object r5 = r4.second     // Catch:{ all -> 0x0616 }
            if (r5 == 0) goto L_0x0248
            java.lang.Object r4 = r4.second     // Catch:{ all -> 0x0616 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0616 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0616 }
            r12.zza((boolean) r4)     // Catch:{ all -> 0x0616 }
            goto L_0x0248
        L_0x022c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r2 = r29.zzq()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzv()     // Catch:{ all -> 0x0616 }
            java.lang.String r4 = "Resettable device id encryption failed"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0616 }
            r2.zza(r4, r0)     // Catch:{ all -> 0x0616 }
            byte[] r0 = new byte[r3]     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()
            r2.zzg()
            return r0
        L_0x0248:
            com.google.android.gms.measurement.internal.zzal r4 = r29.zzk()     // Catch:{ all -> 0x0616 }
            r4.zzaa()     // Catch:{ all -> 0x0616 }
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = r12.zzc((java.lang.String) r4)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzal r5 = r29.zzk()     // Catch:{ all -> 0x0616 }
            r5.zzaa()     // Catch:{ all -> 0x0616 }
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = r4.zzb((java.lang.String) r5)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzal r5 = r29.zzk()     // Catch:{ all -> 0x0616 }
            long r5 = r5.zze()     // Catch:{ all -> 0x0616 }
            int r6 = (int) r5     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = r4.zzf((int) r6)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzal r5 = r29.zzk()     // Catch:{ all -> 0x0616 }
            java.lang.String r5 = r5.zzf()     // Catch:{ all -> 0x0616 }
            r4.zzd((java.lang.String) r5)     // Catch:{ all -> 0x0616 }
            boolean r4 = com.google.android.gms.internal.measurement.zzmb.zzb()     // Catch:{ SecurityException -> 0x05fa }
            if (r4 == 0) goto L_0x0292
            com.google.android.gms.measurement.internal.zzy r4 = r29.zzs()     // Catch:{ SecurityException -> 0x05fa }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzcp     // Catch:{ SecurityException -> 0x05fa }
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r5)     // Catch:{ SecurityException -> 0x05fa }
            if (r4 == 0) goto L_0x0292
            boolean r2 = r2.zze()     // Catch:{ SecurityException -> 0x05fa }
            if (r2 == 0) goto L_0x02a3
        L_0x0292:
            java.lang.String r2 = r11.zzd()     // Catch:{ SecurityException -> 0x05fa }
            long r4 = r0.zzd     // Catch:{ SecurityException -> 0x05fa }
            java.lang.String r4 = java.lang.Long.toString(r4)     // Catch:{ SecurityException -> 0x05fa }
            java.lang.String r2 = zza((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ SecurityException -> 0x05fa }
            r12.zzi((java.lang.String) r2)     // Catch:{ SecurityException -> 0x05fa }
        L_0x02a3:
            java.lang.String r2 = r11.zzi()     // Catch:{ all -> 0x0616 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x02b4
            java.lang.String r2 = r11.zzi()     // Catch:{ all -> 0x0616 }
            r12.zzl((java.lang.String) r2)     // Catch:{ all -> 0x0616 }
        L_0x02b4:
            java.lang.String r5 = r11.zzc()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()     // Catch:{ all -> 0x0616 }
            java.util.List r2 = r2.zza((java.lang.String) r5)     // Catch:{ all -> 0x0616 }
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x0616 }
        L_0x02c4:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0616 }
            if (r6 == 0) goto L_0x02db
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzky r6 = (com.google.android.gms.measurement.internal.zzky) r6     // Catch:{ all -> 0x0616 }
            java.lang.String r7 = "_lte"
            java.lang.String r8 = r6.zzc     // Catch:{ all -> 0x0616 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0616 }
            if (r7 == 0) goto L_0x02c4
            goto L_0x02dc
        L_0x02db:
            r6 = r14
        L_0x02dc:
            r17 = 0
            if (r6 == 0) goto L_0x02e4
            java.lang.Object r4 = r6.zze     // Catch:{ all -> 0x0616 }
            if (r4 != 0) goto L_0x0307
        L_0x02e4:
            com.google.android.gms.measurement.internal.zzky r10 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ all -> 0x0616 }
            java.lang.String r6 = "auto"
            java.lang.String r7 = "_lte"
            com.google.android.gms.common.util.Clock r4 = r29.zzl()     // Catch:{ all -> 0x0616 }
            long r8 = r4.currentTimeMillis()     // Catch:{ all -> 0x0616 }
            java.lang.Long r16 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0616 }
            r4 = r10
            r14 = r10
            r10 = r16
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ all -> 0x0616 }
            r2.add(r14)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r4 = r29.zzi()     // Catch:{ all -> 0x0616 }
            r4.zza((com.google.android.gms.measurement.internal.zzky) r14)     // Catch:{ all -> 0x0616 }
        L_0x0307:
            com.google.android.gms.measurement.internal.zzkt r4 = r29.mo18590f_()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzex r5 = r4.zzq()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzw()     // Catch:{ all -> 0x0616 }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r5.zza(r6)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzal r5 = r4.zzk()     // Catch:{ all -> 0x0616 }
            boolean r5 = r5.zzi()     // Catch:{ all -> 0x0616 }
            r6 = 1
            if (r5 == 0) goto L_0x037e
            java.lang.String r5 = r11.zzc()     // Catch:{ all -> 0x0616 }
            boolean r8 = r11.zzaf()     // Catch:{ all -> 0x0616 }
            if (r8 == 0) goto L_0x037e
            com.google.android.gms.measurement.internal.zzfv r8 = r4.zzj()     // Catch:{ all -> 0x0616 }
            boolean r8 = r8.zze(r5)     // Catch:{ all -> 0x0616 }
            if (r8 == 0) goto L_0x037e
            com.google.android.gms.measurement.internal.zzex r8 = r4.zzq()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzv()     // Catch:{ all -> 0x0616 }
            java.lang.String r9 = "Turning off ad personalization due to account type"
            r8.zza(r9)     // Catch:{ all -> 0x0616 }
            java.util.Iterator r8 = r2.iterator()     // Catch:{ all -> 0x0616 }
        L_0x0349:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x0616 }
            if (r9 == 0) goto L_0x0362
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzky r9 = (com.google.android.gms.measurement.internal.zzky) r9     // Catch:{ all -> 0x0616 }
            java.lang.String r10 = "_npa"
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x0616 }
            boolean r9 = r10.equals(r9)     // Catch:{ all -> 0x0616 }
            if (r9 == 0) goto L_0x0349
            r8.remove()     // Catch:{ all -> 0x0616 }
        L_0x0362:
            com.google.android.gms.measurement.internal.zzky r8 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ all -> 0x0616 }
            java.lang.String r22 = "auto"
            java.lang.String r23 = "_npa"
            com.google.android.gms.common.util.Clock r4 = r4.zzl()     // Catch:{ all -> 0x0616 }
            long r24 = r4.currentTimeMillis()     // Catch:{ all -> 0x0616 }
            java.lang.Long r26 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0616 }
            r20 = r8
            r21 = r5
            r20.<init>(r21, r22, r23, r24, r26)     // Catch:{ all -> 0x0616 }
            r2.add(r8)     // Catch:{ all -> 0x0616 }
        L_0x037e:
            int r4 = r2.size()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzk[] r4 = new com.google.android.gms.internal.measurement.zzcd.zzk[r4]     // Catch:{ all -> 0x0616 }
        L_0x0384:
            int r5 = r2.size()     // Catch:{ all -> 0x0616 }
            if (r3 >= r5) goto L_0x03c2
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r5 = com.google.android.gms.internal.measurement.zzcd.zzk.zzj()     // Catch:{ all -> 0x0616 }
            java.lang.Object r8 = r2.get(r3)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzky r8 = (com.google.android.gms.measurement.internal.zzky) r8     // Catch:{ all -> 0x0616 }
            java.lang.String r8 = r8.zzc     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r5 = r5.zza((java.lang.String) r8)     // Catch:{ all -> 0x0616 }
            java.lang.Object r8 = r2.get(r3)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzky r8 = (com.google.android.gms.measurement.internal.zzky) r8     // Catch:{ all -> 0x0616 }
            long r8 = r8.zzd     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r5 = r5.zza((long) r8)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzkt r8 = r29.mo18590f_()     // Catch:{ all -> 0x0616 }
            java.lang.Object r9 = r2.get(r3)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzky r9 = (com.google.android.gms.measurement.internal.zzky) r9     // Catch:{ all -> 0x0616 }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0616 }
            r8.zza((com.google.android.gms.internal.measurement.zzcd.zzk.zza) r5, (java.lang.Object) r9)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzjg r5 = r5.zzy()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzhv r5 = (com.google.android.gms.internal.measurement.zzhv) r5     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzk r5 = (com.google.android.gms.internal.measurement.zzcd.zzk) r5     // Catch:{ all -> 0x0616 }
            r4[r3] = r5     // Catch:{ all -> 0x0616 }
            int r3 = r3 + 1
            goto L_0x0384
        L_0x03c2:
            java.util.List r2 = java.util.Arrays.asList(r4)     // Catch:{ all -> 0x0616 }
            r12.zzb((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zzk>) r2)     // Catch:{ all -> 0x0616 }
            boolean r2 = com.google.android.gms.internal.measurement.zznr.zzb()     // Catch:{ all -> 0x0616 }
            if (r2 == 0) goto L_0x040e
            com.google.android.gms.measurement.internal.zzy r2 = r29.zzs()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzch     // Catch:{ all -> 0x0616 }
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)     // Catch:{ all -> 0x0616 }
            if (r2 == 0) goto L_0x040e
            com.google.android.gms.measurement.internal.zzy r2 = r29.zzs()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzci     // Catch:{ all -> 0x0616 }
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)     // Catch:{ all -> 0x0616 }
            if (r2 == 0) goto L_0x040e
            com.google.android.gms.measurement.internal.zzfb r2 = com.google.android.gms.measurement.internal.zzfb.zza(r30)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzkx r3 = r29.zzo()     // Catch:{ all -> 0x0616 }
            android.os.Bundle r4 = r2.zzb     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r5 = r29.zzi()     // Catch:{ all -> 0x0616 }
            android.os.Bundle r5 = r5.zzi(r15)     // Catch:{ all -> 0x0616 }
            r3.zza((android.os.Bundle) r4, (android.os.Bundle) r5)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzkx r3 = r29.zzo()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzy r4 = r29.zzs()     // Catch:{ all -> 0x0616 }
            int r4 = r4.zza((java.lang.String) r15)     // Catch:{ all -> 0x0616 }
            r3.zza((com.google.android.gms.measurement.internal.zzfb) r2, (int) r4)     // Catch:{ all -> 0x0616 }
            android.os.Bundle r2 = r2.zzb     // Catch:{ all -> 0x0616 }
            goto L_0x0414
        L_0x040e:
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzb     // Catch:{ all -> 0x0616 }
            android.os.Bundle r2 = r2.zzb()     // Catch:{ all -> 0x0616 }
        L_0x0414:
            r14 = r2
            java.lang.String r2 = "_c"
            r14.putLong(r2, r6)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzex r2 = r29.zzq()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzv()     // Catch:{ all -> 0x0616 }
            java.lang.String r3 = "Marking in-app purchase as real-time"
            r2.zza(r3)     // Catch:{ all -> 0x0616 }
            java.lang.String r2 = "_r"
            r14.putLong(r2, r6)     // Catch:{ all -> 0x0616 }
            java.lang.String r2 = "_o"
            java.lang.String r3 = r0.zzc     // Catch:{ all -> 0x0616 }
            r14.putString(r2, r3)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzkx r2 = r29.zzo()     // Catch:{ all -> 0x0616 }
            java.lang.String r3 = r12.zzj()     // Catch:{ all -> 0x0616 }
            boolean r2 = r2.zze(r3)     // Catch:{ all -> 0x0616 }
            if (r2 == 0) goto L_0x045b
            com.google.android.gms.measurement.internal.zzkx r2 = r29.zzo()     // Catch:{ all -> 0x0616 }
            java.lang.String r3 = "_dbg"
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0616 }
            r2.zza((android.os.Bundle) r14, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzkx r2 = r29.zzo()     // Catch:{ all -> 0x0616 }
            java.lang.String r3 = "_r"
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0616 }
            r2.zza((android.os.Bundle) r14, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ all -> 0x0616 }
        L_0x045b:
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()     // Catch:{ all -> 0x0616 }
            java.lang.String r3 = r0.zza     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzan r2 = r2.zza((java.lang.String) r15, (java.lang.String) r3)     // Catch:{ all -> 0x0616 }
            if (r2 != 0) goto L_0x0499
            com.google.android.gms.measurement.internal.zzan r20 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x0616 }
            java.lang.String r4 = r0.zza     // Catch:{ all -> 0x0616 }
            r5 = 0
            r7 = 0
            long r9 = r0.zzd     // Catch:{ all -> 0x0616 }
            r21 = 0
            r16 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r2 = r20
            r3 = r31
            r26 = r11
            r27 = r12
            r11 = r21
            r28 = r13
            r13 = r16
            r19 = r14
            r21 = 0
            r14 = r23
            r15 = r24
            r16 = r25
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r14, r15, r16)     // Catch:{ all -> 0x0616 }
            r9 = r17
            goto L_0x04ac
        L_0x0499:
            r26 = r11
            r27 = r12
            r28 = r13
            r19 = r14
            r21 = 0
            long r3 = r2.zzf     // Catch:{ all -> 0x0616 }
            long r5 = r0.zzd     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzan r20 = r2.zza(r5)     // Catch:{ all -> 0x0616 }
            r9 = r3
        L_0x04ac:
            r12 = r20
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()     // Catch:{ all -> 0x0616 }
            r2.zza((com.google.android.gms.measurement.internal.zzan) r12)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzak r13 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzgb r3 = r1.zzy     // Catch:{ all -> 0x0616 }
            java.lang.String r4 = r0.zzc     // Catch:{ all -> 0x0616 }
            java.lang.String r6 = r0.zza     // Catch:{ all -> 0x0616 }
            long r7 = r0.zzd     // Catch:{ all -> 0x0616 }
            r2 = r13
            r5 = r31
            r11 = r19
            r2.<init>((com.google.android.gms.measurement.internal.zzgb) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (long) r9, (android.os.Bundle) r11)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch:{ all -> 0x0616 }
            long r3 = r13.zzc     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = r2.zza((long) r3)     // Catch:{ all -> 0x0616 }
            java.lang.String r3 = r13.zzb     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = r2.zza((java.lang.String) r3)     // Catch:{ all -> 0x0616 }
            long r3 = r13.zzd     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = r2.zzb((long) r3)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzam r3 = r13.zze     // Catch:{ all -> 0x0616 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0616 }
        L_0x04e3:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0616 }
            if (r4 == 0) goto L_0x0508
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0616 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r5 = com.google.android.gms.internal.measurement.zzcd.zze.zzm()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r5 = r5.zza((java.lang.String) r4)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzam r6 = r13.zze     // Catch:{ all -> 0x0616 }
            java.lang.Object r4 = r6.zza((java.lang.String) r4)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzkt r6 = r29.mo18590f_()     // Catch:{ all -> 0x0616 }
            r6.zza((com.google.android.gms.internal.measurement.zzcd.zze.zza) r5, (java.lang.Object) r4)     // Catch:{ all -> 0x0616 }
            r2.zza((com.google.android.gms.internal.measurement.zzcd.zze.zza) r5)     // Catch:{ all -> 0x0616 }
            goto L_0x04e3
        L_0x0508:
            r3 = r27
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = r3.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzh$zzb r5 = com.google.android.gms.internal.measurement.zzcd.zzh.zza()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzd$zza r6 = com.google.android.gms.internal.measurement.zzcd.zzd.zza()     // Catch:{ all -> 0x0616 }
            long r7 = r12.zzc     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzd$zza r6 = r6.zza((long) r7)     // Catch:{ all -> 0x0616 }
            java.lang.String r0 = r0.zza     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzd$zza r0 = r6.zza((java.lang.String) r0)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzh$zzb r0 = r5.zza(r0)     // Catch:{ all -> 0x0616 }
            r4.zza((com.google.android.gms.internal.measurement.zzcd.zzh.zzb) r0)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzo r5 = r29.zzh()     // Catch:{ all -> 0x0616 }
            java.lang.String r6 = r26.zzc()     // Catch:{ all -> 0x0616 }
            java.util.List r7 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0616 }
            java.util.List r8 = r3.zzd()     // Catch:{ all -> 0x0616 }
            long r9 = r2.zzf()     // Catch:{ all -> 0x0616 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0616 }
            long r10 = r2.zzf()     // Catch:{ all -> 0x0616 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0616 }
            java.util.List r0 = r5.zza(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0616 }
            r3.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zza>) r0)     // Catch:{ all -> 0x0616 }
            boolean r0 = r2.zze()     // Catch:{ all -> 0x0616 }
            if (r0 == 0) goto L_0x0565
            long r4 = r2.zzf()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r0 = r3.zzb((long) r4)     // Catch:{ all -> 0x0616 }
            long r4 = r2.zzf()     // Catch:{ all -> 0x0616 }
            r0.zzc((long) r4)     // Catch:{ all -> 0x0616 }
        L_0x0565:
            long r4 = r26.zzk()     // Catch:{ all -> 0x0616 }
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0570
            r3.zze((long) r4)     // Catch:{ all -> 0x0616 }
        L_0x0570:
            long r6 = r26.zzj()     // Catch:{ all -> 0x0616 }
            int r2 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r2 == 0) goto L_0x057c
            r3.zzd((long) r6)     // Catch:{ all -> 0x0616 }
            goto L_0x0581
        L_0x057c:
            if (r0 == 0) goto L_0x0581
            r3.zzd((long) r4)     // Catch:{ all -> 0x0616 }
        L_0x0581:
            r26.zzv()     // Catch:{ all -> 0x0616 }
            long r4 = r26.zzs()     // Catch:{ all -> 0x0616 }
            int r0 = (int) r4     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r0 = r3.zzg((int) r0)     // Catch:{ all -> 0x0616 }
            r4 = 31049(0x7949, double:1.534E-319)
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r0 = r0.zzg((long) r4)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.common.util.Clock r2 = r29.zzl()     // Catch:{ all -> 0x0616 }
            long r4 = r2.currentTimeMillis()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r0 = r0.zza((long) r4)     // Catch:{ all -> 0x0616 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0616 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0616 }
            r0.zzb((boolean) r2)     // Catch:{ all -> 0x0616 }
            r0 = r28
            r0.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r3)     // Catch:{ all -> 0x0616 }
            long r4 = r3.zzf()     // Catch:{ all -> 0x0616 }
            r2 = r26
            r2.zza((long) r4)     // Catch:{ all -> 0x0616 }
            long r3 = r3.zzg()     // Catch:{ all -> 0x0616 }
            r2.zzb((long) r3)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r3 = r29.zzi()     // Catch:{ all -> 0x0616 }
            r3.zza((com.google.android.gms.measurement.internal.zzf) r2)     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()     // Catch:{ all -> 0x0616 }
            r2.mo18353b_()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()
            r2.zzg()
            com.google.android.gms.measurement.internal.zzkt r2 = r29.mo18590f_()     // Catch:{ IOException -> 0x05e7 }
            com.google.android.gms.internal.measurement.zzjg r0 = r0.zzy()     // Catch:{ IOException -> 0x05e7 }
            com.google.android.gms.internal.measurement.zzhv r0 = (com.google.android.gms.internal.measurement.zzhv) r0     // Catch:{ IOException -> 0x05e7 }
            com.google.android.gms.internal.measurement.zzcd$zzf r0 = (com.google.android.gms.internal.measurement.zzcd.zzf) r0     // Catch:{ IOException -> 0x05e7 }
            byte[] r0 = r0.zzbk()     // Catch:{ IOException -> 0x05e7 }
            byte[] r0 = r2.zzc(r0)     // Catch:{ IOException -> 0x05e7 }
            return r0
        L_0x05e7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r2 = r29.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()
            java.lang.String r3 = "Data loss. Failed to bundle and serialize. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r31)
            r2.zza(r3, r4, r0)
            return r21
        L_0x05fa:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r2 = r29.zzq()     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzv()     // Catch:{ all -> 0x0616 }
            java.lang.String r4 = "app instance id encryption failed"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0616 }
            r2.zza(r4, r0)     // Catch:{ all -> 0x0616 }
            byte[] r0 = new byte[r3]     // Catch:{ all -> 0x0616 }
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()
            r2.zzg()
            return r0
        L_0x0616:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzac r2 = r29.zzi()
            r2.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzil.zza(com.google.android.gms.measurement.internal.zzar, java.lang.String):byte[]");
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }
}
