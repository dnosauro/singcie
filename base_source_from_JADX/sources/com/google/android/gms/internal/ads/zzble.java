package com.google.android.gms.internal.ads;

public final class zzble {
    private final zzckq zzdgx;
    private final zzdnj zzext;

    public zzble(zzckq zzckq, zzdnj zzdnj) {
        this.zzdgx = zzckq;
        this.zzext = zzdnj;
    }

    public final void zzb(long j, int i) {
        String str;
        zzckp zzr = this.zzdgx.zzaqg().zza(this.zzext.zzhik.zzerj).zzr("action", "ad_closed").zzr("show_time", String.valueOf(j)).zzr("ad_format", "app_open_ad");
        switch (zzbld.zzfsm[i - 1]) {
            case 1:
                str = "bb";
                break;
            case 2:
                str = "h";
                break;
            case 3:
                str = "cc";
                break;
            case 4:
                str = "ac";
                break;
            case 5:
                str = "cb";
                break;
            default:
                str = "u";
                break;
        }
        zzr.zzr("acr", str).zzaqd();
    }
}
