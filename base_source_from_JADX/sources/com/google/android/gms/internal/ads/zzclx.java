package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzclx implements Runnable {
    private final zzclp zzglj;
    private final zzazq zzgll;

    zzclx(zzclp zzclp, zzazq zzazq) {
        this.zzglj = zzclp;
        this.zzgll = zzazq;
    }

    public final void run() {
        zzazq zzazq = this.zzgll;
        String zzxf = zzp.zzku().zzwz().zzxv().zzxf();
        if (!TextUtils.isEmpty(zzxf)) {
            zzazq.set(zzxf);
        } else {
            zzazq.setException(new Exception());
        }
    }
}
