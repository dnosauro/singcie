package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdeu implements zzdfj<Bundle> {
    private final String zzbrf;
    private final int zzdti;
    private final boolean zzduf;
    private final boolean zzego;
    private final boolean zzhaz;
    private final int zzhba;
    private final int zzhbb;

    public zzdeu(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zzhaz = z;
        this.zzego = z2;
        this.zzbrf = str;
        this.zzduf = z3;
        this.zzdti = i;
        this.zzhba = i2;
        this.zzhbb = i3;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzbrf);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) zzwq.zzqe().zzd(zzabf.zzcrt));
        bundle.putInt("target_api", this.zzdti);
        bundle.putInt("dv", this.zzhba);
        bundle.putInt("lv", this.zzhbb);
        Bundle zza = zzdnx.zza(bundle, "sdk_env");
        zza.putBoolean("mf", zzadb.zzdct.get().booleanValue());
        zza.putBoolean("instant_app", this.zzhaz);
        zza.putBoolean("lite", this.zzego);
        zza.putBoolean("is_privileged_process", this.zzduf);
        bundle.putBundle("sdk_env", zza);
        Bundle zza2 = zzdnx.zza(zza, "build_meta");
        zza2.putString("cl", "334274230");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
