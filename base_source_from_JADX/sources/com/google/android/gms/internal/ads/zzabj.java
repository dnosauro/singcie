package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

public final class zzabj {
    private Context context = null;
    private String zzbrf = null;
    private String zzczk;
    private Map<String, String> zzczn;

    public zzabj(Context context2, String str) {
        this.context = context2;
        this.zzbrf = str;
        this.zzczk = zzacu.zzdbq.get();
        this.zzczn = new LinkedHashMap();
        this.zzczn.put("s", "gmob_sdk");
        this.zzczn.put("v", "3");
        this.zzczn.put("os", Build.VERSION.RELEASE);
        this.zzczn.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzczn;
        zzp.zzkq();
        map.put("device", zzm.zzyg());
        this.zzczn.put("app", context2.getApplicationContext() != null ? context2.getApplicationContext().getPackageName() : context2.getPackageName());
        Map<String, String> map2 = this.zzczn;
        zzp.zzkq();
        map2.put("is_lite_sdk", zzm.zzaw(context2) ? "1" : "0");
        Future<zzatq> zzr = zzp.zzlb().zzr(this.context);
        try {
            this.zzczn.put("network_coarse", Integer.toString(zzr.get().zzdwr));
            this.zzczn.put("network_fine", Integer.toString(zzr.get().zzdws));
        } catch (Exception e) {
            zzp.zzku().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: package-private */
    public final String zzlv() {
        return this.zzbrf;
    }

    /* access modifiers changed from: package-private */
    public final String zzrs() {
        return this.zzczk;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzrt() {
        return this.zzczn;
    }
}
