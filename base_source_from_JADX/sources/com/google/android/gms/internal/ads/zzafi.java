package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzafi extends zzgw implements zzafj {
    public zzafi() {
        super("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public static zzafj zzs(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
        return queryLocalInterface instanceof zzafj ? (zzafj) queryLocalInterface : new zzafl(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) {
        /*
            r1 = this;
            r5 = 1
            if (r2 != r5) goto L_0x0026
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x000b
            r2 = 0
            goto L_0x001f
        L_0x000b:
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zzaex
            if (r0 == 0) goto L_0x0019
            r2 = r3
            com.google.android.gms.internal.ads.zzaex r2 = (com.google.android.gms.internal.ads.zzaex) r2
            goto L_0x001f
        L_0x0019:
            com.google.android.gms.internal.ads.zzaez r3 = new com.google.android.gms.internal.ads.zzaez
            r3.<init>(r2)
            r2 = r3
        L_0x001f:
            r1.zza(r2)
            r4.writeNoException()
            return r5
        L_0x0026:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
