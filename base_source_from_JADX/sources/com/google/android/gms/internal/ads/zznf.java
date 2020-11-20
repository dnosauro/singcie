package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

public final class zznf implements zzna {
    private final zzie zzaeu = new zzie();
    private final zzna[] zzbfc;
    private final ArrayList<zzna> zzbfd;
    private zznd zzbfe;
    private zzhz zzbff;
    private Object zzbfg;
    private int zzbfh = -1;
    private zznh zzbfi;

    public zznf(zzna... zznaArr) {
        this.zzbfc = zznaArr;
        this.zzbfd = new ArrayList<>(Arrays.asList(zznaArr));
    }

    /* access modifiers changed from: private */
    public final void zza(int i, zzhz zzhz, Object obj) {
        zznh zznh;
        if (this.zzbfi == null) {
            int zzff = zzhz.zzff();
            for (int i2 = 0; i2 < zzff; i2++) {
                zzhz.zza(i2, this.zzaeu, false);
            }
            if (this.zzbfh == -1) {
                this.zzbfh = zzhz.zzfg();
            } else if (zzhz.zzfg() != this.zzbfh) {
                zznh = new zznh(1);
                this.zzbfi = zznh;
            }
            zznh = null;
            this.zzbfi = zznh;
        }
        if (this.zzbfi == null) {
            this.zzbfd.remove(this.zzbfc[i]);
            if (i == 0) {
                this.zzbff = zzhz;
                this.zzbfg = obj;
            }
            if (this.zzbfd.isEmpty()) {
                this.zzbfe.zzb(this.zzbff, this.zzbfg);
            }
        }
    }

    public final zzmy zza(int i, zzol zzol) {
        zzmy[] zzmyArr = new zzmy[this.zzbfc.length];
        for (int i2 = 0; i2 < zzmyArr.length; i2++) {
            zzmyArr[i2] = this.zzbfc[i2].zza(i, zzol);
        }
        return new zznc(zzmyArr);
    }

    public final void zza(zzhd zzhd, boolean z, zznd zznd) {
        this.zzbfe = zznd;
        int i = 0;
        while (true) {
            zzna[] zznaArr = this.zzbfc;
            if (i < zznaArr.length) {
                zznaArr[i].zza(zzhd, false, new zzne(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzb(zzmy zzmy) {
        zznc zznc = (zznc) zzmy;
        int i = 0;
        while (true) {
            zzna[] zznaArr = this.zzbfc;
            if (i < zznaArr.length) {
                zznaArr[i].zzb(zznc.zzbev[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzhz() {
        zznh zznh = this.zzbfi;
        if (zznh == null) {
            for (zzna zzhz : this.zzbfc) {
                zzhz.zzhz();
            }
            return;
        }
        throw zznh;
    }

    public final void zzia() {
        for (zzna zzia : this.zzbfc) {
            zzia.zzia();
        }
    }
}
