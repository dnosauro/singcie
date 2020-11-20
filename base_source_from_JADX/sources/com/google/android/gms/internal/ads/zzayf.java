package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

public final class zzayf {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Clock zzbpw;
    private final String zzdtd;
    @GuardedBy("lock")
    private boolean zzdun = false;
    @GuardedBy("lock")
    private long zzdur = -1;
    private final zzayq zzeaj;
    @GuardedBy("lock")
    private final LinkedList<zzaye> zzeak;
    private final String zzeal;
    @GuardedBy("lock")
    private long zzeam = -1;
    @GuardedBy("lock")
    private long zzean = -1;
    @GuardedBy("lock")
    private long zzeao = 0;
    @GuardedBy("lock")
    private long zzeap = -1;
    @GuardedBy("lock")
    private long zzeaq = -1;

    zzayf(Clock clock, zzayq zzayq, String str, String str2) {
        this.zzbpw = clock;
        this.zzeaj = zzayq;
        this.zzeal = str;
        this.zzdtd = str2;
        this.zzeak = new LinkedList<>();
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzeal);
            bundle.putString("slotid", this.zzdtd);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzeap);
            bundle.putLong("tresponse", this.zzeaq);
            bundle.putLong("timp", this.zzeam);
            bundle.putLong("tload", this.zzean);
            bundle.putLong("pcc", this.zzeao);
            bundle.putLong("tfetch", this.zzdur);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzeak.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzaye) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzan(boolean z) {
        synchronized (this.lock) {
            if (this.zzeaq != -1) {
                this.zzean = this.zzbpw.elapsedRealtime();
            }
        }
    }

    public final void zze(zzvk zzvk) {
        synchronized (this.lock) {
            this.zzeap = this.zzbpw.elapsedRealtime();
            this.zzeaj.zza(zzvk, this.zzeap);
        }
    }

    public final void zzey(long j) {
        synchronized (this.lock) {
            this.zzeaq = j;
            if (this.zzeaq != -1) {
                this.zzeaj.zzb(this);
            }
        }
    }

    public final void zzwp() {
        synchronized (this.lock) {
            if (this.zzeaq != -1 && this.zzeam == -1) {
                this.zzeam = this.zzbpw.elapsedRealtime();
                this.zzeaj.zzb(this);
            }
            this.zzeaj.zzwp();
        }
    }

    public final void zzwq() {
        synchronized (this.lock) {
            if (this.zzeaq != -1) {
                zzaye zzaye = new zzaye(this);
                zzaye.zzwo();
                this.zzeak.add(zzaye);
                this.zzeao++;
                this.zzeaj.zzwq();
                this.zzeaj.zzb(this);
            }
        }
    }

    public final void zzwr() {
        synchronized (this.lock) {
            if (this.zzeaq != -1 && !this.zzeak.isEmpty()) {
                zzaye last = this.zzeak.getLast();
                if (last.zzwm() == -1) {
                    last.zzwn();
                    this.zzeaj.zzb(this);
                }
            }
        }
    }

    public final String zzws() {
        return this.zzeal;
    }
}
