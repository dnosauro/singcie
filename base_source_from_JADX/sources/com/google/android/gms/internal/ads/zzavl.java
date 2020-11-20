package com.google.android.gms.internal.ads;

public abstract class zzavl extends zzgw implements zzavi {
    public zzavl() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x003d;
                case 2: goto L_0x0039;
                case 3: goto L_0x0019;
                case 4: goto L_0x0011;
                case 5: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzve> r1 = com.google.android.gms.internal.ads.zzve.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzve r1 = (com.google.android.gms.internal.ads.zzve) r1
            r0.zzh(r1)
            goto L_0x0040
        L_0x0011:
            int r1 = r2.readInt()
            r0.onRewardedAdFailedToShow(r1)
            goto L_0x0040
        L_0x0019:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0021
            r1 = 0
            goto L_0x0035
        L_0x0021:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzavc
            if (r4 == 0) goto L_0x002f
            r1 = r2
            com.google.android.gms.internal.ads.zzavc r1 = (com.google.android.gms.internal.ads.zzavc) r1
            goto L_0x0035
        L_0x002f:
            com.google.android.gms.internal.ads.zzave r2 = new com.google.android.gms.internal.ads.zzave
            r2.<init>(r1)
            r1 = r2
        L_0x0035:
            r0.zza(r1)
            goto L_0x0040
        L_0x0039:
            r0.onRewardedAdClosed()
            goto L_0x0040
        L_0x003d:
            r0.onRewardedAdOpened()
        L_0x0040:
            r3.writeNoException()
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavl.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
