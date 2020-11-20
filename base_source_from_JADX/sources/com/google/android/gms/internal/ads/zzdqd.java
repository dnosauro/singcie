package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

final class zzdqd {
    private final long zzhmt = zzp.zzkx().currentTimeMillis();
    private final zzdqg zzhmu = new zzdqg();
    private long zzhmv = this.zzhmt;
    private int zzhmw = 0;
    private int zzhmx = 0;
    private int zzhmy = 0;

    public final long getCreationTimeMillis() {
        return this.zzhmt;
    }

    public final long zzave() {
        return this.zzhmv;
    }

    public final int zzavf() {
        return this.zzhmw;
    }

    public final String zzavq() {
        return "Created: " + this.zzhmt + " Last accessed: " + this.zzhmv + " Accesses: " + this.zzhmw + "\nEntries retrieved: Valid: " + this.zzhmx + " Stale: " + this.zzhmy;
    }

    public final void zzavy() {
        this.zzhmv = zzp.zzkx().currentTimeMillis();
        this.zzhmw++;
    }

    public final void zzavz() {
        this.zzhmx++;
        this.zzhmu.zzhnd = true;
    }

    public final void zzawa() {
        this.zzhmy++;
        this.zzhmu.zzhmy++;
    }

    public final zzdqg zzawb() {
        zzdqg zzdqg = (zzdqg) this.zzhmu.clone();
        zzdqg zzdqg2 = this.zzhmu;
        zzdqg2.zzhnd = false;
        zzdqg2.zzhmy = 0;
        return zzdqg;
    }
}
