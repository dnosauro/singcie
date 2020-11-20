package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxv;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzdya<V, C> extends zzdxv<V, C> {
    private List<zzdyc<V>> zzhxe;

    zzdya(zzdwl<? extends zzdyz<? extends V>> zzdwl, boolean z) {
        super(zzdwl, true, true);
        List<zzdyc<V>> zzayv = zzdwl.isEmpty() ? zzdwm.zzayv() : zzdwu.zzes(zzdwl.size());
        for (int i = 0; i < zzdwl.size(); i++) {
            zzayv.add((Object) null);
        }
        this.zzhxe = zzayv;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdxv.zza zza) {
        super.zza(zza);
        this.zzhxe = null;
    }

    /* access modifiers changed from: package-private */
    public final void zzazg() {
        List<zzdyc<V>> list = this.zzhxe;
        if (list != null) {
            set(zzk(list));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, @NullableDecl V v) {
        List<zzdyc<V>> list = this.zzhxe;
        if (list != null) {
            list.set(i, new zzdyc(v));
        }
    }

    /* access modifiers changed from: package-private */
    public abstract C zzk(List<zzdyc<V>> list);
}
