package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbzc {
    private final zzbdv zzdii;
    private final zzcaf zzfzw;

    public zzbzc(zzcaf zzcaf) {
        this(zzcaf, (zzbdv) null);
    }

    public zzbzc(zzcaf zzcaf, zzbdv zzbdv) {
        this.zzfzw = zzcaf;
        this.zzdii = zzbdv;
    }

    public final zzbdv zzaim() {
        return this.zzdii;
    }

    public final zzcaf zzamb() {
        return this.zzfzw;
    }

    public final View zzamc() {
        zzbdv zzbdv = this.zzdii;
        if (zzbdv != null) {
            return zzbdv.getWebView();
        }
        return null;
    }

    public final View zzamd() {
        zzbdv zzbdv = this.zzdii;
        if (zzbdv == null) {
            return null;
        }
        return zzbdv.getWebView();
    }

    public final zzbxy<zzbvs> zzb(Executor executor) {
        return new zzbxy<>(new zzbze(this.zzdii), executor);
    }

    public Set<zzbxy<zzbru>> zzb(zzbqu zzbqu) {
        return Collections.singleton(zzbxy.zzb(zzbqu, zzazj.zzegu));
    }

    public Set<zzbxy<zzbxn>> zzc(zzbqu zzbqu) {
        return Collections.singleton(zzbxy.zzb(zzbqu, zzazj.zzegu));
    }
}
