package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaa;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzbc;
import com.google.android.gms.internal.ads.zzy;
import java.util.Map;

public final class zzbd extends zzaa<zzy> {
    private final Map<String, String> zzal;
    private final zzazq<zzy> zzeex;
    private final zzayu zzeey;

    public zzbd(String str, zzazq<zzy> zzazq) {
        this(str, (Map<String, String>) null, zzazq);
    }

    private zzbd(String str, Map<String, String> map, zzazq<zzy> zzazq) {
        super(0, str, new zzbg(zzazq));
        this.zzal = null;
        this.zzeex = zzazq;
        this.zzeey = new zzayu();
        this.zzeey.zza(str, "GET", (Map<String, ?>) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzaj<zzy> zza(zzy zzy) {
        return zzaj.zza(zzy, zzbc.zzb(zzy));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zzy zzy = (zzy) obj;
        this.zzeey.zza((Map<String, ?>) zzy.zzal, zzy.statusCode);
        zzayu zzayu = this.zzeey;
        byte[] bArr = zzy.data;
        if (zzayu.isEnabled() && bArr != null) {
            zzayu.zzi(bArr);
        }
        this.zzeex.set(zzy);
    }
}
