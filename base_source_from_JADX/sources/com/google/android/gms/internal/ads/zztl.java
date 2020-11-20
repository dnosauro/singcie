package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

public final class zztl {
    private final Context context;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public zztc zzbur;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean zzbvi;

    zztl(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbur != null) {
                this.zzbur.disconnect();
                this.zzbur = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Future<zztt> zzd(zztf zztf) {
        zztk zztk = new zztk(this);
        zztn zztn = new zztn(this, zztf, zztk);
        zztr zztr = new zztr(this, zztk);
        synchronized (this.lock) {
            this.zzbur = new zztc(this.context, zzp.zzle().zzyw(), zztn, zztr);
            this.zzbur.checkAvailabilityAndConnect();
        }
        return zztk;
    }
}
