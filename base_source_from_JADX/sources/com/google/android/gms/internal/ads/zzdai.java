package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzdai implements zzdfj<Bundle> {
    private final String zzacv;
    private final zzvn zzbpe;
    private final float zzbrt;
    private final boolean zzchr;
    private final int zzdpl;
    private final int zzdpm;
    private final String zzgyh;
    private final String zzgyi;
    private final boolean zzgyj;

    public zzdai(zzvn zzvn, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzvn, "the adSize must not be null");
        this.zzbpe = zzvn;
        this.zzacv = str;
        this.zzchr = z;
        this.zzgyh = str2;
        this.zzbrt = f;
        this.zzdpl = i;
        this.zzdpm = i2;
        this.zzgyi = str3;
        this.zzgyj = z2;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdnx.zza(bundle, "smart_w", "full", this.zzbpe.width == -1);
        zzdnx.zza(bundle, "smart_h", "auto", this.zzbpe.height == -2);
        zzdnx.zza(bundle, "ene", (Boolean) true, this.zzbpe.zzchs);
        zzdnx.zza(bundle, "rafmt", "102", this.zzbpe.zzchv);
        zzdnx.zza(bundle, "rafmt", "103", this.zzbpe.zzchw);
        zzdnx.zza(bundle, "inline_adaptive_slot", (Boolean) true, this.zzgyj);
        zzdnx.zza(bundle, "format", this.zzacv);
        zzdnx.zza(bundle, "fluid", "height", this.zzchr);
        String str = this.zzgyh;
        zzdnx.zza(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zzbrt);
        bundle.putInt("sw", this.zzdpl);
        bundle.putInt("sh", this.zzdpm);
        String str2 = this.zzgyi;
        zzdnx.zza(bundle, "sc", str2, !TextUtils.isEmpty(str2));
        ArrayList arrayList = new ArrayList();
        if (this.zzbpe.zzchq == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zzbpe.height);
            bundle2.putInt("width", this.zzbpe.width);
            bundle2.putBoolean("is_fluid_height", this.zzbpe.zzchr);
            arrayList.add(bundle2);
        } else {
            for (zzvn zzvn : this.zzbpe.zzchq) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzvn.zzchr);
                bundle3.putInt("height", zzvn.height);
                bundle3.putInt("width", zzvn.width);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
