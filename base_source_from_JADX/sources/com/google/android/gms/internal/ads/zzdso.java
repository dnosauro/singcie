package com.google.android.gms.internal.ads;

final class zzdso extends zzdsj {
    private final String zzhpu;
    private final boolean zzwn;
    private final boolean zzzg;

    private zzdso(String str, boolean z, boolean z2) {
        this.zzhpu = str;
        this.zzwn = z;
        this.zzzg = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdsj) {
            zzdsj zzdsj = (zzdsj) obj;
            return this.zzhpu.equals(zzdsj.zzawx()) && this.zzwn == zzdsj.zzawy() && this.zzzg == zzdsj.zzcm();
        }
    }

    public final int hashCode() {
        int i = 1231;
        int hashCode = (((this.zzhpu.hashCode() ^ 1000003) * 1000003) ^ (this.zzwn ? 1231 : 1237)) * 1000003;
        if (!this.zzzg) {
            i = 1237;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String str = this.zzhpu;
        boolean z = this.zzwn;
        boolean z2 = this.zzzg;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public final String zzawx() {
        return this.zzhpu;
    }

    public final boolean zzawy() {
        return this.zzwn;
    }

    public final boolean zzcm() {
        return this.zzzg;
    }
}
