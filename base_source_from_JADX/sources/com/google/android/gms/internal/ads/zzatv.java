package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

final class zzatv implements Callable<zzatq> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzats zzdxn;

    zzatv(zzats zzats, Context context) {
        this.zzdxn = zzats;
        this.val$context = context;
    }

    public final /* synthetic */ Object call() {
        zzatq zzatq;
        zzatu zzatu = (zzatu) this.zzdxn.zzdxk.get(this.val$context);
        if (zzatu != null) {
            if (!(zzatu.zzdxl + zzact.zzdbo.get().longValue() < zzp.zzkx().currentTimeMillis())) {
                zzatq = new zzatt(this.val$context, zzatu.zzdxm).zzvz();
                this.zzdxn.zzdxk.put(this.val$context, new zzatu(this.zzdxn, zzatq));
                return zzatq;
            }
        }
        zzatq = new zzatt(this.val$context).zzvz();
        this.zzdxn.zzdxk.put(this.val$context, new zzatu(this.zzdxn, zzatq));
        return zzatq;
    }
}
