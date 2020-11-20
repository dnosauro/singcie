package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzagl extends zzgu implements zzagj {
    zzagl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    public final void cancelUnconfirmedClick() {
        zzb(22, zzdo());
    }

    public final void destroy() {
        zzb(13, zzdo());
    }

    public final String getAdvertiser() {
        Parcel zza = zza(7, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getBody() {
        Parcel zza = zza(4, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getCallToAction() {
        Parcel zza = zza(6, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final Bundle getExtras() {
        Parcel zza = zza(20, zzdo());
        Bundle bundle = (Bundle) zzgv.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final String getHeadline() {
        Parcel zza = zza(2, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List getImages() {
        Parcel zza = zza(3, zzdo());
        ArrayList zzb = zzgv.zzb(zza);
        zza.recycle();
        return zzb;
    }

    public final String getMediationAdapterClassName() {
        Parcel zza = zza(12, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List getMuteThisAdReasons() {
        Parcel zza = zza(23, zzdo());
        ArrayList zzb = zzgv.zzb(zza);
        zza.recycle();
        return zzb;
    }

    public final String getPrice() {
        Parcel zza = zza(10, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final double getStarRating() {
        Parcel zza = zza(8, zzdo());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    public final String getStore() {
        Parcel zza = zza(9, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final zzys getVideoController() {
        Parcel zza = zza(11, zzdo());
        zzys zzk = zzyr.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final boolean isCustomClickGestureEnabled() {
        Parcel zza = zza(30, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isCustomMuteThisAdEnabled() {
        Parcel zza = zza(24, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void performClick(Bundle bundle) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) bundle);
        zzb(15, zzdo);
    }

    public final void recordCustomClickGesture() {
        zzb(28, zzdo());
    }

    public final boolean recordImpression(Bundle bundle) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) bundle);
        Parcel zza = zza(16, zzdo);
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void reportTouchEvent(Bundle bundle) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) bundle);
        zzb(17, zzdo);
    }

    public final void zza(zzage zzage) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzage);
        zzb(21, zzdo);
    }

    public final void zza(zzxz zzxz) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzxz);
        zzb(26, zzdo);
    }

    public final void zza(zzyd zzyd) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzyd);
        zzb(25, zzdo);
    }

    public final void zza(zzym zzym) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzym);
        zzb(32, zzdo);
    }

    public final zzyn zzkh() {
        Parcel zza = zza(31, zzdo());
        zzyn zzj = zzyq.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    public final IObjectWrapper zzsv() {
        Parcel zza = zza(18, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaej zzsw() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 5
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaej
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzaej r1 = (com.google.android.gms.internal.ads.zzaej) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzael r2 = new com.google.android.gms.internal.ads.zzael
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagl.zzsw():com.google.android.gms.internal.ads.zzaej");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaeb zzsx() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 14
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IAttributionInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaeb
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaeb r1 = (com.google.android.gms.internal.ads.zzaeb) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaed r2 = new com.google.android.gms.internal.ads.zzaed
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagl.zzsx():com.google.android.gms.internal.ads.zzaeb");
    }

    public final IObjectWrapper zzsy() {
        Parcel zza = zza(19, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zztg() {
        zzb(27, zzdo());
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaee zzth() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 29
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaee
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaee r1 = (com.google.android.gms.internal.ads.zzaee) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaeg r2 = new com.google.android.gms.internal.ads.zzaeg
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagl.zzth():com.google.android.gms.internal.ads.zzaee");
    }
}
