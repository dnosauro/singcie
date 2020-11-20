package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedList;

final class zzdpe {
    private final int maxEntries;
    private final LinkedList<zzdpn<?>> zzhkp = new LinkedList<>();
    private final int zzhkq;
    private final zzdqd zzhkr;

    public zzdpe(int i, int i2) {
        this.maxEntries = i;
        this.zzhkq = i2;
        this.zzhkr = new zzdqd();
    }

    private final void zzavi() {
        while (!this.zzhkp.isEmpty()) {
            if (zzp.zzkx().currentTimeMillis() - this.zzhkp.getFirst().zzhmd >= ((long) this.zzhkq)) {
                this.zzhkr.zzawa();
                this.zzhkp.remove();
            } else {
                return;
            }
        }
    }

    public final long getCreationTimeMillis() {
        return this.zzhkr.getCreationTimeMillis();
    }

    public final int size() {
        zzavi();
        return this.zzhkp.size();
    }

    public final zzdpn<?> zzavd() {
        this.zzhkr.zzavy();
        zzavi();
        if (this.zzhkp.isEmpty()) {
            return null;
        }
        zzdpn<?> remove = this.zzhkp.remove();
        if (remove != null) {
            this.zzhkr.zzavz();
        }
        return remove;
    }

    public final long zzave() {
        return this.zzhkr.zzave();
    }

    public final int zzavf() {
        return this.zzhkr.zzavf();
    }

    public final String zzavg() {
        return this.zzhkr.zzavq();
    }

    public final zzdqg zzavh() {
        return this.zzhkr.zzawb();
    }

    public final boolean zzb(zzdpn<?> zzdpn) {
        this.zzhkr.zzavy();
        zzavi();
        if (this.zzhkp.size() == this.maxEntries) {
            return false;
        }
        this.zzhkp.add(zzdpn);
        return true;
    }
}
