package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbv;

final class zzu extends zzv {
    private zzbv.zze zzg;
    private final /* synthetic */ zzo zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzu(zzo zzo, String str, int i, zzbv.zze zze) {
        super(str, i);
        this.zzh = zzo;
        this.zzg = zze;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzg.zzb();
    }

    /* JADX WARNING: type inference failed for: r4v15, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0162 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.Long r11, java.lang.Long r12, com.google.android.gms.internal.measurement.zzcd.zzk r13, boolean r14) {
        /*
            r10 = this;
            boolean r0 = com.google.android.gms.internal.measurement.zzms.zzb()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.measurement.internal.zzo r0 = r10.zzh
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzs()
            java.lang.String r3 = r10.zza
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzba
            boolean r0 = r0.zzd(r3, r4)
            if (r0 == 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            com.google.android.gms.internal.measurement.zzbv$zze r3 = r10.zzg
            boolean r3 = r3.zze()
            com.google.android.gms.internal.measurement.zzbv$zze r4 = r10.zzg
            boolean r4 = r4.zzf()
            com.google.android.gms.internal.measurement.zzbv$zze r5 = r10.zzg
            boolean r5 = r5.zzh()
            if (r3 != 0) goto L_0x0036
            if (r4 != 0) goto L_0x0036
            if (r5 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r3 = 0
            goto L_0x0037
        L_0x0036:
            r3 = 1
        L_0x0037:
            r4 = 0
            if (r14 == 0) goto L_0x0064
            if (r3 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.zzo r11 = r10.zzh
            com.google.android.gms.measurement.internal.zzex r11 = r11.zzq()
            com.google.android.gms.measurement.internal.zzez r11 = r11.zzw()
            java.lang.String r12 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            int r13 = r10.zzb
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            com.google.android.gms.internal.measurement.zzbv$zze r14 = r10.zzg
            boolean r14 = r14.zza()
            if (r14 == 0) goto L_0x0060
            com.google.android.gms.internal.measurement.zzbv$zze r14 = r10.zzg
            int r14 = r14.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
        L_0x0060:
            r11.zza(r12, r13, r4)
            return r2
        L_0x0064:
            com.google.android.gms.internal.measurement.zzbv$zze r6 = r10.zzg
            com.google.android.gms.internal.measurement.zzbv$zzc r6 = r6.zzd()
            boolean r7 = r6.zzf()
            boolean r8 = r13.zzf()
            if (r8 == 0) goto L_0x00ab
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x0099
            com.google.android.gms.measurement.internal.zzo r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()
            java.lang.String r7 = "No number filter for long property. property"
        L_0x0086:
            com.google.android.gms.measurement.internal.zzo r8 = r10.zzh
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzn()
            java.lang.String r9 = r13.zzc()
            java.lang.String r8 = r8.zzc(r9)
            r6.zza(r7, r8)
            goto L_0x014b
        L_0x0099:
            long r8 = r13.zzg()
            com.google.android.gms.internal.measurement.zzbv$zzd r4 = r6.zzd()
            java.lang.Boolean r4 = zza((long) r8, (com.google.android.gms.internal.measurement.zzbv.zzd) r4)
        L_0x00a5:
            java.lang.Boolean r4 = zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x014b
        L_0x00ab:
            boolean r8 = r13.zzh()
            if (r8 == 0) goto L_0x00d1
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x00c4
            com.google.android.gms.measurement.internal.zzo r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()
            java.lang.String r7 = "No number filter for double property. property"
            goto L_0x0086
        L_0x00c4:
            double r8 = r13.zzi()
            com.google.android.gms.internal.measurement.zzbv$zzd r4 = r6.zzd()
            java.lang.Boolean r4 = zza((double) r8, (com.google.android.gms.internal.measurement.zzbv.zzd) r4)
            goto L_0x00a5
        L_0x00d1:
            boolean r8 = r13.zzd()
            if (r8 == 0) goto L_0x013d
            boolean r8 = r6.zza()
            if (r8 != 0) goto L_0x0129
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x00f0
            com.google.android.gms.measurement.internal.zzo r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()
            java.lang.String r7 = "No string or number filter defined. property"
            goto L_0x0086
        L_0x00f0:
            java.lang.String r8 = r13.zze()
            boolean r8 = com.google.android.gms.measurement.internal.zzkt.zza((java.lang.String) r8)
            if (r8 == 0) goto L_0x0107
            java.lang.String r4 = r13.zze()
            com.google.android.gms.internal.measurement.zzbv$zzd r6 = r6.zzd()
            java.lang.Boolean r4 = zza((java.lang.String) r4, (com.google.android.gms.internal.measurement.zzbv.zzd) r6)
            goto L_0x00a5
        L_0x0107:
            com.google.android.gms.measurement.internal.zzo r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()
            java.lang.String r7 = "Invalid user property value for Numeric number filter. property, value"
            com.google.android.gms.measurement.internal.zzo r8 = r10.zzh
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzn()
            java.lang.String r9 = r13.zzc()
            java.lang.String r8 = r8.zzc(r9)
            java.lang.String r9 = r13.zze()
            r6.zza(r7, r8, r9)
            goto L_0x014b
        L_0x0129:
            java.lang.String r4 = r13.zze()
            com.google.android.gms.internal.measurement.zzbv$zzf r6 = r6.zzb()
            com.google.android.gms.measurement.internal.zzo r8 = r10.zzh
            com.google.android.gms.measurement.internal.zzex r8 = r8.zzq()
            java.lang.Boolean r4 = zza((java.lang.String) r4, (com.google.android.gms.internal.measurement.zzbv.zzf) r6, (com.google.android.gms.measurement.internal.zzex) r8)
            goto L_0x00a5
        L_0x013d:
            com.google.android.gms.measurement.internal.zzo r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzh()
            java.lang.String r7 = "User property has no value, property"
            goto L_0x0086
        L_0x014b:
            com.google.android.gms.measurement.internal.zzo r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzex r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzw()
            java.lang.String r7 = "Property filter result"
            if (r4 != 0) goto L_0x015c
            java.lang.String r8 = "null"
            goto L_0x015d
        L_0x015c:
            r8 = r4
        L_0x015d:
            r6.zza(r7, r8)
            if (r4 != 0) goto L_0x0163
            return r1
        L_0x0163:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r10.zzc = r1
            if (r5 == 0) goto L_0x0172
            boolean r1 = r4.booleanValue()
            if (r1 != 0) goto L_0x0172
            return r2
        L_0x0172:
            if (r14 == 0) goto L_0x017c
            com.google.android.gms.internal.measurement.zzbv$zze r14 = r10.zzg
            boolean r14 = r14.zze()
            if (r14 == 0) goto L_0x017e
        L_0x017c:
            r10.zzd = r4
        L_0x017e:
            boolean r14 = r4.booleanValue()
            if (r14 == 0) goto L_0x01c3
            if (r3 == 0) goto L_0x01c3
            boolean r14 = r13.zza()
            if (r14 == 0) goto L_0x01c3
            long r13 = r13.zzb()
            if (r11 == 0) goto L_0x0196
            long r13 = r11.longValue()
        L_0x0196:
            if (r0 == 0) goto L_0x01ae
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.zzg
            boolean r11 = r11.zze()
            if (r11 == 0) goto L_0x01ae
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.zzg
            boolean r11 = r11.zzf()
            if (r11 != 0) goto L_0x01ae
            if (r12 == 0) goto L_0x01ae
            long r13 = r12.longValue()
        L_0x01ae:
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.zzg
            boolean r11 = r11.zzf()
            if (r11 == 0) goto L_0x01bd
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.zzf = r11
            goto L_0x01c3
        L_0x01bd:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.zze = r11
        L_0x01c3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzu.zza(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzcd$zzk, boolean):boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return false;
    }
}
