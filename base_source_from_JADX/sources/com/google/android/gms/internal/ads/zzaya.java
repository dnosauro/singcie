package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public final class zzaya implements zzayc {
    public final zzdyz<String> zza(Context context, int i) {
        return zzdyr.zzag(null);
    }

    public final zzdyz<String> zza(String str, PackageInfo packageInfo) {
        return zzdyr.zzag(str);
    }

    public final zzdyz<AdvertisingIdClient.Info> zzai(Context context) {
        zzazq zzazq = new zzazq();
        zzwq.zzqa();
        if (zzayr.zzbp(context)) {
            zzazj.zzegp.execute(new zzayd(this, context, zzazq));
        }
        return zzazq;
    }
}
