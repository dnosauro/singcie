package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

public final class zzcuo {
    private final zzckq zzdgx;
    private final zzcil zzgja;
    private final zzdoa zzgka;

    public zzcuo(zzdoa zzdoa, zzcil zzcil, zzckq zzckq) {
        this.zzgka = zzdoa;
        this.zzgja = zzcil;
        this.zzdgx = zzckq;
    }

    public final void zza(zzdmz zzdmz, zzdmu zzdmu, int i, @Nullable zzcrd zzcrd, long j) {
        zzcim zzcim;
        zzckp zzr = this.zzdgx.zzaqg().zza(zzdmz).zzc(zzdmu).zzr("action", "adapter_status").zzr("adapter_l", String.valueOf(j));
        zzr.zzr("sc", Integer.toString(i));
        if (zzcrd != null) {
            zzr.zzr("arec", Integer.toString(zzcrd.zzarj().errorCode));
            String zzgr = this.zzgka.zzgr(zzcrd.getMessage());
            if (zzgr != null) {
                zzr.zzr("areec", zzgr);
            }
        }
        zzcil zzcil = this.zzgja;
        Iterator<String> it = zzdmu.zzhgy.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcim = null;
                break;
            }
            zzcim = zzcil.zzgd(it.next());
            if (zzcim != null) {
                break;
            }
        }
        if (zzcim != null) {
            zzr.zzr("ancn", zzcim.zzdhn);
            if (zzcim.zzgix != null) {
                zzr.zzr("adapter_v", zzcim.zzgix.toString());
            }
            if (zzcim.zzgiy != null) {
                zzr.zzr("adapter_sv", zzcim.zzgiy.toString());
            }
        }
        zzr.zzaqd();
    }
}
