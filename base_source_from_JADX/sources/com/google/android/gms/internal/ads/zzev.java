package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

final class zzev implements zzdum {
    private final zzfh zzwr;
    private final zzdsj zzyk;
    private final zzdsv zzyl;
    private final zzey zzym;

    zzev(zzdsj zzdsj, zzdsv zzdsv, zzfh zzfh, zzey zzey) {
        this.zzyk = zzdsj;
        this.zzyl = zzdsv;
        this.zzwr = zzfh;
        this.zzym = zzey;
    }

    private final Map<String, Object> zzcb() {
        HashMap hashMap = new HashMap();
        zzcf.zza zzco = this.zzyl.zzco();
        hashMap.put("v", this.zzyk.zzawx());
        hashMap.put("gms", Boolean.valueOf(this.zzyk.zzcm()));
        hashMap.put("int", zzco.zzaf());
        hashMap.put("up", Boolean.valueOf(this.zzym.zzcf()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(View view) {
        this.zzwr.zze(view);
    }

    public final Map<String, Object> zzcc() {
        Map<String, Object> zzcb = zzcb();
        zzcf.zza zzaxe = this.zzyl.zzaxe();
        zzcb.put("gai", Boolean.valueOf(this.zzyk.zzawy()));
        zzcb.put("did", zzaxe.zzal());
        zzcb.put("dst", Integer.valueOf(zzaxe.zzam().zzv()));
        zzcb.put("doo", Boolean.valueOf(zzaxe.zzan()));
        return zzcb;
    }

    public final Map<String, Object> zzcd() {
        return zzcb();
    }

    public final Map<String, Object> zzce() {
        Map<String, Object> zzcb = zzcb();
        zzcb.put("lts", Long.valueOf(this.zzwr.zzcu()));
        return zzcb;
    }
}
