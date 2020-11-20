package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.regex.Pattern;

public final class zzcke implements zzbry, zzbsm, zzbvz, zzva {
    private final Context context;
    private final zzckq zzdgx;
    private final zzcqo zzdgz;
    private final zzdnj zzext;
    private final zzdmu zzfps;
    private final zzdoa zzgka;
    private Boolean zzgkb;
    private final boolean zzgkc = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcxw)).booleanValue();

    public zzcke(Context context2, zzdoa zzdoa, zzckq zzckq, zzdnj zzdnj, zzdmu zzdmu, zzcqo zzcqo) {
        this.context = context2;
        this.zzgka = zzdoa;
        this.zzdgx = zzckq;
        this.zzext = zzdnj;
        this.zzfps = zzdmu;
        this.zzdgz = zzcqo;
    }

    private final void zza(zzckp zzckp) {
        if (this.zzfps.zzhhq) {
            this.zzdgz.zza(new zzcqv(zzp.zzkx().currentTimeMillis(), this.zzext.zzhik.zzerj.zzbvf, zzckp.zzaqe(), zzcql.zzgqc));
            return;
        }
        zzckp.zzaqd();
    }

    private final boolean zzapz() {
        if (this.zzgkb == null) {
            synchronized (this) {
                if (this.zzgkb == null) {
                    zzaaq zzaaq = zzabf.zzcqf;
                    zzp.zzkq();
                    this.zzgkb = Boolean.valueOf(zzf((String) zzwq.zzqe().zzd(zzaaq), zzm.zzba(this.context)));
                }
            }
        }
        return this.zzgkb.booleanValue();
    }

    private static boolean zzf(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzp.zzku().zza(e, "CsiActionsListener.isPatternMatched");
            }
        }
        return false;
    }

    private final zzckp zzge(String str) {
        zzckp zzc = this.zzdgx.zzaqg().zza(this.zzext.zzhik.zzerj).zzc(this.zzfps);
        zzc.zzr("action", str);
        if (!this.zzfps.zzhgy.isEmpty()) {
            zzc.zzr("ancn", this.zzfps.zzhgy.get(0));
        }
        if (this.zzfps.zzhhq) {
            zzp.zzkq();
            zzc.zzr("device_connectivity", zzm.zzbc(this.context) ? "online" : "offline");
            zzc.zzr("event_timestamp", String.valueOf(zzp.zzkx().currentTimeMillis()));
            zzc.zzr("offline_ad", "1");
        }
        return zzc;
    }

    public final void onAdClicked() {
        if (this.zzfps.zzhhq) {
            zza(zzge("click"));
        }
    }

    public final void onAdImpression() {
        if (zzapz() || this.zzfps.zzhhq) {
            zza(zzge("impression"));
        }
    }

    public final void zza(zzcai zzcai) {
        if (this.zzgkc) {
            zzckp zzge = zzge("ifts");
            zzge.zzr("reason", "exception");
            if (!TextUtils.isEmpty(zzcai.getMessage())) {
                zzge.zzr("msg", zzcai.getMessage());
            }
            zzge.zzaqd();
        }
    }

    public final void zzakm() {
        if (zzapz()) {
            zzge("adapter_impression").zzaqd();
        }
    }

    public final void zzako() {
        if (zzapz()) {
            zzge("adapter_shown").zzaqd();
        }
    }

    public final void zzaky() {
        if (this.zzgkc) {
            zzckp zzge = zzge("ifts");
            zzge.zzr("reason", "blocked");
            zzge.zzaqd();
        }
    }

    public final void zzl(zzve zzve) {
        if (this.zzgkc) {
            zzckp zzge = zzge("ifts");
            zzge.zzr("reason", "adapter");
            int i = zzve.errorCode;
            String str = zzve.zzcgs;
            if (zzve.zzcgt.equals(MobileAds.ERROR_DOMAIN) && zzve.zzcgu != null && !zzve.zzcgu.zzcgt.equals(MobileAds.ERROR_DOMAIN)) {
                i = zzve.zzcgu.errorCode;
                str = zzve.zzcgu.zzcgs;
            }
            if (i >= 0) {
                zzge.zzr("arec", String.valueOf(i));
            }
            String zzgr = this.zzgka.zzgr(str);
            if (zzgr != null) {
                zzge.zzr("areec", zzgr);
            }
            zzge.zzaqd();
        }
    }
}
