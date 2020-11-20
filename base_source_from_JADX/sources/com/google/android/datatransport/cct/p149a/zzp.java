package com.google.android.datatransport.cct.p149a;

import com.google.android.datatransport.cct.p149a.zzg;
import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: com.google.android.datatransport.cct.a.zzp */
public abstract class zzp {

    @AutoValue.Builder
    /* renamed from: com.google.android.datatransport.cct.a.zzp$zza */
    public static abstract class zza {
        public abstract zza zza(zza zza);

        public abstract zza zza(zzb zzb);

        public abstract zzp zza();
    }

    /* renamed from: com.google.android.datatransport.cct.a.zzp$zzb */
    public enum zzb {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        static {
            UNKNOWN = new zzb("UNKNOWN", 0, 0);
            ANDROID_FIREBASE = new zzb("ANDROID_FIREBASE", 1, 23);
            zzb[] zzbArr = {UNKNOWN, ANDROID_FIREBASE};
        }

        private zzb(int i) {
        }
    }

    public static zza zza() {
        return new zzg.zza();
    }

    public abstract zza zzb();

    public abstract zzb zzc();
}
