package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

final /* synthetic */ class zzcdu implements zzahv {
    static final zzahv zzdgn = new zzcdu();

    private zzcdu() {
    }

    public final void zza(Object obj, Map map) {
        zzd.zzeb("Show native ad policy validator overlay.");
        ((zzbdv) obj).getView().setVisibility(0);
    }
}
