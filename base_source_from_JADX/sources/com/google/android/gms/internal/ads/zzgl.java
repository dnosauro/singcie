package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzgl implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzcf.zza.C3704zza zzaay;
    private final String zzabg;
    protected Method zzabi;
    private final int zzabl;
    private final int zzabm;
    protected final zzfa zzwb;

    public zzgl(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        this.zzwb = zzfa;
        this.className = str;
        this.zzabg = str2;
        this.zzaay = zza;
        this.zzabl = i;
        this.zzabm = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzcw();

    /* renamed from: zzcy */
    public Void call() {
        try {
            long nanoTime = System.nanoTime();
            this.zzabi = this.zzwb.zza(this.className, this.zzabg);
            if (this.zzabi == null) {
                return null;
            }
            zzcw();
            zzdt zzcl = this.zzwb.zzcl();
            if (!(zzcl == null || this.zzabl == Integer.MIN_VALUE)) {
                zzcl.zza(this.zzabm, this.zzabl, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
