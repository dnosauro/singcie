package com.google.android.gms.measurement.internal;

final class zzew implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzex zzf;

    zzew(zzex zzex, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzex;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        char c;
        zzex zzex;
        zzfj zzb2 = this.zzf.zzy.zzb();
        if (!zzb2.zzz()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zzs().zze()) {
                zzex = this.zzf;
                c = 'C';
            } else {
                zzex = this.zzf;
                c = 'c';
            }
            char unused = zzex.zza = c;
        }
        if (this.zzf.zzb < 0) {
            long unused2 = this.zzf.zzb = 31049;
        }
        char charAt = "01VDIWEA?".charAt(this.zza);
        char zza2 = this.zzf.zza;
        long zzb3 = this.zzf.zzb;
        String zza3 = zzex.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(zza3).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(zza2);
        sb.append(zzb3);
        sb.append(":");
        sb.append(zza3);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.zzb.substring(0, 1024);
        }
        zzb2.zzb.zza(sb2, 1);
    }
}
