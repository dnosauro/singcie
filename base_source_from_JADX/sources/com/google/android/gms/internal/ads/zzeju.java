package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzeju {
    private static volatile boolean zzikg = false;
    private static boolean zzikh = true;
    private static volatile zzeju zziki;
    private static volatile zzeju zzikj;
    private static final zzeju zzikk = new zzeju(true);
    private final Map<zza, zzekh.zzd<?, ?>> zzikl;

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return this.object == zza.object && this.number == zza.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzeju() {
        this.zzikl = new HashMap();
    }

    private zzeju(boolean z) {
        this.zzikl = Collections.emptyMap();
    }

    public static zzeju zzbhe() {
        zzeju zzeju = zziki;
        if (zzeju == null) {
            synchronized (zzeju.class) {
                zzeju = zziki;
                if (zzeju == null) {
                    zzeju = zzikk;
                    zziki = zzeju;
                }
            }
        }
        return zzeju;
    }

    public static zzeju zzbhf() {
        zzeju zzeju = zzikj;
        if (zzeju != null) {
            return zzeju;
        }
        synchronized (zzeju.class) {
            zzeju zzeju2 = zzikj;
            if (zzeju2 != null) {
                return zzeju2;
            }
            zzeju zze = zzekg.zze(zzeju.class);
            zzikj = zze;
            return zze;
        }
    }

    public final <ContainingType extends zzels> zzekh.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzikl.get(new zza(containingtype, i));
    }
}
