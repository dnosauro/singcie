package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

public final class zzdlf extends AdMetadataListener implements zzbru, zzbrz, zzbsi, zzbtj, zzbub, zzdki {
    private final zzdpa zzhdt;
    private final AtomicReference<AdMetadataListener> zzhfs = new AtomicReference<>();
    private final AtomicReference<zzavp> zzhft = new AtomicReference<>();
    private final AtomicReference<zzavi> zzhfu = new AtomicReference<>();
    private final AtomicReference<zzaup> zzhfv = new AtomicReference<>();
    private final AtomicReference<zzavq> zzhfw = new AtomicReference<>();
    private final AtomicReference<zzaug> zzhfx = new AtomicReference<>();
    private final AtomicReference<zzym> zzhfy = new AtomicReference<>();
    private zzdlf zzhfz = null;

    public zzdlf(zzdpa zzdpa) {
        this.zzhdt = zzdpa;
    }

    public static zzdlf zzb(zzdlf zzdlf) {
        zzdlf zzdlf2 = new zzdlf(zzdlf.zzhdt);
        zzdlf2.zzb((zzdki) zzdlf);
        return zzdlf2;
    }

    public final void onAdClosed() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdlf.zzhdt.onAdClosed();
                zzdkb.zza(zzdlf.zzhfu, zzdlx.zzgwb);
                zzdkb.zza(zzdlf.zzhfv, zzdlw.zzgwb);
                return;
            }
        }
    }

    public final void onAdLeftApplication() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.zzhfv, zzdlz.zzgwb);
                return;
            }
        }
    }

    public final void onAdLoaded() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.zzhft, zzdle.zzgwb);
                zzdkb.zza(zzdlf.zzhfv, zzdlh.zzgwb);
                return;
            }
        }
    }

    public final void onAdMetadataChanged() {
        zzdlf zzdlf = this.zzhfz;
        if (zzdlf != null) {
            zzdlf.onAdMetadataChanged();
        } else {
            zzdkb.zza(this.zzhfs, zzdlo.zzgwb);
        }
    }

    public final void onAdOpened() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.zzhfu, zzdlv.zzgwb);
                zzdkb.zza(zzdlf.zzhfv, zzdlu.zzgwb);
                return;
            }
        }
    }

    public final void onRewardedVideoCompleted() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.zzhfv, zzdln.zzgwb);
                return;
            }
        }
    }

    public final void onRewardedVideoStarted() {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.zzhfv, zzdlg.zzgwb);
                return;
            }
        }
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzhfs.set(adMetadataListener);
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.zzhfu, new zzdlj(zzauf));
                zzdkb.zza(zzdlf.zzhfw, new zzdli(zzauf, str, str2));
                zzdkb.zza(zzdlf.zzhfv, new zzdll(zzauf));
                zzdkb.zza(zzdlf.zzhfx, new zzdlk(zzauf, str, str2));
                return;
            }
        }
    }

    @Deprecated
    public final void zzb(zzaug zzaug) {
        this.zzhfx.set(zzaug);
    }

    @Deprecated
    public final void zzb(zzaup zzaup) {
        this.zzhfv.set(zzaup);
    }

    public final void zzb(zzavi zzavi) {
        this.zzhfu.set(zzavi);
    }

    public final void zzb(zzavp zzavp) {
        this.zzhft.set(zzavp);
    }

    public final void zzb(zzavq zzavq) {
        this.zzhfw.set(zzavq);
    }

    public final void zzb(zzdki zzdki) {
        this.zzhfz = (zzdlf) zzdki;
    }

    public final void zzb(zzvp zzvp) {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.zzhfy, new zzdlr(zzvp));
                return;
            }
        }
    }

    public final void zzd(zzym zzym) {
        this.zzhfy.set(zzym);
    }

    public final void zzj(zzve zzve) {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                zzdkb.zza(zzdlf.zzhfu, new zzdlm(zzve));
                zzdkb.zza(zzdlf.zzhfu, new zzdlp(zzve));
                return;
            }
        }
    }

    public final void zzk(zzve zzve) {
        zzdlf zzdlf = this;
        while (true) {
            zzdlf zzdlf2 = zzdlf.zzhfz;
            if (zzdlf2 != null) {
                zzdlf = zzdlf2;
            } else {
                int i = zzve.errorCode;
                zzdkb.zza(zzdlf.zzhft, new zzdlq(zzve));
                zzdkb.zza(zzdlf.zzhft, new zzdlt(i));
                zzdkb.zza(zzdlf.zzhfv, new zzdls(i));
                return;
            }
        }
    }
}
