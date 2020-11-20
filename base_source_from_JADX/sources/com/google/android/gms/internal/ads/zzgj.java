package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzgj {
    private static final String TAG = "zzgj";
    private final String className;
    private final String zzabg;
    private final int zzabh = 2;
    private volatile Method zzabi = null;
    private final Class<?>[] zzabj;
    private CountDownLatch zzabk = new CountDownLatch(1);
    private final zzfa zzwb;

    public zzgj(zzfa zzfa, String str, String str2, Class<?>... clsArr) {
        this.zzwb = zzfa;
        this.className = str;
        this.zzabg = str2;
        this.zzabj = clsArr;
        this.zzwb.zzcg().submit(new zzgm(this));
    }

    private final String zzb(byte[] bArr, String str) {
        return new String(this.zzwb.zzci().zza(bArr, str), "UTF-8");
    }

    /* access modifiers changed from: private */
    public final void zzda() {
        try {
            Class loadClass = this.zzwb.zzch().loadClass(zzb(this.zzwb.zzcj(), this.className));
            if (loadClass != null) {
                this.zzabi = loadClass.getMethod(zzb(this.zzwb.zzcj(), this.zzabg), this.zzabj);
                Method method = this.zzabi;
            }
        } catch (zzek | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            this.zzabk.countDown();
            throw th;
        }
        this.zzabk.countDown();
    }

    public final Method zzdb() {
        if (this.zzabi != null) {
            return this.zzabi;
        }
        try {
            if (!this.zzabk.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zzabi;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
