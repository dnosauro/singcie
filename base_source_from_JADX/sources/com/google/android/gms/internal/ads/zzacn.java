package com.google.android.gms.internal.ads;

public class zzacn<T> {
    private final String zzck;
    private final T zzcld;
    private final int zzdax;

    /* JADX WARNING: type inference failed for: r3v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected zzacn(java.lang.String r1, T r2, java.lang.Integer r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzck = r1
            r0.zzcld = r2
            r0.zzdax = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacn.<init>(java.lang.String, java.lang.Object, int):void");
    }

    public static zzacn<Double> zzb(String str, double d) {
        return new zzacn<>(str, Double.valueOf(d), zzacp.zzdba);
    }

    public static zzacn<Long> zzb(String str, long j) {
        return new zzacn<>(str, Long.valueOf(j), zzacp.zzdaz);
    }

    public static zzacn<Boolean> zzg(String str, boolean z) {
        return new zzacn<>(str, Boolean.valueOf(z), zzacp.zzday);
    }

    public static zzacn<String> zzi(String str, String str2) {
        return new zzacn<>(str, str2, zzacp.zzdbb);
    }

    public T get() {
        zzadp zzsl = zzado.zzsl();
        if (zzsl != null) {
            switch (zzacm.zzdaw[this.zzdax - 1]) {
                case 1:
                    return zzsl.zzf(this.zzck, ((Boolean) this.zzcld).booleanValue());
                case 2:
                    return zzsl.getLong(this.zzck, ((Long) this.zzcld).longValue());
                case 3:
                    return zzsl.zza(this.zzck, ((Double) this.zzcld).doubleValue());
                case 4:
                    return zzsl.get(this.zzck, (String) this.zzcld);
                default:
                    throw new IllegalStateException();
            }
        } else {
            throw new IllegalStateException("Flag is not initialized.");
        }
    }
}
