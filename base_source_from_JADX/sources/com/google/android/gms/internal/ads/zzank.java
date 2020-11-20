package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class zzank extends zzgu implements zzani {
    zzank(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzann zzde(java.lang.String r4) {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zzdo()
            r0.writeString(r4)
            r4 = 1
            android.os.Parcel r4 = r3.zza(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzann
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzann r0 = (com.google.android.gms.internal.ads.zzann) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzanp r1 = new com.google.android.gms.internal.ads.zzanp
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzank.zzde(java.lang.String):com.google.android.gms.internal.ads.zzann");
    }

    public final boolean zzdf(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(2, zzdo);
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final zzapo zzdg(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(3, zzdo);
        zzapo zzaf = zzapr.zzaf(zza.readStrongBinder());
        zza.recycle();
        return zzaf;
    }
}
