package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

public final class zzckq {
    /* access modifiers changed from: private */
    public final Executor executor;
    /* access modifiers changed from: private */
    public final zzckv zzgke;
    /* access modifiers changed from: private */
    public final Map<String, String> zzgki;

    public zzckq(zzckv zzckv, Executor executor2) {
        this.zzgke = zzckv;
        this.zzgki = zzckv.zzaqh();
        this.executor = executor2;
    }

    public final zzckp zzaqg() {
        return new zzckp(this).zzaqc();
    }
}
