package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzad {
    public static final zzad zza = new zzad((Boolean) null, (Boolean) null);
    private final Boolean zzb;
    private final Boolean zzc;

    public zzad(Boolean bool, Boolean bool2) {
        this.zzb = bool;
        this.zzc = bool2;
    }

    private static int zza(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    public static zzad zza(String str) {
        Boolean bool;
        Boolean bool2 = null;
        if (str != null) {
            bool = str.length() >= 3 ? zza(str.charAt(2)) : null;
            if (str.length() >= 4) {
                bool2 = zza(str.charAt(3));
            }
        } else {
            bool = null;
        }
        return new zzad(bool, bool2);
    }

    private static Boolean zza(char c) {
        if (c == '-') {
            return null;
        }
        switch (c) {
            case '0':
                return Boolean.FALSE;
            case '1':
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    private static Boolean zza(Boolean bool, Boolean bool2) {
        if (bool == null) {
            return (bool2 == null || bool2.booleanValue()) ? null : false;
        }
        if (bool.booleanValue()) {
            return bool2;
        }
        return false;
    }

    public static String zza(Bundle bundle) {
        String string = bundle.getString("ad_storage");
        if (string != null && zzb(string) == null) {
            return string;
        }
        String string2 = bundle.getString("analytics_storage");
        if (string2 == null || zzb(string2) != null) {
            return null;
        }
        return string2;
    }

    static boolean zza(int i, int i2) {
        return i <= i2;
    }

    private static char zzb(Boolean bool) {
        if (bool == null) {
            return '-';
        }
        return bool.booleanValue() ? '1' : '0';
    }

    public static zzad zzb(Bundle bundle) {
        return bundle == null ? zza : new zzad(zzb(bundle.getString("ad_storage")), zzb(bundle.getString("analytics_storage")));
    }

    private static Boolean zzb(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzad = (zzad) obj;
        return zza(this.zzb) == zza(zzad.zzb) && zza(this.zzc) == zza(zzad.zzc);
    }

    public final int hashCode() {
        return ((zza(this.zzb) + 527) * 31) + zza(this.zzc);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConsentSettings: ");
        sb.append("adStorage=");
        Boolean bool = this.zzb;
        sb.append(bool == null ? "uninitialized" : bool.booleanValue() ? "granted" : "denied");
        sb.append(", analyticsStorage=");
        Boolean bool2 = this.zzc;
        sb.append(bool2 == null ? "uninitialized" : bool2.booleanValue() ? "granted" : "denied");
        return sb.toString();
    }

    public final String zza() {
        return "G1" + zzb(this.zzb) + zzb(this.zzc);
    }

    public final boolean zza(zzad zzad) {
        if (this.zzb != Boolean.FALSE || zzad.zzb == Boolean.FALSE) {
            return this.zzc == Boolean.FALSE && zzad.zzc != Boolean.FALSE;
        }
        return true;
    }

    public final zzad zzb(zzad zzad) {
        return new zzad(zza(this.zzb, zzad.zzb), zza(this.zzc, zzad.zzc));
    }

    public final Boolean zzb() {
        return this.zzb;
    }

    public final zzad zzc(zzad zzad) {
        Boolean bool = this.zzb;
        if (bool == null) {
            bool = zzad.zzb;
        }
        Boolean bool2 = this.zzc;
        if (bool2 == null) {
            bool2 = zzad.zzc;
        }
        return new zzad(bool, bool2);
    }

    public final boolean zzc() {
        Boolean bool = this.zzb;
        return bool == null || bool.booleanValue();
    }

    public final Boolean zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        Boolean bool = this.zzc;
        return bool == null || bool.booleanValue();
    }
}
