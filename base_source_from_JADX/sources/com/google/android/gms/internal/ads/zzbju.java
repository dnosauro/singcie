package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

public final class zzbju implements zzbjn {
    private final Context context;

    public zzbju(Context context2) {
        this.context = context2;
    }

    public final void zzm(Map<String, String> map) {
        CookieManager zzbh;
        String str = map.get("cookie");
        if (!TextUtils.isEmpty(str) && (zzbh = zzp.zzks().zzbh(this.context)) != null) {
            zzbh.setCookie((String) zzwq.zzqe().zzd(zzabf.zzcoi), str);
        }
    }
}
