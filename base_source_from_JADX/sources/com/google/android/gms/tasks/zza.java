package com.google.android.gms.tasks;

final class zza extends CancellationToken {
    private final zzu<Void> zza = new zzu<>();

    zza() {
    }

    public final boolean isCancellationRequested() {
        return this.zza.isComplete();
    }

    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        this.zza.addOnSuccessListener(new zzb(this, onTokenCanceledListener));
        return this;
    }

    public final void zza() {
        this.zza.zzb(null);
    }
}
