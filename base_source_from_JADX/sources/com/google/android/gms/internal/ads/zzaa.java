package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzaq;
import java.util.Collections;
import java.util.Map;

public abstract class zzaa<T> implements Comparable<zzaa<T>> {
    private final Object mLock;
    /* access modifiers changed from: private */
    public final zzaq.zza zzao;
    private final int zzap;
    private final String zzaq;
    private final int zzar;
    private zzai zzas;
    private Integer zzat;
    private zzae zzau;
    private boolean zzav;
    private boolean zzaw;
    private boolean zzax;
    private boolean zzay;
    private zzan zzaz;
    private zzn zzba;
    private zzac zzbb;

    public zzaa(int i, String str, zzai zzai) {
        Uri parse;
        String host;
        this.zzao = zzaq.zza.zzbu ? new zzaq.zza() : null;
        this.mLock = new Object();
        this.zzav = true;
        int i2 = 0;
        this.zzaw = false;
        this.zzax = false;
        this.zzay = false;
        this.zzba = null;
        this.zzap = i;
        this.zzaq = str;
        this.zzas = zzai;
        this.zzaz = new zzq();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzar = i2;
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzaa zzaa = (zzaa) obj;
        zzaf zzaf = zzaf.NORMAL;
        zzaf zzaf2 = zzaf.NORMAL;
        return zzaf == zzaf2 ? this.zzat.intValue() - zzaa.zzat.intValue() : zzaf2.ordinal() - zzaf.ordinal();
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzap;
    }

    public final String getUrl() {
        return this.zzaq;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzar));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        isCanceled();
        String str = this.zzaq;
        String valueOf2 = String.valueOf(zzaf.NORMAL);
        String valueOf3 = String.valueOf(this.zzat);
        StringBuilder sb = new StringBuilder(String.valueOf("[ ] ").length() + 3 + String.valueOf(str).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(concat);
        sb.append(" ");
        sb.append(valueOf2);
        sb.append(" ");
        sb.append(valueOf3);
        return sb.toString();
    }

    public final zzaa<?> zza(zzae zzae) {
        this.zzau = zzae;
        return this;
    }

    public final zzaa<?> zza(zzn zzn) {
        this.zzba = zzn;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzaj<T> zza(zzy zzy);

    /* access modifiers changed from: package-private */
    public final void zza(zzac zzac) {
        synchronized (this.mLock) {
            this.zzbb = zzac;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaj<?> zzaj) {
        zzac zzac;
        synchronized (this.mLock) {
            zzac = this.zzbb;
        }
        if (zzac != null) {
            zzac.zza(this, zzaj);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zza(T t);

    public final void zzb(zzao zzao2) {
        zzai zzai;
        synchronized (this.mLock) {
            zzai = this.zzas;
        }
        if (zzai != null) {
            zzai.zzc(zzao2);
        }
    }

    public final void zzc(String str) {
        if (zzaq.zza.zzbu) {
            this.zzao.zza(str, Thread.currentThread().getId());
        }
    }

    public final int zzd() {
        return this.zzar;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i) {
        zzae zzae = this.zzau;
        if (zzae != null) {
            zzae.zza(this, i);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zzae zzae = this.zzau;
        if (zzae != null) {
            zzae.zzf(this);
        }
        if (zzaq.zza.zzbu) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzad(this, str, id));
                return;
            }
            this.zzao.zza(str, id);
            this.zzao.zzd(toString());
        }
    }

    public final zzaa<?> zze(int i) {
        this.zzat = Integer.valueOf(i);
        return this;
    }

    public final String zze() {
        String str = this.zzaq;
        int i = this.zzap;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    public final zzn zzf() {
        return this.zzba;
    }

    public byte[] zzg() {
        return null;
    }

    public final boolean zzh() {
        return this.zzav;
    }

    public final int zzi() {
        return this.zzaz.zzb();
    }

    public final zzan zzj() {
        return this.zzaz;
    }

    public final void zzk() {
        synchronized (this.mLock) {
            this.zzax = true;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzax;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void zzm() {
        zzac zzac;
        synchronized (this.mLock) {
            zzac = this.zzbb;
        }
        if (zzac != null) {
            zzac.zza(this);
        }
    }
}
