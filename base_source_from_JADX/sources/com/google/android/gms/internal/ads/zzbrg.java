package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

public class zzbrg {
    private final Context context;
    private final zzdnn zzfvl;
    private Bundle zzfxi;
    private final String zzfxj;
    private final zzdni zzfxk;

    public static class zza {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public zzdnn zzfvl;
        /* access modifiers changed from: private */
        public Bundle zzfxi;
        /* access modifiers changed from: private */
        public String zzfxj;
        /* access modifiers changed from: private */
        public zzdni zzfxk;

        public final zza zza(zzdni zzdni) {
            this.zzfxk = zzdni;
            return this;
        }

        public final zza zza(zzdnn zzdnn) {
            this.zzfvl = zzdnn;
            return this;
        }

        public final zzbrg zzakx() {
            return new zzbrg(this);
        }

        public final zza zzcg(Context context2) {
            this.context = context2;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.zzfxi = bundle;
            return this;
        }

        public final zza zzfu(String str) {
            this.zzfxj = str;
            return this;
        }
    }

    private zzbrg(zza zza2) {
        this.context = zza2.context;
        this.zzfvl = zza2.zzfvl;
        this.zzfxi = zza2.zzfxi;
        this.zzfxj = zza2.zzfxj;
        this.zzfxk = zza2.zzfxk;
    }

    /* access modifiers changed from: package-private */
    public final zza zzaks() {
        return new zza().zzcg(this.context).zza(this.zzfvl).zzfu(this.zzfxj).zze(this.zzfxi);
    }

    /* access modifiers changed from: package-private */
    public final zzdnn zzakt() {
        return this.zzfvl;
    }

    /* access modifiers changed from: package-private */
    public final zzdni zzaku() {
        return this.zzfxk;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzakv() {
        return this.zzfxi;
    }

    /* access modifiers changed from: package-private */
    public final String zzakw() {
        return this.zzfxj;
    }

    /* access modifiers changed from: package-private */
    public final Context zzcf(Context context2) {
        return this.zzfxj != null ? context2 : this.context;
    }
}
