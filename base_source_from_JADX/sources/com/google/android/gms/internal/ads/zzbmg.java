package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;

final class zzbmg extends zzbme {
    private final Context context;
    private final View view;
    private final zzbdv zzdii;
    private final Executor zzfqx;
    private final zzdmx zzfrz;
    private final zzbnz zzftc;
    private final zzccl zzftd;
    private final zzbyc zzfte;
    private final zzeoz<zzcxi> zzftf;
    private zzvn zzftg;

    zzbmg(zzbob zzbob, Context context2, zzdmx zzdmx, View view2, zzbdv zzbdv, zzbnz zzbnz, zzccl zzccl, zzbyc zzbyc, zzeoz<zzcxi> zzeoz, Executor executor) {
        super(zzbob);
        this.context = context2;
        this.view = view2;
        this.zzdii = zzbdv;
        this.zzfrz = zzdmx;
        this.zzftc = zzbnz;
        this.zzftd = zzccl;
        this.zzfte = zzbyc;
        this.zzftf = zzeoz;
        this.zzfqx = executor;
    }

    public final zzys getVideoController() {
        try {
            return this.zzftc.getVideoController();
        } catch (zzdnr unused) {
            return null;
        }
    }

    public final void zza(ViewGroup viewGroup, zzvn zzvn) {
        zzbdv zzbdv;
        if (viewGroup != null && (zzbdv = this.zzdii) != null) {
            zzbdv.zza(zzbfn.zzb(zzvn));
            viewGroup.setMinimumHeight(zzvn.heightPixels);
            viewGroup.setMinimumWidth(zzvn.widthPixels);
            this.zzftg = zzvn;
        }
    }

    public final zzdmx zzaiy() {
        boolean z;
        zzvn zzvn = this.zzftg;
        if (zzvn != null) {
            return zzdns.zzg(zzvn);
        }
        if (this.zzeri.zzhhk) {
            Iterator<String> it = this.zzeri.zzhgo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdmx(this.view.getWidth(), this.view.getHeight(), false);
            }
        }
        return zzdns.zza(this.zzeri.zzhgw, this.zzfrz);
    }

    public final View zzaiz() {
        return this.view;
    }

    public final zzdmx zzajh() {
        return this.zzfrz;
    }

    public final int zzaji() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcye)).booleanValue() && this.zzeri.zzhho) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyf)).booleanValue()) {
                return 0;
            }
        }
        return this.zzfpr.zzhik.zzerj.zzhhx;
    }

    public final void zzajj() {
        this.zzfqx.execute(new zzbmf(this));
        super.zzajj();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzajk() {
        if (this.zzftd.zzanu() != null) {
            try {
                this.zzftd.zzanu().zza(this.zzftf.get(), ObjectWrapper.wrap(this.context));
            } catch (RemoteException e) {
                zzd.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    public final void zzke() {
        this.zzfte.zzalx();
    }
}
