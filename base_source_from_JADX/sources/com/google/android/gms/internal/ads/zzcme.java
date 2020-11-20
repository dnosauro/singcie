package com.google.android.gms.internal.ads;

public class zzcme extends Exception {
    private final zzdok zzgmc;

    public zzcme(zzdok zzdok) {
        this.zzgmc = zzdok;
    }

    public zzcme(zzdok zzdok, String str) {
        super(str);
        this.zzgmc = zzdok;
    }

    public zzcme(zzdok zzdok, String str, Throwable th) {
        super(str, th);
        this.zzgmc = zzdok;
    }

    public final zzdok zzaqs() {
        return this.zzgmc;
    }
}
