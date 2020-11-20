package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzwq;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzal {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private String zzedw = "";
    @GuardedBy("lock")
    private String zzedx = "";
    @GuardedBy("lock")
    private boolean zzedy = false;
    @VisibleForTesting
    private String zzedz = "";

    @VisibleForTesting
    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzd.zzez("Can not create dialog without Activity Context");
        } else {
            zzm.zzedd.post(new zzao(this, context, str, z, z2));
        }
    }

    private final String zzbj(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzedw)) {
                zzp.zzkq();
                this.zzedw = zzm.zzr(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzedw)) {
                    zzp.zzkq();
                    this.zzedw = zzm.zzyf();
                    zzp.zzkq();
                    zzm.zzc(context, "debug_signals_id.txt", this.zzedw);
                }
            }
            str = this.zzedw;
        }
        return str;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzd(context, (String) zzwq.zzqe().zzd(zzabf.zzctv), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzp.zzkq();
        zzm.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbj(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    @VisibleForTesting
    private final boolean zzf(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzwq.zzqe().zzd(zzabf.zzctt), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzd.zzeb("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzh.trim());
            String optString = jSONObject.optString("gct");
            this.zzedz = jSONObject.optString("status");
            synchronized (this.lock) {
                this.zzedx = optString;
            }
            return true;
        } catch (JSONException e) {
            zzd.zzd("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzg(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzwq.zzqe().zzd(zzabf.zzctu), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzd.zzeb("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzedy = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzd.zzd("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String zzh(Context context, String str, String str2) {
        String str3;
        Throwable e;
        String str4;
        String str5;
        HashMap hashMap = new HashMap();
        hashMap.put(AbstractSpiCall.HEADER_USER_AGENT, zzp.zzkq().zzq(context, str2));
        zzdyz<String> zzc = new zzax(context).zzc(str, hashMap);
        try {
            return (String) zzc.get((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzctw)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            e = e2;
            str5 = "Timeout while retriving a response from: ";
            str4 = String.valueOf(str);
            if (str4.length() == 0) {
                str3 = new String(str5);
                zzd.zzc(str3, e);
                zzc.cancel(true);
                return null;
            }
            str3 = str5.concat(str4);
            zzd.zzc(str3, e);
            zzc.cancel(true);
            return null;
        } catch (InterruptedException e3) {
            e = e3;
            str5 = "Interrupted while retriving a response from: ";
            str4 = String.valueOf(str);
            if (str4.length() == 0) {
                str3 = new String(str5);
                zzd.zzc(str3, e);
                zzc.cancel(true);
                return null;
            }
            str3 = str5.concat(str4);
            zzd.zzc(str3, e);
            zzc.cancel(true);
            return null;
        } catch (Exception e4) {
            String valueOf = String.valueOf(str);
            zzd.zzc(valueOf.length() != 0 ? "Error retriving a response from: ".concat(valueOf) : new String("Error retriving a response from: "), e4);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzp.zzkq();
        zzm.zzb(context, zzd(context, (String) zzwq.zzqe().zzd(zzabf.zzcts), str, str2));
    }

    public final void zza(Context context, String str, String str2, String str3) {
        boolean zzyt = zzyt();
        if (zzg(context, str, str2)) {
            if (!zzyt && !TextUtils.isEmpty(str3)) {
                zzc(context, str2, str3, str);
            }
            zzd.zzeb("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzi(context, str, str2);
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzp.zzla().zzyt()) {
            return false;
        }
        zzd.zzeb("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(this.zzedz)) {
            zzd.zzeb("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzedz)) {
            zzd.zzeb("The app is not linked for creative preview.");
            zzi(context, str, str2);
        } else if ("0".equals(this.zzedz)) {
            zzd.zzeb("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String zzys() {
        String str;
        synchronized (this.lock) {
            str = this.zzedx;
        }
        return str;
    }

    public final boolean zzyt() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzedy;
        }
        return z;
    }
}
