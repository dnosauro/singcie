package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdvu {
    private static final Logger logger = Logger.getLogger(zzdvu.class.getName());
    private static final zzdvr zzhtd = new zza();

    static final class zza {
        private zza() {
        }
    }

    private zzdvu() {
    }

    static String emptyToNull(@NullableDecl String str) {
        if (zzhf(str)) {
            return null;
        }
        return str;
    }

    static boolean zzhf(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static String zzhg(@NullableDecl String str) {
        return str == null ? "" : str;
    }
}
