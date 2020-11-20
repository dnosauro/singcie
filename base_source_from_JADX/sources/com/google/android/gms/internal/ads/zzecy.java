package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzecy {
    @Deprecated
    private static final zzegf zzhzr;
    @Deprecated
    private static final zzegf zzhzs;
    @Deprecated
    private static final zzegf zzhzt = zzhzr;
    private static final String zziax = new zzecu().getKeyType();

    static {
        zzegf zzbes = zzegf.zzbes();
        zzhzr = zzbes;
        zzhzs = zzbes;
        try {
            zzbai();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zzbai() {
        zzeap.zza(new zzecu(), true);
        zzeap.zza(new zzecp(), true);
        zzeap.zza(new zzecx());
    }
}
