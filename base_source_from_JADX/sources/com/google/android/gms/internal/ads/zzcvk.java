package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;

final class zzcvk implements zzcaf {
    private final Context context;
    private final zzazh zzbos;
    private final zzdmu zzeri;
    private final zzdnn zzfvl;
    private final zzchp zzgey;
    private final zzdyz<zzche> zzgre;
    private final zzbdv zzgtn;

    private zzcvk(Context context2, zzchp zzchp, zzdnn zzdnn, zzazh zzazh, zzdmu zzdmu, zzdyz<zzche> zzdyz, zzbdv zzbdv) {
        this.context = context2;
        this.zzgey = zzchp;
        this.zzfvl = zzdnn;
        this.zzbos = zzazh;
        this.zzeri = zzdmu;
        this.zzgre = zzdyz;
        this.zzgtn = zzbdv;
    }

    public final void zza(boolean z, Context context2) {
        zzbdv zzbdv;
        zzche zzche = (zzche) zzdyr.zzb(this.zzgre);
        try {
            zzdmu zzdmu = this.zzeri;
            if (this.zzgtn.zzadh()) {
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcog)).booleanValue()) {
                    zzbdv zzd = this.zzgey.zzd(this.zzfvl.zzbpe);
                    zzaig.zza(zzd, (zzaij) zzche.zzahr());
                    zzcif zzcif = new zzcif();
                    zzcif.zzc(this.context, zzd.getView());
                    zzche.zzagr().zzb(zzd, true);
                    zzd.zzacs().zza((zzbfj) new zzcvj(zzcif, zzd));
                    zzbfg zzacs = zzd.zzacs();
                    zzd.getClass();
                    zzacs.zza(zzcvm.zzq(zzd));
                    zzd.zzb(zzdmu.zzhgx.zzdrn, zzdmu.zzhgx.zzdrp, (String) null);
                    zzbdv = zzd;
                    zzbdv.zzaz(true);
                    zzp.zzkq();
                    zzi zzi = new zzi(false, zzm.zzaz(this.context), false, 0.0f, -1, z, this.zzeri.zzfsc, this.zzeri.zzbpc);
                    zzp.zzkp();
                    Context context3 = context2;
                    zzo.zza(context3, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzche.zzags(), (zzu) null, zzbdv, this.zzeri.zzhhg, this.zzbos, this.zzeri.zzdus, zzi, this.zzeri.zzhgx.zzdrn, this.zzeri.zzhgx.zzdrp), true);
                }
            }
            zzbdv = this.zzgtn;
            zzbdv.zzaz(true);
            zzp.zzkq();
            zzi zzi2 = new zzi(false, zzm.zzaz(this.context), false, 0.0f, -1, z, this.zzeri.zzfsc, this.zzeri.zzbpc);
            zzp.zzkp();
            Context context32 = context2;
            zzo.zza(context32, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzche.zzags(), (zzu) null, zzbdv, this.zzeri.zzhhg, this.zzbos, this.zzeri.zzdus, zzi2, this.zzeri.zzhgx.zzdrn, this.zzeri.zzhgx.zzdrp), true);
        } catch (zzbeh e) {
            zzaza.zzc("", e);
        }
    }
}
