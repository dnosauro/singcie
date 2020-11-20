package com.google.android.gms.measurement.internal;

abstract class zzkm extends zzkn {
    private boolean zzb;

    zzkm(zzkp zzkp) {
        super(zzkp);
        this.zza.zza(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzai() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzaj() {
        if (!zzai()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzak() {
        if (!this.zzb) {
            zzd();
            this.zza.zzs();
            this.zzb = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzd();
}
