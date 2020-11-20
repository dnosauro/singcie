package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public abstract class zzcky {
    private final Executor executor;
    private final String zzczk = zzacu.zzdbq.get();
    private final boolean zzczu;
    protected final zzaze zzeff;
    protected final Map<String, String> zzgki = new HashMap();

    protected zzcky(Executor executor2, zzaze zzaze) {
        this.executor = executor2;
        this.zzeff = zzaze;
        this.zzczu = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() ? ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqo)).booleanValue() : ((double) zzwq.zzqh().nextFloat()) <= zzacu.zzdbp.get().doubleValue();
    }

    /* access modifiers changed from: protected */
    public abstract void zzaqi();

    public final void zzo(Map<String, String> map) {
        String zzp = zzp(map);
        if (this.zzczu) {
            this.executor.execute(new zzckx(this, zzp));
        }
        zzd.zzee(zzp);
    }

    /* access modifiers changed from: protected */
    public final String zzp(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zzczk).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }
}
