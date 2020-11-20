package com.google.android.gms.internal.ads;

import org.apache.commons.p172io.IOUtils;

final class zzdpi {
    private final zzdph zzhky = new zzdph();
    private int zzhkz;
    private int zzhla;
    private int zzhlb;
    private int zzhlc;
    private int zzhld;

    zzdpi() {
    }

    public final void zzavk() {
        this.zzhlb++;
    }

    public final void zzavl() {
        this.zzhlc++;
    }

    public final void zzavm() {
        this.zzhkz++;
        this.zzhky.zzhkw = true;
    }

    public final void zzavn() {
        this.zzhla++;
        this.zzhky.zzhkx = true;
    }

    public final void zzavo() {
        this.zzhld++;
    }

    public final zzdph zzavp() {
        zzdph zzdph = (zzdph) this.zzhky.clone();
        zzdph zzdph2 = this.zzhky;
        zzdph2.zzhkw = false;
        zzdph2.zzhkx = false;
        return zzdph;
    }

    public final String zzavq() {
        return "\n\tPool does not exist: " + this.zzhlb + "\n\tNew pools created: " + this.zzhkz + "\n\tPools removed: " + this.zzhla + "\n\tEntries added: " + this.zzhld + "\n\tNo entries retrieved: " + this.zzhlc + IOUtils.LINE_SEPARATOR_UNIX;
    }
}
