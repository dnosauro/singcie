package com.google.android.gms.internal.ads;

final class zzenh extends zzenf<zzeni, zzeni> {
    zzenh() {
    }

    private static void zza(Object obj, zzeni zzeni) {
        ((zzekh) obj).zzino = zzeni;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzeni) obj).zzd(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzeiu zzeiu) {
        ((zzeni) obj).zzd((i << 3) | 2, zzeiu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzeni) obj).zzd((i << 3) | 3, (zzeni) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzeoc zzeoc) {
        ((zzeni) obj).zzb(zzeoc);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzemh zzemh) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zzak(Object obj) {
        ((zzekh) obj).zzino.zzbfl();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaq(Object obj) {
        zzeni zzeni = (zzeni) obj;
        zzeni.zzbfl();
        return zzeni;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzau(Object obj) {
        return ((zzeni) obj).zzbhz();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzay(Object obj) {
        return ((zzekh) obj).zzino;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaz(Object obj) {
        zzeni zzeni = ((zzekh) obj).zzino;
        if (zzeni != zzeni.zzbkg()) {
            return zzeni;
        }
        zzeni zzbkh = zzeni.zzbkh();
        zza(obj, zzbkh);
        return zzbkh;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzeni) obj).zzd((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzba(Object obj) {
        return ((zzeni) obj).zzbki();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzbkf() {
        return zzeni.zzbkh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzeni) obj).zzd((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, zzeoc zzeoc) {
        ((zzeni) obj).zza(zzeoc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Object obj, Object obj2) {
        zza(obj, (zzeni) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Object obj, Object obj2) {
        zza(obj, (zzeni) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzk(Object obj, Object obj2) {
        zzeni zzeni = (zzeni) obj;
        zzeni zzeni2 = (zzeni) obj2;
        return zzeni2.equals(zzeni.zzbkg()) ? zzeni : zzeni.zza(zzeni, zzeni2);
    }
}
