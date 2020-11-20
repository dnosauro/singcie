package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.ads.internal.util.zzi;
import com.google.android.gms.ads.internal.util.zzj;
import java.util.HashMap;
import java.util.Map;

public final class zzdop {
    private final Context zzaaa;
    private final zzazh zzbos;
    private final zzayg zzbpt;
    private final Map<String, zzdor> zzhkc = new HashMap();

    public zzdop(Context context, zzazh zzazh, zzayg zzayg) {
        this.zzaaa = context;
        this.zzbos = zzazh;
        this.zzbpt = zzayg;
    }

    private final zzdor zzauz() {
        return new zzdor(this.zzaaa, this.zzbpt.zzwz(), this.zzbpt.zzxb());
    }

    private final zzdor zzgt(String str) {
        zzauc zzx = zzauc.zzx(this.zzaaa);
        try {
            zzx.setAppPackageName(str);
            zzi zzi = new zzi();
            zzi.zza(this.zzaaa, str, false);
            zzj zzj = new zzj(this.zzbpt.zzwz(), zzi);
            return new zzdor(zzx, zzj, new zzayq(zzayr.zzzf(), zzj));
        } catch (PackageManager.NameNotFoundException unused) {
            return zzauz();
        }
    }

    public final zzdor zzgs(String str) {
        if (str == null) {
            return zzauz();
        }
        if (this.zzhkc.containsKey(str)) {
            return this.zzhkc.get(str);
        }
        zzdor zzgt = zzgt(str);
        this.zzhkc.put(str, zzgt);
        return zzgt;
    }
}
