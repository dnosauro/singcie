package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfo extends zzgl {
    private static zzgo<String> zzaau = new zzgo<>();
    private final Context zzaas;

    public zzfo(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2, Context context) {
        super(zzfa, str, str2, zza, i, 29);
        this.zzaas = context;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zzw("E");
        AtomicReference<String> zzas = zzaau.zzas(this.zzaas.getPackageName());
        if (zzas.get() == null) {
            synchronized (zzas) {
                if (zzas.get() == null) {
                    zzas.set((String) this.zzabi.invoke((Object) null, new Object[]{this.zzaas}));
                }
            }
        }
        String str = zzas.get();
        synchronized (this.zzaay) {
            this.zzaay.zzw(zzcv.zza(str.getBytes(), true));
        }
    }
}
