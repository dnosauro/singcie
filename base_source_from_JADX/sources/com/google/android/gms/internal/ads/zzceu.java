package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

final /* synthetic */ class zzceu implements zzdvm {
    private final String zzdih;
    private final int zzedt;
    private final int zzedu;
    private final double zzggr;

    zzceu(String str, double d, int i, int i2) {
        this.zzdih = str;
        this.zzggr = d;
        this.zzedt = i;
        this.zzedu = i2;
    }

    public final Object apply(Object obj) {
        String str = this.zzdih;
        return new zzadv(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzggr, this.zzedt, this.zzedu);
    }
}
