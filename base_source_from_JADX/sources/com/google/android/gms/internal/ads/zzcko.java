package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzcko {
    private final zzayq zzeaj;
    private ConcurrentHashMap<String, String> zzgkg;

    public zzcko(zzckv zzckv, zzayq zzayq) {
        this.zzgkg = new ConcurrentHashMap<>(zzckv.zzgki);
        this.zzeaj = zzayq;
    }

    public final void zzc(zzdnj zzdnj) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        String str;
        String str2;
        if (zzdnj.zzhik.zzhih.size() > 0) {
            switch (zzdnj.zzhik.zzhih.get(0).zzhgp) {
                case 1:
                    concurrentHashMap = this.zzgkg;
                    str = "ad_format";
                    str2 = "banner";
                    break;
                case 2:
                    concurrentHashMap = this.zzgkg;
                    str = "ad_format";
                    str2 = "interstitial";
                    break;
                case 3:
                    concurrentHashMap = this.zzgkg;
                    str = "ad_format";
                    str2 = "native_express";
                    break;
                case 4:
                    concurrentHashMap = this.zzgkg;
                    str = "ad_format";
                    str2 = "native_advanced";
                    break;
                case 5:
                    concurrentHashMap = this.zzgkg;
                    str = "ad_format";
                    str2 = "rewarded";
                    break;
                case 6:
                    this.zzgkg.put("ad_format", "app_open_ad");
                    concurrentHashMap = this.zzgkg;
                    str = "as";
                    if (!this.zzeaj.zzxm()) {
                        str2 = "0";
                        break;
                    } else {
                        str2 = "1";
                        break;
                    }
                default:
                    concurrentHashMap = this.zzgkg;
                    str = "ad_format";
                    str2 = "unknown";
                    break;
            }
            concurrentHashMap.put(str, str2);
        }
        if (!TextUtils.isEmpty(zzdnj.zzhik.zzerj.zzbvf)) {
            this.zzgkg.put("gqi", zzdnj.zzhik.zzerj.zzbvf);
        }
    }

    public final void zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzgkg.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzgkg.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzrx() {
        return this.zzgkg;
    }
}
