package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzavj extends zzgu implements zzavh {
    zzavj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final Bundle getAdMetadata() {
        Parcel zza = zza(9, zzdo());
        Bundle bundle = (Bundle) zzgv.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final String getMediationAdapterClassName() {
        Parcel zza = zza(4, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final boolean isLoaded() {
        Parcel zza = zza(3, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.writeBoolean(zzdo, z);
        zzb(10, zzdo);
    }

    public final void zza(zzavi zzavi) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzavi);
        zzb(2, zzdo);
    }

    public final void zza(zzavq zzavq) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzavq);
        zzb(6, zzdo);
    }

    public final void zza(zzavy zzavy) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzavy);
        zzb(7, zzdo);
    }

    public final void zza(zzvk zzvk, zzavp zzavp) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzgv.zza(zzdo, (IInterface) zzavp);
        zzb(1, zzdo);
    }

    public final void zza(zzyh zzyh) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzyh);
        zzb(8, zzdo);
    }

    public final void zza(zzym zzym) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzym);
        zzb(13, zzdo);
    }

    public final void zzb(zzvk zzvk, zzavp zzavp) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzgv.zza(zzdo, (IInterface) zzavp);
        zzb(14, zzdo);
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(5, zzdo);
    }

    public final zzyn zzkh() {
        Parcel zza = zza(12, zzdo());
        zzyn zzj = zzyq.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzavc zzre() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 11
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzavc
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzavc r1 = (com.google.android.gms.internal.ads.zzavc) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzave r2 = new com.google.android.gms.internal.ads.zzave
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavj.zzre():com.google.android.gms.internal.ads.zzavc");
    }
}
