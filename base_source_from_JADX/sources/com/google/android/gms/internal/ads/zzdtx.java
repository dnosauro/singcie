package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

final class zzdtx implements zzdsl {
    private final Object zzhri;
    private final zzdua zzhrj;
    private final zzdum zzhrk;
    private final zzdsi zzvs;

    zzdtx(Object obj, zzdua zzdua, zzdum zzdum, zzdsi zzdsi) {
        this.zzhri = obj;
        this.zzhrj = zzdua;
        this.zzhrk = zzdum;
        this.zzvs = zzdsi;
    }

    private final synchronized byte[] zzc(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzvs.zza(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zzhri.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zzhri, new Object[]{null, map2});
    }

    private static String zzj(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(((zzcf.zzf) ((zzekh) zzcf.zzf.zzbl().zzb(zzcm.DG).zzj(zzeiu.zzt(bArr)).zzbhv())).toByteArray(), 11);
    }

    public final synchronized void close() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zzhri.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zzhri, new Object[0]);
            this.zzvs.zzh(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzduk(2003, (Throwable) e);
        }
    }

    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zzce;
        zzce = this.zzhrk.zzce();
        zzce.put("f", "c");
        zzce.put("ctx", context);
        zzce.put("cs", str2);
        zzce.put("aid", (Object) null);
        zzce.put("view", view);
        zzce.put("act", activity);
        return zzj(zzc((Map<String, String>) null, zzce));
    }

    public final synchronized void zza(String str, MotionEvent motionEvent) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.zzhri.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zzhri, new Object[]{hashMap});
            this.zzvs.zzh(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzduk(2005, (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzdua zzaxt() {
        return this.zzhrj;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzaxu() {
        try {
        } catch (Exception e) {
            throw new zzduk(2001, (Throwable) e);
        }
        return ((Boolean) this.zzhri.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zzhri, new Object[0])).booleanValue();
    }

    public final synchronized int zzaxv() {
        try {
        } catch (Exception e) {
            throw new zzduk(2006, (Throwable) e);
        }
        return ((Integer) this.zzhri.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zzhri, new Object[0])).intValue();
    }

    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzcd;
        zzcd = this.zzhrk.zzcd();
        zzcd.put("f", "v");
        zzcd.put("ctx", context);
        zzcd.put("aid", (Object) null);
        zzcd.put("view", view);
        zzcd.put("act", activity);
        return zzj(zzc((Map<String, String>) null, zzcd));
    }

    public final synchronized String zzt(Context context, String str) {
        Map<String, Object> zzcc;
        zzcc = this.zzhrk.zzcc();
        zzcc.put("f", "q");
        zzcc.put("ctx", context);
        zzcc.put("aid", (Object) null);
        return zzj(zzc((Map<String, String>) null, zzcc));
    }
}
