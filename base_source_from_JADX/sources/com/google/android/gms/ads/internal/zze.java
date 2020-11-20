package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzamd;
import com.google.android.gms.internal.ads.zzamg;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzdyr;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzwq;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zze {
    private Context context;
    private long zzboo = 0;

    @VisibleForTesting
    private final void zza(Context context2, zzazh zzazh, boolean z, zzayh zzayh, String str, String str2, Runnable runnable) {
        if (zzp.zzkx().elapsedRealtime() - this.zzboo < 5000) {
            zzd.zzfa("Not retrying to fetch app settings");
            return;
        }
        this.zzboo = zzp.zzkx().elapsedRealtime();
        boolean z2 = true;
        if (zzayh != null) {
            if (!(zzp.zzkx().currentTimeMillis() - zzayh.zzxd() > ((Long) zzwq.zzqe().zzd(zzabf.zzcsu)).longValue()) && zzayh.zzxe()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context2 == null) {
                zzd.zzfa("Context not provided to fetch application settings");
            } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                Context applicationContext = context2.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context2;
                }
                this.context = applicationContext;
                zzamd<I, O> zza = zzp.zzld().zzb(this.context, zzazh).zza("google.afma.config.fetchAppSettings", zzamg.zzdjy, zzamg.zzdjy);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("app_id", str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("ad_unit_id", str2);
                    }
                    jSONObject.put("is_init", z);
                    jSONObject.put("pn", context2.getPackageName());
                    zzdyz<O> zzi = zza.zzi(jSONObject);
                    zzdyz<O> zzb = zzdyr.zzb(zzi, zzd.zzbon, (Executor) zzazj.zzegu);
                    if (runnable != null) {
                        zzi.addListener(runnable, zzazj.zzegu);
                    }
                    zzazm.zza(zzb, "ConfigLoader.maybeFetchNewAppSettings");
                } catch (Exception e) {
                    zzd.zzc("Error requesting application settings", e);
                }
            } else {
                zzd.zzfa("App settings could not be fetched. Required parameters missing");
            }
        }
    }

    public final void zza(Context context2, zzazh zzazh, String str, zzayh zzayh) {
        zza(context2, zzazh, false, zzayh, zzayh != null ? zzayh.zzxg() : null, str, (Runnable) null);
    }

    public final void zza(Context context2, zzazh zzazh, String str, Runnable runnable) {
        zza(context2, zzazh, true, (zzayh) null, str, (String) null, runnable);
    }
}
