package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

final /* synthetic */ class zzdcs implements Callable {
    private final zzdct zzgzy;

    zzdcs(zzdct zzdct) {
        this.zzgzy = zzdct;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzp.zzkq();
        zzrk zzxo = zzp.zzku().zzwz().zzxo();
        Bundle bundle = null;
        if (!(zzxo == null || zzxo == null || (zzp.zzku().zzwz().zzxp() && zzp.zzku().zzwz().zzxr()))) {
            if (zzxo.zzml()) {
                zzxo.wakeup();
            }
            zzre zzmj = zzxo.zzmj();
            if (zzmj != null) {
                str2 = zzmj.zzly();
                str = zzmj.zzlz();
                str3 = zzmj.zzma();
                if (str2 != null) {
                    zzp.zzku().zzwz().zzef(str2);
                }
                if (str3 != null) {
                    zzp.zzku().zzwz().zzeg(str3);
                }
            } else {
                str2 = zzp.zzku().zzwz().zzxq();
                str3 = zzp.zzku().zzwz().zzxs();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzp.zzku().zzwz().zzxr()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzp.zzku().zzwz().zzxp()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzdcq(bundle);
    }
}
