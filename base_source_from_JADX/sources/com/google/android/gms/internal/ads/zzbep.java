package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public final class zzbep extends zzyr {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private boolean zzadv;
    @GuardedBy("lock")
    private boolean zzadw;
    @GuardedBy("lock")
    private int zzaey;
    @GuardedBy("lock")
    private zzyt zzdmn;
    private final zzbbe zzehi;
    private final boolean zzeso;
    private final boolean zzesp;
    @GuardedBy("lock")
    private boolean zzesq;
    @GuardedBy("lock")
    private boolean zzesr = true;
    @GuardedBy("lock")
    private float zzess;
    @GuardedBy("lock")
    private float zzest;
    @GuardedBy("lock")
    private float zzesu;
    @GuardedBy("lock")
    private zzafv zzesv;

    public zzbep(zzbbe zzbbe, float f, boolean z, boolean z2) {
        this.zzehi = zzbbe;
        this.zzess = f;
        this.zzeso = z;
        this.zzesp = z2;
    }

    private final void zza(int i, int i2, boolean z, boolean z2) {
        zzazj.zzegt.execute(new zzber(this, i, i2, z, z2));
    }

    private final void zzf(String str, Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzazj.zzegt.execute(new zzbeo(this, hashMap));
    }

    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzesu;
        }
        return f;
    }

    public final float getCurrentTime() {
        float f;
        synchronized (this.lock) {
            f = this.zzest;
        }
        return f;
    }

    public final float getDuration() {
        float f;
        synchronized (this.lock) {
            f = this.zzess;
        }
        return f;
    }

    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzaey;
        }
        return i;
    }

    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    if (this.zzadw && this.zzesp) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeso && this.zzadv;
        }
        return z;
    }

    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzesr;
        }
        return z;
    }

    public final void mute(boolean z) {
        zzf(z ? "mute" : "unmute", (Map<String, String>) null);
    }

    public final void pause() {
        zzf("pause", (Map<String, String>) null);
    }

    public final void play() {
        zzf("play", (Map<String, String>) null);
    }

    public final void stop() {
        zzf("stop", (Map<String, String>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(float r4, float r5, int r6, boolean r7, float r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            float r1 = r3.zzess     // Catch:{ all -> 0x0051 }
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0012
            float r1 = r3.zzesu     // Catch:{ all -> 0x0051 }
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            r3.zzess = r5     // Catch:{ all -> 0x0051 }
            r3.zzest = r4     // Catch:{ all -> 0x0051 }
            boolean r4 = r3.zzesr     // Catch:{ all -> 0x0051 }
            r3.zzesr = r7     // Catch:{ all -> 0x0051 }
            int r5 = r3.zzaey     // Catch:{ all -> 0x0051 }
            r3.zzaey = r6     // Catch:{ all -> 0x0051 }
            float r2 = r3.zzesu     // Catch:{ all -> 0x0051 }
            r3.zzesu = r8     // Catch:{ all -> 0x0051 }
            float r8 = r3.zzesu     // Catch:{ all -> 0x0051 }
            float r8 = r8 - r2
            float r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x0051 }
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzbbe r8 = r3.zzehi     // Catch:{ all -> 0x0051 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x0051 }
            r8.invalidate()     // Catch:{ all -> 0x0051 }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzafv r8 = r3.zzesv     // Catch:{ RemoteException -> 0x0047 }
            if (r8 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzafv r8 = r3.zzesv     // Catch:{ RemoteException -> 0x0047 }
            r8.zztf()     // Catch:{ RemoteException -> 0x0047 }
            goto L_0x004d
        L_0x0047:
            r8 = move-exception
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzaza.zze(r0, r8)
        L_0x004d:
            r3.zza(r5, r6, r4, r7)
            return
        L_0x0051:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbep.zza(float, float, int, boolean, float):void");
    }

    public final void zza(zzafv zzafv) {
        synchronized (this.lock) {
            this.zzesv = zzafv;
        }
    }

    public final void zza(zzyt zzyt) {
        synchronized (this.lock) {
            this.zzdmn = zzyt;
        }
    }

    public final void zzadt() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzesr;
            i = this.zzaey;
            this.zzaey = 3;
        }
        zza(i, 3, z, z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = !this.zzesq && i2 == 1;
            boolean z6 = z4 && i2 == 1;
            boolean z7 = z4 && i2 == 2;
            boolean z8 = z4 && i2 == 3;
            boolean z9 = z != z2;
            if (this.zzesq || z5) {
                z3 = true;
            }
            this.zzesq = z3;
            if (z5) {
                try {
                    if (this.zzdmn != null) {
                        this.zzdmn.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
            if (z6 && this.zzdmn != null) {
                this.zzdmn.onVideoPlay();
            }
            if (z7 && this.zzdmn != null) {
                this.zzdmn.onVideoPause();
            }
            if (z8) {
                if (this.zzdmn != null) {
                    this.zzdmn.onVideoEnd();
                }
                this.zzehi.zzaar();
            }
            if (z9 && this.zzdmn != null) {
                this.zzdmn.onVideoMute(z2);
            }
        }
    }

    public final void zzb(zzaak zzaak) {
        boolean z = zzaak.zzadu;
        boolean z2 = zzaak.zzadv;
        boolean z3 = zzaak.zzadw;
        synchronized (this.lock) {
            this.zzadv = z2;
            this.zzadw = z3;
        }
        zzf("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzest = f;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(Map map) {
        this.zzehi.zza("pubVideoCmd", map);
    }

    public final zzyt zzqq() {
        zzyt zzyt;
        synchronized (this.lock) {
            zzyt = this.zzdmn;
        }
        return zzyt;
    }
}
