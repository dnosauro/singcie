package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;

public final class zza {
    private static boolean zza(Context context, Intent intent, zzu zzu) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzd.zzee(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzp.zzkq();
            zzm.zza(context, intent);
            if (zzu == null) {
                return true;
            }
            zzu.zzvo();
            return true;
        } catch (ActivityNotFoundException e) {
            zzd.zzfa(e.getMessage());
            return false;
        }
    }

    public static boolean zza(Context context, zzb zzb, zzu zzu) {
        String str;
        int i = 0;
        if (zzb == null) {
            str = "No intent data for launcher overlay.";
        } else {
            zzabf.initialize(context);
            if (zzb.intent != null) {
                return zza(context, zzb.intent, zzu);
            }
            Intent intent = new Intent();
            if (TextUtils.isEmpty(zzb.url)) {
                str = "Open GMSG did not contain a URL.";
            } else {
                if (!TextUtils.isEmpty(zzb.mimeType)) {
                    intent.setDataAndType(Uri.parse(zzb.url), zzb.mimeType);
                } else {
                    intent.setData(Uri.parse(zzb.url));
                }
                intent.setAction("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(zzb.packageName)) {
                    intent.setPackage(zzb.packageName);
                }
                if (!TextUtils.isEmpty(zzb.zzdqd)) {
                    String[] split = zzb.zzdqd.split("/", 2);
                    if (split.length < 2) {
                        String valueOf = String.valueOf(zzb.zzdqd);
                        zzd.zzfa(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                        return false;
                    }
                    intent.setClassName(split[0], split[1]);
                }
                String str2 = zzb.zzdqe;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        i = Integer.parseInt(str2);
                    } catch (NumberFormatException unused) {
                        zzd.zzfa("Could not parse intent flags.");
                    }
                    intent.addFlags(i);
                }
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcto)).booleanValue()) {
                    intent.addFlags(268435456);
                    intent.putExtra("androidx.browser.customtabs.extra.user_opt_out", true);
                } else {
                    if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctn)).booleanValue()) {
                        zzp.zzkq();
                        zzm.zzb(context, intent);
                    }
                }
                return zza(context, intent, zzu);
            }
        }
        zzd.zzfa(str);
        return false;
    }
}
