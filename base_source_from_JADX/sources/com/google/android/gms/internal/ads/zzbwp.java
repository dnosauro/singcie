package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbwp {
    private final zzdki zzfut;
    private final Set<zzbxy<zzva>> zzfys;
    private final Set<zzbxy<zzbru>> zzfyt;
    private final Set<zzbxy<zzbsm>> zzfyu;
    private final Set<zzbxy<zzbto>> zzfyv;
    private final Set<zzbxy<zzbtj>> zzfyw;
    private final Set<zzbxy<zzbrz>> zzfyx;
    private final Set<zzbxy<zzbsi>> zzfyy;
    private final Set<zzbxy<AdMetadataListener>> zzfyz;
    private final Set<zzbxy<AppEventListener>> zzfza;
    private final Set<zzbxy<zzbub>> zzfzb;
    private final Set<zzbxy<zzp>> zzfzc;
    private zzbrx zzfzd;
    private zzcum zzfze;

    public static class zza {
        /* access modifiers changed from: private */
        public zzdki zzfut;
        /* access modifiers changed from: private */
        public Set<zzbxy<zzva>> zzfys = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<zzbru>> zzfyt = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<zzbsm>> zzfyu = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<zzbto>> zzfyv = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<zzbtj>> zzfyw = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<zzbrz>> zzfyx = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<zzbsi>> zzfyy = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<AdMetadataListener>> zzfyz = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<AppEventListener>> zzfza = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<zzp>> zzfzc = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbxy<zzbub>> zzfzh = new HashSet();

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzfza.add(new zzbxy(appEventListener, executor));
            return this;
        }

        public final zza zza(zzp zzp, Executor executor) {
            this.zzfzc.add(new zzbxy(zzp, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.zzfyz.add(new zzbxy(adMetadataListener, executor));
            return this;
        }

        public final zza zza(zzbru zzbru, Executor executor) {
            this.zzfyt.add(new zzbxy(zzbru, executor));
            return this;
        }

        public final zza zza(zzbrz zzbrz, Executor executor) {
            this.zzfyx.add(new zzbxy(zzbrz, executor));
            return this;
        }

        public final zza zza(zzbsi zzbsi, Executor executor) {
            this.zzfyy.add(new zzbxy(zzbsi, executor));
            return this;
        }

        public final zza zza(zzbsm zzbsm, Executor executor) {
            this.zzfyu.add(new zzbxy(zzbsm, executor));
            return this;
        }

        public final zza zza(zzbtj zzbtj, Executor executor) {
            this.zzfyw.add(new zzbxy(zzbtj, executor));
            return this;
        }

        public final zza zza(zzbto zzbto, Executor executor) {
            this.zzfyv.add(new zzbxy(zzbto, executor));
            return this;
        }

        public final zza zza(zzbub zzbub, Executor executor) {
            this.zzfzh.add(new zzbxy(zzbub, executor));
            return this;
        }

        public final zza zza(zzdki zzdki) {
            this.zzfut = zzdki;
            return this;
        }

        public final zza zza(zzva zzva, Executor executor) {
            this.zzfys.add(new zzbxy(zzva, executor));
            return this;
        }

        public final zza zza(zzxo zzxo, Executor executor) {
            if (this.zzfza != null) {
                zzcxq zzcxq = new zzcxq();
                zzcxq.zzb(zzxo);
                this.zzfza.add(new zzbxy(zzcxq, executor));
            }
            return this;
        }

        public final zzbwp zzalt() {
            return new zzbwp(this);
        }
    }

    private zzbwp(zza zza2) {
        this.zzfys = zza2.zzfys;
        this.zzfyu = zza2.zzfyu;
        this.zzfyv = zza2.zzfyv;
        this.zzfyt = zza2.zzfyt;
        this.zzfyw = zza2.zzfyw;
        this.zzfyx = zza2.zzfyx;
        this.zzfyy = zza2.zzfyy;
        this.zzfyz = zza2.zzfyz;
        this.zzfza = zza2.zzfza;
        this.zzfzb = zza2.zzfzh;
        this.zzfut = zza2.zzfut;
        this.zzfzc = zza2.zzfzc;
    }

    public final zzcum zza(Clock clock, zzcuo zzcuo, zzcrg zzcrg) {
        if (this.zzfze == null) {
            this.zzfze = new zzcum(clock, zzcuo, zzcrg);
        }
        return this.zzfze;
    }

    public final Set<zzbxy<zzbru>> zzalh() {
        return this.zzfyt;
    }

    public final Set<zzbxy<zzbtj>> zzali() {
        return this.zzfyw;
    }

    public final Set<zzbxy<zzbrz>> zzalj() {
        return this.zzfyx;
    }

    public final Set<zzbxy<zzbsi>> zzalk() {
        return this.zzfyy;
    }

    public final Set<zzbxy<AdMetadataListener>> zzall() {
        return this.zzfyz;
    }

    public final Set<zzbxy<AppEventListener>> zzalm() {
        return this.zzfza;
    }

    public final Set<zzbxy<zzva>> zzaln() {
        return this.zzfys;
    }

    public final Set<zzbxy<zzbsm>> zzalo() {
        return this.zzfyu;
    }

    public final Set<zzbxy<zzbto>> zzalp() {
        return this.zzfyv;
    }

    public final Set<zzbxy<zzbub>> zzalq() {
        return this.zzfzb;
    }

    public final Set<zzbxy<zzp>> zzalr() {
        return this.zzfzc;
    }

    public final zzdki zzals() {
        return this.zzfut;
    }

    public final zzbrx zzc(Set<zzbxy<zzbrz>> set) {
        if (this.zzfzd == null) {
            this.zzfzd = new zzbrx(set);
        }
        return this.zzfzd;
    }
}
