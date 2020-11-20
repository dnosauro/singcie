package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

final class zzdr implements zzduf {
    private final /* synthetic */ zzdsg zzvz;

    zzdr(zzdp zzdp, zzdsg zzdsg) {
        this.zzvz = zzdsg;
    }

    public final boolean zzb(File file) {
        try {
            return this.zzvz.zzb(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
