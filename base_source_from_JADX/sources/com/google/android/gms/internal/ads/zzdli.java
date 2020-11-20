package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdli implements zzdka {
    private final String zzdgt;
    private final String zzdha;
    private final zzauf zzfxx;

    zzdli(zzauf zzauf, String str, String str2) {
        this.zzfxx = zzauf;
        this.zzdha = str;
        this.zzdgt = str2;
    }

    public final void zzq(Object obj) {
        zzauf zzauf = this.zzfxx;
        ((zzavq) obj).zza(new zzawd(zzauf.getType(), zzauf.getAmount()), this.zzdha, this.zzdgt);
    }
}
