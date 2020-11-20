package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

public abstract class zzaaq<T> {
    private final String zzck;
    private final int zzclc;
    private final T zzcld;

    private zzaaq(int i, String str, T t) {
        this.zzclc = i;
        this.zzck = str;
        this.zzcld = t;
        zzwq.zzqd().zza(this);
    }

    /* synthetic */ zzaaq(int i, String str, Object obj, zzaat zzaat) {
        this(i, str, obj);
    }

    public static zzaaq<Float> zza(int i, String str, float f) {
        return new zzaau(1, str, Float.valueOf(0.0f));
    }

    public static zzaaq<Integer> zza(int i, String str, int i2) {
        return new zzaas(1, str, Integer.valueOf(i2));
    }

    public static zzaaq<Boolean> zza(int i, String str, Boolean bool) {
        return new zzaat(i, str, bool);
    }

    public static zzaaq<String> zza(int i, String str, String str2) {
        return new zzaax(1, str, str2);
    }

    public static zzaaq<String> zzb(int i, String str) {
        zzaaq<String> zza = zza(1, str, (String) null);
        zzwq.zzqd().zzc(zza);
        return zza;
    }

    public static zzaaq<Long> zzb(int i, String str, long j) {
        return new zzaav(1, str, Long.valueOf(j));
    }

    public final String getKey() {
        return this.zzck;
    }

    public final int getSource() {
        return this.zzclc;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    /* access modifiers changed from: protected */
    public abstract T zzb(JSONObject jSONObject);

    public final T zzrk() {
        return this.zzcld;
    }
}
