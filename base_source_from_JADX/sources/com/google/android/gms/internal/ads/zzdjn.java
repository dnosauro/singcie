package com.google.android.gms.internal.ads;

import java.util.Iterator;

final /* synthetic */ class zzdjn implements zzdyb {
    private final zzdjk zzhej;
    private final zzdpn zzhek;
    private final zzboz zzhel;

    zzdjn(zzdjk zzdjk, zzdpn zzdpn, zzboz zzboz) {
        this.zzhej = zzdjk;
        this.zzhek = zzdpn;
        this.zzhel = zzboz;
    }

    public final zzdyz zzf(Object obj) {
        zzdpn zzdpn = this.zzhek;
        zzboz zzboz = this.zzhel;
        zzdnj zzdnj = (zzdnj) obj;
        zzdpn.zzext = zzdnj;
        Iterator<zzdmu> it = zzdnj.zzhik.zzhih.iterator();
        boolean z = false;
        boolean z2 = false;
        loop0:
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            Iterator<String> it2 = it.next().zzhgo.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!it2.next().contains("FirstPartyRenderer")) {
                        break loop0;
                    }
                    z2 = true;
                }
            }
        }
        return !z ? zzdyr.zzag(null) : zzboz.zzb((zzdyz<zzdnj>) zzdyr.zzag(zzdnj));
    }
}
