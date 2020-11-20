package com.google.android.gms.internal.ads;

final class zzdzn extends zzdyy<zzdyz<V>> {
    private final zzdxz<V> zzhyc;
    private final /* synthetic */ zzdzo zzhyd;

    zzdzn(zzdzo zzdzo, zzdxz<V> zzdxz) {
        this.zzhyd = zzdzo;
        this.zzhyc = (zzdxz) zzdvv.checkNotNull(zzdxz);
    }

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzhyd.isDone();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzazk() {
        return (zzdyz) zzdvv.zza(this.zzhyc.zzata(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzhyc);
    }

    /* access modifiers changed from: package-private */
    public final String zzazl() {
        return this.zzhyc.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Throwable th) {
        zzdyz zzdyz = (zzdyz) obj;
        if (th == null) {
            this.zzhyd.setFuture(zzdyz);
        } else {
            this.zzhyd.setException(th);
        }
    }
}
