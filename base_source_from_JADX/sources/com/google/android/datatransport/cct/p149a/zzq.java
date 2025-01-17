package com.google.android.datatransport.cct.p149a;

import com.google.android.datatransport.cct.p149a.zzi;
import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: com.google.android.datatransport.cct.a.zzq */
public abstract class zzq {

    @AutoValue.Builder
    /* renamed from: com.google.android.datatransport.cct.a.zzq$zza */
    public static abstract class zza {
        public abstract zza zza(long j);

        public abstract zza zza(zzt zzt);

        public abstract zza zza(Integer num);

        /* access modifiers changed from: package-private */
        public abstract zza zza(String str);

        /* access modifiers changed from: package-private */
        public abstract zza zza(byte[] bArr);

        public abstract zzq zza();

        public abstract zza zzb(long j);

        public abstract zza zzc(long j);
    }

    public static zza zza(String str) {
        return new zzi.zza().zza(str);
    }

    public static zza zza(byte[] bArr) {
        return new zzi.zza().zza(bArr);
    }

    public abstract Integer zza();

    public abstract long zzb();

    public abstract long zzc();

    public abstract zzt zzd();

    public abstract byte[] zze();

    public abstract String zzf();

    public abstract long zzg();
}
