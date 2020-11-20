package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicReference;

public final class zzdir implements zzp, zzbrz, zzbto, zzdki {
    private final zzdpa zzhdt;
    private final AtomicReference<zzsl> zzhdu = new AtomicReference<>();
    private final AtomicReference<zzsm> zzhdv = new AtomicReference<>();
    private final AtomicReference<zzsq> zzhdw = new AtomicReference<>();
    private final AtomicReference<zzbto> zzhdx = new AtomicReference<>();
    private final AtomicReference<zzp> zzhdy = new AtomicReference<>();
    private zzdir zzhdz = null;

    public zzdir(zzdpa zzdpa) {
        this.zzhdt = zzdpa;
    }

    public static zzdir zzb(zzdir zzdir) {
        zzdir zzdir2 = new zzdir(zzdir.zzhdt);
        zzdir2.zzb((zzdki) zzdir);
        return zzdir2;
    }

    public final void onAdClosed() {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.zzhdz;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdir.zzhdt.onAdClosed();
                zzdkb.zza(zzdir.zzhdv, zzdiv.zzgwb);
                zzdkb.zza(zzdir.zzhdw, zzdiu.zzgwb);
                return;
            }
        }
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.zzhdz;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.zzhdy, zzdjb.zzgwb);
                return;
            }
        }
    }

    public final void zza(zzl zzl) {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.zzhdz;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.zzhdy, new zzdiy(zzl));
                return;
            }
        }
    }

    public final void zza(zzp zzp) {
        this.zzhdy.set(zzp);
    }

    public final void zza(zzbto zzbto) {
        this.zzhdx.set(zzbto);
    }

    public final void zza(zzsq zzsq) {
        this.zzhdw.set(zzsq);
    }

    public final void zzakz() {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.zzhdz;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.zzhdx, zzdix.zzgwb);
                return;
            }
        }
    }

    public final void zzb(zzdki zzdki) {
        this.zzhdz = (zzdir) zzdki;
    }

    public final void zzb(zzsg zzsg) {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.zzhdz;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.zzhdu, new zzdiq(zzsg));
                return;
            }
        }
    }

    public final void zzb(zzsl zzsl) {
        this.zzhdu.set(zzsl);
    }

    public final void zzb(zzsm zzsm) {
        this.zzhdv.set(zzsm);
    }

    public final void zzk(zzve zzve) {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.zzhdz;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.zzhdu, new zzdit(zzve));
                zzdkb.zza(zzdir.zzhdu, new zzdis(zzve));
                return;
            }
        }
    }

    public final void zzux() {
        zzdir zzdir = this;
        while (true) {
            zzdir zzdir2 = zzdir.zzhdz;
            if (zzdir2 != null) {
                zzdir = zzdir2;
            } else {
                zzdkb.zza(zzdir.zzhdy, zzdiw.zzgwb);
                zzdkb.zza(zzdir.zzhdw, zzdiz.zzgwb);
                return;
            }
        }
    }
}
