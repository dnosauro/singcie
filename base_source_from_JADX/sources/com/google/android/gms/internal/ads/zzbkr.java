package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbkr implements zzqu {
    private final Clock zzbpw;
    private boolean zzbvu = false;
    private zzbdv zzdii;
    private final zzbkg zzfqu;
    private final Executor zzfqx;
    private zzbkk zzfqz = new zzbkk();
    private boolean zzfrs = false;

    public zzbkr(Executor executor, zzbkg zzbkg, Clock clock) {
        this.zzfqx = executor;
        this.zzfqu = zzbkg;
        this.zzbpw = clock;
    }

    private final void zzaij() {
        try {
            JSONObject zza = this.zzfqu.zzj(this.zzfqz);
            if (this.zzdii != null) {
                this.zzfqx.execute(new zzbku(this, zza));
            }
        } catch (JSONException e) {
            zzd.zza("Failed to call video active view js", e);
        }
    }

    public final void disable() {
        this.zzbvu = false;
    }

    public final void enable() {
        this.zzbvu = true;
        zzaij();
    }

    public final void zza(zzqv zzqv) {
        this.zzfqz.zzbqz = this.zzfrs ? false : zzqv.zzbqz;
        this.zzfqz.timestamp = this.zzbpw.elapsedRealtime();
        this.zzfqz.zzfrj = zzqv;
        if (this.zzbvu) {
            zzaij();
        }
    }

    public final void zzbe(boolean z) {
        this.zzfrs = z;
    }

    public final void zzg(zzbdv zzbdv) {
        this.zzdii = zzbdv;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(JSONObject jSONObject) {
        this.zzdii.zza("AFMA_updateActiveView", jSONObject);
    }
}
