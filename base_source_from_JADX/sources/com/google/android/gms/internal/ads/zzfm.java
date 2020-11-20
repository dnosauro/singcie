package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;

public final class zzfm extends zzgl {
    private final Activity zzaap;
    private final View zzaaq;

    public zzfm(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2, View view, Activity activity) {
        super(zzfa, str, str2, zza, i, 62);
        this.zzaaq = view;
        this.zzaap = activity;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (this.zzaaq != null) {
            boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqz)).booleanValue();
            Object[] objArr = (Object[]) this.zzabi.invoke((Object) null, new Object[]{this.zzaaq, this.zzaap, Boolean.valueOf(booleanValue)});
            synchronized (this.zzaay) {
                this.zzaay.zzai(((Long) objArr[0]).longValue());
                this.zzaay.zzaj(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzaay.zzaa((String) objArr[2]);
                }
            }
        }
    }
}
