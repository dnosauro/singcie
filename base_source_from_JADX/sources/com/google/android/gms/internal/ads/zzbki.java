package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzbki implements zzp, zzbsm, zzbsp, zzqu {
    private final Clock zzbpw;
    private final zzbjz zzfqt;
    private final zzbkg zzfqu;
    private final Set<zzbdv> zzfqv = new HashSet();
    private final zzamx<JSONObject, JSONObject> zzfqw;
    private final Executor zzfqx;
    private final AtomicBoolean zzfqy = new AtomicBoolean(false);
    @GuardedBy("this")
    private final zzbkk zzfqz = new zzbkk();
    private boolean zzfra = false;
    private WeakReference<?> zzfrb = new WeakReference<>(this);

    public zzbki(zzamq zzamq, zzbkg zzbkg, Executor executor, zzbjz zzbjz, Clock clock) {
        this.zzfqt = zzbjz;
        this.zzfqw = zzamq.zzb("google.afma.activeView.handleUpdate", zzamg.zzdjy, zzamg.zzdjy);
        this.zzfqu = zzbkg;
        this.zzfqx = executor;
        this.zzbpw = clock;
    }

    private final void zzaih() {
        for (zzbdv zze : this.zzfqv) {
            this.zzfqt.zze(zze);
        }
        this.zzfqt.zzaif();
    }

    public final synchronized void onAdImpression() {
        if (this.zzfqy.compareAndSet(false, true)) {
            this.zzfqt.zza(this);
            zzaig();
        }
    }

    public final synchronized void onPause() {
        this.zzfqz.zzfrg = true;
        zzaig();
    }

    public final synchronized void onResume() {
        this.zzfqz.zzfrg = false;
        zzaig();
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
    }

    public final synchronized void zza(zzqv zzqv) {
        this.zzfqz.zzbqz = zzqv.zzbqz;
        this.zzfqz.zzfrj = zzqv;
        zzaig();
    }

    public final synchronized void zzaig() {
        if (!(this.zzfrb.get() != null)) {
            zzaii();
        } else if (!this.zzfra && this.zzfqy.get()) {
            try {
                this.zzfqz.timestamp = this.zzbpw.elapsedRealtime();
                JSONObject zza = this.zzfqu.zzj(this.zzfqz);
                for (zzbdv zzbkh : this.zzfqv) {
                    this.zzfqx.execute(new zzbkh(zzbkh, zza));
                }
                zzazm.zzb(this.zzfqw.zzf(zza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzd.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    public final synchronized void zzaii() {
        zzaih();
        this.zzfra = true;
    }

    public final synchronized void zzcc(Context context) {
        this.zzfqz.zzfrg = true;
        zzaig();
    }

    public final synchronized void zzcd(Context context) {
        this.zzfqz.zzfrg = false;
        zzaig();
    }

    public final synchronized void zzce(Context context) {
        this.zzfqz.zzfri = "u";
        zzaig();
        zzaih();
        this.zzfra = true;
    }

    public final synchronized void zzf(zzbdv zzbdv) {
        this.zzfqv.add(zzbdv);
        this.zzfqt.zzd(zzbdv);
    }

    public final void zzo(Object obj) {
        this.zzfrb = new WeakReference<>(obj);
    }

    public final void zzux() {
    }
}
