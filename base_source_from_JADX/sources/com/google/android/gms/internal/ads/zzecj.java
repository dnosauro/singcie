package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzecj {
    @Deprecated
    public static final zzegf zzhzr = zzegf.zzbes();
    @Deprecated
    private static final zzegf zzhzs = zzegf.zzbes();
    @Deprecated
    private static final zzegf zzhzt = zzegf.zzbes();
    private static final String zzial = new zzech().getKeyType();
    private static final String zziam = new zzecc().getKeyType();

    static {
        try {
            zzeav.zzbai();
            zzeap.zza(new zzecc(), new zzech(), true);
            zzeap.zza(new zzeci());
            zzeap.zza(new zzecm());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
