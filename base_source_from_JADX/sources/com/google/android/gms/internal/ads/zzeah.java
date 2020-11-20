package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzeah {
    private static final CopyOnWriteArrayList<zzeai> zzhyo = new CopyOnWriteArrayList<>();

    public static zzeai zzhh(String str) {
        Iterator<zzeai> it = zzhyo.iterator();
        while (it.hasNext()) {
            zzeai next = it.next();
            if (next.zzhi(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
