package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbjo implements zzdyb<zzdnj, zzdnj> {
    private Map<String, zzbjn> zzfpn;

    public zzbjo(Map<String, zzbjn> map) {
        this.zzfpn = map;
    }

    public final /* synthetic */ zzdyz zzf(Object obj) {
        zzdnj zzdnj = (zzdnj) obj;
        for (zzdng next : zzdnj.zzhik.zzhii) {
            if (this.zzfpn.containsKey(next.name)) {
                this.zzfpn.get(next.name).zzm(next.zzhig);
            }
        }
        return zzdyr.zzag(zzdnj);
    }
}
