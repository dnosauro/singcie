package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdeq implements zzdfj<Bundle> {
    private final String zzdzp;
    private final String zzhau;
    private final String zzhav;
    private final String zzhaw;
    private final Long zzhax;

    public zzdeq(String str, String str2, String str3, String str4, Long l) {
        this.zzdzp = str;
        this.zzhau = str2;
        this.zzhav = str3;
        this.zzhaw = str4;
        this.zzhax = l;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdnx.zza(bundle, "gmp_app_id", this.zzdzp);
        zzdnx.zza(bundle, "fbs_aiid", this.zzhau);
        zzdnx.zza(bundle, "fbs_aeid", this.zzhav);
        zzdnx.zza(bundle, "apm_id_origin", this.zzhaw);
        Long l = this.zzhax;
        if (l != null) {
            bundle.putLong("sai_timeout", l.longValue());
        }
    }
}
