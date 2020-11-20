package com.google.android.gms.internal.ads;

public abstract class zzsj extends zzgw implements zzsg {
    public zzsj() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzsm] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzsq] */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        r4.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        r4.writeNoException();
        com.google.android.gms.internal.ads.zzgv.zza(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 2: goto L_0x0051;
                case 3: goto L_0x0030;
                case 4: goto L_0x000b;
                case 5: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            com.google.android.gms.internal.ads.zzyn r2 = r1.zzkh()
            goto L_0x0055
        L_0x000b:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x001a
            goto L_0x002c
        L_0x001a:
            java.lang.String r5 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzsq
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzsq r5 = (com.google.android.gms.internal.ads.zzsq) r5
            goto L_0x002c
        L_0x0027:
            com.google.android.gms.internal.ads.zzss r5 = new com.google.android.gms.internal.ads.zzss
            r5.<init>(r3)
        L_0x002c:
            r1.zza(r2, r5)
            goto L_0x004d
        L_0x0030:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0037
            goto L_0x004a
        L_0x0037:
            java.lang.String r3 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzsm
            if (r5 == 0) goto L_0x0045
            r5 = r3
            com.google.android.gms.internal.ads.zzsm r5 = (com.google.android.gms.internal.ads.zzsm) r5
            goto L_0x004a
        L_0x0045:
            com.google.android.gms.internal.ads.zzso r5 = new com.google.android.gms.internal.ads.zzso
            r5.<init>(r2)
        L_0x004a:
            r1.zza(r5)
        L_0x004d:
            r4.writeNoException()
            goto L_0x005b
        L_0x0051:
            com.google.android.gms.internal.ads.zzxg r2 = r1.zzdx()
        L_0x0055:
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
        L_0x005b:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsj.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
