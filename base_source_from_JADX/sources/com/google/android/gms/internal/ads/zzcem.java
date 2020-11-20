package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

final class zzcem implements zzdvm<zzy, Bitmap> {
    private final /* synthetic */ double zzgfv;
    private final /* synthetic */ boolean zzgfw;
    private final /* synthetic */ zzcej zzgfx;

    zzcem(zzcej zzcej, double d, boolean z) {
        this.zzgfx = zzcej;
        this.zzgfv = d;
        this.zzgfw = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.zzgfx.zza(((zzy) obj).data, this.zzgfv, this.zzgfw);
    }
}
