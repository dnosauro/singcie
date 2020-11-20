package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzciq {
    private final zzcil zzgja;
    private final AtomicReference<zzani> zzgjb = new AtomicReference<>();

    zzciq(zzcil zzcil) {
        this.zzgja = zzcil;
    }

    private final zzani zzaph() {
        zzani zzani = this.zzgjb.get();
        if (zzani != null) {
            return zzani;
        }
        zzd.zzfa("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    private final zzann zze(String str, JSONObject jSONObject) {
        zzani zzaph = zzaph();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                return zzaph.zzdf(jSONObject.getString("class_name")) ? zzaph.zzde("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") : zzaph.zzde("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzd.zzc("Invalid custom event.", e);
            }
        }
        return zzaph.zzde(str);
    }

    public final boolean zzapg() {
        return this.zzgjb.get() != null;
    }

    public final void zzb(zzani zzani) {
        this.zzgjb.compareAndSet((Object) null, zzani);
    }

    public final zzdoe zzd(String str, JSONObject jSONObject) {
        try {
            zzdoe zzdoe = new zzdoe("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? new zzaoe((MediationAdapter) new AdMobAdapter()) : "com.google.ads.mediation.AdUrlAdapter".equals(str) ? new zzaoe((MediationAdapter) new AdUrlAdapter()) : "com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str) ? new zzaoe((MediationAdapter) new zzaqe()) : zze(str, jSONObject));
            this.zzgja.zza(str, zzdoe);
            return zzdoe;
        } catch (Throwable th) {
            throw new zzdnr(th);
        }
    }

    public final zzapo zzdg(String str) {
        zzapo zzdg = zzaph().zzdg(str);
        this.zzgja.zza(str, zzdg);
        return zzdg;
    }
}
