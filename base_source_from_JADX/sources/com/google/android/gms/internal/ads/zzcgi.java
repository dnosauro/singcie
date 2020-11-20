package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

public final class zzcgi implements zzahv<Object> {
    private final zzeoz<zzcgb> zzgca;
    private final zzcgh zzgep;
    private final zzafp zzghk;

    public zzcgi(zzccl zzccl, zzcce zzcce, zzcgh zzcgh, zzeoz<zzcgb> zzeoz) {
        this.zzghk = zzccl.zzgb(zzcce.getCustomTemplateId());
        this.zzgep = zzcgh;
        this.zzgca = zzeoz;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zzghk.zza(this.zzgca.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzd.zzd(sb.toString(), e);
        }
    }

    public final void zzaov() {
        if (this.zzghk != null) {
            this.zzgep.zza("/nativeAdCustomClick", (zzahv<Object>) this);
        }
    }
}
