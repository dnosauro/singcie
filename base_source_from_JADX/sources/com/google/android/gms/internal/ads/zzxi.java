package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzxi extends zzgu implements zzxg {
    zzxi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final void destroy() {
        zzb(2, zzdo());
    }

    public final Bundle getAdMetadata() {
        Parcel zza = zza(37, zzdo());
        Bundle bundle = (Bundle) zzgv.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final String getAdUnitId() {
        Parcel zza = zza(31, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getMediationAdapterClassName() {
        Parcel zza = zza(18, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzys getVideoController() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 26
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoController"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzys
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzys r1 = (com.google.android.gms.internal.ads.zzys) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzyu r2 = new com.google.android.gms.internal.ads.zzyu
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxi.getVideoController():com.google.android.gms.internal.ads.zzys");
    }

    public final boolean isLoading() {
        Parcel zza = zza(23, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isReady() {
        Parcel zza = zza(3, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void pause() {
        zzb(5, zzdo());
    }

    public final void resume() {
        zzb(6, zzdo());
    }

    public final void setImmersiveMode(boolean z) {
        Parcel zzdo = zzdo();
        zzgv.writeBoolean(zzdo, z);
        zzb(34, zzdo);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        Parcel zzdo = zzdo();
        zzgv.writeBoolean(zzdo, z);
        zzb(22, zzdo);
    }

    public final void setUserId(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(25, zzdo);
    }

    public final void showInterstitial() {
        zzb(9, zzdo());
    }

    public final void stopLoading() {
        zzb(10, zzdo());
    }

    public final void zza(zzaak zzaak) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzaak);
        zzb(29, zzdo);
    }

    public final void zza(zzacb zzacb) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzacb);
        zzb(19, zzdo);
    }

    public final void zza(zzart zzart) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzart);
        zzb(14, zzdo);
    }

    public final void zza(zzarz zzarz, String str) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzarz);
        zzdo.writeString(str);
        zzb(15, zzdo);
    }

    public final void zza(zzaup zzaup) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaup);
        zzb(24, zzdo);
    }

    public final void zza(zzsl zzsl) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzsl);
        zzb(40, zzdo);
    }

    public final void zza(zzvn zzvn) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvn);
        zzb(13, zzdo);
    }

    public final void zza(zzvw zzvw) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvw);
        zzb(39, zzdo);
    }

    public final void zza(zzws zzws) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzws);
        zzb(20, zzdo);
    }

    public final void zza(zzwt zzwt) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzwt);
        zzb(7, zzdo);
    }

    public final void zza(zzxj zzxj) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzxj);
        zzb(36, zzdo);
    }

    public final void zza(zzxo zzxo) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzxo);
        zzb(8, zzdo);
    }

    public final void zza(zzxu zzxu) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzxu);
        zzb(21, zzdo);
    }

    public final void zza(zzym zzym) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzym);
        zzb(42, zzdo);
    }

    public final void zza(zzyy zzyy) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzyy);
        zzb(30, zzdo);
    }

    public final boolean zza(zzvk zzvk) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvk);
        Parcel zza = zza(4, zzdo);
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zzbl(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(38, zzdo);
    }

    public final IObjectWrapper zzkd() {
        Parcel zza = zza(1, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zzke() {
        zzb(11, zzdo());
    }

    public final zzvn zzkf() {
        Parcel zza = zza(12, zzdo());
        zzvn zzvn = (zzvn) zzgv.zza(zza, zzvn.CREATOR);
        zza.recycle();
        return zzvn;
    }

    public final String zzkg() {
        Parcel zza = zza(35, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzyn zzkh() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 41
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IResponseInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzyn
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzyn r1 = (com.google.android.gms.internal.ads.zzyn) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzyp r2 = new com.google.android.gms.internal.ads.zzyp
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxi.zzkh():com.google.android.gms.internal.ads.zzyn");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxo zzki() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 32
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzxo
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzxo r1 = (com.google.android.gms.internal.ads.zzxo) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzxq r2 = new com.google.android.gms.internal.ads.zzxq
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxi.zzki():com.google.android.gms.internal.ads.zzxo");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzwt zzkj() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 33
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzwt
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzwt r1 = (com.google.android.gms.internal.ads.zzwt) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzwv r2 = new com.google.android.gms.internal.ads.zzwv
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxi.zzkj():com.google.android.gms.internal.ads.zzwt");
    }
}
