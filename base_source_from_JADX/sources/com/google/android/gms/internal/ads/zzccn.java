package com.google.android.gms.internal.ads;

import androidx.p018c.C0413g;

public final class zzccn {
    zzafk zzgdj;
    zzafj zzgdk;
    zzafy zzgdl;
    zzafx zzgdm;
    zzajt zzgdn;
    final C0413g<String, zzafq> zzgdo = new C0413g<>();
    final C0413g<String, zzafp> zzgdp = new C0413g<>();

    public final zzccn zza(zzafx zzafx) {
        this.zzgdm = zzafx;
        return this;
    }

    public final zzccl zzany() {
        return new zzccl(this);
    }

    public final zzccn zzb(zzafj zzafj) {
        this.zzgdk = zzafj;
        return this;
    }

    public final zzccn zzb(zzafk zzafk) {
        this.zzgdj = zzafk;
        return this;
    }

    public final zzccn zzb(zzafy zzafy) {
        this.zzgdl = zzafy;
        return this;
    }

    public final zzccn zzb(zzajt zzajt) {
        this.zzgdn = zzajt;
        return this;
    }

    public final zzccn zzb(String str, zzafq zzafq, zzafp zzafp) {
        this.zzgdo.put(str, zzafq);
        this.zzgdp.put(str, zzafp);
        return this;
    }
}
