package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzckv extends zzcky {
    private final Context context;
    private final String packageName;
    private final String zzbrf;

    public zzckv(Executor executor, zzaze zzaze, Context context2, zzazh zzazh) {
        super(executor, zzaze);
        this.context = context2;
        this.packageName = context2.getPackageName();
        this.zzbrf = zzazh.zzbrf;
        zzaqi();
    }

    public final Map<String, String> zzaqh() {
        return new HashMap(this.zzgki);
    }

    /* access modifiers changed from: protected */
    public final void zzaqi() {
        this.zzgki.put("s", "gmob_sdk");
        this.zzgki.put("v", "3");
        this.zzgki.put("os", Build.VERSION.RELEASE);
        this.zzgki.put("api_v", Build.VERSION.SDK);
        Map map = this.zzgki;
        zzp.zzkq();
        map.put("device", zzm.zzyg());
        this.zzgki.put("app", this.packageName);
        Map map2 = this.zzgki;
        zzp.zzkq();
        map2.put("is_lite_sdk", zzm.zzaw(this.context) ? "1" : "0");
        this.zzgki.put("e", TextUtils.join(",", zzabf.zzrm()));
        this.zzgki.put("sdkVersion", this.zzbrf);
    }
}
