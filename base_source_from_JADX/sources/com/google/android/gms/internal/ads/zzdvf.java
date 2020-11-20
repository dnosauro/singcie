package com.google.android.gms.internal.ads;

final class zzdvf extends zzdvg {
    private final char zzhsx = ';';

    zzdvf(char c) {
    }

    public final String toString() {
        String zze = zzdvd.zzd(this.zzhsx);
        StringBuilder sb = new StringBuilder(String.valueOf(zze).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(zze);
        sb.append("')");
        return sb.toString();
    }

    public final boolean zzc(char c) {
        return c == this.zzhsx;
    }
}
