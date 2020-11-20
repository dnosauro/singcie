package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhv;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzhi {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzhi zzc;
    private static volatile zzhi zzd;
    private static final zzhi zze = new zzhi(true);
    private final Map<zza, zzhv.zzf<?, ?>> zzf;

    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            return this.zza == zza2.zza && this.zzb == zza2.zzb;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }
    }

    zzhi() {
        this.zzf = new HashMap();
    }

    private zzhi(boolean z) {
        this.zzf = Collections.emptyMap();
    }

    public static zzhi zza() {
        zzhi zzhi = zzc;
        if (zzhi == null) {
            synchronized (zzhi.class) {
                zzhi = zzc;
                if (zzhi == null) {
                    zzhi = zze;
                    zzc = zzhi;
                }
            }
        }
        return zzhi;
    }

    public static zzhi zzb() {
        zzhi zzhi = zzd;
        if (zzhi != null) {
            return zzhi;
        }
        synchronized (zzhi.class) {
            zzhi zzhi2 = zzd;
            if (zzhi2 != null) {
                return zzhi2;
            }
            zzhi zza2 = zzht.zza(zzhi.class);
            zzd = zza2;
            return zza2;
        }
    }

    public final <ContainingType extends zzjg> zzhv.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzf.get(new zza(containingtype, i));
    }
}
