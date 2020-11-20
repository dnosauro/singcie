package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzaul extends zzgw implements zzaui {
    public zzaul() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzaui zzan(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof zzaui ? (zzaui) queryLocalInterface : new zzauk(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3, types: [com.google.android.gms.internal.ads.zzaup] */
    /* JADX WARNING: type inference failed for: r4v8, types: [com.google.android.gms.internal.ads.zzaug] */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bf, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgv.writeBoolean(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) {
        /*
            r0 = this;
            r4 = 34
            if (r1 == r4) goto L_0x00f7
            r4 = 0
            switch(r1) {
                case 1: goto L_0x00e8;
                case 2: goto L_0x00e4;
                case 3: goto L_0x00c6;
                default: goto L_0x0008;
            }
        L_0x0008:
            switch(r1) {
                case 5: goto L_0x00bb;
                case 6: goto L_0x00b7;
                case 7: goto L_0x00b3;
                case 8: goto L_0x00af;
                case 9: goto L_0x00a3;
                case 10: goto L_0x0097;
                case 11: goto L_0x008b;
                case 12: goto L_0x007f;
                case 13: goto L_0x0076;
                case 14: goto L_0x0069;
                case 15: goto L_0x005d;
                case 16: goto L_0x003e;
                case 17: goto L_0x0035;
                case 18: goto L_0x0028;
                case 19: goto L_0x001f;
                case 20: goto L_0x0019;
                case 21: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            r1 = 0
            return r1
        L_0x000d:
            com.google.android.gms.internal.ads.zzyn r1 = r0.zzkh()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            goto L_0x00ff
        L_0x0019:
            boolean r1 = r0.zzrf()
            goto L_0x00bf
        L_0x001f:
            java.lang.String r1 = r2.readString()
            r0.setCustomData(r1)
            goto L_0x00f3
        L_0x0028:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzi(r1)
            goto L_0x00f3
        L_0x0035:
            java.lang.String r1 = r2.readString()
            r0.setAppPackageName(r1)
            goto L_0x00f3
        L_0x003e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0045
            goto L_0x0058
        L_0x0045:
            java.lang.String r2 = "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzaug
            if (r4 == 0) goto L_0x0053
            r4 = r2
            com.google.android.gms.internal.ads.zzaug r4 = (com.google.android.gms.internal.ads.zzaug) r4
            goto L_0x0058
        L_0x0053:
            com.google.android.gms.internal.ads.zzauj r4 = new com.google.android.gms.internal.ads.zzauj
            r4.<init>(r1)
        L_0x0058:
            r0.zza((com.google.android.gms.internal.ads.zzaug) r4)
            goto L_0x00f3
        L_0x005d:
            android.os.Bundle r1 = r0.getAdMetadata()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zzb(r3, r1)
            goto L_0x00ff
        L_0x0069:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzxj r1 = com.google.android.gms.internal.ads.zzxm.zzd(r1)
            r0.zza((com.google.android.gms.internal.ads.zzxj) r1)
            goto L_0x00f3
        L_0x0076:
            java.lang.String r1 = r2.readString()
            r0.setUserId(r1)
            goto L_0x00f3
        L_0x007f:
            java.lang.String r1 = r0.getMediationAdapterClassName()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x00ff
        L_0x008b:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzl(r1)
            goto L_0x00f3
        L_0x0097:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzk(r1)
            goto L_0x00f3
        L_0x00a3:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzj(r1)
            goto L_0x00f3
        L_0x00af:
            r0.destroy()
            goto L_0x00f3
        L_0x00b3:
            r0.resume()
            goto L_0x00f3
        L_0x00b7:
            r0.pause()
            goto L_0x00f3
        L_0x00bb:
            boolean r1 = r0.isLoaded()
        L_0x00bf:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgv.writeBoolean(r3, r1)
            goto L_0x00ff
        L_0x00c6:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00cd
            goto L_0x00e0
        L_0x00cd:
            java.lang.String r2 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzaup
            if (r4 == 0) goto L_0x00db
            r4 = r2
            com.google.android.gms.internal.ads.zzaup r4 = (com.google.android.gms.internal.ads.zzaup) r4
            goto L_0x00e0
        L_0x00db:
            com.google.android.gms.internal.ads.zzaur r4 = new com.google.android.gms.internal.ads.zzaur
            r4.<init>(r1)
        L_0x00e0:
            r0.zza((com.google.android.gms.internal.ads.zzaup) r4)
            goto L_0x00f3
        L_0x00e4:
            r0.show()
            goto L_0x00f3
        L_0x00e8:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzauv> r1 = com.google.android.gms.internal.ads.zzauv.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzauv r1 = (com.google.android.gms.internal.ads.zzauv) r1
            r0.zza((com.google.android.gms.internal.ads.zzauv) r1)
        L_0x00f3:
            r3.writeNoException()
            goto L_0x00ff
        L_0x00f7:
            boolean r1 = com.google.android.gms.internal.ads.zzgv.zza(r2)
            r0.setImmersiveMode(r1)
            goto L_0x00f3
        L_0x00ff:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaul.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
