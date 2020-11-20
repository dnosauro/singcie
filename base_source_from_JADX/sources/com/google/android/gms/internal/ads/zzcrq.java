package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;

final class zzcrq implements zzcaf {
    private final Context context;
    private final zzazh zzbos;
    private final zzdnn zzfvl;
    private final zzdmu zzgdi;
    private final zzdyz<zzbln> zzgre;
    private final zzbdv zzgrf;

    zzcrq(Context context2, zzazh zzazh, zzdyz<zzbln> zzdyz, zzdmu zzdmu, zzbdv zzbdv, zzdnn zzdnn) {
        this.context = context2;
        this.zzbos = zzazh;
        this.zzgre = zzdyz;
        this.zzgdi = zzdmu;
        this.zzgrf = zzbdv;
        this.zzfvl = zzdnn;
    }

    public final void zza(boolean z, Context context2) {
        int i;
        this.zzgrf.zzaz(true);
        zzi zzi = new zzi(true, true, false, 0.0f, -1, z, this.zzgdi.zzfsc, false);
        zzp.zzkp();
        zzbzv zzags = ((zzbln) zzdyr.zzb(this.zzgre)).zzags();
        zzbdv zzbdv = this.zzgrf;
        if (this.zzgdi.zzhhg == -1) {
            if (this.zzfvl.zzhis != null) {
                if (this.zzfvl.zzhis.orientation == 1) {
                    zzp.zzks();
                    i = 7;
                } else if (this.zzfvl.zzhis.orientation == 2) {
                    zzp.zzks();
                    i = 6;
                }
                Context context3 = context2;
                zzo.zza(context3, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzags, (zzu) null, zzbdv, i, this.zzbos, this.zzgdi.zzdus, zzi, this.zzgdi.zzhgx.zzdrn, this.zzgdi.zzhgx.zzdrp), true);
            }
            zzd.zzeb("Error setting app open orientation; no targeting orientation available.");
        }
        i = this.zzgdi.zzhhg;
        Context context32 = context2;
        zzo.zza(context32, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) zzags, (zzu) null, zzbdv, i, this.zzbos, this.zzgdi.zzdus, zzi, this.zzgdi.zzhgx.zzdrn, this.zzgdi.zzhgx.zzdrp), true);
    }
}
