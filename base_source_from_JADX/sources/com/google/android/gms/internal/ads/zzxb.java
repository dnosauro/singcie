package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class zzxb extends zzgu implements zzwz {
    zzxb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) publisherAdViewOptions);
        zzb(9, zzdo);
    }

    public final void zza(zzadz zzadz) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzadz);
        zzb(6, zzdo);
    }

    public final void zza(zzafj zzafj) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzafj);
        zzb(3, zzdo);
    }

    public final void zza(zzafk zzafk) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzafk);
        zzb(4, zzdo);
    }

    public final void zza(zzafx zzafx, zzvn zzvn) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzafx);
        zzgv.zza(zzdo, (Parcelable) zzvn);
        zzb(8, zzdo);
    }

    public final void zza(zzafy zzafy) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzafy);
        zzb(10, zzdo);
    }

    public final void zza(zzajl zzajl) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzajl);
        zzb(13, zzdo);
    }

    public final void zza(zzajt zzajt) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzajt);
        zzb(14, zzdo);
    }

    public final void zza(String str, zzafq zzafq, zzafp zzafp) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) zzafq);
        zzgv.zza(zzdo, (IInterface) zzafp);
        zzb(5, zzdo);
    }

    public final void zzb(zzwt zzwt) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzwt);
        zzb(2, zzdo);
    }

    public final void zzb(zzxu zzxu) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzxu);
        zzb(7, zzdo);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzwy zzqj() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 1
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzwy
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzwy r1 = (com.google.android.gms.internal.ads.zzwy) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzxa r2 = new com.google.android.gms.internal.ads.zzxa
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxb.zzqj():com.google.android.gms.internal.ads.zzwy");
    }
}
