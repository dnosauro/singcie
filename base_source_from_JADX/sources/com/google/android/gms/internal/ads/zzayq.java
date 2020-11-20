package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class zzayq implements zzrl {
    private final Object lock = new Object();
    private final zzf zzebt;
    private final zzayp zzebz;
    @VisibleForTesting
    private final zzayn zzeca;
    @VisibleForTesting
    private final HashSet<zzayf> zzecb = new HashSet<>();
    @VisibleForTesting
    private final HashSet<zzayo> zzecc = new HashSet<>();
    private boolean zzecd = false;

    public zzayq(String str, zzf zzf) {
        this.zzeca = new zzayn(str, zzf);
        this.zzebt = zzf;
        this.zzebz = new zzayp();
    }

    public final Bundle zza(Context context, zzaym zzaym) {
        HashSet hashSet = new HashSet();
        synchronized (this.lock) {
            hashSet.addAll(this.zzecb);
            this.zzecb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzeca.zzn(context, this.zzebz.zzxk()));
        Bundle bundle2 = new Bundle();
        Iterator<zzayo> it = this.zzecc.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzayf) it2.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzaym.zza(hashSet);
            return bundle;
        }
        zzayo next = it.next();
        throw new NoSuchMethodError();
    }

    public final zzayf zza(Clock clock, String str) {
        return new zzayf(clock, this, this.zzebz.zzxj(), str);
    }

    public final void zza(zzvk zzvk, long j) {
        synchronized (this.lock) {
            this.zzeca.zza(zzvk, j);
        }
    }

    public final void zzb(zzayf zzayf) {
        synchronized (this.lock) {
            this.zzecb.add(zzayf);
        }
    }

    public final void zzb(HashSet<zzayf> hashSet) {
        synchronized (this.lock) {
            this.zzecb.addAll(hashSet);
        }
    }

    public final void zzp(boolean z) {
        zzayn zzayn;
        int i;
        long currentTimeMillis = zzp.zzkx().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzebt.zzxw() > ((Long) zzwq.zzqe().zzd(zzabf.zzcop)).longValue()) {
                zzayn = this.zzeca;
                i = -1;
            } else {
                zzayn = this.zzeca;
                i = this.zzebt.zzxx();
            }
            zzayn.zzebq = i;
            this.zzecd = true;
            return;
        }
        this.zzebt.zzez(currentTimeMillis);
        this.zzebt.zzdf(this.zzeca.zzebq);
    }

    public final void zzwp() {
        synchronized (this.lock) {
            this.zzeca.zzwp();
        }
    }

    public final void zzwq() {
        synchronized (this.lock) {
            this.zzeca.zzwq();
        }
    }

    public final boolean zzxm() {
        return this.zzecd;
    }
}
