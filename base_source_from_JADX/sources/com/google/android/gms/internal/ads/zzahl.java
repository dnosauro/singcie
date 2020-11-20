package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

final class zzahl implements zzahv<zzbdv> {
    zzahl() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (zzbdv.zzadg() != null) {
            zzbdv.zzadg().zzms();
        }
        zze zzaco = zzbdv.zzaco();
        if (zzaco != null) {
            zzaco.close();
            return;
        }
        zze zzacp = zzbdv.zzacp();
        if (zzacp != null) {
            zzacp.close();
        } else {
            zzd.zzfa("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
