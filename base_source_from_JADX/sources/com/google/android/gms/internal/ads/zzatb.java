package com.google.android.gms.internal.ads;

public abstract class zzatb extends zzgw implements zzasy {
    public zzatb() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzatd] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzatf] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzatf] */
    /* JADX WARNING: type inference failed for: r5v17, types: [com.google.android.gms.internal.ads.zzatf] */
    /* JADX WARNING: type inference failed for: r5v22, types: [com.google.android.gms.internal.ads.zzatf] */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: type inference failed for: r5v29 */
    /* JADX WARNING: type inference failed for: r5v30 */
    /* JADX WARNING: type inference failed for: r5v31 */
    /* JADX WARNING: type inference failed for: r5v32 */
    /* JADX WARNING: type inference failed for: r5v33 */
    /* JADX WARNING: type inference failed for: r5v34 */
    /* JADX WARNING: type inference failed for: r5v35 */
    /* JADX WARNING: type inference failed for: r5v36 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x00c0;
                case 2: goto L_0x0098;
                case 3: goto L_0x0004;
                case 4: goto L_0x0073;
                case 5: goto L_0x004e;
                case 6: goto L_0x0028;
                case 7: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            java.lang.String r2 = r3.readString()
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0011
            goto L_0x0023
        L_0x0011:
            java.lang.String r5 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzatf
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzatf r5 = (com.google.android.gms.internal.ads.zzatf) r5
            goto L_0x0023
        L_0x001e:
            com.google.android.gms.internal.ads.zzath r5 = new com.google.android.gms.internal.ads.zzath
            r5.<init>(r3)
        L_0x0023:
            r1.zza((java.lang.String) r2, (com.google.android.gms.internal.ads.zzatf) r5)
            goto L_0x00bc
        L_0x0028:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzatl> r2 = com.google.android.gms.internal.ads.zzatl.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzatl r2 = (com.google.android.gms.internal.ads.zzatl) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0037
            goto L_0x0049
        L_0x0037:
            java.lang.String r5 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzatf
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzatf r5 = (com.google.android.gms.internal.ads.zzatf) r5
            goto L_0x0049
        L_0x0044:
            com.google.android.gms.internal.ads.zzath r5 = new com.google.android.gms.internal.ads.zzath
            r5.<init>(r3)
        L_0x0049:
            r1.zzc(r2, r5)
            goto L_0x00bc
        L_0x004e:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzatl> r2 = com.google.android.gms.internal.ads.zzatl.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzatl r2 = (com.google.android.gms.internal.ads.zzatl) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x005d
            goto L_0x006f
        L_0x005d:
            java.lang.String r5 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzatf
            if (r0 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzatf r5 = (com.google.android.gms.internal.ads.zzatf) r5
            goto L_0x006f
        L_0x006a:
            com.google.android.gms.internal.ads.zzath r5 = new com.google.android.gms.internal.ads.zzath
            r5.<init>(r3)
        L_0x006f:
            r1.zzb(r2, r5)
            goto L_0x00bc
        L_0x0073:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzatl> r2 = com.google.android.gms.internal.ads.zzatl.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzatl r2 = (com.google.android.gms.internal.ads.zzatl) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0082
            goto L_0x0094
        L_0x0082:
            java.lang.String r5 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzatf
            if (r0 == 0) goto L_0x008f
            com.google.android.gms.internal.ads.zzatf r5 = (com.google.android.gms.internal.ads.zzatf) r5
            goto L_0x0094
        L_0x008f:
            com.google.android.gms.internal.ads.zzath r5 = new com.google.android.gms.internal.ads.zzath
            r5.<init>(r3)
        L_0x0094:
            r1.zza((com.google.android.gms.internal.ads.zzatl) r2, (com.google.android.gms.internal.ads.zzatf) r5)
            goto L_0x00bc
        L_0x0098:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzass> r2 = com.google.android.gms.internal.ads.zzass.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzass r2 = (com.google.android.gms.internal.ads.zzass) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x00a7
            goto L_0x00b9
        L_0x00a7:
            java.lang.String r5 = "com.google.android.gms.ads.internal.request.IAdResponseListener"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzatd
            if (r0 == 0) goto L_0x00b4
            com.google.android.gms.internal.ads.zzatd r5 = (com.google.android.gms.internal.ads.zzatd) r5
            goto L_0x00b9
        L_0x00b4:
            com.google.android.gms.internal.ads.zzatc r5 = new com.google.android.gms.internal.ads.zzatc
            r5.<init>(r3)
        L_0x00b9:
            r1.zza((com.google.android.gms.internal.ads.zzass) r2, (com.google.android.gms.internal.ads.zzatd) r5)
        L_0x00bc:
            r4.writeNoException()
            goto L_0x00d2
        L_0x00c0:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzass> r2 = com.google.android.gms.internal.ads.zzass.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzass r2 = (com.google.android.gms.internal.ads.zzass) r2
            com.google.android.gms.internal.ads.zzasu r2 = r1.zza(r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zzb(r4, r2)
        L_0x00d2:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatb.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
