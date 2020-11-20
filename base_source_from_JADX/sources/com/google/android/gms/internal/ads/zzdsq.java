package com.google.android.gms.internal.ads;

final class zzdsq extends zzdsm {
    private String zzhpu;
    private Boolean zzhpv;
    private Boolean zzhpw;

    zzdsq() {
    }

    public final zzdsj zzaxa() {
        String str = "";
        if (this.zzhpu == null) {
            str = String.valueOf(str).concat(" clientVersion");
        }
        if (this.zzhpv == null) {
            str = String.valueOf(str).concat(" shouldGetAdvertisingId");
        }
        if (this.zzhpw == null) {
            str = String.valueOf(str).concat(" isGooglePlayServicesAvailable");
        }
        if (str.isEmpty()) {
            return new zzdso(this.zzhpu, this.zzhpv.booleanValue(), this.zzhpw.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }

    public final zzdsm zzbp(boolean z) {
        this.zzhpv = Boolean.valueOf(z);
        return this;
    }

    public final zzdsm zzbq(boolean z) {
        this.zzhpw = true;
        return this;
    }

    public final zzdsm zzgy(String str) {
        if (str != null) {
            this.zzhpu = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }
}
