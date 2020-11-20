package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzxr extends zzgu implements zzxp {
    zzxr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final zzaen zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper2);
        Parcel zza = zza(5, zzdo);
        zzaen zzp = zzaem.zzp(zza.readStrongBinder());
        zza.recycle();
        return zzp;
    }

    public final zzaeq zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper2);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper3);
        Parcel zza = zza(11, zzdo);
        zzaeq zzq = zzaet.zzq(zza.readStrongBinder());
        zza.recycle();
        return zzq;
    }

    public final zzaui zza(IObjectWrapper iObjectWrapper, zzani zzani, int i) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzani);
        zzdo.writeInt(i);
        Parcel zza = zza(6, zzdo);
        zzaui zzan = zzaul.zzan(zza.readStrongBinder());
        zza.recycle();
        return zzan;
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzwz zza(com.google.android.gms.dynamic.IObjectWrapper r2, java.lang.String r3, com.google.android.gms.internal.ads.zzani r4, int r5) {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zzdo()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            r0.writeString(r3)
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r4)
            r0.writeInt(r5)
            r2 = 3
            android.os.Parcel r2 = r1.zza(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x001d
            r3 = 0
            goto L_0x0031
        L_0x001d:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzwz
            if (r5 == 0) goto L_0x002b
            r3 = r4
            com.google.android.gms.internal.ads.zzwz r3 = (com.google.android.gms.internal.ads.zzwz) r3
            goto L_0x0031
        L_0x002b:
            com.google.android.gms.internal.ads.zzxb r4 = new com.google.android.gms.internal.ads.zzxb
            r4.<init>(r3)
            r3 = r4
        L_0x0031:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zza(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, com.google.android.gms.internal.ads.zzani, int):com.google.android.gms.internal.ads.zzwz");
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxg zza(com.google.android.gms.dynamic.IObjectWrapper r2, com.google.android.gms.internal.ads.zzvn r3, java.lang.String r4, int r5) {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zzdo()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.Parcelable) r3)
            r0.writeString(r4)
            r0.writeInt(r5)
            r2 = 10
            android.os.Parcel r2 = r1.zza(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x001e
            r3 = 0
            goto L_0x0032
        L_0x001e:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzxg
            if (r5 == 0) goto L_0x002c
            r3 = r4
            com.google.android.gms.internal.ads.zzxg r3 = (com.google.android.gms.internal.ads.zzxg) r3
            goto L_0x0032
        L_0x002c:
            com.google.android.gms.internal.ads.zzxi r4 = new com.google.android.gms.internal.ads.zzxi
            r4.<init>(r3)
            r3 = r4
        L_0x0032:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zza(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzvn, java.lang.String, int):com.google.android.gms.internal.ads.zzxg");
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxg zza(com.google.android.gms.dynamic.IObjectWrapper r2, com.google.android.gms.internal.ads.zzvn r3, java.lang.String r4, com.google.android.gms.internal.ads.zzani r5, int r6) {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zzdo()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.Parcelable) r3)
            r0.writeString(r4)
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r5)
            r0.writeInt(r6)
            r2 = 1
            android.os.Parcel r2 = r1.zza(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x0020
            r3 = 0
            goto L_0x0034
        L_0x0020:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzxg
            if (r5 == 0) goto L_0x002e
            r3 = r4
            com.google.android.gms.internal.ads.zzxg r3 = (com.google.android.gms.internal.ads.zzxg) r3
            goto L_0x0034
        L_0x002e:
            com.google.android.gms.internal.ads.zzxi r4 = new com.google.android.gms.internal.ads.zzxi
            r4.<init>(r3)
            r3 = r4
        L_0x0034:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zza(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzvn, java.lang.String, com.google.android.gms.internal.ads.zzani, int):com.google.android.gms.internal.ads.zzxg");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxw zza(com.google.android.gms.dynamic.IObjectWrapper r3, int r4) {
        /*
            r2 = this;
            android.os.Parcel r0 = r2.zzdo()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r3)
            r0.writeInt(r4)
            r3 = 9
            android.os.Parcel r3 = r2.zza(r3, r0)
            android.os.IBinder r4 = r3.readStrongBinder()
            if (r4 != 0) goto L_0x0018
            r4 = 0
            goto L_0x002c
        L_0x0018:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzxw
            if (r1 == 0) goto L_0x0026
            r4 = r0
            com.google.android.gms.internal.ads.zzxw r4 = (com.google.android.gms.internal.ads.zzxw) r4
            goto L_0x002c
        L_0x0026:
            com.google.android.gms.internal.ads.zzxy r0 = new com.google.android.gms.internal.ads.zzxy
            r0.<init>(r4)
            r4 = r0
        L_0x002c:
            r3.recycle()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zza(com.google.android.gms.dynamic.IObjectWrapper, int):com.google.android.gms.internal.ads.zzxw");
    }

    public final zzarj zzb(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        Parcel zza = zza(8, zzdo);
        zzarj zzai = zzari.zzai(zza.readStrongBinder());
        zza.recycle();
        return zzai;
    }

    public final zzavh zzb(IObjectWrapper iObjectWrapper, String str, zzani zzani, int i) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) zzani);
        zzdo.writeInt(i);
        Parcel zza = zza(12, zzdo);
        zzavh zzar = zzavg.zzar(zza.readStrongBinder());
        zza.recycle();
        return zzar;
    }

    public final zzaxq zzb(IObjectWrapper iObjectWrapper, zzani zzani, int i) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzani);
        zzdo.writeInt(i);
        Parcel zza = zza(14, zzdo);
        zzaxq zzas = zzaxt.zzas(zza.readStrongBinder());
        zza.recycle();
        return zzas;
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxg zzb(com.google.android.gms.dynamic.IObjectWrapper r2, com.google.android.gms.internal.ads.zzvn r3, java.lang.String r4, com.google.android.gms.internal.ads.zzani r5, int r6) {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zzdo()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.Parcelable) r3)
            r0.writeString(r4)
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r5)
            r0.writeInt(r6)
            r2 = 2
            android.os.Parcel r2 = r1.zza(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x0020
            r3 = 0
            goto L_0x0034
        L_0x0020:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzxg
            if (r5 == 0) goto L_0x002e
            r3 = r4
            com.google.android.gms.internal.ads.zzxg r3 = (com.google.android.gms.internal.ads.zzxg) r3
            goto L_0x0034
        L_0x002e:
            com.google.android.gms.internal.ads.zzxi r4 = new com.google.android.gms.internal.ads.zzxi
            r4.<init>(r3)
            r3 = r4
        L_0x0034:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zzb(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzvn, java.lang.String, com.google.android.gms.internal.ads.zzani, int):com.google.android.gms.internal.ads.zzxg");
    }

    public final zzaqw zzc(IObjectWrapper iObjectWrapper, zzani zzani, int i) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzani);
        zzdo.writeInt(i);
        Parcel zza = zza(15, zzdo);
        zzaqw zzag = zzaqz.zzag(zza.readStrongBinder());
        zza.recycle();
        return zzag;
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxg zzc(com.google.android.gms.dynamic.IObjectWrapper r2, com.google.android.gms.internal.ads.zzvn r3, java.lang.String r4, com.google.android.gms.internal.ads.zzani r5, int r6) {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.zzdo()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.Parcelable) r3)
            r0.writeString(r4)
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r5)
            r0.writeInt(r6)
            r2 = 13
            android.os.Parcel r2 = r1.zza(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x0021
            r3 = 0
            goto L_0x0035
        L_0x0021:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzxg
            if (r5 == 0) goto L_0x002f
            r3 = r4
            com.google.android.gms.internal.ads.zzxg r3 = (com.google.android.gms.internal.ads.zzxg) r3
            goto L_0x0035
        L_0x002f:
            com.google.android.gms.internal.ads.zzxi r4 = new com.google.android.gms.internal.ads.zzxi
            r4.<init>(r3)
            r3 = r4
        L_0x0035:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zzc(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzvn, java.lang.String, com.google.android.gms.internal.ads.zzani, int):com.google.android.gms.internal.ads.zzxg");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzxw zzc(com.google.android.gms.dynamic.IObjectWrapper r4) {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zzdo()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r0, (android.os.IInterface) r4)
            r4 = 4
            android.os.Parcel r4 = r3.zza(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzxw
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzxw r0 = (com.google.android.gms.internal.ads.zzxw) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzxy r1 = new com.google.android.gms.internal.ads.zzxy
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zzc(com.google.android.gms.dynamic.IObjectWrapper):com.google.android.gms.internal.ads.zzxw");
    }

    public final zzaru zzd(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        Parcel zza = zza(7, zzdo);
        zzaru zzak = zzarx.zzak(zza.readStrongBinder());
        zza.recycle();
        return zzak;
    }
}
