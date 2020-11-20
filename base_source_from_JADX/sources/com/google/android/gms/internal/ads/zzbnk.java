package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbnk extends zzbme {
    private final Executor zzfqx;
    private final zzagd zzfua;
    private final Runnable zzfub;

    public zzbnk(zzbob zzbob, zzagd zzagd, Runnable runnable, Executor executor) {
        super(zzbob);
        this.zzfua = zzagd;
        this.zzfub = runnable;
        this.zzfqx = executor;
    }

    public final zzys getVideoController() {
        return null;
    }

    public final void zza(ViewGroup viewGroup, zzvn zzvn) {
    }

    public final zzdmx zzaiy() {
        return null;
    }

    public final View zzaiz() {
        return null;
    }

    public final zzdmx zzajh() {
        return null;
    }

    public final int zzaji() {
        return 0;
    }

    public final void zzajj() {
        this.zzfqx.execute(new zzbnm(this, new zzbnj(new AtomicReference(this.zzfub))));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Runnable runnable) {
        try {
            if (!this.zzfua.zzm(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }

    public final void zzke() {
    }
}
