package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;

final class zzctb implements zzcaf {
    private final Context context;
    private final zzazh zzbos;
    private final zzdmu zzgdi;
    private final zzdyz<zzbyz> zzgre;
    private final zzbdv zzgrf;

    private zzctb(Context context2, zzazh zzazh, zzdyz<zzbyz> zzdyz, zzdmu zzdmu, zzbdv zzbdv) {
        this.context = context2;
        this.zzbos = zzazh;
        this.zzgre = zzdyz;
        this.zzgdi = zzdmu;
        this.zzgrf = zzbdv;
    }

    public final void zza(boolean z, Context context2) {
        this.zzgrf.zzaz(true);
        zzp.zzkq();
        zzi zzi = new zzi(false, zzm.zzaz(this.context), false, 0.0f, -1, z, this.zzgdi.zzfsc, false);
        zzp.zzkp();
        Context context3 = context2;
        zzo.zza(context3, new AdOverlayInfoParcel((zzva) null, (com.google.android.gms.ads.internal.overlay.zzp) ((zzbyz) zzdyr.zzb(this.zzgre)).zzags(), (zzu) null, this.zzgrf, this.zzgdi.zzhhg, this.zzbos, this.zzgdi.zzdus, zzi, this.zzgdi.zzhgx.zzdrn, this.zzgdi.zzhgx.zzdrp), true);
    }
}
