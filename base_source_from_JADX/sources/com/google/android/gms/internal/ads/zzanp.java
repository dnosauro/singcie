package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public final class zzanp extends zzgu implements zzann {
    zzanp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void destroy() {
        zzb(5, zzdo());
    }

    public final Bundle getInterstitialAdapterInfo() {
        Parcel zza = zza(18, zzdo());
        Bundle bundle = (Bundle) zzgv.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final zzys getVideoController() {
        Parcel zza = zza(26, zzdo());
        zzys zzk = zzyr.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final boolean isInitialized() {
        Parcel zza = zza(13, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void pause() {
        zzb(8, zzdo());
    }

    public final void resume() {
        zzb(9, zzdo());
    }

    public final void setImmersiveMode(boolean z) {
        Parcel zzdo = zzdo();
        zzgv.writeBoolean(zzdo, z);
        zzb(25, zzdo);
    }

    public final void showInterstitial() {
        zzb(4, zzdo());
    }

    public final void showVideo() {
        zzb(12, zzdo());
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajb zzajb, List<zzajj> list) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzajb);
        zzdo.writeTypedList(list);
        zzb(31, zzdo);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzauw zzauw, List<String> list) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzauw);
        zzdo.writeStringList(list);
        zzb(23, zzdo);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(3, zzdo);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzauw zzauw, String str2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) zzauw);
        zzdo.writeString(str2);
        zzb(10, zzdo);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(7, zzdo);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano, zzadz zzadz, List<String> list) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzgv.zza(zzdo, (Parcelable) zzadz);
        zzdo.writeStringList(list);
        zzb(14, zzdo);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, zzano zzano) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzvn);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(1, zzdo);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, String str2, zzano zzano) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzvn);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(6, zzdo);
    }

    public final void zza(zzvk zzvk, String str) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzb(11, zzdo);
    }

    public final void zza(zzvk zzvk, String str, String str2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(20, zzdo);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(28, zzdo);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(32, zzdo);
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(21, zzdo);
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(30, zzdo);
    }

    public final IObjectWrapper zzud() {
        Parcel zza = zza(2, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzanv zzue() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 15
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzanv
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzanv r1 = (com.google.android.gms.internal.ads.zzanv) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzanx r2 = new com.google.android.gms.internal.ads.zzanx
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanp.zzue():com.google.android.gms.internal.ads.zzanv");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzanw zzuf() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 16
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzanw
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzanw r1 = (com.google.android.gms.internal.ads.zzanw) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzany r2 = new com.google.android.gms.internal.ads.zzany
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanp.zzuf():com.google.android.gms.internal.ads.zzanw");
    }

    public final Bundle zzug() {
        Parcel zza = zza(17, zzdo());
        Bundle bundle = (Bundle) zzgv.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final Bundle zzuh() {
        Parcel zza = zza(19, zzdo());
        Bundle bundle = (Bundle) zzgv.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final boolean zzui() {
        Parcel zza = zza(22, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final zzaff zzuj() {
        Parcel zza = zza(24, zzdo());
        zzaff zzr = zzafe.zzr(zza.readStrongBinder());
        zza.recycle();
        return zzr;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaob zzuk() {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zzdo()
            r1 = 27
            android.os.Parcel r0 = r4.zza(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaob
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaob r1 = (com.google.android.gms.internal.ads.zzaob) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaod r2 = new com.google.android.gms.internal.ads.zzaod
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanp.zzuk():com.google.android.gms.internal.ads.zzaob");
    }

    public final zzaqc zzul() {
        Parcel zza = zza(33, zzdo());
        zzaqc zzaqc = (zzaqc) zzgv.zza(zza, zzaqc.CREATOR);
        zza.recycle();
        return zzaqc;
    }

    public final zzaqc zzum() {
        Parcel zza = zza(34, zzdo());
        zzaqc zzaqc = (zzaqc) zzgv.zza(zza, zzaqc.CREATOR);
        zza.recycle();
        return zzaqc;
    }
}
