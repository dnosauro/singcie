package com.google.android.gms.internal.ads;

final class zzad implements Runnable {
    private final /* synthetic */ String val$tag;
    private final /* synthetic */ long zzbc;
    private final /* synthetic */ zzaa zzbd;

    zzad(zzaa zzaa, String str, long j) {
        this.zzbd = zzaa;
        this.val$tag = str;
        this.zzbc = j;
    }

    public final void run() {
        this.zzbd.zzao.zza(this.val$tag, this.zzbc);
        this.zzbd.zzao.zzd(this.zzbd.toString());
    }
}
