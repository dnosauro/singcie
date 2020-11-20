package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcno {
    private final Context context;
    private final Executor executor;
    private final zzdnn zzfvl;
    private final zzazh zzgnb;

    public zzcno(Context context2, zzazh zzazh, zzdnn zzdnn, Executor executor2) {
        this.context = context2;
        this.zzgnb = zzazh;
        this.zzfvl = zzdnn;
        this.executor = executor2;
    }

    public final zzdyz<zzdnj> zzaqz() {
        zzamd<I, O> zza = zzp.zzld().zzb(this.context, this.zzgnb).zza("google.afma.response.normalize", zzamg.zzdjy, zzamg.zzdjy);
        return zzdyr.zzb(zzdyr.zzb(zzdyr.zzb(zzdyr.zzag(""), new zzcnn(this, this.zzfvl.zzhio.zzchn), this.executor), new zzcnq(zza), this.executor), new zzcnp(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzo(JSONObject jSONObject) {
        return zzdyr.zzag(new zzdnj(new zzdne(this.zzfvl), zzdnh.zza(new StringReader(jSONObject.toString()))));
    }
}
