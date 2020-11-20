package com.google.android.gms.internal.ads;

final class zzawk implements zzdyo<Void> {
    private final /* synthetic */ zzdyz zzdyz;

    zzawk(zzawh zzawh, zzdyz zzdyz2) {
        this.zzdyz = zzdyz2;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Void voidR = (Void) obj;
        zzawh.zzdym.remove(this.zzdyz);
    }

    public final void zzb(Throwable th) {
        zzawh.zzdym.remove(this.zzdyz);
    }
}
