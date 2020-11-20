package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzdfd;
import com.google.android.gms.internal.ads.zzvk;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

final class zzq {
    private final Context context;
    private final String zzbqp;
    private final Map<String, String> zzbqq = new TreeMap();
    private String zzbqr;
    private String zzbqs;

    public zzq(Context context2, String str) {
        this.context = context2.getApplicationContext();
        this.zzbqp = str;
    }

    public final String getQuery() {
        return this.zzbqr;
    }

    public final void zza(zzvk zzvk, zzazh zzazh) {
        this.zzbqr = zzvk.zzchd.zzbqr;
        Bundle bundle = zzvk.zzchf != null ? zzvk.zzchf.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle != null) {
            String str = zzacr.zzdbh.get();
            for (String str2 : bundle.keySet()) {
                if (str.equals(str2)) {
                    this.zzbqs = bundle.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.zzbqq.put(str2.substring(4), bundle.getString(str2));
                }
            }
            this.zzbqq.put("SDKVersion", zzazh.zzbrf);
            if (zzacr.zzdbf.get().booleanValue()) {
                try {
                    Bundle zza = zzdfd.zza(this.context, new JSONArray(zzacr.zzdbg.get()));
                    for (String str3 : zza.keySet()) {
                        this.zzbqq.put(str3, zza.get(str3).toString());
                    }
                } catch (JSONException e) {
                    zzd.zzc("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e);
                }
            }
        }
    }

    public final String zzlp() {
        return this.zzbqs;
    }

    public final String zzlq() {
        return this.zzbqp;
    }

    public final Map<String, String> zzlr() {
        return this.zzbqq;
    }
}
