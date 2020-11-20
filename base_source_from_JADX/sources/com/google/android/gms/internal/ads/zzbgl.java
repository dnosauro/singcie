package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

public class zzbgl {
    private final Context zzaaa;
    private final zzazh zzbos;
    private final WeakReference<Context> zzeva;

    public static class zza {
        /* access modifiers changed from: private */
        public Context zzaaa;
        /* access modifiers changed from: private */
        public zzazh zzbos;
        /* access modifiers changed from: private */
        public WeakReference<Context> zzeva;

        public final zza zza(zzazh zzazh) {
            this.zzbos = zzazh;
            return this;
        }

        public final zza zzby(Context context) {
            this.zzeva = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaaa = context;
            return this;
        }
    }

    private zzbgl(zza zza2) {
        this.zzbos = zza2.zzbos;
        this.zzaaa = zza2.zzaaa;
        this.zzeva = zza2.zzeva;
    }

    /* access modifiers changed from: package-private */
    public final Context zzaef() {
        return this.zzaaa;
    }

    /* access modifiers changed from: package-private */
    public final WeakReference<Context> zzaeg() {
        return this.zzeva;
    }

    /* access modifiers changed from: package-private */
    public final zzazh zzaeh() {
        return this.zzbos;
    }

    /* access modifiers changed from: package-private */
    public final String zzaei() {
        return zzp.zzkq().zzq(this.zzaaa, this.zzbos.zzbrf);
    }

    public final zzef zzaej() {
        return new zzef(new zzf(this.zzaaa, this.zzbos));
    }
}
