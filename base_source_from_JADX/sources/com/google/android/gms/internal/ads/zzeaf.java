package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzeaf {
    private final zzefr zzhyn;

    private zzeaf(zzefr zzefr) {
        this.zzhyn = zzefr;
    }

    static final zzeaf zza(zzefr zzefr) {
        if (zzefr != null && zzefr.zzbdu() > 0) {
            return new zzeaf(zzefr);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return zzeaw.zzb(this.zzhyn).toString();
    }

    /* access modifiers changed from: package-private */
    public final zzefr zzazz() {
        return this.zzhyn;
    }
}
