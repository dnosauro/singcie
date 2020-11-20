package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.List;

public final class zzgb extends zzgl {
    private List<Long> zzabc = null;

    public zzgb(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 31);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zzq(-1);
        this.zzaay.zzr(-1);
        if (this.zzabc == null) {
            this.zzabc = (List) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext()});
        }
        List<Long> list = this.zzabc;
        if (list != null && list.size() == 2) {
            synchronized (this.zzaay) {
                this.zzaay.zzq(this.zzabc.get(0).longValue());
                this.zzaay.zzr(this.zzabc.get(1).longValue());
            }
        }
    }
}
