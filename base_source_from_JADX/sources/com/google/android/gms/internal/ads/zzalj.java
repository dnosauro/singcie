package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

final class zzalj implements zzahv<zzalz> {
    private final /* synthetic */ zzako zzdjb;
    private final /* synthetic */ zzalb zzdjc;
    private final /* synthetic */ zzef zzdje;
    private final /* synthetic */ zzbr zzdjf;

    zzalj(zzalb zzalb, zzef zzef, zzako zzako, zzbr zzbr) {
        this.zzdjc = zzalb;
        this.zzdje = zzef;
        this.zzdjb = zzako;
        this.zzdjf = zzbr;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzalz zzalz = (zzalz) obj;
        synchronized (this.zzdjc.lock) {
            zzd.zzez("JS Engine is requesting an update");
            if (this.zzdjc.status == 0) {
                zzd.zzez("Starting reload.");
                int unused = this.zzdjc.status = 2;
                this.zzdjc.zza(this.zzdje);
            }
            this.zzdjb.zzb("/requestReload", (zzahv) this.zzdjf.get());
        }
    }
}
