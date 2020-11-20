package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;

public class zzbim {
    private zza zzfol;

    public static abstract class zza {
        public abstract zzbdf zzafh();

        public abstract zzbao zzafi();

        public abstract zztx zzafj();

        public abstract zzaws zzafk();

        public abstract zzarq zzafl();

        public abstract zzamy zzafm();

        public abstract zzacl zzafn();
    }

    public zzbim(zza zza2) {
        this.zzfol = zza2;
    }

    public final zzaws zzafk() {
        return this.zzfol.zzafk();
    }

    public final zzarq zzafl() {
        return this.zzfol.zzafl();
    }

    public final zzamy zzafm() {
        return this.zzfol.zzafm();
    }

    public final zzacl zzafn() {
        return this.zzfol.zzafn();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzawn, com.google.android.gms.internal.ads.zzawt] */
    public final zzb zzahu() {
        zza zza2 = this.zzfol;
        return new zzb(zza2.zzafh(), zza2.zzafi(), new zzawn(zza2.zzafk()), zza2.zzafj(), zza2.zzafl(), zza2.zzafn());
    }
}
