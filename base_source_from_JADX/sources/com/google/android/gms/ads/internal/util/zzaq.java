package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzaa;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzae;
import com.google.android.gms.internal.ads.zzait;
import com.google.android.gms.internal.ads.zzar;
import com.google.android.gms.internal.ads.zzau;
import com.google.android.gms.internal.ads.zzav;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzbd;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzy;
import java.io.File;
import java.util.regex.Pattern;

public final class zzaq extends zzau {
    private final Context context;

    private zzaq(Context context2, zzar zzar) {
        super(zzar);
        this.context = context2;
    }

    public static zzae zzbk(Context context2) {
        zzae zzae = new zzae(new zzav(new File(context2.getCacheDir(), "admob_volley"), 20971520), new zzaq(context2, new zzbd()));
        zzae.start();
        return zzae;
    }

    public final zzy zzc(zzaa<?> zzaa) {
        if (zzaa.zzh() && zzaa.getMethod() == 0) {
            if (Pattern.matches((String) zzwq.zzqe().zzd(zzabf.zzctl), zzaa.getUrl())) {
                zzwq.zzqa();
                if (zzayr.zzd(this.context, 13400000)) {
                    zzy zzc = new zzait(this.context).zzc(zzaa);
                    if (zzc != null) {
                        String valueOf = String.valueOf(zzaa.getUrl());
                        zzd.zzee(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zzc;
                    }
                    String valueOf2 = String.valueOf(zzaa.getUrl());
                    zzd.zzee(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzaa);
    }
}
