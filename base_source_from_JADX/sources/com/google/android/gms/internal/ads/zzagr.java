package com.google.android.gms.internal.ads;

final class zzagr extends zzafo {
    private final /* synthetic */ zzagp zzdfi;

    private zzagr(zzagp zzagp) {
        this.zzdfi = zzagp;
    }

    public final void zza(zzaff zzaff, String str) {
        if (this.zzdfi.zzdfg != null) {
            this.zzdfi.zzdfg.onCustomClick(this.zzdfi.zzb(zzaff), str);
        }
    }
}
