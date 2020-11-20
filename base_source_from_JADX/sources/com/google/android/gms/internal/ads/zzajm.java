package com.google.android.gms.internal.ads;

public abstract class zzajm extends zzgw implements zzajn {
    public zzajm() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r4.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r4.writeNoException();
        com.google.android.gms.internal.ads.zzgv.zza(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) {
        /*
            r1 = this;
            switch(r2) {
                case 3: goto L_0x0045;
                case 4: goto L_0x003e;
                case 5: goto L_0x0016;
                case 6: goto L_0x000a;
                case 7: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            com.google.android.gms.internal.ads.zzaee r2 = r1.zzth()
            goto L_0x0049
        L_0x000a:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zzr(r2)
            goto L_0x0041
        L_0x0016:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0026
            r3 = 0
            goto L_0x003a
        L_0x0026:
            java.lang.String r5 = "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzajo
            if (r0 == 0) goto L_0x0034
            r3 = r5
            com.google.android.gms.internal.ads.zzajo r3 = (com.google.android.gms.internal.ads.zzajo) r3
            goto L_0x003a
        L_0x0034:
            com.google.android.gms.internal.ads.zzajq r5 = new com.google.android.gms.internal.ads.zzajq
            r5.<init>(r3)
            r3 = r5
        L_0x003a:
            r1.zza(r2, r3)
            goto L_0x0041
        L_0x003e:
            r1.destroy()
        L_0x0041:
            r4.writeNoException()
            goto L_0x004f
        L_0x0045:
            com.google.android.gms.internal.ads.zzys r2 = r1.getVideoController()
        L_0x0049:
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
        L_0x004f:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajm.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
