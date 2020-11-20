package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;

public final class zzals extends zzazx<zzako> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzau<zzako> zzdiv;
    private boolean zzdjm;
    private int zzdjn;

    public zzals(zzau<zzako> zzau) {
        this.zzdiv = zzau;
        this.zzdjm = false;
        this.zzdjn = 0;
    }

    private final void zzty() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdjn >= 0);
            if (!this.zzdjm || this.zzdjn != 0) {
                zzd.zzee("There are still references to the engine. Not destroying.");
            } else {
                zzd.zzee("No reference is left (including root). Cleaning up engine.");
                zza(new zzalx(this), new zzazv());
            }
        }
    }

    public final zzalo zztv() {
        zzalo zzalo = new zzalo(this);
        synchronized (this.lock) {
            zza(new zzalv(this, zzalo), new zzalu(this, zzalo));
            Preconditions.checkState(this.zzdjn >= 0);
            this.zzdjn++;
        }
        return zzalo;
    }

    /* access modifiers changed from: protected */
    public final void zztw() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdjn > 0);
            zzd.zzee("Releasing 1 reference for JS Engine");
            this.zzdjn--;
            zzty();
        }
    }

    public final void zztx() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdjn >= 0);
            zzd.zzee("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdjm = true;
            zzty();
        }
    }
}
