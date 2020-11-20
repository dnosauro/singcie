package com.google.android.gms.internal.ads;

final class zzabc implements zzadp {
    private final /* synthetic */ zzabb zzclp;

    zzabc(zzabb zzabb) {
        this.zzclp = zzabb;
    }

    public final String get(String str, String str2) {
        return this.zzclp.zzclm.getString(str, str2);
    }

    public final Long getLong(String str, long j) {
        try {
            return Long.valueOf(this.zzclp.zzclm.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.zzclp.zzclm.getInt(str, (int) j));
        }
    }

    public final Double zza(String str, double d) {
        return Double.valueOf((double) this.zzclp.zzclm.getFloat(str, (float) d));
    }

    public final Boolean zzf(String str, boolean z) {
        return Boolean.valueOf(this.zzclp.zzclm.getBoolean(str, z));
    }
}
