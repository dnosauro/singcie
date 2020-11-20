package com.google.android.gms.internal.ads;

public final class zzdps implements zzdpq {
    private final String zzck;

    public zzdps(String str) {
        this.zzck = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdps)) {
            return false;
        }
        return this.zzck.equals(((zzdps) obj).zzck);
    }

    public final int hashCode() {
        return this.zzck.hashCode();
    }

    public final String toString() {
        return this.zzck;
    }
}
