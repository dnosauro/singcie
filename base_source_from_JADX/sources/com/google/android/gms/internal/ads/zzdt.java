package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzbw;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzdt {
    /* access modifiers changed from: private */
    public static final ConditionVariable zzwc = new ConditionVariable();
    protected static volatile zztx zzwd = null;
    private static volatile Random zzwf = null;
    /* access modifiers changed from: private */
    public zzfa zzwb;
    protected volatile Boolean zzwe;

    public zzdt(zzfa zzfa) {
        this.zzwb = zzfa;
        zzfa.zzcg().execute(new zzdw(this));
    }

    public static int zzbu() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzbv().nextInt();
        } catch (RuntimeException unused) {
            return zzbv().nextInt();
        }
    }

    private static Random zzbv() {
        if (zzwf == null) {
            synchronized (zzdt.class) {
                if (zzwf == null) {
                    zzwf = new Random();
                }
            }
        }
        return zzwf;
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, (String) null, (Exception) null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, (Exception) null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzwc.block();
            if (this.zzwe.booleanValue() && zzwd != null) {
                zzbw.zza.C3701zza zzc = zzbw.zza.zzs().zzj(this.zzwb.context.getPackageName()).zzc(j);
                if (str != null) {
                    zzc.zzm(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzeid.zza((Throwable) exc, new PrintWriter(stringWriter));
                    zzc.zzk(stringWriter.toString()).zzl(exc.getClass().getName());
                }
                zzub zzf = zzwd.zzf(((zzbw.zza) ((zzekh) zzc.zzbhv())).toByteArray());
                zzf.zzbv(i);
                if (i2 != -1) {
                    zzf.zzbu(i2);
                }
                zzf.log();
            }
        } catch (Exception unused) {
        }
    }
}
