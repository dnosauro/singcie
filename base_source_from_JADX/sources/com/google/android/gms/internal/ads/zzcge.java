package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import org.json.JSONObject;

final class zzcge implements zzadx {
    private final /* synthetic */ zzcgb zzghg;

    zzcge(zzcgb zzcgb) {
        this.zzghg = zzcgb;
    }

    public final void zzc(MotionEvent motionEvent) {
    }

    public final void zzss() {
        if (this.zzghg.zzgdx != null) {
            this.zzghg.zzgdx.zzfw(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
        }
    }

    public final JSONObject zzst() {
        return null;
    }
}
