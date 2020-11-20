package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzc;

public abstract class zzeo extends zzc implements zzep {
    public zzeo() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00fe, code lost:
        r9.writeNoException();
        r9.writeTypedList(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0158, code lost:
        r9.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) {
        /*
            r6 = this;
            switch(r7) {
                case 1: goto L_0x0145;
                case 2: goto L_0x0131;
                case 3: goto L_0x0003;
                case 4: goto L_0x0125;
                case 5: goto L_0x0111;
                case 6: goto L_0x0105;
                case 7: goto L_0x00ee;
                case 8: goto L_0x0003;
                case 9: goto L_0x00d7;
                case 10: goto L_0x00c1;
                case 11: goto L_0x00ad;
                case 12: goto L_0x0098;
                case 13: goto L_0x008b;
                case 14: goto L_0x0072;
                case 15: goto L_0x005c;
                case 16: goto L_0x0046;
                case 17: goto L_0x0034;
                case 18: goto L_0x0027;
                case 19: goto L_0x0012;
                case 20: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r7 = 0
            return r7
        L_0x0005:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.zze(r7)
            goto L_0x0158
        L_0x0012:
            android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            android.os.Bundle r7 = (android.os.Bundle) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r10 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r10)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.zza((android.os.Bundle) r7, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x0158
        L_0x0027:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.zzd(r7)
            goto L_0x0158
        L_0x0034:
            java.lang.String r7 = r8.readString()
            java.lang.String r10 = r8.readString()
            java.lang.String r8 = r8.readString()
            java.util.List r7 = r6.zza((java.lang.String) r7, (java.lang.String) r10, (java.lang.String) r8)
            goto L_0x00fe
        L_0x0046:
            java.lang.String r7 = r8.readString()
            java.lang.String r10 = r8.readString()
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r0 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r0)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            java.util.List r7 = r6.zza((java.lang.String) r7, (java.lang.String) r10, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x00fe
        L_0x005c:
            java.lang.String r7 = r8.readString()
            java.lang.String r10 = r8.readString()
            java.lang.String r0 = r8.readString()
            boolean r8 = com.google.android.gms.internal.measurement.zzb.zza(r8)
            java.util.List r7 = r6.zza((java.lang.String) r7, (java.lang.String) r10, (java.lang.String) r0, (boolean) r8)
            goto L_0x00fe
        L_0x0072:
            java.lang.String r7 = r8.readString()
            java.lang.String r10 = r8.readString()
            boolean r0 = com.google.android.gms.internal.measurement.zzb.zza(r8)
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r1 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r1)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            java.util.List r7 = r6.zza((java.lang.String) r7, (java.lang.String) r10, (boolean) r0, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x00fe
        L_0x008b:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r7 = com.google.android.gms.measurement.internal.zzw.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzw r7 = (com.google.android.gms.measurement.internal.zzw) r7
            r6.zza((com.google.android.gms.measurement.internal.zzw) r7)
            goto L_0x0158
        L_0x0098:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r7 = com.google.android.gms.measurement.internal.zzw.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzw r7 = (com.google.android.gms.measurement.internal.zzw) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r10 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r10)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.zza((com.google.android.gms.measurement.internal.zzw) r7, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x0158
        L_0x00ad:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            java.lang.String r7 = r6.zzc(r7)
            r9.writeNoException()
            r9.writeString(r7)
            goto L_0x015b
        L_0x00c1:
            long r1 = r8.readLong()
            java.lang.String r3 = r8.readString()
            java.lang.String r4 = r8.readString()
            java.lang.String r5 = r8.readString()
            r0 = r6
            r0.zza((long) r1, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)
            goto L_0x0158
        L_0x00d7:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r7 = com.google.android.gms.measurement.internal.zzar.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzar r7 = (com.google.android.gms.measurement.internal.zzar) r7
            java.lang.String r8 = r8.readString()
            byte[] r7 = r6.zza((com.google.android.gms.measurement.internal.zzar) r7, (java.lang.String) r8)
            r9.writeNoException()
            r9.writeByteArray(r7)
            goto L_0x015b
        L_0x00ee:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            boolean r8 = com.google.android.gms.internal.measurement.zzb.zza(r8)
            java.util.List r7 = r6.zza((com.google.android.gms.measurement.internal.zzn) r7, (boolean) r8)
        L_0x00fe:
            r9.writeNoException()
            r9.writeTypedList(r7)
            goto L_0x015b
        L_0x0105:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.zzb(r7)
            goto L_0x0158
        L_0x0111:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r7 = com.google.android.gms.measurement.internal.zzar.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzar r7 = (com.google.android.gms.measurement.internal.zzar) r7
            java.lang.String r10 = r8.readString()
            java.lang.String r8 = r8.readString()
            r6.zza((com.google.android.gms.measurement.internal.zzar) r7, (java.lang.String) r10, (java.lang.String) r8)
            goto L_0x0158
        L_0x0125:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.zza((com.google.android.gms.measurement.internal.zzn) r7)
            goto L_0x0158
        L_0x0131:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkw> r7 = com.google.android.gms.measurement.internal.zzkw.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzkw r7 = (com.google.android.gms.measurement.internal.zzkw) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r10 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r10)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.zza((com.google.android.gms.measurement.internal.zzkw) r7, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x0158
        L_0x0145:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r7 = com.google.android.gms.measurement.internal.zzar.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzar r7 = (com.google.android.gms.measurement.internal.zzar) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r10 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r10)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.zza((com.google.android.gms.measurement.internal.zzar) r7, (com.google.android.gms.measurement.internal.zzn) r8)
        L_0x0158:
            r9.writeNoException()
        L_0x015b:
            r7 = 1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeo.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
