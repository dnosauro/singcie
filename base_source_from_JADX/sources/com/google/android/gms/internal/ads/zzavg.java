package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzavg extends zzgw implements zzavh {
    public zzavg() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzavh zzar(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return queryLocalInterface instanceof zzavh ? (zzavh) queryLocalInterface : new zzavj(iBinder);
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzavp] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzavi] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzavq] */
    /* JADX WARNING: type inference failed for: r5v17, types: [com.google.android.gms.internal.ads.zzavp] */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r5v25 */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: type inference failed for: r5v29 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        r4.writeNoException();
        com.google.android.gms.internal.ads.zzgv.zza(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a7, code lost:
        r4.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x00df;
                case 2: goto L_0x00c1;
                case 3: goto L_0x00b6;
                case 4: goto L_0x00ab;
                case 5: goto L_0x009c;
                case 6: goto L_0x007e;
                case 7: goto L_0x0072;
                case 8: goto L_0x0066;
                case 9: goto L_0x005a;
                case 10: goto L_0x004a;
                case 11: goto L_0x003e;
                case 12: goto L_0x0039;
                case 13: goto L_0x002c;
                case 14: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r2 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzvk r2 = (com.google.android.gms.internal.ads.zzvk) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0015
            goto L_0x0027
        L_0x0015:
            java.lang.String r5 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzavp
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzavp r5 = (com.google.android.gms.internal.ads.zzavp) r5
            goto L_0x0027
        L_0x0022:
            com.google.android.gms.internal.ads.zzavr r5 = new com.google.android.gms.internal.ads.zzavr
            r5.<init>(r3)
        L_0x0027:
            r1.zzb(r2, r5)
            goto L_0x00a7
        L_0x002c:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzym r2 = com.google.android.gms.internal.ads.zzyl.zzi(r2)
            r1.zza((com.google.android.gms.internal.ads.zzym) r2)
            goto L_0x00a7
        L_0x0039:
            com.google.android.gms.internal.ads.zzyn r2 = r1.zzkh()
            goto L_0x0042
        L_0x003e:
            com.google.android.gms.internal.ads.zzavc r2 = r1.zzre()
        L_0x0042:
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
            goto L_0x0104
        L_0x004a:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            boolean r3 = com.google.android.gms.internal.ads.zzgv.zza(r3)
            r1.zza((com.google.android.gms.dynamic.IObjectWrapper) r2, (boolean) r3)
            goto L_0x00a7
        L_0x005a:
            android.os.Bundle r2 = r1.getAdMetadata()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zzb(r4, r2)
            goto L_0x0104
        L_0x0066:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzyh r2 = com.google.android.gms.internal.ads.zzyk.zzh(r2)
            r1.zza((com.google.android.gms.internal.ads.zzyh) r2)
            goto L_0x00a7
        L_0x0072:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzavy> r2 = com.google.android.gms.internal.ads.zzavy.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzavy r2 = (com.google.android.gms.internal.ads.zzavy) r2
            r1.zza((com.google.android.gms.internal.ads.zzavy) r2)
            goto L_0x00a7
        L_0x007e:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0085
            goto L_0x0098
        L_0x0085:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzavq
            if (r5 == 0) goto L_0x0093
            r5 = r3
            com.google.android.gms.internal.ads.zzavq r5 = (com.google.android.gms.internal.ads.zzavq) r5
            goto L_0x0098
        L_0x0093:
            com.google.android.gms.internal.ads.zzavt r5 = new com.google.android.gms.internal.ads.zzavt
            r5.<init>(r2)
        L_0x0098:
            r1.zza((com.google.android.gms.internal.ads.zzavq) r5)
            goto L_0x00a7
        L_0x009c:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zzh(r2)
        L_0x00a7:
            r4.writeNoException()
            goto L_0x0104
        L_0x00ab:
            java.lang.String r2 = r1.getMediationAdapterClassName()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x0104
        L_0x00b6:
            boolean r2 = r1.isLoaded()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgv.writeBoolean(r4, r2)
            goto L_0x0104
        L_0x00c1:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00c8
            goto L_0x00db
        L_0x00c8:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzavi
            if (r5 == 0) goto L_0x00d6
            r5 = r3
            com.google.android.gms.internal.ads.zzavi r5 = (com.google.android.gms.internal.ads.zzavi) r5
            goto L_0x00db
        L_0x00d6:
            com.google.android.gms.internal.ads.zzavk r5 = new com.google.android.gms.internal.ads.zzavk
            r5.<init>(r2)
        L_0x00db:
            r1.zza((com.google.android.gms.internal.ads.zzavi) r5)
            goto L_0x00a7
        L_0x00df:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r2 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzvk r2 = (com.google.android.gms.internal.ads.zzvk) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x00ee
            goto L_0x0100
        L_0x00ee:
            java.lang.String r5 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzavp
            if (r0 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzavp r5 = (com.google.android.gms.internal.ads.zzavp) r5
            goto L_0x0100
        L_0x00fb:
            com.google.android.gms.internal.ads.zzavr r5 = new com.google.android.gms.internal.ads.zzavr
            r5.<init>(r3)
        L_0x0100:
            r1.zza((com.google.android.gms.internal.ads.zzvk) r2, (com.google.android.gms.internal.ads.zzavp) r5)
            goto L_0x00a7
        L_0x0104:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavg.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
