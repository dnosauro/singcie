package com.google.android.gms.internal.ads;

public final class zzdgz implements zzdfi<zzdgw> {
    private String packageName;
    private zzdzc zzggb;
    private zzaxy zzhcq;

    public zzdgz(zzaxy zzaxy, zzdzc zzdzc, String str) {
        this.zzhcq = zzaxy;
        this.zzggb = zzdzc;
        this.packageName = str;
    }

    public final zzdyz<zzdgw> zzasm() {
        new zzazq();
        zzdyz<String> zzag = zzdyr.zzag(null);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvx)).booleanValue()) {
            zzag = this.zzhcq.zzec(this.packageName);
        }
        zzdyz<String> zzed = this.zzhcq.zzed(this.packageName);
        return zzdyr.zzb((zzdyz<? extends V>[]) new zzdyz[]{zzag, zzed}).zza(new zzdgy(zzag, zzed), zzazj.zzegp);
    }
}
