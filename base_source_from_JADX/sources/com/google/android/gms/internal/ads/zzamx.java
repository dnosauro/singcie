package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzamx<I, O> implements zzdyb<I, O> {
    /* access modifiers changed from: private */
    public final zzamf<O> zzdke;
    private final zzame<I> zzdkf;
    private final String zzdkg;
    private final zzdyz<zzalz> zzdkk;

    zzamx(zzdyz<zzalz> zzdyz, String str, zzame<I> zzame, zzamf<O> zzamf) {
        this.zzdkk = zzdyz;
        this.zzdkg = str;
        this.zzdkf = zzame;
        this.zzdke = zzamf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(Object obj, zzalz zzalz) {
        zzazq zzazq = new zzazq();
        zzp.zzkq();
        String zzyf = zzm.zzyf();
        zzahc.zzdgi.zza(zzyf, (zzaih) new zzamz(this, zzazq));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzyf);
        jSONObject.put("args", this.zzdkf.zzj(obj));
        zzalz.zza(this.zzdkg, jSONObject);
        return zzazq;
    }

    public final zzdyz<O> zzf(I i) {
        return zzdyr.zzb(this.zzdkk, new zzamw(this, i), (Executor) zzazj.zzegu);
    }
}
